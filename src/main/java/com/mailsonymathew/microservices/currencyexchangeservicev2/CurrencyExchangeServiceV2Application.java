package com.mailsonymathew.microservices.currencyexchangeservicev2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Currency Exchange  API", version = "1.0", description = "Documentation of Currency Exchange API v1.0"))
public class CurrencyExchangeServiceV2Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceV2Application.class, args);
	}

}
