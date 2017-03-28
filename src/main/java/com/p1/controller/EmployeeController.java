package com.p1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.p1.model.Employee;
import com.p1.service.EmployeeService;

@Controller
@SessionAttributes("employee")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping(value = "addEmployee", method = RequestMethod.GET)
  public String addEmployee(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);

    return "addEmployee";
  }

  @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
  public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee,
      BindingResult result) {

    System.out.println("result has errors: " + result.hasErrors());
    System.out.println("Employee " + employee.getName());
    if (result.hasErrors()) {
      return "addEmployee";
    } else {
      employeeService.save(employee);
    }

    return "redirect:index.jsp";
  }

  @RequestMapping(value = "getEmployees", method = RequestMethod.GET)
  public String getEmpoyees(Model model) {
    List<Employee> employees = employeeService.findAllEmployees();
    model.addAttribute("employees", employees);
    return "getEmployees";
  }

  @RequestMapping(value = "employee.xml", method = RequestMethod.GET)
  public @ResponseBody Employee getEmployeeInXML() {
    List<Employee> employees = employeeService.findAllEmployees();
    return employees.get(0);
  }

  @RequestMapping(value = "employee.json", method = RequestMethod.GET)
  public @ResponseBody Employee getEmployeeInJson() {
    List<Employee> employees = employeeService.findAllEmployees();
    return employees.get(0);
  }

}
