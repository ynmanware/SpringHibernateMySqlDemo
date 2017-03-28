package com.p1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p1.model.Employee;
import com.p1.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Transactional
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public List<Employee> findAllEmployees() {
    return employeeRepository.getAll();
  }
}
