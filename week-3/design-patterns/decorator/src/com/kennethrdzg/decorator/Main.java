package com.kennethrdzg.decorator;

import com.kennethrdzg.decorator.computer.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Computer budgetPC = new BaseComputer();
        System.out.println("Description: " + budgetPC.getDescription());
        System.out.println("Price: $" + budgetPC.getPrice() + " MXN");

        System.out.println();

        Computer gamingPC = new GraphicsUpgrade(new RAMUpgrade(new SSDUpgrade(new BaseComputer())));
        System.out.println("Description: " + gamingPC.getDescription());
        System.out.println("Price: $" + gamingPC.getPrice() + " MXN"); 
    }
}
