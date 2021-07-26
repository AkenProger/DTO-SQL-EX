package com.example.sqlex1.models;

import com.example.sqlex1.enums.ProductType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
@Entity
@Data
public class Product {
    @Id
    private String model;
    private String maker;
    @Enumerated(EnumType.STRING)
    private ProductType type;



}
