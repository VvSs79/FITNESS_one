package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.web.filter.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,JwtFilter filter) throws Exception {
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.setStatus(
                                    HttpServletResponse.SC_UNAUTHORIZED
                            );
                        }
                )
                .accessDeniedHandler((request, response, ex) -> {
                    response.setStatus(
                            HttpServletResponse.SC_FORBIDDEN
                    );
                })
                .and();

        // Set permissions on endpoints
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/v1/users/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/users/").hasRole("ADMIN")
                        .requestMatchers("/api/v1/users/registration").permitAll()
                        .requestMatchers("/api/v1/users/verification").permitAll()
                        .requestMatchers("/api/v1/users/login").permitAll()
                        .requestMatchers("/api/v1/users/me").hasAnyAuthority("USER","ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/product").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/recipe").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/product/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/product").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/recipe/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/recipe").hasRole("ADMIN")

//                .httpBasic(withDefaults());
//        http.addFilterBefore(
//                filter,
//                UsernamePasswordAuthenticationFilter.class
                .anyRequest().authenticated());

        // Add JWT token з
        http.addFilterBefore(
                filter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}