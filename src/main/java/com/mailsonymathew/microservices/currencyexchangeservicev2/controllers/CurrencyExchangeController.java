package com.mailsonymathew.microservices.currencyexchangeservicev2.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mailsonymathew.microservices.currencyexchangeservicev2.beans.CurrencyExchangeBean;
import com.mailsonymathew.microservices.currencyexchangeservicev2.jparepository.ExchangeValueRepository;


@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;	
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
		
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		
		
		logger.info("Retrieve Exchange Value call with{} to {}",from,to);
		// Hard coded E.g.
		// CurrencyExchangeBean exchangeValue	= new CurrencyExchangeBean(100L, from, to, BigDecimal.valueOf(65));

		// Get from JPA Repository  	
		CurrencyExchangeBean  exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		// Throw exception if data is not found in repository:
		if (exchangeValue == null){
			throw new RuntimeException("Ooops!!Could not find anything in the repository for" + from + "to "+ to + "!!!");
		}
			
		// We are setting the port value as we had inserted it as null
		String port = environment.getProperty("local.server.port");
		exchangeValue.setPort(port);
		

		
		
		 return exchangeValue;
		
		
	}	
	
}
