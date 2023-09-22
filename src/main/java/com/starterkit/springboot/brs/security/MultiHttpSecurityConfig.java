package com.starterkit.springboot.brs.security;

import com.starterkit.springboot.brs.security.api.ApiJWTAuthenticationFilter;
import com.starterkit.springboot.brs.security.api.ApiJWTAuthorizationFilter;
import com.starterkit.springboot.brs.security.form.CustomAuthenticationSuccessHandler;
import com.starterkit.springboot.brs.security.form.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


/**
 * Created by Arpit Khandelwal.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MultiHttpSecurityConfig {
//
//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter  {
//        @Autowired
//        private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//        @Autowired
//        private CustomUserDetailsService userDetailsService;
//        /**
//         * 注入AuthenticationConfiguration
//         */
//        @Autowired
//        private AuthenticationConfiguration auth;
////        @Override
////        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////            auth
////                    .userDetailsService(userDetailsService)
////                    .passwordEncoder(bCryptPasswordEncoder);
////        }
//        /**
//         * 编写AuthenticationManager的bean
//         */
//        @Bean
//        public AuthenticationManager authenticationManager() throws Exception {
//            return auth.getAuthenticationManager();
//        }
//        /**
//         * 替换旧版本中的configure(HttpSecurity http)方法
//         */
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .csrf(Customizer.withDefaults())
//                    .antMatcher("/api/**")
//                    .authorizeRequests()
//                    .antMatchers("/api/v1/user/signup").permitAll()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .exceptionHandling()
//                    .authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                    .and()
//                    .addFilter(new ApiJWTAuthenticationFilter(authenticationManager()))
//                    .addFilter(new ApiJWTAuthorizationFilter(authenticationManager()))
//                    .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        }
//        // @formatter:on
//
//    }
//
//    @Order(2)
//    @Configuration
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//        @Autowired
//        private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//        @Autowired
//        private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//        @Autowired
//        private CustomUserDetailsService userDetailsService;
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth
//                    .userDetailsService(userDetailsService)
//                    .passwordEncoder(bCryptPasswordEncoder);
//        }
//
//        // @formatter:off
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .cors()
//                    .and()
//                    .csrf()
//                    .disable()
//                    .authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .antMatchers("/login").permitAll()
//                    .antMatchers("/signup").permitAll()
//                    .antMatchers("/dashboard/**").hasAuthority("ADMIN")
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                    .failureUrl("/login?error=true")
//                    .usernameParameter("email")
//                    .passwordParameter("password")
//                    .successHandler(customAuthenticationSuccessHandler)
//                    .and()
//                    .logout()
//                    .permitAll()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                    .logoutSuccessHandler(new CustomLogoutSuccessHandler())
//                    .deleteCookies("JSESSIONID")
//                    .logoutSuccessUrl("/")
//                    .and()
//                    .exceptionHandling();
//        }
//
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web.ignoring().antMatchers(
//                    "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**",
//                    "/resources/static/**", "/css/**", "/js/**", "/img/**", "/fonts/**",
//                    "/images/**", "/scss/**", "/vendor/**", "/favicon.ico", "/auth/**", "/favicon.png",
//                    "/v2/api-docs", "/configuration/ui", "/configuration/security",
//                    "/webjars/**", "/swagger-resources/**", "/actuator", "/swagger-ui/**",
//                    "/actuator/**", "/swagger-ui/index.html", "/swagger-ui/");
//        }
//        // @formatter:on
//    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // WebSecurityCustomizer是一个类似于Consumer<WebSecurity>的接口，函数接受一个WebSecurity类型的变量，无返回值
        // 此处使用lambda实现WebSecurityCustomizer接口，web变量的类型WebSecurity，箭头后面可以对其进行操作
        // 使用requestMatchers()代替antMatchers()
        return (web) -> web.ignoring().requestMatchers("/ignore1",
                                    "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**",
                    "/resources/static/**", "/css/**", "/js/**", "/img/**", "/fonts/**",
                    "/images/**", "/scss/**", "/vendor/**", "/favicon.ico", "/auth/**", "/favicon.png",
                    "/v2/api-docs", "/configuration/ui", "/configuration/security",
                    "/webjars/**", "/swagger-resources/**", "/actuator", "/swagger-ui/**",
                    "/actuator/**", "/swagger-ui/index.html", "/swagger-ui/");
    }
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
            @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;
            @Autowired
        private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
            @Autowired
        private CustomUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

        try {
            http.cors(withDefaults())
                    .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                    //使用authorizeHttpRequests()代替authorizeRequests()
                    .authorizeHttpRequests((authz) -> {
                                try {
                                    authz
                                            .requestMatchers("/").permitAll()
                                            .requestMatchers("/login").permitAll()
                                            .requestMatchers("/signup").permitAll()
                                            .requestMatchers("/dashboard/**").hasAuthority("ADMIN")
                                            //这种写法被称为Lambda DSL，代替原来的and()链式操作
                                            .anyRequest().authenticated().and().formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/login")
                                                    .loginProcessingUrl("/login").permitAll()
                                                      .failureUrl("/login?error=true")
                                                    .usernameParameter("email")
                                                    .passwordParameter("password")
                                                    .successHandler(customAuthenticationSuccessHandler)
                                                    )
                                                    .logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                                            .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                                                            .deleteCookies("JSESSIONID")
                                                            .logoutSuccessUrl("/")
                                                    .permitAll());
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    );
//                    .httpBasic();
            // 需要进行build()，返回SecurityFilterChain
        }catch (Exception e){
            e.printStackTrace();
        }
       return http.build();
    }
}
