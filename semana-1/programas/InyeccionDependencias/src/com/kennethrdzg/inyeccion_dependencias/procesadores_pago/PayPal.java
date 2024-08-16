package com.kennethrdzg.inyeccion_dependencias.procesadores_pago;

public class PayPal extends ProcesadorPago{
	@Override
	public void procesarPago() {
		System.out.println("Pago procesado por PayPal");
	}
}
