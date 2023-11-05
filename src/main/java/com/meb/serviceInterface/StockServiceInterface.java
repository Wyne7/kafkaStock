package com.meb.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meb.dto.DataKafkaRequestDTO;
import com.meb.dto.DatakafkaResponseDTO;

@Service
public interface StockServiceInterface {

    DatakafkaResponseDTO findItemsFromStock(List<DataKafkaRequestDTO> dto);
}