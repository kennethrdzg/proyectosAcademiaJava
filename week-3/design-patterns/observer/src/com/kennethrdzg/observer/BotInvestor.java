package com.kennethrdzg.observer;

import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BotInvestor implements Investor {
    double initialBudget;
    double budget;
    int shares;
    double lastPrice;
    int historySize;
    List<Double> priceHistory;

    public BotInvestor(int historySize){
        this.initialBudget = 10000.0;
        this.budget = this.initialBudget;
        this.historySize = historySize;
        this.priceHistory = new ArrayList<>();
        shares = 0;
    }

    @Override
    public void update(Stock stock){
        int trend = 0;
        double currentPrice = stock.getPrice();
        priceHistory.add(currentPrice);

        if(priceHistory.size() > historySize)
            priceHistory.remove(0);
        
        for(int i = 1; i < priceHistory.size(); i++){
            if(priceHistory.get(i) < priceHistory.get(i - 1))
                trend--;
            else if(priceHistory.get(i) > priceHistory.get(i - 1))
                trend++;
        }

        if(trend < 0 && budget > currentPrice){
            budget -= currentPrice;
            shares++;
        }
        else if(trend > 0 && shares > 0){
            budget += currentPrice;
            shares--;
        }
    }

    @Override
    public void sellAll(){
        while (shares > 0) {
            budget += lastPrice;
            shares--;
        }
        System.out.print("BotInvestor's Profit: ");
        double profit = new BigDecimal(budget - initialBudget).setScale(2, RoundingMode.FLOOR).doubleValue();
        if(profit >= 0)
            System.out.println("$" + profit);
        else
            System.out.println("-$" + (profit * -1));
    }
}