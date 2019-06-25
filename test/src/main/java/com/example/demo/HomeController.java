package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String home() {
		return restTemplate.getForObject("http://inputfile/", String.class);
	}

}
