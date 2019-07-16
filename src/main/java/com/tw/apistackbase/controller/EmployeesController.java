package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable int id) {
        employees = employees.stream().filter(employee -> employee.getId() != id).collect(Collectors.toList());
    }

    @PutMapping()
    public void updateEmployee(@RequestBody Employee employee) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            employees.remove(index);
            employees.add(index, employee);
        }
    }
}
