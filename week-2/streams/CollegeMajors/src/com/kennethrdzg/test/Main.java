package com.kennethrdzg.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("John", "Computer Science", 60, 0));
		students.add(new Student("Eliza", "Computer Science", 50, 2));
		students.add(new Student("Jenny", "Mathematics", 70, 5));
		students.add(new Student("Tom", "Business", 80, 2));
		students.add(new Student("Alice", "Psychology", 65, 2));
		students.add(new Student("Kevin", "Engineering", 60, 10));
		students.add(new Student("Maddie", "Journalism", 71, 2));
		students.add(new Student("Tyler", "Biology", 68, 4));
		students.add(new Student("Sandy", "Law", 74, 2));
		students.add(new Student("Robert", "Accounting", 57, 3));
		students.add(new Student("Pearl", "Business", 67, 0));
		students.add(new Student("Richard", "Psychology", 72, 4));
		students.add(new Student("Anne", "Journalism", 69, 4));
		students.add(new Student("Jared", "Education", 55, 7));
		students.add(new Student("Isabella", "Education", 97, 20));
		students.add(new Student("Ethan", "Education", 81, 0));
		students.add(new Student("Sarah", "Biology", 64, 1));
		students.add(new Student("Jay", "Business", 71, 2));
		students.add(new Student("Amanda", "Accounting", 63, 5));
		students.add(new Student("Homer", "Business", 60, 7));
		students.add(new Student("Olivia", "Law", 70, 4));
		students.add(new Student("Peter", "Journalism", 47, 3));
		
		
		Map<String, Integer> majors = new HashMap<>();
		
		students.stream()
			// Filters out the students who have a passing grade, keeping only those who have failed
			.filter( (student) -> student.grade < 70)
			// Allows students with less than 5 absences to do an extra credit assignment
			.peek( (s) -> s.extraCredit())
			// Filters out the students with a passing grade, if they received the extra credit
			.filter( (s) -> s.grade < 70)
			// Sorts the students from lowest grade to highest
			.sorted( (s1, s2) -> s1.grade - s2.grade)
			// Select only up to 10 student
			.limit(10)
			// Prints and lists the selected students
			.peek( (s) -> System.out.println(s))
			// Maps the students to a String of their major
			.map( (s) -> s.major)
			// Puts the Strings into a HashMap to keep track of the amount of failed students in each major
			.forEach( (m) -> {
				if(majors.containsKey(m)) {
					majors.put(m, majors.get(m) + 1);
				}
				else {
					majors.put(m, 1);
				}
			});
		
		System.out.println("Majors: " + majors);
	}

}
