package com.kennethrdzg.observer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    String name;
    private List<Investor> investors = new ArrayList<>();
    private double price;

    public Stock(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void addObserver(Investor investor){
        investors.add(investor);
    }

    public void removeObserver(Investor investor){
        investors.remove(investor);
    }

    public List<Investor> getInvestors(){
        return this.investors;
    }

    public int notifyObservers(){
        int notified = 0;
        for(Investor investor: investors){
            investor.update(this);
            notified += 1;
        }
        return notified;
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
        return this.name + " [ $" + this.price + " ]";
    }
}
