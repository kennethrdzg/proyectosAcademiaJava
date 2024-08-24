package com.kenneth.streams;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Salesperson s1 = new Salesperson("John", 20000.0);
		Salesperson s2 = new Salesperson("Eliza", 27000.0);
		Salesperson s3 = new Salesperson("Kevin", 24500.0);
		Salesperson s4 = new Salesperson("Christine", 32000.0);
		Salesperson s5 = new Salesperson("Ethan", 35000.0);
		Salesperson s6 = new Salesperson("Alice", 24000.0);
		Salesperson s7 = new Salesperson("Jay", 2800.0);
		Salesperson s8 = new Salesperson("Mary", 29000.0);
		
		Product p1 = new Product(100.0);
		Product p2 = new Product(75.0);
		Product p3 = new Product(120.0);
		Product p4 = new Product(200.0);
		Product p5 = new Product(90.0);
		Product p6 = new Product(45.0);
		Product p7 = new Product(140.0);
		Product p8 = new Product(210.0);
		Product p9 = new Product(160.0);
		Product p10 = new Product(95.0);
		
		List<Sale> salesData = new ArrayList<>();
		salesData.add(new Sale(p1, s2, 3));
		salesData.add(new Sale(p2, s4, 2));
		salesData.add(new Sale(p1, s3, 5));
		salesData.add(new Sale(p3, s1, 1));
		salesData.add(new Sale(p4, s5, 6));
		salesData.add(new Sale(p7, s6, 7));
		salesData.add(new Sale(p5, s7, 2));
		salesData.add(new Sale(p9, s8, 1));
		salesData.add(new Sale(p8, s4, 3));
		salesData.add(new Sale(p6, s1, 9));
		salesData.add(new Sale(p10, s2, 2));
		salesData.add(new Sale(p2, s7, 3));
		salesData.add(new Sale(p4, s3, 1));
		salesData.add(new Sale(p8, s4, 6));
		salesData.add(new Sale(p3, s5, 5));
		salesData.add(new Sale(p5, s7, 3));
		salesData.add(new Sale(p5, s1, 4));
		salesData.add(new Sale(p2, s2, 1));
		salesData.add(new Sale(p9, s6, 5));
		salesData.add(new Sale(p10, s8, 2));
		salesData.add(new Sale(p1, s1, 7));
		salesData.add(new Sale(p6, s2, 8));
		salesData.add(new Sale(p4, s5, 1));
		salesData.add(new Sale(p5, s6, 1));
		salesData.add(new Sale(p3, s1, 4));

		List<Salesperson> bestSalespersons = salesData.stream()
		.filter( (s) -> s.product.price * s.quantity >= 700.0)
		.sorted( (sale1, sale2) -> (int) (sale2.product.price * sale2.quantity - sale1.product.price * sale1.quantity))
		.map( (s) -> s.salesperson)
		.distinct()
		.limit(3)
		.collect(Collectors.toList());
		
		bestSalespersons.stream()
		.peek( (s) -> s.raiseSalary(1000.0))
		.forEach(
				(s) -> {
					System.out.println(s + " deserves a raise.");
					System.out.println("New salary: $" + s.salary);
				}
		);
	}

}
