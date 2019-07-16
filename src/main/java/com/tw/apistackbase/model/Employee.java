package com.tw.apistackbase.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;

    public static List<Employee> createTestEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Jerry");
        employee.setAge(22);
        employee.setGender("Male");
        employees.add(employee);
        return employees;
    }

}
