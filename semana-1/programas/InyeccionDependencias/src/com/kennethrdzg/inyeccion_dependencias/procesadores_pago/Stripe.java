package com.kennethrdzg.inyeccion_dependencias.procesadores_pago;

public class Stripe extends ProcesadorPago{
	@Override
	public void procesarPago() {
		System.out.println("Pago procesado por Stripe");
	}
}
