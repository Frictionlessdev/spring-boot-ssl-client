package com.sb.java.training.springboot.sampleClient.model;

import lombok.Data;

import java.util.List;

@Data
public class Company {
    private List<Employee> employees;
}
