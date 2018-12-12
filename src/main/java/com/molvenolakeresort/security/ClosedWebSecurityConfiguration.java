package com.molvenolakeresort.security;

import com.molvenolakeresort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(1)
@EnableWebSecurity
public class ClosedWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

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
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**")
                .fullyAuthenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("CP_LOGIN")
                .and()
                .formLogin()
                .loginPage("/cplogin")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/cplogout"))
                .logoutSuccessUrl("/cplogin?logout")
                .permitAll();
//        //CSFR is disabled,if you dont know what csrf is,Spring has a beautiful documentaion about it ,Check it out.
//        http.csrf().disable();
//        //Without the following line(s) the h2 database will return a blank page.
//        http.headers().frameOptions().disable();
//
//        //Login,logout page and resources are permitted for all users
//        http.authorizeRequests().antMatchers("/", "/login", "/logout", "/resources/**").permitAll();
    }
}
