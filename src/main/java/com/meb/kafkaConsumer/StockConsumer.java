package com.meb.kafkaConsumer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.meb.dto.DataKafkaRequestDTO;
import com.meb.dto.DataResponse;
import com.meb.dto.DatakafkaResponseDTO;
import com.meb.serviceInterface.StockServiceInterface;

@Service
public class StockConsumer {
    
 
	@Autowired
	StockServiceInterface stockServiceInterface;
	
	    private KafkaTemplate<String, DatakafkaResponseDTO> kafkaTemplate;
	    
	  @KafkaListener(topics = "stock_topic", groupId = "stock")
	    public void consumeOrderEvent(List<DataKafkaRequestDTO> dataKafkaRequestDTO) {
		  	
		  DatakafkaResponseDTO datakafkaResponseDTO=stockServiceInterface.findItemsFromStock(dataKafkaRequestDTO);
	        kafkaTemplate.send("stock_topic", datakafkaResponseDTO);
	    }
}
