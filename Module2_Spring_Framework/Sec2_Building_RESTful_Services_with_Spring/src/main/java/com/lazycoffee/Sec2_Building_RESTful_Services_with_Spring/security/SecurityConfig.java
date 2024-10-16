package com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.jwtutils.JwtAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;  
// Import this for `withDefaults()` part of the Spring Security package that allows configuring default settings for certain components, like httpBasic()

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 private final JwtAuthenticationFilter jwtAuthenticationFilter;

	    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
	        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	    }
	    
	    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.csrf(csrf -> csrf.disable())  // Disable CSRF protection for API endpoints //By default, Spring Security enables CSRF protection, which can block non-browser clients (like Postman or cURL) from making POST, PUT, DELETE, and PATCH requests if no CSRF token is provided.
        									// hence we Disable CSRF Protection for API Endpoints whiele development. or we could implement CSRF token handling.
        	.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/public/**").permitAll()  // Public endpoints
                    .requestMatchers("/api/authenticate/**").permitAll()
                    .anyRequest().authenticated()  // All other endpoints require authentication
            )
            //.httpBasic(withDefaults());  // Enable basic authentication with default settings // Disabling it for now to add JWT filter
        	.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);  // Add JWT filter

        return http.build();
    }
    
    // Define the AuthenticationManager bean explicitly
    // AuthenticationManager is no longer automatically exposed as a bean, so you need to explicitly configure it in your SecurityConfig
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
   
}
