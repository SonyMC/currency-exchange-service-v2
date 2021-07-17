package com.mailsonymathew.microservices.currencyexchangeservicev2.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//package com.in28minutes.microservices.currencyexchangeservice.beans;
//
//import java.math.BigDecimal;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="exchange_value")
//public class ExchangeValue {
//	
//	
//	@Id
//	private Long id;
//	
//	@Column(name="currency_from")  // we need thsi as from is  akeyword in SQL and so we have to use a different column name
//	private String from;
//	
//	
//	@Column(name="currency_to") // we need thsi as to is a keyword in SQL and so we have to use a different column name
//	private String to;
//	
//	
//	private BigDecimal conversionMultiple;
//	private int port;
//	
//	
//	
//	public ExchangeValue() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	
//	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
//		super();
//		this.id = id;
//		this.from = from;
//		this.to = to;
//		this.conversionMultiple = conversionMultiple;
//	}
//
//
//	
//	
//
//	public int getPort() {
//		return port;
//	}
//
//
//
//	public void setPort(int port) {
//		this.port = port;
//	}
//
//
//
//	public Long getId() {
//		return id;
//	}
//	
//	public String getFrom() {
//		return from;
//	}
//	
//	public String getTo() {
//		return to;
//	}
//
//	public BigDecimal getConversionMultiple() {
//		return conversionMultiple;
//	}
//	
//
//
//	@Override
//	public String toString() {
//		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
//				+ conversionMultiple + "]";
//	}
//	
//	
//	
//	
//
//}

@Entity
@Table(name="currency_exchange_value")
public class CurrencyExchangeBean {

	@Id
	private Long id;
	
	@Column(name="currency_from",nullable=false)  // we need this as from is  a keyword in SQL and so we have to use a different column name
	private String from;
	
	@Column(name="currency_to",nullable=false) // we need this as from is  a keyword in SQL and so we have to use a different column name
	private String to;
	
	@Column(name="conversion_multiple_value") // if not provided , column name will be conversion_multiple
	private BigDecimal conversionMultiple;
	
	@Column(name="port",nullable=true)
	private String port;
	
	public CurrencyExchangeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CurrencyExchangeBean(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}


	
	

	public String getPort() {
		return port;
	}



	public void setPort(String port) {
		this.port = port;
	}



	public Long getId() {
		return id;
	}
	
	public String getFrom() {
		return from;
	}
	
	public String getTo() {
		return to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	


	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + "]";	
	}

}
