package com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria;

public abstract class ServicioPaqueteria {
	String nombre;
	public void enviarPaquete() {
		System.out.println("Paquete enviado por: " + this.nombre);
	}
}
