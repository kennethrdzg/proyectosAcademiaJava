package com.kennethrdzg.observer;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        Random market = new Random();
        Stock mappleStock = new Stock("MAPPLE", 1000.0);

        HumanInvestor humanInvestor = new HumanInvestor("John");
        BotInvestor botInvestor = new BotInvestor(20);

        mappleStock.addObserver(humanInvestor);
        humanInvestor.lastPrice = mappleStock.getPrice();

        mappleStock.addObserver(botInvestor);
        botInvestor.lastPrice = mappleStock.getPrice();

        System.out.println("Initial Price: " + mappleStock);

        // Each loop represents a day of stock market exchange
        for(int i = 0; i < 365; i++){
            mappleStock.setPrice(mappleStock.getPrice() * (1 + market.nextDouble(-0.1, 0.1)));
        }

        System.out.println("Final Price: " + mappleStock);
        
        botInvestor.sellAll();
        humanInvestor.sellAll();

        mappleStock.removeObserver(humanInvestor);
        mappleStock.removeObserver(botInvestor);
    }
}
