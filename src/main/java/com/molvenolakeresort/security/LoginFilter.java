package com.molvenolakeresort.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public LoginFilter() {
        super();
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login.html", "POST"));
    }
}
