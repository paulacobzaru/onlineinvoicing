package com.sda.onlineinvoicing.configuration;

import com.sda.onlineinvoicing.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();
        http.authorizeRequests()
                .antMatchers("/app/**")
                .authenticated()
                .and()
                .formLogin().permitAll() //.antMatchers("/login").permitAll();
                .and()
                .logout()
                .permitAll();
//        LogoutConfigurer<HttpSecurity> httpSecurityLogoutConfigurer = http.authorizeRequests()
//                //antMatchers("/**").hasAnyAuthority("ADMIN", "USER", "FREETRIAL")
//                .antMatchers("/pages/**", "/fragments/**", "/app/users", "/app/users/delete", "/admin/**").hasAnyAuthority("ADMIN")
//                .antMatchers("/pages/**", "/fragments", "/app/saveUser", "/app/users/edit", "/app/clients",
//                        "/app/invoiceLine", "/app/invoices", "/app/payments", "/app/products", "/app/services").hasAnyAuthority("USER", "FREETRIAL")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll() //.antMatchers("/login").permitAll();
//                .and()
//                .logout().permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
    //NOTE user detail service should be defined as bean here not resource

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}