package com.meb.dto;

import java.util.List;

import lombok.Data;

@Data
public class DatakafkaResponseDTO {
      private String description;
    private boolean status;
    private  List<Integer> syskey;
	
    
}
