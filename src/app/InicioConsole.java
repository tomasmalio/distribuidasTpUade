package app;

public class InicioConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaInmobiliaria sistema = new SistemaInmobiliaria();
//		sistema.addPersona("pepe");
//		sistema.grabarPersonas(sistema.getPersonas());
		
		System.out.println("Still working...");
		sistema.addPropiedad("Rivadavia");
		sistema.grabarPropiedades(sistema.getPropiedades());
		System.out.println("Finished!");
	}

}
