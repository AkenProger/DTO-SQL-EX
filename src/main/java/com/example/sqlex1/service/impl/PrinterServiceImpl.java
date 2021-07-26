package com.example.sqlex1.service.impl;

import com.example.sqlex1.dao.PrinterRepo;
import com.example.sqlex1.models.Printer;
import com.example.sqlex1.models.tasks_dto.Task10Printers;
import com.example.sqlex1.models.tasks_dto.Task4Printer;
import com.example.sqlex1.models.tasks_dto.Task7ProductModel;
import com.example.sqlex1.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrinterServiceImpl implements PrinterService {
    @Autowired
    PrinterRepo printerRepo;

    @Override
    public List<Task4Printer> findAllPrinterByColor(String color) {
        List<Printer> printers = printerRepo.findAllByColorEquals(color);
        List<Task4Printer> task4PrinterList = printers.stream()
                .map(s -> {
                    Task4Printer task4Printer = new Task4Printer();
                    task4Printer.setCode(s.getCode());
                    task4Printer.setModel(s.getProduct().getModel());
                    task4Printer.setColor(s.getColor());
                    task4Printer.setPrinterType(s.getType());
                    task4Printer.setPrice(s.getPrice());
                    return task4Printer;
                }).collect(Collectors.toList());
        return task4PrinterList;
    }

    @Override
    public List<Task7ProductModel> findMaxPriceFromPrinter() {
        List<Printer> printers = printerRepo.findMaxPrinterPrice();
        List<Task7ProductModel> task7ProductModels = printers.stream()
                .map(s -> {
                    Task7ProductModel task7ProductModel = new Task7ProductModel();
                    task7ProductModel.setModel(s.getProduct().getModel());
                    task7ProductModel.setPrice(s.getPrice());
                    return task7ProductModel;
                }).collect(Collectors.toList());
        return task7ProductModels;
    }

    @Override
    public List<Task10Printers> findMaxPriceOfPrinters() {
        List<Printer> printers = printerRepo.findMaxPrinterPrice();
        List<Task10Printers> task10Printers = printers.stream()
                .map(s -> {
                    Task10Printers task10Printers1 = new Task10Printers();
                    task10Printers1.setMaker(s.getProduct().getMaker());
                    task10Printers1.setPrice(s.getPrice());
                    return task10Printers1;
                }).collect(Collectors.toList());
        return task10Printers;
    }


}
