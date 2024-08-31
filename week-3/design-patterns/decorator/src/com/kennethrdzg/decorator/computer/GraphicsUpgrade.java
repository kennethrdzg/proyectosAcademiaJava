package com.kennethrdzg.decorator.computer;

public class GraphicsUpgrade extends Upgrade{
    public GraphicsUpgrade(Computer decoratgedComputer){
        super(decoratgedComputer);
    }

    @Override
    public String getDescription(){
        return decoratedComputer.getDescription() + ", Dedicated GPU";
    }

    @Override
    public double getPrice(){
        return decoratedComputer.getPrice() + 5000.0;
    }
}