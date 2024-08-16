package com.kennethrdzg.inyeccion_dependencias;

import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.PayPal;
import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.ProcesadorPago;
import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.Shopify;
import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.Stripe;
import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.TipoPago;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.Estafeta;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.FedEx;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.Redpack;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.ServicioPaqueteria;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.TipoPaqueteria;

public class Inyector {
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
