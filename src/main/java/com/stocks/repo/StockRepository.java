package com.stocks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface StockRepository extends JpaRepository<Stock, Long>  {

}
