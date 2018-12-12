package com.molvenolakeresort.security;

import com.molvenolakeresort.services.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    CustomAuthenticationProvider customauthentication;

    @Autowired
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customauthentication); //The Custom Authenticator is used here.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/api/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                    .loginPage("/login.html")
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                            HttpSession session = httpServletRequest.getSession();
                            User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                            session.setAttribute("username", authUser.getUsername());
                            session.setAttribute("authorities", authentication.getAuthorities());

                            //set our response to OK status
                            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

                            //since we have created our custom success handler, its up to us to where
                            //we will redirect the user after successfully login
                            httpServletResponse.sendRedirect("home");
                        }
                    })
                    .defaultSuccessUrl("/", true)
                    .failureUrl("/login.html?error")
                    .permitAll()
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login.html?logout")
                    .permitAll();

    //        http.authorizeRequests().anyRequest().authenticated()
    //                .and()
    //                .formLogin()
    //                    .loginPage("/login.html")
    //                    .permitAll()
    //                .and()
    //                .httpBasic();
        //CSFR is disabled,if you dont know what csrf is,Spring has a beautiful documentaion about it ,Check it out.
        http.csrf().disable();
        //Without the following line(s) the h2 database will return a blank page.
        http.headers().frameOptions().disable();
//
//        //Login,logout page and resources are permitted for all users
//        http.authorizeRequests().antMatchers("/", "/login", "/logout", "/resources/**").permitAll();
    }


}
