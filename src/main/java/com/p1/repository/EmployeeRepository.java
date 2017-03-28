package com.p1.repository;

import java.util.List;

import com.p1.model.Employee;

public interface EmployeeRepository {

  Employee save(Employee employee);

  List<Employee> getAll();

}
