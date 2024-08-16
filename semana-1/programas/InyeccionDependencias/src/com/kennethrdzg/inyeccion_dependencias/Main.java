package com.kennethrdzg.inyeccion_dependencias;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;
		
		Negocio negocio = Inyector.inyectarNegocio("MiPrimerTiendita", TipoPago.STRIPE, TipoPaqueteria.REDPACK);
		
		
		
		System.out.println(negocio);
		Orden o1 = negocio.crearOrden("Av. Siempreviva 742, Springfield, E.E.U.U.");
		Orden o2 = negocio.crearOrden("221B Baker Street, Londres, Inglaterra");
		Orden o3 = negocio.crearOrden("Calle Wallaby 42, Sydney, Australia");
		
		negocio.procesarPago(o1);
		negocio.procesarPago(o2);
		
		negocio.enviarPaquete(o3);
		negocio.procesarPago(o2);
		
		negocio.procesarPago(o3);
		
		negocio.enviarPaquete(o1);
		negocio.enviarPaquete(o2);
		negocio.enviarPaquete(o3);
		negocio.enviarPaquete(o1);
		
		// System.out.println("PROGRAMA FINALIZADO");
	}
}
