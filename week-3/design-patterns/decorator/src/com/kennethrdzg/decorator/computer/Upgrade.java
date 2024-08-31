package com.kennethrdzg.decorator.computer;

abstract class Upgrade implements Computer{
    protected Computer decoratedComputer;

    public Upgrade(Computer decoratedComputer){
        this.decoratedComputer = decoratedComputer;
    }

    @Override
    public String getDescription(){
        return decoratedComputer.getDescription();
    }

    @Override
    public double getPrice(){
        return decoratedComputer.getPrice();
    }
}