package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;
import java.util.Scanner;

public class Clerigo extends Aventurero{
	public Clerigo(String nombre, Random rand, Scanner scanner) {
		super(nombre, rand, scanner);
		
		this.vida = 10 + rand.nextInt(1,  7);
		this.poder = 10 + rand.nextInt(1, 5);
		this.defensa = 10 + rand.nextInt(1, 7);
		this.agilidad = 10 + rand.nextInt(1, 7);
		this.magia = 10 + rand.nextInt(1, 9);
		this.mana = 10 + rand.nextInt(1, 9);
	}
	@Override
	public int calcularAtaque() {
		return rand.nextInt(1, 5) + (poder - 10) / 2;
	}
	
	@Override
	public void actuar() {
		System.out.println("Turno: " + this);
		System.out.println("Atributos: " + "[ATK=" + poder + ", DEF=" + defensa + ", MANA=" + mana +", HP=" + vida + "]");
		System.out.println("¿Qué Desea Hacer?");
		System.out.println("1 - Atacar\n2 - Defender\n3 - Sanar Aliados");
		int opc = -1;
		while(opc == -1) {
			System.out.print("Selección: ");
			opc = scanner.nextInt();
			switch(opc) {
			case 1: 
				accion = Accion.ATACAR;
				break;
			case 2: 
				accion = Accion.DEFENDER;
				break;
			case 3: 
				accion = Accion.SANAR;
				break;
			default: 
				System.out.println("Opción Invalida");
				opc = -1;
				break;
			}
		}
	}
}
