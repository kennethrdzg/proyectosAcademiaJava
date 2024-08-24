package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;

public abstract class Personaje {
	
	public enum Accion {
		ATACAR, DEFENDER, MAGIA, SANAR
	}
	
	public int vida;
	public int poder;
	public int defensa;
	public int magia;
	public int mana;
	public int agilidad;
	public int temp_def;
	public Accion accion;
	public Random rand;
	
	public Personaje(Random rand) {
		this.rand = rand;
	}
	
	public int calcularAtaque() {
		return 1;
	}
	
	public int calcularDefensa() {
		return defensa + temp_def;
	}
	
	public void ejecutarAccion(Personaje otro) {
		System.out.println();
		switch(accion) {
		case ATACAR:
			temp_def = 0;
			atacar(otro);
			break;
		case DEFENDER: 
			temp_def = (defensa - 10) / 2;
			System.out.println(this + " se prepara para defenderse.");
			break;
		case MAGIA: 
			//
			break;
		case SANAR: 
			sanar(otro);
			break;
		}
	}
	
	public void atacar(Personaje enemigo) {
		int mod = (poder - 10) / 2;
		int resultado = rand.nextInt(1, 21);
		System.out.println(this + " ataca a " + enemigo);
		if(resultado  + mod > enemigo.calcularDefensa() || resultado == 20) {
			// int dmg = 
			int ataque = calcularAtaque();
			if(resultado == 20) {
				ataque *= 2;
			}
			enemigo.vida -= ataque;
			System.out.println("¡" + enemigo + " recibió " + ataque + " puntos de daño!");
			if(enemigo.vida <= 0) {
				System.out.println(enemigo + " fue derrotado!");
			}
		}
		else {
			System.out.println("¡Pero el ataque falló!");
		}
	}
	
	public void sanar(Personaje aliado) {
		System.out.println(this + " intenta curar a " + aliado);
		if(mana < 3) {
			System.out.println("¡Sin maná suficiente!");
			return;
		}
		mana -= 3;
		int curacion = (magia - 10) / 2 + rand.nextInt(1, 6);
		aliado.vida += curacion;
		System.out.println(this + " cura a " + aliado);
		System.out.println("¡" + aliado + " recuperó " + curacion + " puntos de vida!");
	}
	
	public abstract void actuar();
}
