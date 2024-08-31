package com.kennethrdzg.decorator.computer;

public class BaseComputer implements Computer{
    @Override
    public String getDescription(){
        return "Desktop Computer";
    }

    @Override
    public double getPrice(){
        return 15000.0;
    }
}