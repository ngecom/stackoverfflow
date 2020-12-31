package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

public class CustomService {
	 public void serviceMethod(String message) {
	        System.out.println(message);
	    }
	    
	    public void invokeMethod() {
	        System.out.println("=============== Your method has executed !");
	    }
	    
	    public List<Employee> getEmployees(){
	        // In real world, it will be an GET API call to XYZ system
	        List<Employee> employees = new ArrayList<>();
	        employees.add(Employee.builder().firstName("Ravi").lastName("Shankar").email("ravi.shankar@gmail.com").age(30).build());
	        employees.add(Employee.builder().firstName("Parag").lastName("Rane").email("parag.rane@gmail.com").age(11).build());
	        employees.add(Employee.builder().firstName("Priya").lastName("Pande").email("priya.pande@gmail.com").age(40).build());
	        employees.add(Employee.builder().firstName("Kiran").lastName("khot").email("kiran.khot@gmail.com").age(50).build());
	        System.out.println("=============== Your method has executed Employees-->"+employees);
	        return employees;
	    }
}
