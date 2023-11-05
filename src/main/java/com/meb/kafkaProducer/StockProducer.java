package com.meb.kafkaProducer;
import java.util.List;
import org.springframework.kafka.core.KafkaTemplate;

import com.meb.dto.DataKafkaRequestDTO;

public class StockProducer {
    
//    private final KafkaTemplate<String, DataKafkaRequestDTO > kafkaTemplate;
//
//    public StockProducer(KafkaTemplate<String, DataKafkaRequestDTO>kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    
//    public void sendLogger(String message, DataKafkaRequestDTO syskey ) {
//        	
//        kafkaTemplate.send( "stock_topic", syskey);
//    }
//    
//    public void sendOrderEventstock_topic(int message,List<Integer> syskey) {
//        kafkaTemplate.send("stock-topic", syskey);
//    }
//    

}
