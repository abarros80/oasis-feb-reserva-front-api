package com.info.febreserva.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
/*	
	@Bean                                                             
	public UserDetailsService userDetailsService() throws Exception {
		// ensure the passwords are encoded properly
		UserBuilder users = User.withDefaultPasswordEncoder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(users.username("user").password("userPass").roles("USER").build());
		manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
		return manager;
	}

	@Bean
	@Order(1)                                                        
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		http
			.securityMatcher("/feb-api/**")                              
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().hasRole("ADMIN")
			)
			.httpBasic(withDefaults());
		return http.build();
	}

	@Bean                                                            
	public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.anyRequest().authenticated()
			)
			.formLogin(withDefaults());
		return http.build();
	}
	
	
	
*/
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
        .authorizeHttpRequests((authz) -> authz.anyRequest()
        		.permitAll())
        		//.authenticated())
        .httpBasic(withDefaults())
        .formLogin(withDefaults())
        .csrf(AbstractHttpConfigurer::disable);
		
		return http.build();
		
	}
	
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		
		

	    UserDetails user = User.withUsername("user")
	      .password(encoder().encode("userPass"))
	      .roles("USER")
	      .build();
	    return new InMemoryUserDetailsManager(user);

	}
	 
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

     

}
