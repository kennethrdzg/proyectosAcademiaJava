package com.kennethrdzg.inyeccion_dependencias;

public abstract class ServicioPaqueteria {
	String nombre;
	public void enviarPaquete(Orden orden) {
		if(!orden.pagada) {
			System.out.println("No se puede enviar la orden " + orden + " debido a que el pago no ha sido procesado aún.\n");
			return;
		}
		else if(orden.enviada) {
			System.out.println("La orden " + orden + " ya fue enviada a su destino.\n");
			return;
		}
		orden.enviada = true;
		System.out.println("Orden " + orden + " enviada por " + this.nombre + "a " + orden.direccion + "\n");
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
