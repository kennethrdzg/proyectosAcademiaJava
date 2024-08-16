package com.kennethrdzg.inyeccion_dependencias;

public class Shopify extends ProcesadorPago{
	@Override
	public void procesarPago(Orden orden) {
		if(orden.pagada) {
			System.out.println("La orden #" + orden + " ya fue pagada.\n");
			return;
		}
		orden.pagada = true;
		System.out.println("Pago procesado por Stripe");
		System.out.println("Pago procesado con éxito.\n");
	}
}
