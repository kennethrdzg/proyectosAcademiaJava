package com.kennethrdzg.singleton;

import java.util.List;
import java.util.ArrayList;

public class Planificador {
	private static Planificador instancia;
	private List<Tarea> baja_prioridad;
	private List<Tarea> media_prioridad;
	private List<Tarea> alta_prioridad;
	
	// Constructor
	private Planificador() {
		this.baja_prioridad = new ArrayList<Tarea>();
		this.media_prioridad = new ArrayList<Tarea>();
		this.alta_prioridad = new ArrayList<Tarea>();
	}
	
	public static Planificador getInstancia() {
		if(instancia == null) {
			instancia = new Planificador();
		}
		return instancia;
	}
	
	public void agendarTarea(Tarea tarea, Prioridad prioridad) {
		// Agenda las tareas en colas, según su prioridad
		switch(prioridad) {
		case Prioridad.BAJA: 
			this.baja_prioridad.add(tarea);
			break;
		case Prioridad.MEDIA:
			this.media_prioridad.add(tarea);
			break;
		case Prioridad.ALTA:
			this.alta_prioridad.add(tarea);
			break;
		default: 
			System.out.println("No debería llegar aquí.");
			return;
		}
		System.out.println(tarea + " agendada.");
	}
	
	public void ejecutarTarea() {
		
		// Ejecutar una sola tarea
		
		if(this.alta_prioridad.isEmpty() && this.media_prioridad.isEmpty() && this.baja_prioridad.isEmpty()) {
			System.out.println("No hay tareas que ejecutar.");
			return;
		}
		if(! this.alta_prioridad.isEmpty()) {
			this.alta_prioridad.removeFirst().ejecutar();
		}
		else if(! this.media_prioridad.isEmpty()) {
			this.media_prioridad.removeFirst().ejecutar();
		}
		else if(! this.baja_prioridad.isEmpty()) {
			this.baja_prioridad.removeFirst().ejecutar();
		}
	}
	
	public void ejecutarTodo() {
		
		// Ejecutar todas las tareas en las colas
		
		if(this.alta_prioridad.isEmpty() && this.media_prioridad.isEmpty() && this.baja_prioridad.isEmpty()) {
			System.out.println("No hay tareas que ejecutar.");
		}
		while(! this.alta_prioridad.isEmpty()) {
			this.alta_prioridad.removeFirst().ejecutar();
		}
		while(! this.media_prioridad.isEmpty()) {
			this.media_prioridad.removeFirst().ejecutar();
		}
		while(! this.baja_prioridad.isEmpty()) {
			this.baja_prioridad.removeFirst().ejecutar();
		}
	}
	
	@Override
	public String toString() {
		return "Tareas: [ ALTA: " + this.alta_prioridad.size() + ", MEDIA: " + this.media_prioridad.size() + ", BAJA: " + this.baja_prioridad.size() + "]";
	}
}
