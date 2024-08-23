package com.kennethrdzg.inyeccion_dependencias;

public class Orden {
	public int id;
	public String direccion;
	public boolean pagada;
	public boolean enviada;
	public Orden(int id, String direccion) {
		this.id = id;
		this.direccion = direccion;
		this.pagada = false;
		this.enviada = false;
	}
	
	@Override
	public String toString() {
		return "#" + id;
	}
}
