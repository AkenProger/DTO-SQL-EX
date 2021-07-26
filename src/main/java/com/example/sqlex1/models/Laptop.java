package com.example.sqlex1.models;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Laptop {
    @Id
    private Long code;
    @ManyToOne
    @JoinColumn(name = "model")
    private Product product;
    private int speed;
    private int ram;
    private double hd;
    private double price;
    private int screen;

}
