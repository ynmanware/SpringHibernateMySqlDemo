package com.p1.service;

import java.util.List;

import com.p1.model.Employee;

public interface EmployeeService {

  Employee save(Employee employee);

  List<Employee> findAllEmployees();

}
