package com.kennethrdzg.decorator.computer;

public class SSDUpgrade extends Upgrade{
    public SSDUpgrade(Computer decoratgedComputer){
        super(decoratgedComputer);
    }

    @Override
    public String getDescription(){
        return decoratedComputer.getDescription() + ", 1 TB SSD";
    }

    @Override
    public double getPrice(){
        return decoratedComputer.getPrice() + 1300.0;
    }
}