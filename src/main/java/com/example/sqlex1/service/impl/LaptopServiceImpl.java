package com.example.sqlex1.service.impl;

import com.example.sqlex1.dao.LaptopRepo;
import com.example.sqlex1.models.Laptop;
import com.example.sqlex1.models.tasks_dto.Task3Laptop;
import com.example.sqlex1.models.tasks_dto.Task6PC;
import com.example.sqlex1.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    LaptopRepo laptopRepo;

    @Override
    public List<Task3Laptop> selectAllWherePriceGreaterThan(double price) {
        List<Laptop> laptopList = laptopRepo.findAllByPriceGreaterThan(price);
        List<Task3Laptop> task3LaptopList = laptopList.stream()
                .map(s -> {
                    Task3Laptop task3Laptop = new Task3Laptop();
                    task3Laptop.setModel(s.getProduct().getModel());
                    task3Laptop.setRam(s.getRam());
                    task3Laptop.setScreen(s.getScreen());
                    return task3Laptop;
                }).collect(Collectors.toList());
        return task3LaptopList;
    }

    @Override
    public List<Task6PC> findLaptopByHd(double hd) {
        List<Laptop> laptopList = laptopRepo.findByHd(hd);
        List<Task6PC> task6PCList = laptopList.stream()
                .distinct()
                .map(s -> {
                    Task6PC task6PC = new Task6PC();
                    task6PC.setModel(s.getProduct().getModel());
                    task6PC.setSpeed(s.getSpeed());
                    return task6PC;
                }).collect(Collectors.toList());
        return task6PCList;
    }


}
