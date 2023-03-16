package Mk.JD2_95_22.fitness.config.security;

import Mk.JD2_95_22.fitness.web.filtrs.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

public class SecurityConfig {
    private final JwtFilter filter;

    public SecurityConfig(JwtFilter filter) {
        this.filter = filter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

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
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/v1/users/registration").permitAll()
                        .requestMatchers("/api/v1/users/verification").permitAll()
                        .requestMatchers("/api/v1/users/me").authenticated()
                        .requestMatchers("/api/v1/users/login").permitAll()
                        .requestMatchers("/api/v1/users/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/product").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/product/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/product/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/recipe").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/recipe/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/recipe/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        http.addFilterBefore(
                filter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}
