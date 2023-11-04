package com.meb.serviceInterface;

import org.springframework.stereotype.Service;

import com.meb.dto.DataResponse;

@Service
public interface StockServiceInterface {

    DataResponse findItemsFromStock(int payment_id);
}