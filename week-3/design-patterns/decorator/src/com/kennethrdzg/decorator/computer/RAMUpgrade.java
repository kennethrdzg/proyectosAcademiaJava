package com.kennethrdzg.decorator.computer;

public class RAMUpgrade extends Upgrade{
    public RAMUpgrade(Computer decoratgedComputer){
        super(decoratgedComputer);
    }

    @Override
    public String getDescription(){
        return decoratedComputer.getDescription() + ", 64 GB RAM";
    }

    @Override
    public double getPrice(){
        return decoratedComputer.getPrice() + 4200.0;
    }
}