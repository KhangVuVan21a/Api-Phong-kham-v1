package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.common.util.AuthTokenFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	 @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Autowired
	    private PasswordConfig passwordConfig;

	    @Bean
	    public AuthTokenFilter authenticationJwtTokenFilter(){
	        return new AuthTokenFilter();
	    };

	    @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordConfig.passwordEncoder());
	    }


	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.cors();
	        // Disable CSRF (cross site request forgery)
	        http.csrf().disable();
	        
	        // No session will be created or used by spring security
//	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        // Entry points
	        http.authorizeRequests()
	            .antMatchers("/public/**").permitAll()
	            .antMatchers("/api/auth/login", "/api/auth/register", "/index", "/swagger-ui.html" ).permitAll();

	        // error page
	        http.exceptionHandling().accessDeniedPage("/error");

	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        // Disable CSRF (cross site request forgery)
//        http.csrf().disable();
//
//        // No session will be created or used by spring security
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Entry points
//        http.authorizeRequests()
//            .antMatchers("/public/**").permitAll()
//
//            .antMatchers("/api/auth/login", "/api/auth/register", "/index", "/swagger-ui.html" ).permitAll();
//
//        // error page
//        http.exceptionHandling().accessDeniedPage("/error");
//    }
}
