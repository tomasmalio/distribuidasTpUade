package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Setup {
	
	private SistemaInmobiliaria sistema;
	
	public Setup  (SistemaInmobiliaria s, boolean cargaAlquileres, boolean cargaVenta) {
		super();
		sistema = s;
		cargaDePersonas();
		cargaDePropiedades();
		if (cargaAlquileres)
			cargaAlquier();
		if (cargaVenta)
			cargaVenta();
	}
	
	public void cargaDePersonas () {
		sistema.addPersona("12348", "Tomás", "Lima 123", "1158259693", "tomasmalio@gmail.com" );
		sistema.addPersona("12349", "Ramon", "Julian Alvarez 32", "1590901010", "ramon@gmail.com");
		sistema.grabarPersonas(sistema.getPersonas());
		
		sistema.addPersona("12345", "Martín", "Av. Cabildo 1000", "1150001000", "martin.sacco@gmail.com");
		sistema.addPersona("12346", "Florencia", "Av. Monroe 4000", "1520004444", "florencia.otero@gmail.com");
	}	

	public void cargaDePropiedades () {
		sistema.addPropiedad("1", "Av. Cabildo", 3530, "3", "A", "Buenos Aires", "3", 120, 12000, 1000000, 100, 50, 500, sistema.buscarPersona("12345"));
		sistema.addPropiedad("2", "Juramento", 2060, "15", "B", "Buenos Aires", "5", 320, 26000, 2000000, 2030, 150, 1500, sistema.buscarPersona("12345"));
		sistema.addPropiedad("3", "Av. Lacroze", 460, "5", "D", "Buenos Aires", "1", 90, 8000, 750000, 80, 60, 300, sistema.buscarPersona("12346"));
		sistema.grabarPropiedades(sistema.getPropiedades());
	}
	
	public void cargaAlquier () {
		try {
			Date fechaRegServicio 	= new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-10");
			Date fechaDesde 		= new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
			Date fechaHasta 		= new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-01");
			
			sistema.addAlquiler(fechaDesde, fechaHasta, 1550, 3000, fechaRegServicio, sistema.buscarPropiedad("1"), sistema.buscarPersona("12346"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void cargaVenta () {
		try {
			Date fechaRegServicio 	= new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-10");
			Date fechaEscritura 	= new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01");
			
			sistema.addVenta(fechaEscritura, 1550, 3000, 100, fechaRegServicio, sistema.buscarPropiedad("1"), sistema.buscarPersona("12346"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
