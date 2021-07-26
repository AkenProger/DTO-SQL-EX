package com.example.sqlex1.service.impl;

import com.example.sqlex1.dao.PCRepo;
import com.example.sqlex1.mappers.PCMapper;
import com.example.sqlex1.models.PC;
import com.example.sqlex1.models.dto.PCDto;
import com.example.sqlex1.models.tasks_dto.Task5PC;
import com.example.sqlex1.models.tasks_dto.Task9Speed;
import com.example.sqlex1.models.tasks_dto.TaskPC_1;
import com.example.sqlex1.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PCServiceImpl implements PCService {

    @Autowired
    private PCRepo pcRepo;

    @Override
    public List<TaskPC_1> findByPriceLess(double price) {
        List<PC> psc = pcRepo.findAllByPriceLessThan(price);
        List<TaskPC_1> list = psc.stream()
                .map(x -> {
                    TaskPC_1 task1 = new TaskPC_1();
                    task1.setModel(x.getProduct().getModel());
                    task1.setHd(x.getHd());
                    task1.setSpeed(x.getSpeed());
                    return task1;
                }).collect(Collectors.toList());

        return list;
    }

    @Override
    public List<Task5PC> findByCdAndPrice(Collection<String> cd, double price) {
        List<PC> pcList = pcRepo.findByCdInAndPriceLessThan(cd, price);
        List<Task5PC> task5PCList = pcList.stream()
                .map(s -> {
                    Task5PC task5PC = new Task5PC();
                    task5PC.setModel(s.getProduct().getModel());
                    task5PC.setHd(s.getHd());
                    task5PC.setSpeed(s.getSpeed());
                    return task5PC;
                }).collect(Collectors.toList());
        return task5PCList;
    }

    @Override
    public List<Task9Speed> findBySpeed(int speed) {
        List<PC> pcList = pcRepo.findBySpeed(speed);
        List<Task9Speed> task9SpeedList = pcList.stream()
                .distinct()
                .map(s -> {
                    Task9Speed task9Speed = new Task9Speed();
                    task9Speed.setMaker(s.getProduct().getMaker());
                    return task9Speed;
                }).collect(Collectors.toList());
        return task9SpeedList;
    }

}
