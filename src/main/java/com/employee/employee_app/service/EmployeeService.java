package com.employee.employee_app.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.employee.employee_app.model.Employee;

@Service
public class EmployeeService {

	private final Map<Long, Employee> employeeMap = new HashMap<>();
    private Long idCounter = 1L;

    public Employee addEmployee(Employee employee) {
        employee.setId(idCounter++);
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = employeeMap.get(id);
        if (existing == null) return null;

        existing.setName(updated.getName());
        existing.setPosition(updated.getPosition());
        return existing;
    }
}
