package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.Employee;
import com.kh.polymorphism.model.Engineer;

public class EmployeeController {

	public Employee findEmployee(Employee[] emp, String name) {
		for(int i = 0; i < emp.length; i++) {
			if(emp[i].getName().equals(name)) {
				return emp[i];
			}
		}
		/*
		for (Employee employee : emp) {
			if (employee.getName().equals("최다인")) {
				return employee;
			}
		}*/
		return null;
	}

	public int getAnnualSalary(Employee findEmployee) {
		if (findEmployee == null) return -1;
		
		if (findEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) findEmployee;
			return (findEmployee.getSalary() * 12 + engineer.getBonus());
		}
		return findEmployee.getSalary() * 12;

	}

	public int totalSalary(Employee[] emp) {
		int sum = 0;
		for (Employee employee : emp) {
			sum += employee.getSalary();
		}
		return sum;

	}
}
