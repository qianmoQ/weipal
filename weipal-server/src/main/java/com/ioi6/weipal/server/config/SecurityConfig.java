package com.ioi6.weipal.server.config;

import com.ioi6.weipal.server.security.WeipalAuthenticationFailureHandler;
import com.ioi6.weipal.server.security.WeipalAuthenticationSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * user security config
 * Created by shicheng on 2017/5/11.
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String LOGIN_PAGE_URL = "/login";
    public static final String LOGIN_ERROR_URL = "/authorization/error";
    public static final String TARGET_URL_PARAMETER = "from";
    private static final String LOGIN_PROCESSING_URL = "/authorization/authenticate";
    private static final String REGISTER_ACTIVATE_URL = "/register/activate";
    private static final String DOCUMENT_VIEW_URL = "/manual/documentview";
    // all user access url
    private static final String[] ACCESS_URL = {"/index", "/", "/register"};
    private static final String[] STATIC_RESOURCES_URL_PATTERN = {"/vendor/**", "/website/**"};

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private WeipalAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private WeipalAuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("config http security");
        http.csrf().disable().authorizeRequests().antMatchers(ACCESS_URL).permitAll().
                and().
                authorizeRequests().antMatchers(REGISTER_ACTIVATE_URL).permitAll().
                and().
                authorizeRequests().antMatchers(DOCUMENT_VIEW_URL).permitAll().
                and().
                authorizeRequests().antMatchers(LOGIN_ERROR_URL).permitAll().
                anyRequest().authenticated().
                and().
                formLogin().loginPage(LOGIN_PAGE_URL).permitAll().
                loginProcessingUrl(LOGIN_PROCESSING_URL).permitAll().
                successHandler(authenticationSuccessHandler).
                failureHandler(authenticationFailureHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/").permitAll()
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        log.info("config web static source");
        web.ignoring().antMatchers(HttpMethod.GET, STATIC_RESOURCES_URL_PATTERN);
    }

}
