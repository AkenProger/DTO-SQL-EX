package com.example.sqlex1.service.impl;

import com.example.sqlex1.dao.ProductRepo;
import com.example.sqlex1.enums.ProductType;
import com.example.sqlex1.models.Product;
import com.example.sqlex1.models.tasks_dto.Task2Product;
import com.example.sqlex1.models.tasks_dto.Task8Maker;
import com.example.sqlex1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Task2Product> findByMakerPrinter(ProductType productType) {
        List<Product> productList = productRepo.findDistinctMakerByType(productType);
        List<String> strings = new ArrayList<>();
        for (Product product : productList) {
            strings.add(product.getMaker());
        }
        List<Task2Product> task2Products = strings.stream()
                .distinct()
                .map(s-> {
                    Task2Product task2Product = new Task2Product();
                    task2Product.setMaker(s);
                    return task2Product;
                }).collect(Collectors.toList());
        return task2Products;
    }

    @Override
    public List<Task8Maker> findPcMaker(ProductType productType, ProductType productType1) {
        return productRepo.findByPcMaker(productType, productType1);
    }
}
