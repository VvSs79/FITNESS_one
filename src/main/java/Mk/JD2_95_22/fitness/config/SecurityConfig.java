package Mk.JD2_95_22.fitness.config;

import Mk.JD2_95_22.fitness.web.filter.JwtFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtFilter filter;
    public SecurityConfig(JwtFilter filter) {
        this.filter = filter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter filter) throws Exception  {
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
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/v1/users").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/users/registration").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/users/verification").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/users/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/users/me").permitAll()  //authenticated()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/users/**").hasAnyAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/product").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/product/**").permitAll()    //hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/product/**").permitAll()   //hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/v1/recipe").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/recipe/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST,"/api/v1/recipe/**").permitAll()    //hasAuthority("ROLE_ADMIN")
                )
                .httpBasic(withDefaults());
        http.addFilterBefore(
                filter,
                UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}