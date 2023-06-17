package dev.toktab.security.config;

import dev.toktab.service.AuthenticationProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProviderService authenticationProviderService;

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProviderService);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/api/v1/**").hasRole("Head-Admin")
                .requestMatchers("/api/v1/register/**").permitAll()
                .requestMatchers("/api/v1/home/**").permitAll()
                .requestMatchers("/api/v1/login/**").permitAll()
                .requestMatchers("/api/v1/messages/**").hasAnyRole("Worker","Manager","Head-Manager","Admin","Head-Admin")
                .requestMatchers("/api/v1/profile/**").hasAnyRole("Worker","Manager","Head-Manager","Admin","Head-Admin")
                .requestMatchers("/api/v1/work/**").hasAnyRole("Worker","Manager","Head-Manager","Admin","Head-Admin")
                .requestMatchers("/api/v1/management/**").hasAnyRole("Manager","Head-Manager","Admin","Head-Admin")
                .requestMatchers("/api/v1/head/management/**").hasAnyRole("Head-Manager","Admin","Head-Admin")
                .requestMatchers("/api/v1/admin/**").hasAnyRole("Admin","Head-Admin")
                .requestMatchers("/api/v1/head-admin/**").hasAnyRole("Head-Admin")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().permitAll();//httpbasic req

//        httpSecurity.httpBasic();
//        httpSecurity.authorizeHttpRequests((auth) -> {
//            auth.anyRequest().authenticated();
//        });


        return httpSecurity.build();
    }

}
