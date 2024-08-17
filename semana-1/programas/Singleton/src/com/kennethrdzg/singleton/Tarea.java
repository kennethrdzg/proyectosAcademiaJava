package com.kennethrdzg.singleton;

public class Tarea {
	String nombre;
	
	public Tarea(String nombre) {
		this.nombre = nombre;
	}
	
	public void ejecutar() {
		System.out.println(this + " ejecutada.");
	}
	
	@Override
	public String toString() {
		return "Tarea [" + nombre + "]";
	}
}
