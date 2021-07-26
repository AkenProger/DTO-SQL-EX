package com.example.sqlex1.service;

import com.example.sqlex1.models.tasks_dto.Task10Printers;
import com.example.sqlex1.models.tasks_dto.Task4Printer;
import com.example.sqlex1.models.tasks_dto.Task7ProductModel;

import java.util.List;

public interface PrinterService {
    List<Task4Printer> findAllPrinterByColor(String color);

    List<Task7ProductModel> findMaxPriceFromPrinter();

    List<Task10Printers> findMaxPriceOfPrinters();
}
