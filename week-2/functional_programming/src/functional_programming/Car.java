package functional_programming;

public class Car {

    String brand;
    String model;
    String color;
    int speed;

    public void increaseSpeed(int increment){
        this.speed += increment;
    }

    public void brake(int decrement){
        this.speed = Math.max(this.speed - decrement, 0);
    }

    @Override
    public String toString(){
        return this.brand + " " + this.model + " (" + this.color + ")";
    }
}