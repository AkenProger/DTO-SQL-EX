package com.example.sqlex1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PC {
    @Id
    private long code;
    @ManyToOne
    @JoinColumn(name = "model")
    private Product product;
    private int speed;
    private int ram;
    private double hd;
    private String cd;
    private double price;
}
