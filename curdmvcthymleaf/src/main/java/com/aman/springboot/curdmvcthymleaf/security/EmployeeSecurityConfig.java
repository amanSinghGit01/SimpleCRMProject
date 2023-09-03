package com.aman.springboot.curdmvcthymleaf.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Configuration
public class EmployeeSecurityConfig {
	
	
	@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
		
//		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
//		
//		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		
		return jdbcUserDetailsManager;
		
		
		
	}
	
	
	

	
	  
	  @Bean 
	  public SecurityFilterChain filterChain(HttpSecurity http) throws
	  Exception {
	 
	  http.authorizeHttpRequests(configurer -> {
		try {
			configurer
			  .requestMatchers(HttpMethod.GET,"/employees/list").hasRole("EMPLOYEE")
			  .requestMatchers(HttpMethod.GET,"/employees/showInfo").hasRole("EMPLOYEE")
			  .requestMatchers(HttpMethod.GET,"/employees/showFormForUpdate").hasRole("MANAGER")
			  .requestMatchers(HttpMethod.POST,"/employees/save").hasRole("MANAGER")
			  .requestMatchers(HttpMethod.GET,"/employees/showFormForAdd").hasRole("ADMIN")
			  .requestMatchers(HttpMethod.GET,"/employees/deleteEmployee/**").hasRole("ADMIN")
			  .anyRequest().authenticated()
			  .and()
			  .formLogin().loginPage("/showMyLoginPage")
			  .failureUrl("/showMyLoginPage?error")
			  .loginProcessingUrl("/authenticateTheUser")
			  .permitAll()
			  .and()
			  .logout()
			  .logoutUrl("/logout")
			  .logoutSuccessUrl("/showMyLoginPage?logout")
			  .permitAll()
			  .and()
			  .exceptionHandling()
			  .accessDeniedPage("/access-denied");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	  );
	 
	  
	  //use basic Authentication
	  
	  http.httpBasic();
	  
	  //disable CSRF //in general,not required for sateless REST APIs 
	  
	  
		/* http.csrf().disable(); */
	  
	  return http.build(); }
	 
	
	
	
	  /*
		 * @Bean public InMemoryUserDetailsManager userDetailManager() {
		 * 
		 * UserDetails john=User.builder() .username("john") .password("{noop}test123")
		 * .roles("EMPLOYEE") .build();
		 * 
		 * UserDetails mary=User.builder().username("mary"). password("{noop}test123")
		 * .roles("EMPLOYEE","MANAGER") .build();
		 * 
		 * UserDetails susan=User.builder().username("susan"). password("{noop}test123")
		 * .roles("EMPLOYEE","MANAGER","ADMIN") .build(); return new
		 * InMemoryUserDetailsManager(john,mary,susan); }
		 */
	
}
