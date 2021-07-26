package com.example.sqlex1.models.tasks_dto;

import com.example.sqlex1.enums.PrinterType;
import lombok.Data;

@Data
public class Task4Printer {
    private Long code;
    private String model;
    private String color;
    private PrinterType printerType;
    private double price;

}
