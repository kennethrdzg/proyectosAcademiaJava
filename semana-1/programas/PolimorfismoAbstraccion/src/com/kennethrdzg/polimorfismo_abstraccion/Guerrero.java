package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;
import java.util.Scanner;

public class Guerrero extends Aventurero{
	public Guerrero(String nombre, Random rand, Scanner scanner) {
		super(nombre, rand, scanner);
		this.vida = 10 + rand.nextInt(1, 9);
		this.poder = 10 + rand.nextInt(1, 9);
		this.defensa = 10 + rand.nextInt(1, 7);
		this.agilidad = 10 + rand.nextInt(1, 5);
		this.mana = 0;
	}
	
	@Override
	public int calcularAtaque() {
		return rand.nextInt(1, 9) + (poder - 10) / 2;
	}
}
