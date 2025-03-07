package com.fooddelivery.foodapp.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.MatcherSecurityWebFilterChain;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable() // Disable CSRF for simplicity (not recommended for production)
	            .authorizeRequests()
	            .requestMatchers("/**").permitAll() // Allow access to the /login endpoint without authentication
	            .anyRequest().authenticated()   // Protect all other endpoints
	            .and()
	            .httpBasic(); // Enable basic HTTP authentication (or use form login, JWT, etc.)
	        return http.build();
	    }
}
