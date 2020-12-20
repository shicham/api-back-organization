package com.crm.erk.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CrmErkServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmErkServerApplication.class, args);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getAuthor(@PathVariable("id") int id) {
		return "id : " + id;
	}

}
