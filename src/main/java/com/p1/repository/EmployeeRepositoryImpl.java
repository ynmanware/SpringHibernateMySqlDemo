package com.p1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.p1.model.Employee;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

  @PersistenceContext
  private EntityManager em;

  /*
   * (non-Javadoc)
   * 
   * @see com.p1.repository.EmployeeRepository#save(com.p1.model.Employee)
   */
  public Employee save(Employee employee) {
    em.persist(employee);
    em.flush();
    return employee;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.p1.repository.EmployeeRepository#getAll()
   */
  public List<Employee> getAll() {
    Query q = em.createNamedQuery(Employee.FIND_ALL_EMPLOYEES, Employee.class);
    List<Employee> employeeList = q.getResultList();
    for (Employee employee : employeeList) {
      System.out.println(employee.getName());
    }

    return employeeList;
  }
}
