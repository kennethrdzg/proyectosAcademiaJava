package com.kennethrdzg.observer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HumanInvestor implements Investor{
    String name;
    double initialBudget;
    double budget;
    int shares;
    public double lastPrice;

    public HumanInvestor(String name){
        this.name = name;
        this.initialBudget = 10000.0;
        this.budget = this.initialBudget;
        this.shares = 0;
    }
    
    @Override
    public void update(Stock stock){
        double currentPrice = stock.getPrice();
        if(currentPrice < lastPrice && budget > currentPrice){
            shares++;
            budget -= currentPrice;
        }
        else if(currentPrice > lastPrice && shares > 1){
            shares--;
            budget += currentPrice;
        }
        lastPrice = currentPrice;
    }

    @Override
    public void sellAll(){
        while (shares > 0) {
            budget += lastPrice;
            shares--;
        }
        
        double profit = new BigDecimal(budget - initialBudget).setScale(2, RoundingMode.FLOOR).doubleValue();
        System.out.print(this.name + "'s Profit : ");
        if(profit >= 0)
            System.out.println("$" + profit);
        else
            System.out.println("-$" + (profit * -1));
    }
}