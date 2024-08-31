package com.kennethrdzg.observer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    String name;
    private List<Investor> observers = new ArrayList<>();
    private double price;

    public Stock(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void addObserver(Investor investor){
        observers.add(investor);
    }

    public void removeObserver(Investor investor){
        observers.remove(investor);
    }

    public void notifyObservers(){
        for(Investor investor: observers){
            investor.update(this);
        }
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        BigDecimal d = new BigDecimal(price).setScale(2, RoundingMode.FLOOR);
        this.price = Math.max(d.doubleValue(), 0.01);
        notifyObservers();
    }

    public String toString(){
        return this.name + " - $" + this.price;
    }
}