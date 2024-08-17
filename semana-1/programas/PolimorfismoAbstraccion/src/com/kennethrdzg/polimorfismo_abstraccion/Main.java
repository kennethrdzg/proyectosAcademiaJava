package com.kennethrdzg.polimorfismo_abstraccion;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		List<Personaje> orden_combate = new ArrayList<>();
		
		
		Aventurero[] aventureros = {
				new Guerrero("Jack", rand, scanner), 
				new Picaro("Silver", rand, scanner), 
				new Mago("Merlin", rand, scanner),
				new Clerigo("Eliza", rand, scanner)
		};
		
		Monstruo mon = new Goblin(rand);
		
		iniciativa(orden_combate, aventureros, mon);
		
		System.out.println("Orden de combate: ");
		for(int i = 0; i < orden_combate.size(); i++) {
			System.out.println((i + 1) + ". " + orden_combate.get(i));
		}
		
		
		while(heroesVivos(aventureros) && mon.vida > 0) {
			System.out.println("**********");
			for(Aventurero a: aventureros) {
				if(a.vida > 0)
					a.actuar();
			}
			mon.actuar();
			for(Personaje p: orden_combate) {
				if(p instanceof Aventurero) {
					if(mon.vida <= 0)
						break;
					
					if(p.vida <= 0) 
						continue;
					
					if(p.accion == Personaje.Accion.SANAR) {
						p.ejecutarAccion(aventureros[rand.nextInt(0, aventureros.length)]);
					}
					else {
						p.ejecutarAccion(mon);
					}
					
				}
				else {
					if(p.vida <= 0)
						break;
					Personaje otro = aventureros[rand.nextInt(0, aventureros.length)];
					
					while(otro.vida <= 0) {
						otro = aventureros[rand.nextInt(0, aventureros.length)];
					}
					p.ejecutarAccion(otro);
				}
			}
		}
		System.out.println();
		if(mon.vida <=  0) {
			System.out.println("¡Ganaron los Héroes!");
		}
		else {
			System.out.println("Los héroes cayeron en combate...");
		}
	}
	
	public static boolean heroesVivos(Aventurero[] av) {
		boolean vivos = false;
		for(Aventurero a: av) {
			if(a.vida > 0) {
				vivos = true;
				break;
			}
		}
		return vivos;
	}
	
	public static void iniciativa(List<Personaje> orden, Aventurero[] aventureros, Monstruo mon) {
		orden.add(mon);
		for(Aventurero a: aventureros) {
			boolean flag = false;
			for(int i = 0; i < orden.size(); i++) {
				if(a.agilidad > orden.get(i).agilidad) {
					orden.add(i, a);
					flag = true;
					break;
				}
			}
			if(! flag) {
				orden.add(a);
			}
		}
	}
}
