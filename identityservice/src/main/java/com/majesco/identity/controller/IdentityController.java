package com.majesco.identity.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityController {

	private void initializeModel(Model model, OAuth2AuthenticationToken token) {
		if (token != null) {
			final OAuth2User user = token.getPrincipal();

			model.addAttribute("grant_type", user.getAuthorities());
			model.addAllAttributes(user.getAttributes());
		}
	}

	@RequestMapping("/")
	public String index(Model model, OAuth2AuthenticationToken token) {
        initializeModel(model, token);
		return "Greetings from Spring Boot Azure Cloud Application updated!";
	}

}