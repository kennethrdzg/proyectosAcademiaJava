package com.kennethrdzg.college_majors;

public class Student {
	String name;
	String major;
	int grade;
	int absences;
	
	public Student(String name, String major, int grade, int absences) {
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.absences = absences;
	}
	
	public void extraCredit() {
		if(absences <= 5)
			// Failed students can increase their grade up to 70, but cannot exceed it
			// Students with a passing grade cannot improve their grade
			this.grade = Math.max(this.grade, Math.min(this.grade + 5, 70));
	}
	
	@Override
	public String toString() {
		return "Student [ Name: " + this.name + ", Major: " + this.major + ", Grade: " + this.grade + " ]";
	}
}
