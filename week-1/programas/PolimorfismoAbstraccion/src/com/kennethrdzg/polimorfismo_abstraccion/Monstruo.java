package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.Random;

public abstract class Monstruo extends Personaje{
	public int nivel;
	
	public Monstruo(Random rand, int nivel){
		super(rand);
		this.nivel = nivel;
	}
	
	@Override
	public void actuar() {
		if(rand.nextInt(1, 7) < 6) {
			accion = Accion.ATACAR;
		}
		else {
			accion = Accion.DEFENDER;
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
