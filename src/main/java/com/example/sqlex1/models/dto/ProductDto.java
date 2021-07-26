package com.example.sqlex1.models.dto;

import com.example.sqlex1.enums.ProductType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
@Data
public class ProductDto {

    private String model;
    private String maker;
    private ProductType type;

}
