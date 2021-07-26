package com.example.sqlex1.service;

import com.example.sqlex1.models.dto.PCDto;
import com.example.sqlex1.models.tasks_dto.Task5PC;
import com.example.sqlex1.models.tasks_dto.Task9Speed;
import com.example.sqlex1.models.tasks_dto.TaskPC_1;

import java.util.Collection;
import java.util.List;

public interface PCService {
    List<TaskPC_1> findByPriceLess(double price);

    List<Task5PC>  findByCdAndPrice(Collection<String> cd, double price);

    List<Task9Speed> findBySpeed(int speed);



}
