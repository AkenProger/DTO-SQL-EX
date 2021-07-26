package com.example.sqlex1.models.dto;

import com.example.sqlex1.models.Product;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class PCDto {
    private long code;
    private Product product;
    private int speed;
    private int ram;
    private double hd;
    private String cd;
    private double price;
}
