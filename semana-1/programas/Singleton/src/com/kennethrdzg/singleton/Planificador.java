package com.kennethrdzg.singleton;

public class Planificador {
	private static Planificador instancia;
	
	// Constructor
	private Planificador() {
		// 
	}
	
	public static Planificador getInstancia() {
		if(instancia == null) {
			instancia = new Planificador();
		}
		return instancia;
	}
	
	public void agendarTarea(Tarea tarea) {
		// Implementación
	}
	
	public void ejecutarTarea() {
		// Implementación 
	}
}
