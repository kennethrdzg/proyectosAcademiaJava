package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;
import java.util.Scanner;

public class Mago extends Aventurero{
	public Mago(String nombre, Random rand, Scanner scanner) {
		super(nombre, rand, scanner);
		this.vida = 10 + rand.nextInt(1,  5);
		this.poder = 10 + rand.nextInt(1, 5);
		this.defensa = 10 + rand.nextInt(1, 5);
		this.agilidad = 10 + rand.nextInt(1, 7);
		this.magia = 10 + rand.nextInt(1, 9);
		this.mana = 10 + rand.nextInt(1, 11);
	}
	
	@Override
	public int calcularAtaque() {
		return rand.nextInt(1, 4) + (poder - 10) / 2;
	}
}
