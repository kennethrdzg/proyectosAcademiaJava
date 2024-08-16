package com.kennethrdzg.inyeccion_dependencias;

import com.kennethrdzg.inyeccion_dependencias.procesadores_pago.*;
import com.kennethrdzg.inyeccion_dependencias.servicios_paqueteria.*;

public class Pedido {
	String cliente;
	String direccion;
	ProcesadorPago formaDePago;
	ServicioPaqueteria paqueteria;
}
