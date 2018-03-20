package app;

import java.util.Date;



public class InicioConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaInmobiliaria sistema = new SistemaInmobiliaria();
		sistema.addPersona("11234567890", "pepe");
		sistema.addPersona("22222222222", "juan");
		//sistema.grabarPersonas(sistema.getPersonas());
		System.out.println("Still working...");
		
		sistema.addPropiedad("Rivadavia", sistema.getPersonas().get(1));
		//sistema.grabarPropiedades(sistema.getPropiedades());
		System.out.println("Still working...");
		
		//sistema.addServicio(new Date(), sistema.getPropiedades().get(0), sistema.getPersonas().get(0));
		sistema.grabarServicio(sistema.getServicios());
		System.out.println("Finished!");
	}

}
