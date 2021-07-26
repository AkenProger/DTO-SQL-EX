package com.example.sqlex1.models.tasks_dto;

import lombok.Data;

@Data
public class Task8Maker {
    private String maker;

    public Task8Maker() {
    }

    public Task8Maker(String maker) {
        this.maker = maker;
    }
}
