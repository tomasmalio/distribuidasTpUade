package app;

import java.util.Date;

import bean.Persona;

public class InicioConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaInmobiliaria sistema = new SistemaInmobiliaria();
		Persona p1 = sistema.addPersona("11234567890", "pepe");
		Persona p2 = sistema.addPersona("22222222222", "juan");
		sistema.grabarPersonas(sistema.getPersonas());
		System.out.println("Still working...");
		
		sistema.addPropiedad("Rivadavia", p2);
		sistema.grabarPropiedades(sistema.getPropiedades());
		System.out.println("Still working...");
		
		// sistema.addServicio(new Date(), sistema.getPropiedades().get(0), sistema.getPersonas().get(0));
		// sistema.grabarServicio(sistema.getServicios());
		System.out.println("Finished!");
	}

}
