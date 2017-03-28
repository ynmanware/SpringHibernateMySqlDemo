package com.p1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Range;

@Entity
@NamedQueries({@NamedQuery(name = Employee.FIND_ALL_EMPLOYEES, query = "Select e from Employee e")})
@XmlRootElement(name = "employee")
public class Employee {

  public static final String FIND_ALL_EMPLOYEES = "findAllEmployees";

  @Id
  @GeneratedValue
  private Long id;

  private String name = "name";

  private String location = "location";

  @Range(min = 18, max = 65)
  private int age;

  @XmlElement
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlElement
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @XmlElement
  public Long getId() {
    return id;
  }
}
