package com.kennethrdzg.singleton;

public class Tarea {
	Prioridad prioridad;
	
	public Tarea() {
		prioridad = Prioridad.BAJA;
	}
	public Tarea(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
}
