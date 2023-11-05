package com.meb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meb.dto.DataKafkaRequestDTO;
import com.meb.dto.DataResponse;
import com.meb.dto.DatakafkaResponseDTO;
import com.meb.model.StockModel;
import com.meb.persistence.StockRepository;
import com.meb.serviceInterface.StockServiceInterface;

@Service
public class StockService implements StockServiceInterface {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public DatakafkaResponseDTO findItemsFromStock(List<DataKafkaRequestDTO> dto) {
        DatakafkaResponseDTO response = new DatakafkaResponseDTO();
       for(DataKafkaRequestDTO i:dto)
       {
         StockModel stockModel = stockRepository.findStockBySyskey(i.getStock_syskey());
        if(stockModel !=null& stockModel.getQuantity()!=0)
        { 
                response.setStatus(true);
                if(stockModel.getQuantity()>=i.getQty())
                {
                	int remainingQuantity = stockModel.getQuantity() - i.getQty();
                	   stockModel.setQuantity(remainingQuantity);
                       response.setDescription("Stock Remain"+remainingQuantity);
                }
                else
                {
                	   response.setStatus(false);
                       response.setDescription("Out of stock"+stockModel.getDescription());
                       break;
                }
                stockRepository.save(stockModel);
             
        } else {
            response.setStatus(false);
                response.setDescription("Out of stock"+i.getQty());
        }
        }
        return response;

    }
}
