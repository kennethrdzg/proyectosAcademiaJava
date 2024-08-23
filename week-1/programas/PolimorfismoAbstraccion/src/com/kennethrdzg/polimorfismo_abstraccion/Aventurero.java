package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;
import java.util.Scanner;

public abstract class Aventurero extends Personaje {
	public String nombre;
	public Scanner scanner;
	public Aventurero(String nombre, Random rand, Scanner scanner) {
		super(rand);
		this.nombre = nombre;
		this.scanner = scanner;
	}
	
	@Override
	public void actuar() {
		System.out.println("Turno: " + this);
		System.out.println("Atributos: " + "[ATK=" + poder + ", DEF=" + defensa + ", MANA=" + mana +", HP=" + vida + "]");
		System.out.println("¿Qué Desea Hacer?");
		System.out.println("1 - Atacar\n2 - Defender");
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
			default: 
				System.out.println("Opción Invalida");
				opc = -1;
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + nombre;
	}
}
