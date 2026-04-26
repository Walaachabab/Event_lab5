package com.udemycourse.springboot.event_lab5.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
public class Event {
    private int id;
    private String description;
    private int capacity;
    private String startDate;
    private String endDate;
}
