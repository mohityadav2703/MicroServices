package com.ms.app.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.app.entity.Stock;
import com.ms.app.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageStore {
	
	@Autowired
	private StockRepository repo;
	
	public void save(Stock stock) {
		log.info("INSIDE MESSAGE STORE TO SAVE {}", stock);
		repo.save(stock);
	}
	
	public List<Stock> fetchAll() {
		log.info("INSIDE MESSAGE STORE TO FETCH ");
		return repo.findAll();
	}


}
