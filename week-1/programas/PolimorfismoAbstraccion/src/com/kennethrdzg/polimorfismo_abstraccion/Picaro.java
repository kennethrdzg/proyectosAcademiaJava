package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;
import java.util.Scanner;

public class Picaro extends Aventurero{
	public Picaro(String nombre, Random rand, Scanner scanner) {
		super(nombre, rand, scanner);
		
		this.vida = 10 + rand.nextInt(1,  7);
		this.poder = 10 + rand.nextInt(1, 7);
		this.defensa = 10 + rand.nextInt(1, 5);
		this.agilidad = 10 + rand.nextInt(1, 9);
		this.mana = 0;
	}
	
	@Override
	public int calcularDefensa() {
		if(agilidad > defensa) {
			return agilidad;
		}
		return defensa;
	}
	
	@Override
	public int calcularAtaque() {
		int mod = (poder - 10) / 2;
		if(agilidad > poder) {
			mod = (poder - 10) / 2;
		}
		return rand.nextInt(1, 6) + mod;
	}
}
