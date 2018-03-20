/****************************************************
 * Aplicaciones Distribuidas 2018 Verano
 * Trabajo Práctico - Inmobiliaria
 * GitHub: https://github.com/tomasmalio/distribuidasTpUade
 * 
 * @author	Tomas Malio, 
 * 			Florencia Otero
 * 			Martin Sacco,
 * 
 ****************************************************/
package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import bean.Persona;
import views.AlquilerAlta;
import views.AlquilerModificar;
import views.VentaAlta;
import views.VentaBaja;
import views.VentaModificar;
import views.AlquilerBaja;

public class Inicio extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JMenuBar jMenuBar;

	private JMenu jMenuAlquiler;
	private JMenu jMenuVenta;
	
	private JMenuItem jMenuAltaAlquiler;
	private JMenuItem jMenuModificarAlquiler;
	private JMenuItem jMenuBajaAlquiler;
	
	private JMenuItem jMenuAltaVenta;
	private JMenuItem jMenuModificarVenta;
	private JMenuItem jMenuBajaVenta;

	private JMenu jMenuSalir;
	
	private SistemaInmobiliaria inmobiliariaController;
	
	public Inicio() {
		super();
		inmobiliariaController = SistemaInmobiliaria.getInstance();
		setup();
		initGUI();
	}
	
    public static void main(String[] args) {
	    	Inicio inicio = new Inicio();
	    	inicio.setVisible(true);
    }
    
    private void setup() {
    	/**
    	 * Carga de datos de Personas
    	 */
		inmobiliariaController.addPersona("12345", "Martín", "Av. Cabildo 1000", "1150001000", "martin.sacco@gmail.com");
		inmobiliariaController.addPersona("12346", "Juan", "Av. Monroe 4000", "1520004444", "juan.pedro@gmail.com");
		inmobiliariaController.addPersona("12348", "Tomás", "Lima 123", "1158259693", "tomasmalio@gmail.com" );
		inmobiliariaController.grabarPersonas(inmobiliariaController.getPersonas());
		
		/**
		 * Carga de datos de propiedades
		 */
		//System.out.println(inmobiliariaController.getPersonas().get(12345));
		//inmobiliariaController.addPropiedad("1", "Av. Cabildo", 3530, "3", "A", "Buenos Aires", "3", 120, 12000, 0, 100, 50, 500, inmobiliariaController.getPersonas().get(12345));
		//inmobiliariaController.addPropiedad("2", "Juramento", 2060, "15", "B", "Buenos Aires", "5", 320, 0, 2000000, 2030, 150, 1500, inmobiliariaController.getPersonas().get(12346));
		//inmobiliariaController.addPropiedad("3", "Av. Lacroze", 460, "5", "D", "Buenos Aires", "1", 90, 8000, 750000, 80, 60, 300, inmobiliariaController.getPersonas().get(12347));
		//inmobiliariaController.grabarVentas(inmobiliariaController.getVentas());

		//System.out.println("Finalizo la etapa de carga de datos");
    }
   
    private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				jMenuBar.setPreferredSize(new java.awt.Dimension(392, 22));
				
				/**************************************************************
				 * 						ALQUILER
				 * 1) Alta
				 * 2) Modificar
				 * 3) Baja
				 **************************************************************/
				jMenuAlquiler = new JMenu();
				jMenuBar.add(jMenuAlquiler);
				jMenuAlquiler.setText("Alquiler");
				jMenuAlquiler.setPreferredSize(new java.awt.Dimension(70, 21));
				jMenuAlquiler.setVisible(true);
				jMenuAlquiler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
						{
						}
					});

				/**
				 * 1) Alta de Alquiler
				 **/
				jMenuAltaAlquiler = new JMenuItem();
				jMenuAlquiler.add(jMenuAltaAlquiler);
				jMenuAltaAlquiler.setText("Alta");
				jMenuAltaAlquiler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						if (inmobiliariaController != null) {
							AlquilerAlta alquilerAlta = new AlquilerAlta(inmobiliariaController);
							alquilerAlta.setVisible(true);
							toFront();
						}
					}
				});
				
				/**
				 * 2) Modificar Alquiler
				 **/
				jMenuModificarAlquiler = new JMenuItem();
				jMenuAlquiler.add(jMenuModificarAlquiler);
				jMenuModificarAlquiler.setText("Modificar");
				jMenuModificarAlquiler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						if (inmobiliariaController != null) {
							AlquilerModificar alquilerModificar = new AlquilerModificar(inmobiliariaController);
							alquilerModificar.setVisible(true);
							toFront();
						}
					}
				});
				
				/**
				 * 3) Baja de Alquiler
				 **/
				jMenuBajaAlquiler = new JMenuItem();
				jMenuAlquiler.add(jMenuBajaAlquiler);
				jMenuBajaAlquiler.setText("Baja");
				jMenuBajaAlquiler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						if (inmobiliariaController != null) {
							AlquilerBaja alquilerBaja = new AlquilerBaja(inmobiliariaController);
							alquilerBaja.setVisible(true);
							toFront();
						}
					}
				});
				
				/**************************************************************
				 * 						EOF ALQUILER
				 **************************************************************/
				
				/**************************************************************
				 * 						VENTA
				 * 1) Alta
				 * 2) Modificar
				 * 3) Baja
				 **************************************************************/
				jMenuVenta = new JMenu();
				jMenuBar.add(jMenuVenta);
				jMenuVenta.setText("Venta");
				jMenuVenta.setPreferredSize(new java.awt.Dimension(70, 21));
				jMenuVenta.setVisible(true);
				jMenuVenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
						{
						}
					});

				/**
				 * 1) Alta de Venta de Propiedad
				 **/
				jMenuAltaVenta = new JMenuItem();
				jMenuVenta.add(jMenuAltaVenta);
				jMenuAltaVenta.setText("Alta");
				jMenuAltaVenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						if (inmobiliariaController != null) {
							VentaAlta ventaAlta = new VentaAlta(inmobiliariaController);
							ventaAlta.setVisible(true);
							toFront();
						}
					}
				});
				
				/**
				 * 2) Modificar Venta de Propiedad
				 **/
				jMenuModificarVenta = new JMenuItem();
				jMenuVenta.add(jMenuModificarVenta);
				jMenuModificarVenta.setText("Modificar");
				jMenuModificarVenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						if (inmobiliariaController != null) {
							VentaModificar ventaModificar = new VentaModificar(inmobiliariaController);
							ventaModificar.setVisible(true);
							toFront();
						}
					}
				});
				
				/**
				 * 3) Baja de Venta de Propiedad
				 **/
				jMenuBajaVenta = new JMenuItem();
				jMenuVenta.add(jMenuBajaVenta);
				jMenuBajaVenta.setText("Baja");
				jMenuBajaVenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						if (inmobiliariaController != null) {
							VentaBaja ventaBaja = new VentaBaja(inmobiliariaController);
							ventaBaja.setVisible(true);
							toFront();
						}
					}
				});
				
				/**************************************************************
				 * 						EOF VENTA
				 **************************************************************/
				
				/**************************************************************
				 * 						SALIR
				 **************************************************************/
				jMenuSalir = new JMenu();
				jMenuBar.add(jMenuSalir);
				jMenuSalir.setText("Salir");
				jMenuSalir.setVisible(true);
				jMenuSalir.addMenuListener(new MenuListener() {
					public void menuSelected(MenuEvent evt) {
						System.exit(0);
					}
					public void menuDeselected(MenuEvent evt) {
					}
					public void menuCanceled(MenuEvent evt) {
					}
				});
				
			pack();
			setSize(500, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
