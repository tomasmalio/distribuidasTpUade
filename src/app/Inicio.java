/****************************************************
 * Aplicaciones Distribuidas 2018 Verano
 * Trabajo Práctico - Inmobiliaria
 * GitHub: https://github.com/tomasmalio/distribuidasTpUade
 * 
 * @author	1037546 - Tomas Malio 
 * 			1065743 - Florencia Otero
 * 			1024354 - Martin Sacco
 * 
 ****************************************************/
package app;

import app.Setup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
		
		/**
		 * Carga automática de valores
		 * 
		 * @params Sistema, boolean (cargaDeAlquileres), boolean (cargaDeVentas)
		 */
		new Setup(inmobiliariaController, true, true);
		initGUI();
	}

	public static void main(String[] args) {
	    	Inicio inicio = new Inicio();
	    	inicio.setVisible(true);
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
