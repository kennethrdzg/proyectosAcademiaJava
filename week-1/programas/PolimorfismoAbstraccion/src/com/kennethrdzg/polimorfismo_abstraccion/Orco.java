package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;

public class Orco extends Monstruo{
	public Orco(Random rand) {
		super(rand, 2);
		this.vida = 10 + rand.nextInt(1, 7);
		this.poder = 10 + rand.nextInt(1, 9);
		this.defensa = 10 + rand.nextInt(1, 5);
		this.agilidad = 10 + rand.nextInt(1, 5);
	}
}
