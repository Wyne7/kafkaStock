package com.meb.dto;

import java.util.List;

import lombok.Data;

@Data
public class DataResponse {
    
    private int payment_id;
    private String description;
    private boolean status;
    private  List<Integer> syskey;
}
