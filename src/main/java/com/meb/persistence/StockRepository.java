package com.meb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meb.model.StockModel;

@Repository
public interface StockRepository extends JpaRepository<StockModel,Integer> {
    
    StockModel findStockBySyskey(int syskey);
}
