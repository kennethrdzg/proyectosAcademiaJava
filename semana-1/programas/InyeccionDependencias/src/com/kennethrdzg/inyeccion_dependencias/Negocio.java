package com.kennethrdzg.inyeccion_dependencias;

import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.*;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.*;

public class Negocio {
	String nombre;
	public Negocio(String nombre) {
		this.nombre = nombre;
	}
	
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
}
