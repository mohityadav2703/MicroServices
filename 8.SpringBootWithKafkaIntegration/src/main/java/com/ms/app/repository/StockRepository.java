package com.ms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.app.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
