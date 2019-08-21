package com.stocks;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stocks.entity.Stock;
import com.stocks.repo.StockRepository;

/*
 * This class is created to fulfill the requirement of generating
 * stocks in memmory
 */
@Component
public class GeneratedStock {
	@Autowired
	StockRepository stock_repo;

	@PostConstruct
	public List<Stock> getAllStocks(){		
		List<Stock> stocks = stock_repo.findAll();		
		return stocks;
	}

}
