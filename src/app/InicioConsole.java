package app;

public class InicioConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SistemaInmobiliaria sistema = new SistemaInmobiliaria();
		sistema.addPropiedad("Rivadavia");
		
		sistema.grabarUsuarios(sistema.getUsuarios());
	}

}
