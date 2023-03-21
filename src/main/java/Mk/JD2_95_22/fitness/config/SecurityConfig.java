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
//    private final JwtFilter filter;
//
//    public SecurityConfig(JwtFilter filter) {
//        this.filter = filter;
//    }
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
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();

        // Set permissions on endpoints
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/users/**").hasRole("ROLE_ADMIN")
                        .requestMatchers("/users/").hasRole("ROLE_ADMIN")
                        .requestMatchers("/users/registration").permitAll()
                        .requestMatchers("/users/verification").permitAll()
                        .requestMatchers("/users/login").permitAll()
                        .requestMatchers("/users/me").hasRole("ROLE_USER")
                        .requestMatchers(HttpMethod.GET,"/product").permitAll()
                        .requestMatchers(HttpMethod.GET,"/recipe").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/product/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/product").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/recipe/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/recipe").hasRole("ADMIN")

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