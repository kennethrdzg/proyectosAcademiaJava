package com.kennethrdzg.inyeccion_dependencias;

public abstract class ProcesadorPago {
	public abstract void procesarPago(Orden orden);
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
