package com.kennethrdzg.inyeccion_dependencias;

public class Inyector {
	static Negocio inyectarNegocio(String nombre, TipoPago pago, TipoPaqueteria paqueteria) {
		return new Negocio(nombre, inyectarProcesadorPago(pago), inyectarServicioPaqueteria(paqueteria));
	}
	
	private static ProcesadorPago inyectarProcesadorPago(TipoPago tipo) {
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
	
	private static ServicioPaqueteria inyectarServicioPaqueteria(TipoPaqueteria tipo) {
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
