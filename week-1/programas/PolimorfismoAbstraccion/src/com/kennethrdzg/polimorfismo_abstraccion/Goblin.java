package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;

public class Goblin extends Monstruo{
	public Goblin(Random rand) {
		super(rand, 1);
		this.vida = 10 + rand.nextInt(1, 5);
		this.poder = 10 + rand.nextInt(1, 5);
		this.defensa = 10 + rand.nextInt(1, 5);
		this.agilidad = 10 + rand.nextInt(1, 7);
	}
	
	public int calcularAtaque() {
		return rand.nextInt(1, 4) + (poder - 10) / 2;
	}
}
