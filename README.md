# SpringHibernateMySqlDemo

Simple end to end example for Spring + Hibernate + MySql configuration (JSP is used on the UI side)

# Prerequisite 
install Mysql, have Tomcat 7.0+ and create a database with name 'myn'

It is a maven based dynamic java project.
Checkout, maven update, and deploy the project.
By default it empties the database on each start.
change *hibernate.hbm2ddl.auto* (jpaContext.xml) to suite your requirement

You can get the response in either json or xml format. 
try this..
1. add one or more employee
2. view list of employees

Urls:
* http://localhost:8080/SpringHibernateMySqlDemo/
* http://localhost:8080/SpringHibernateMySqlDemo/employee.json
* http://localhost:8080/SpringHibernateMySqlDemo/employee.xml


