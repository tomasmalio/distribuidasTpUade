package app;

import java.util.Date;

public class InicioConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaInmobiliaria sistema = new SistemaInmobiliaria();
		sistema.addPersona("11234567890", "pepe");
		sistema.grabarPersonas(sistema.getPersonas());
		System.out.println("Still working...");
		
		sistema.addPropiedad("Rivadavia");
		sistema.grabarPropiedades(sistema.getPropiedades());
		System.out.println("Still working...");
		
		// sistema.addServicio(new Date(), sistema.getPropiedades().get(0), sistema.getPersonas().get(0));
		// sistema.grabarServicio(sistema.getServicios());
		System.out.println("Finished!");
	}

}
