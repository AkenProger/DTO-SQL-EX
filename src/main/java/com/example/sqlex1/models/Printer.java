package com.example.sqlex1.models;
import com.example.sqlex1.enums.PrinterType;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Printer {
    @Id
    private Long code;
    @ManyToOne
    @JoinColumn(name = "model")
    private Product product;
    private String color;
    @Enumerated(EnumType.STRING)
    private PrinterType type;
    private double price;

    
}
