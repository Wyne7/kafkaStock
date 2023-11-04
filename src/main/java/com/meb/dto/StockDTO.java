package com.meb.dto;

import lombok.Data;

@Data
public class StockDTO {

    private int id;
	private int syskey;
	private int payment_syskey;
	private double price;
    private String description ;
    private String status;
}