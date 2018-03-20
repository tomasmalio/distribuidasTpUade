package app;

import java.util.Date;



public class InicioConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaInmobiliaria sistema = new SistemaInmobiliaria();
		sistema.addPersona("11234567890", "pepe", "asd", "asd", "asd");
		sistema.addPersona("20331114821", "Lima 123", "tomasmalio@gmail.com", "Tomás", "1158259693");
		//sistema.grabarPersonas(sistema.getPersonas());
		System.out.println("Still working...");
		
		sistema.addPropiedad("Rivadavia", sistema.getPersonas().get(1));
		//sistema.grabarPropiedades(sistema.getPropiedades());
		System.out.println("Still working...");
		
		// sistema.addServicio(new Date(), sistema.getPropiedades().get(0), sistema.getPersonas().get(0));
		// sistema.addAlquiler(new Date(), new Date(), 100, 100, new Date(), sistema.getPropiedades().get(0), sistema.getPersonas().get(0));
		sistema.addVenta(new Date(), 100, 100, 100, new Date(), sistema.getPropiedades().get(0), sistema.getPersonas().get(0));
		sistema.grabarVentas(sistema.getVentas());
		System.out.println("Finished!");
	}

}
