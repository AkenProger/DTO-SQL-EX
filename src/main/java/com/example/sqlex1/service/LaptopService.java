package com.example.sqlex1.service;

import com.example.sqlex1.models.tasks_dto.Task3Laptop;
import com.example.sqlex1.models.tasks_dto.Task6PC;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LaptopService {
    List<Task3Laptop>  selectAllWherePriceGreaterThan(double price);
    List<Task6PC> findLaptopByHd(double hd);
}
