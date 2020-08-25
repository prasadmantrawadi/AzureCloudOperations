package com.majesco.identity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.microsoft.azure.spring.autoconfigure.b2c.AADB2COidcLoginConfigurer;

@EnableWebSecurity
@Configuration
public class IdentityConfiguration extends WebSecurityConfigurerAdapter {

	private final AADB2COidcLoginConfigurer configurer;

	@Autowired
	public IdentityConfiguration(AADB2COidcLoginConfigurer configurer) {
		this.configurer = configurer;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().apply(configurer);
	}

	/*
	 * private final OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService;
	 * 
	 * public IdentityConfiguration(OAuth2UserService<OidcUserRequest, OidcUser>
	 * oidcUserService) { this.oidcUserService = oidcUserService; }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .anyRequest().authenticated() .and() .oauth2Login()
	 * .userInfoEndpoint() .oidcUserService(oidcUserService); }
	 */
}
