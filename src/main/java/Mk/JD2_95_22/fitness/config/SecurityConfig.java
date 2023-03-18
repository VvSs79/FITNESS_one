package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.web.filtrs.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter filter) throws Exception {
        // Enable CORS and disable CSRF
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
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,  //401
                                    ex.getMessage()
                            );
                        }
                )
                .accessDeniedHandler((request, response, ex) -> {
                    response.setStatus(
                            HttpServletResponse.SC_FORBIDDEN  //403
                    );
                })
                .and();

        // Set permissions on endpoints
        http
                .authorizeHttpRequests((authz) -> authz
                        // Our public endpoints
                        .requestMatchers("/api/v1/users/registration").permitAll()
                        .requestMatchers("/api/v1/users/verification").permitAll()
                        .requestMatchers("/api/v1/users/me").authenticated()
                        .requestMatchers("/api/v1/users/login").permitAll()
                        .requestMatchers("/api/v1/users/**").hasRole("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/product").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/product/**").hasRole("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/product/**").hasRole("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/recipe").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/recipe/**").hasRole("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/recipe/**").hasRole("ROLE_ADMIN")

                        //Our private endpoints
                        .anyRequest().authenticated()
                );

        // Add JWT token filter
        http.addFilterBefore(
                filter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
