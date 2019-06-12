package com.local.ysf.Proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ProxyApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder creatBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}
