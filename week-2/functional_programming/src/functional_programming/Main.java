package functional_programming;

import java.util.Random;
import java.util.function.*;

public class Main {
	public static void main(String[] args) {

        //Suppliers -> T, get()
		Supplier<String> greetingSupplier = () -> "Hello!";
        Supplier<Random> randomSupplier = () -> new Random();
        Supplier<Car> carSupplier = () -> new Car();
        Supplier<Employee> employeeSupplier = () -> new Employee();
        
        System.out.println("\nInterface: Suppliers");
        Car car = buildCar(carSupplier, "Tesla", "Model S", "Red");
        Employee emp = hireEmployee(employeeSupplier, "Eliza Jones", "Marketer", 40000.0);

        // Consumer<T> -> void, accept(T)
        Consumer<String> greetingConsumer = (greeting) -> System.out.println(greeting);
        Consumer<Random> coinFilp = (coin) -> {
            if(coin.nextInt() % 2 == 0){
                System.out.println("Coin landed on heads");
            }
            else{
                System.out.println("Coin landed on tails");
            }
        };
        Consumer<String> print = (s) -> System.out.println(s);
        Consumer<Car> stopCar = (c) -> c.brake(c.speed);
        print.accept("\nInterface: Consumer");
        greetingConsumer.accept(greetingSupplier.get());
        coinFilp.accept(randomSupplier.get());
        print.accept(car.toString());
        print.accept(emp.toString());

        // BiConsumer
        BiConsumer<Employee, Double> raiseSalary = (e, r) -> e.raiseSalary(r);
        BiConsumer<Employee, String> promote = (e, s) -> e.promote(s);
        BiConsumer<Car, Integer> accelerateCar = (c, i) -> c.increaseSpeed(i);
        BiConsumer<Car, Integer> decelerateCar = (c, i) -> c.brake(i);
        print.accept("\nInterface: BiConsumer");
        print.accept(emp.toString());
        print.accept("Raising " + emp.name + "'s salary");
        raiseSalary.accept(emp, 1000.0);
        print.accept("Promoting " + emp.name + " to Marketing Manager");
        promote.accept(emp, "Marketing Manager");
        print.accept(emp.toString());
        print.accept("Accelerate car 100 km/h");
        accelerateCar.accept(car, 100);
        print.accept("Decelerate car 30 km/h");
        decelerateCar.accept(car, 30);
        print.accept(car.toString());

        // Predicate -> boolean, test(T)
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        Predicate<Employee> isManager = (e) -> e.title.endsWith("Manager");
        Predicate<Car> isStopped = (c) -> c.speed == 0;
        Predicate<Car> isRed = (c) -> c.color.equals("Red");
        print.accept("\nInterface: Predicate");
        if(isManager.test(emp)){
            print.accept(emp + " is a manager");
        }
        if(!isStopped.test(car)){
            print.accept("Car is not parked");
        }
        if(isRed.test(car)){
            print.accept("Car is Red");
        }
        isEven.test(randomSupplier.get().nextInt());

        // BiPredicate
        BiPredicate<Employee, Integer> jobLongerThan = (e, i) -> e.title.length() > i;
        BiPredicate<Employee, Double> earnsLessThan = (e, s) -> e.salary < s;
        BiPredicate<Car, Integer> fasterThan = (c, i) -> c.speed > i;
        BiPredicate<Car, String> isColor = (c, s) -> c.color.equals(s);
        print.accept("\nInterface: BiPredicate");
        jobLongerThan.test(emp, 10);
        if(jobLongerThan.test(emp, 12)){
            print.accept("Job title \"" + emp.title + "\" is too long.");
        }
        if(earnsLessThan.test(emp, 50000.0)){
            print.accept("Employee " + emp.name + " earns too little.");
            raiseSalary.accept(emp, 20000.0);
        }
        if(fasterThan.test(car, 60)){
            print.accept(car + " speed exceeded 60 km/h");
            stopCar.accept(car);
        }
        if(isColor.test(car, "Red")){
            print.accept("Repainting car to Blue");
            car.color = "Blue";
        }

        // Function (T) -> R
        Function<String, Integer> stringLength = (s) -> s.length();
        Function<Random, Integer> randInt = (r) -> r.nextInt();
        Function<Employee, Character> getInitial = (e) -> e.name.charAt(0);
        Function<Integer, Double> half = (i) -> i / 2.0;
        print.accept("\nInterface: Function");
        print.accept("String \"" + emp.name + "\"\nString Length: " + stringLength.apply(emp.name));
        int rand = randInt.apply(randomSupplier.get());
        print.accept("Random Number: " + rand);
        if(isEven.test(rand)){
            print.accept(rand + " is Even");
        }
        else{
            print.accept(rand + " is Odd");
        }
        print.accept("Name: " + emp.name + ", Initial: " + getInitial.apply((emp)));
        print.accept("Half of 27 is " + half.apply(27));

        // BiFunction
        BiFunction<Car, Car, Car> fasterCar = (c1, c2) -> {
            if(c1.speed > c2.speed)
                return c1;
            else{
                return c2;
            }
        };
        BiFunction<String, Integer, String> limitString = (s, i) -> s.substring(0, i);
        BiFunction<Random, Integer, Integer> randIntRange = (r, i) -> r.nextInt(i);
        BiFunction<Double, Double, Double> applyDiscound = (p, d) -> p * d / 100.0;

        Car car2 = buildCar(carSupplier, "Ford", "Focus", "Black");
        print.accept("\nInterface: BiFunction");
        print.accept("Racing " + car + " vs " + car2);
        print.accept(fasterCar.apply(car, car2) + " is faster.");
        if(stringLength.apply(emp.title) > 12){
            print.accept(
                "Limiting \"" + emp.title + "\" to 12 characters: \"" + limitString.apply(emp.title, 12) + "\""
            );
        }
        print.accept("Rolling 1d20: " + (randIntRange.apply(randomSupplier.get(), 20) + 1)) ;
        print.accept("Original Price of a Purse: $12,346 MXN. Price after 20% discound: $" + applyDiscound.apply(12346.0, 20.0));
        // UnaryOperator
        UnaryOperator<String> strip = (s) -> s.strip();
        UnaryOperator<Integer> doubleNum = (i) -> i * 2;
        UnaryOperator<String> toUpper = (s) -> s.toUpperCase();
        UnaryOperator<String> toLower = (s) -> s.toLowerCase();
        print.accept("\nInterface: UnaryOperator");
        print.accept("Removing whitespace from \"\t Hello, World\t\t\"");
        print.accept("\"" + strip.apply("\t Hello, World\t\t") + "\"");
        print.accept("Text to Upper case: " + toUpper.apply("Hello, World"));
        print.accept("Text to lower case: " + toLower.apply("Hello, World"));
        print.accept("The double of 57 is " + doubleNum.apply(57));

        // BinaryOperator
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        BinaryOperator<Integer> modulo = (a, b) -> {
            while (a >= b) {
                a -= b;
            }
            return a;
        };
        BinaryOperator<String> concatenate = (s1, s2) -> s1.concat(" ").concat(s2);
        print.accept("\nInterface: BinaryOperator");
        print.accept("The sum of 84 and -237 is " + sum.apply(84, -237));
        print.accept("The product of 84 and -237 is " + multiply.apply(84, -237));
        print.accept("47 mod 3 is " + modulo.apply(47, 3));
        print.accept("Concatenating \"Hello\" and \"World\": " + concatenate.apply("Hello", "World"));
	}

    public static Car buildCar(Supplier<Car> carSupplier, String brand, String model, String color){
        Car car = carSupplier.get();
        car.brand = brand;
        car.model = model;
        car.color = color;
        return car;
    }

    public static Employee hireEmployee(Supplier<Employee> s, String name, String job_title, double salary){
        Employee e = s.get();
        e.name = name;
        e.title = job_title;
        e.salary = salary;
        return e;
    }
}
