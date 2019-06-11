package com.local.ysf.Proxy.proxSsecurity.security;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.local.ysf.Proxy.proxSsecurity.JWT.JWTAuthenticationFilter;
import com.local.ysf.Proxy.proxSsecurity.JWT.JWTAutorizationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) ;
		http.formLogin();
		http.authorizeRequests().antMatchers("/*").permitAll();
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/books/book")
			.hasAuthority("ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.DELETE,"/books/book/*")
			.hasAuthority("ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST,"/reader/reader")
			.hasAuthority("ADMIN")
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.DELETE,"/reader/reader/*")
			.hasAuthority("ADMIN")
			.and()
            .logout()
            .logoutUrl("/logout")
            .permitAll()
            .invalidateHttpSession(true);
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilterBefore(new JWTAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	}
}
