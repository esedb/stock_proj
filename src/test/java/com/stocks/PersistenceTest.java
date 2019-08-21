package com.stocks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stocks.entity.Stock;
import com.stocks.repo.StockRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class PersistenceTest {
	@Autowired
	StockRepository stock_repo;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	   
	    Stock stock = new Stock();
	   
	    stock.setName("Car");
	    stock.setCurrentPrice(3000L);
	    stock_repo.save(stock);  
	 
	    
	}

}
