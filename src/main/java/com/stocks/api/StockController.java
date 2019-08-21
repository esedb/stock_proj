package com.stocks.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.stocks.entity.Stock;
import com.stocks.repo.StockRepository;
import com.stocks.CException.*;



@RestController
public class StockController {
	
	@Autowired
	StockRepository stock_repo;
	
	@RequestMapping(value = {"/", "/api"}, method = {RequestMethod.GET, RequestMethod.POST}) 
	public List<Stock> home(){
		List<Stock> stock_list = stock_repo.findAll();
		if(stock_list.isEmpty()) {
			throw new NoResultException("There is no stock associated with this URL");
			
		}
		return stock_list;
	}
	
	
	@GetMapping("/api/stocks")
	public List<Stock> getStock() {
		
		List<Stock> stock_list = stock_repo.findAll();
		if(stock_list.isEmpty()) {
			throw new NoResultException("There is no stock associated with this URL");
			
		}
		return stock_list;
		
	}
	@GetMapping("/api/stocks/{id}")
	@ResponseBody
	public ResponseEntity<Stock> getAmount(@PathVariable("id") String id) {
		
		Optional<Stock> op_stock = stock_repo.findById(Long.parseLong(id));
		Stock stock = op_stock.get();
		if(stock == null) {
			throw new NoResultException("There is no stock associated with this URL");			
		}
		
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
		
	}
	
			
	@PutMapping("/api/stocks/{id}")
	@ResponseBody
	public ResponseEntity<Stock> updateStock(@RequestBody @Valid Stock stock, @PathVariable("id") String id){		
		
		Optional<Stock> op_stock = stock_repo.findById(Long.parseLong(id));
		Stock n_stock = op_stock.get();
		if(n_stock == null) {
			throw new NoResultException("There is no stock associated with this URL");			
		}
		
		n_stock.setName(stock.getName());
		n_stock.setCurrentPrice(stock.getCurrentPrice());
		n_stock.setLastupdate_time(new Date());	
		
		stock_repo.save(n_stock);
		
		return new ResponseEntity<Stock>(n_stock, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/api/stocks")
	@ResponseBody
	public ResponseEntity<Stock> createStock(@RequestBody @Valid Stock stock){
		
		stock.setCreate_time(new Date());
		stock_repo.save(stock);		
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
		
	}
	

}
