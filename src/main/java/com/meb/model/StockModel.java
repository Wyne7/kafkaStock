package com.meb.model;

import javax.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Entity
@Data
@NamedQuery(name = "StockModel.findStockByPaymentId", query = "SELECT s FROM StockModel  s WHERE s.payment_id = :payment_id")
public class StockModel {

    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
    @Column(name = "syskey", nullable = true)
    @NotNull
	private int syskey;
    @NotNull
	private int payment_id;
    @NotNull
	private double price;
    @NotNull
    private String description ;
    @NotNull
    private int quantity;

    
    
}
