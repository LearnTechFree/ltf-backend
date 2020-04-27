//package com.learntechfree.ltf.config;
//
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    private CustomOAuth2UserService customOAuth2UserService;
//
//    @Autowired
//    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
//
//    @Autowired
//    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
//
//    @Autowired
//    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;
//
//    @Bean
//    public TokenAuthenticationFilter tokenAuthenticationFilter() {
//        return new TokenAuthenticationFilter();
//    }
//
//    /*
//      By default, Spring OAuth2 uses HttpSessionOAuth2AuthorizationRequestRepository to save
//      the authorization request. But, since our service is stateless, we can't save it in
//      the session. We'll save the request in a Base64 encoded cookie instead.
//    */
//    @Bean
//    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
//        return new HttpCookieOAuth2AuthorizationRequestRepository();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .userDetailsService(customUserDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .csrf()
//                .disable()
//                .formLogin()
//                .disable()
//                .httpBasic()
//                .disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
//                .and()
//                .authorizeRequests()
//                .antMatchers("/",
//                        "/error",
//                        "/favicon.ico",
//                        "/**/*.png",
//                        "/**/*.gif",
//                        "/**/*.svg",
//                        "/**/*.jpg",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js")
//                .permitAll()
//                .antMatchers("/v1/**", " /v1/user/**", "/v1/admin/**", "/v1/oauth2/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login()
//                .authorizationEndpoint()
//                .baseUri("/v1/oauth2/authorize")
//                .authorizationRequestRepository(cookieAuthorizationRequestRepository())
//                .and()
//                .redirectionEndpoint()
//                .baseUri("/v1/oauth2/callback/*")
//                .and()
//                .userInfoEndpoint()
//                .userService(customOAuth2UserService)
//                .and()
//                .successHandler(oAuth2AuthenticationSuccessHandler)
//                .failureHandler(oAuth2AuthenticationFailureHandler);
//
//        // Add our custom Token based authentication filter
//        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//    }
//}