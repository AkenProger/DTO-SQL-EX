package com.example.sqlex1.service;

import com.example.sqlex1.enums.ProductType;
import com.example.sqlex1.models.tasks_dto.Task2Product;
import com.example.sqlex1.models.tasks_dto.Task8Maker;

import java.util.List;

public interface ProductService {
    List<Task2Product> findByMakerPrinter(ProductType productType);

    List<Task8Maker> findPcMaker(ProductType productType, ProductType productType1);

}
