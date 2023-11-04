package com.meb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meb.dto.DataResponse;
import com.meb.serviceInterface.StockServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StockController {

    @Autowired
    private StockServiceInterface stockService;

   
    @GetMapping("/stock/{payment_id}")
    public DataResponse getStockInfo(@PathVariable int payment_id) {
        DataResponse response = stockService.findItemsFromStock(payment_id);
        return response;
    }
}