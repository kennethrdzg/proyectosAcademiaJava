package com.kennethrdzg.inyeccion_dependencias;

public class Negocio {
	String nombre;
	private ProcesadorPago procesadorPago;
	private ServicioPaqueteria servicioPaqueteria;
	int orden_id;
	
	public Negocio(String nombre, ProcesadorPago procesadorPago, ServicioPaqueteria servicioPaqueteria) {
		this.nombre = nombre;
		this.procesadorPago = procesadorPago;
		this.servicioPaqueteria = servicioPaqueteria;
		this.orden_id = 0;
	}
	
	public Orden crearOrden(String direccion) {
		orden_id += 1;
		return new Orden(orden_id, direccion);
	}
	
	public void procesarPago(Orden orden) {
		System.out.println("Procesando pago de orden " + orden);
		procesadorPago.procesarPago(orden);
	}
	
	public void enviarPaquete(Orden orden) {
		System.out.println("Realizando envío de orden " + orden);
		servicioPaqueteria.enviarPaquete(orden);
	}
	
	@Override
	public String toString() {
		return nombre + ": [ Procesador de Pago = " + procesadorPago + ", Servicio de Paqueteria = " + servicioPaqueteria + "]";
	}
	
	/*
	static ProcesadorPago inyectarProcesadorPago(TipoPago tipo) {
		switch(tipo) {
		case TipoPago.PAYPAL:
			return new PayPal();
		case TipoPago.STRIPE:
			return new Stripe();
		case TipoPago.SHOPIFY:
			return new Shopify();
		}
		throw new UnsupportedOperationException();
	}
	static ServicioPaqueteria inyectarServicioPaqueteria(TipoPaqueteria tipo) {
		switch(tipo) {
		case TipoPaqueteria.FEDEX: 
			return new FedEx();
		case TipoPaqueteria.ESTAFETA: 
			return new Estafeta();
		case TipoPaqueteria.REDPACK:
			return new Redpack();
		}
		throw new UnsupportedOperationException();
	}
	 */
}
