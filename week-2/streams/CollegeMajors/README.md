# College Majors
**By Kenneth Rodriguez**

## The Problem

A college wants to determine which majors the 10 students with the worst grades belong who have failed their respective course. To pass a course, the student must earn a grade of 70. However, all students who have failed their course and have not missed more than 5 days of class will be allowed to submit an extra credit work, which will award them up 5 points, increasing their grade up to (but not exceeding) the passing grade. 

Once students have submitted the extra credit work, the lowest 10 scoring and failing students will be selected. The dean will then proceed to check their respective majors and help them improve their grades. 

## Classes
This program uses 1 class: `Student`. 

### Student
The `Student` class represents an individual student in college. The class contains 4 attributes: the student's name, their major, their grade, and their absences during the semester. The class also has a single method: `extraCredit()` which allows the student to submit an extra credit work to try and pass their course. 

```
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
			this.grade = Math.max(this.grade, Math.min(this.grade + 5, 70));
	}
}

```

## Solution

The `List` of students first has to be filtered, eliminating students with a passing grade (70 or above). After filtering the students, they can be allowed to submit the extra credit assignment. The assignment allows a few failing students to pass, so the list must be filtered yet again, eliminating the students who have a passing grade. 

The dean will only focus on the 10 lowest scoring students, so we have to sort the students by grade and then select the lowest 10 students. After having identified the students, we can map each of them to identify their majors and, using a `Map`, keep track of how many of these students belong to each of their majors. 

```
		List<Student> students = new ArrayList<>();
		Map<String, Integer> majors = new HashMap<>();
		
		students.stream()
			.filter( (student) -> student.grade < 70)
			.peek( (s) -> s.extraCredit())
			.filter( (s) -> s.grade < 70)
			.sorted( (s1, s2) -> s1.grade - s2.grade)
			.limit(10)
			.peek( (s) -> System.out.println(s))
			.map( (s) -> s.major)
			.forEach( (m) -> {
				if(majors.containsKey(m)) {
					majors.put(m, majors.get(m) + 1);
				}
				else {
					majors.put(m, 1);
				}
			});
		
		System.out.println("Majors: " + majors);
```