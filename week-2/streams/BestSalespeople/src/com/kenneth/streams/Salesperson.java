package com.kenneth.streams;

public class Salesperson {
	static int totalEmployees;
	
	public String name;
	public int employeeId;
	public double salary;
	
	public Salesperson(String name, double salary) {
		Salesperson.totalEmployees += 1;
		
		employeeId = Salesperson.totalEmployees;
		this.name = name;
		this.salary = salary;
	}
	
	public void raiseSalary(double raise) {
		this.salary += raise;
	}
	
	@Override
	public String toString() {
		return "Salesman: " + this.name;
	}
}
