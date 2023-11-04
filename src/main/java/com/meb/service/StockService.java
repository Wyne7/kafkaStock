package com.meb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meb.dto.DataResponse;
import com.meb.model.StockModel;
import com.meb.persistence.StockRepository;
import com.meb.serviceInterface.StockServiceInterface;

@Service
public class StockService implements StockServiceInterface {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public DataResponse findItemsFromStock(int payment_id) {
        StockModel stockModel = stockRepository.findStockByPaymentId(payment_id);
        DataResponse response = new DataResponse();
        if (stockModel != null && stockModel.getQuantity() > 0) {
                response.setPayment_id(payment_id);
                response.setDescription(stockModel.getDescription());
                int requestedQuantity = 7;
                int currentQuantity = stockModel.getQuantity();
                if(requestedQuantity <= currentQuantity){
                    response.setStatus("Stock is available");
                    response.setDescription(stockModel.getDescription());
                    response.setPayment_id(payment_id);
                    int remainingQuantity = stockModel.getQuantity() - requestedQuantity;
                    stockModel.setQuantity(remainingQuantity);
                    stockRepository.save(stockModel);
                } 
        } else {
                response.setPayment_id(payment_id);
                response.setDescription(stockModel.getDescription());
                response.setStatus("Out of stock");
                return response;   
        }
        return response;
    }
}
