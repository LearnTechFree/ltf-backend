package com.learntechfree.ltf.security;

import com.learntechfree.ltf.redis.AuthTokenService;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private TokenProvider tokenProvider;


    @Autowired
    private AuthTokenService authTokenService;

    @Autowired
    private CustomUserDetailService customUserDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}
