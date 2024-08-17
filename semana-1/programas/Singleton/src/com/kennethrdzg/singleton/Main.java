package com.kennethrdzg.singleton;

enum Prioridad{
	BAJA, 
	MEDIA, 
	ALTA
}

public class Main {
	public static void main(String[] args) {
		Tarea t1 = new Tarea("Abrir Navegador");
		Planificador planificador = Planificador.getInstancia();
		planificador.agendarTarea(t1, Prioridad.BAJA);
		planificador.agendarTarea(new Tarea("Crear Respaldo"), Prioridad.ALTA);
		planificador.agendarTarea(new Tarea("Actualizar software"),  Prioridad.ALTA);
		
		planificador.ejecutarTarea();
		
		planificador.agendarTarea(new Tarea("Conectar a Red"),  Prioridad.MEDIA);
		
		planificador.ejecutarTarea();
		
		planificador.agendarTarea(new Tarea("Crear archivo 'documento.txt'"), Prioridad.BAJA);
		planificador.agendarTarea(new Tarea("Cerrar Navegador"), Prioridad.BAJA);
		
		planificador.ejecutarTodo();
	}
}
