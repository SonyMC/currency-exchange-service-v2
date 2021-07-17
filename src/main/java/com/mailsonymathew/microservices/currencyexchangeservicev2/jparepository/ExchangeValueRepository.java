package com.mailsonymathew.microservices.currencyexchangeservicev2.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mailsonymathew.microservices.currencyexchangeservicev2.beans.CurrencyExchangeBean;



public interface ExchangeValueRepository extends JpaRepository<CurrencyExchangeBean, Long> {
	
	CurrencyExchangeBean findByFromAndTo(String from, String to);
	
	CurrencyExchangeBean findByFrom(String from);

	CurrencyExchangeBean findByTo(String to);
	
}
