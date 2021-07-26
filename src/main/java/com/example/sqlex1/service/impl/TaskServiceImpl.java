package com.example.sqlex1.service.impl;

import com.example.sqlex1.enums.ProductType;
import com.example.sqlex1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private PCService pcService;

    @Autowired
    private ProductService productService;

    @Autowired
    private LaptopService laptopService;

    @Autowired
    private PrinterService printerService;

    @Override
    public Object execute(String taskNum) {
        switch (taskNum) {
            case "1":
                return pcService.findByPriceLess(500);
            case "2":
                return productService.findByMakerPrinter(ProductType.Printer);
            case "3":
                return laptopService.selectAllWherePriceGreaterThan(1000);
            case "4":
                return printerService.findAllPrinterByColor("y");
            case "5":
                return pcService.findByCdAndPrice(Arrays.asList("12x", "24x"), 600);
            case "6":
                return laptopService.findLaptopByHd(10);
            case "7":
                return printerService.findMaxPriceFromPrinter();
            case "8":
                return productService.findPcMaker(ProductType.PC, ProductType.Laptop);
            case "9":
                return pcService.findBySpeed(450);
            case "10":
                return printerService.findMaxPriceOfPrinters();
            default:
                return "<h1 style='color: red;'>API с таким номером не существует!</h1>";
        }

    }
}
