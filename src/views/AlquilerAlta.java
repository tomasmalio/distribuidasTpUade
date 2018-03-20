package views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Alquiler;
import bean.Persona;
import bean.Propiedad;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class AlquilerAlta {

	private JFrame frmAlquilerAlta;
	private JTextField textFechaDesde;
	private JTextField textFechaHasta;
	private JTable tablep;
	private JTable tablepers;
	List<Propiedad> propiedades;
	List<Persona> personas;
	
	private SistemaInmobiliaria sistema;
	private JTextField textComision;
	private JTextField textSellado;
	
	private Persona pers;
	private Propiedad prop;

	/**
	 * Create the application.
	 */
	public AlquilerAlta(SistemaInmobiliaria s) {
		
		sistema = s;
		buscarPropiedad();
		buscarPersonas();
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		createTablePropiedades();
		createTablePersonas();
		frmAlquilerAlta = new JFrame();
		frmAlquilerAlta.setBounds(100, 100, 551, 524);
		frmAlquilerAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlquilerAlta.getContentPane().setLayout(null);
		
		JLabel lblFechaDesde = new JLabel("Fecha Desde:");
		lblFechaDesde.setBounds(6, 218, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaDesde);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		textFechaDesde = new JFormattedTextField(dateFormat);
		textFechaDesde.setBounds(103, 213, 130, 26);
		frmAlquilerAlta.getContentPane().add(textFechaDesde);
		textFechaDesde.setColumns(10);
		
		JLabel lblFechaHasta = new JLabel("Fecha Hasta:");
		lblFechaHasta.setBounds(6, 283, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaHasta);
		
		textFechaHasta = new JFormattedTextField(dateFormat);
		textFechaHasta.setBounds(103, 278, 130, 26);
		frmAlquilerAlta.getContentPane().add(textFechaHasta);
		textFechaHasta.setColumns(10);
		
		JLabel lblPropiedad = new JLabel("Propiedad:");
		lblPropiedad.setBounds(213, 6, 80, 16);
		frmAlquilerAlta.getContentPane().add(lblPropiedad);
		
		JLabel lblComision = new JLabel("Comisión:");
		lblComision.setBounds(245, 218, 61, 16);
		frmAlquilerAlta.getContentPane().add(lblComision);
		
		JLabel lblGastoSellado = new JLabel("Gasto Sellado:");
		lblGastoSellado.setBounds(245, 283, 90, 16);
		frmAlquilerAlta.getContentPane().add(lblGastoSellado);
		
		textComision = new JTextField();
		textComision.setBounds(358, 213, 130, 26);
		frmAlquilerAlta.getContentPane().add(textComision);
		textComision.setColumns(10);
		
		textSellado = new JTextField();
		textSellado.setBounds(358, 278, 130, 26);
		frmAlquilerAlta.getContentPane().add(textSellado);
		textSellado.setColumns(10);
		
		String[] columnNames = {"Calle", "Propietario"};
		tablep = new JTable();
		tablep.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {
			 @Override
			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		tablep.setAutoCreateRowSorter(true);
		tablep.setRowHeight(20);
		tablep.getColumnModel().getColumn(0).setMaxWidth(32);
		tablep.getColumnModel().getColumn(1).setMaxWidth(100);

		JScrollPane scrollPanePropiedades = new JScrollPane(tablep);
		scrollPanePropiedades.setBounds(10, 120, 480, 300);
		tablep.setFillsViewportHeight(true);
		frmAlquilerAlta.getContentPane().add(scrollPanePropiedades);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(213, 332, 61, 16);
		frmAlquilerAlta.getContentPane().add(lblPersona);
		
		String[] columnNamesPers = {"Nombre", "CUIT"};
		tablepers = new JTable();
		tablepers.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {
			 @Override
			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		tablepers.setAutoCreateRowSorter(true);
		tablepers.setRowHeight(20);
		tablepers.getColumnModel().getColumn(0).setMaxWidth(32);
		tablepers.getColumnModel().getColumn(1).setMaxWidth(100);

		JScrollPane scrollPanePersonas = new JScrollPane(tablepers);
		scrollPanePersonas.setBounds(10, 120, 480, 300);
		tablepers.setFillsViewportHeight(true);
		frmAlquilerAlta.getContentPane().add(scrollPanePersonas);
		
		JButton btnAlquilar = new JButton("Alquilar");
		
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date fdesde = new SimpleDateFormat("yyyy-MM-dd").parse(textFechaDesde.getText());
					Date fhasta = new SimpleDateFormat("yyyy-MM-dd").parse(textFechaHasta.getText());
					
					float gestion = Float.parseFloat(textComision.getText());
					float sellado = Float.parseFloat(textSellado.getText());
					
					/**
					 * Agregamos el alquiler
					 */
					Date dateNow = new Date();
					sistema.addAlquiler(fdesde, fhasta, gestion, sellado, dateNow, prop, pers);
					frmAlquilerAlta.dispose();
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnAlquilar.setBounds(417, 467, 117, 29);
		frmAlquilerAlta.getContentPane().add(btnAlquilar);
	}
	
	private List<Propiedad> buscarPropiedad() {
		List<Propiedad> propiedades = sistema.getPropiedades();
		return propiedades;
	}
	
	public void createTablePropiedades() {
			
		DefaultTableModel model = (DefaultTableModel) tablep.getModel();
		model.setRowCount(0);
		
		if (propiedades != null) {
			
			for (Propiedad p: propiedades) {
				if (p.getValorAlquiler()>0) {
					model.addRow(new Object[]{
						p.getCalle(),
						p.getPropietario().getNombre_razon(),
					});
				}
			}
			
			tablep.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tablep.rowAtPoint(evt.getPoint());
			        int col = tablep.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        	/**
			        	 * Propiedad seleccionada para luego alquilarla
			        	 **/
			        	prop = propiedades.get(row);
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
	
	private List<Persona> buscarPersonas() {
		List<Persona> personas = sistema.getPersonas();
		return personas;
	}
	
	public void createTablePersonas() {
		
		DefaultTableModel model = (DefaultTableModel) tablepers.getModel();
		model.setRowCount(0);
		
		if (personas != null) {
			
			for (Persona p: personas) {		
				model.addRow(new Object[]{
					p.getNombre_razon(),
					p.getCuil_cuit()
				});
			}

			tablepers.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tablepers.rowAtPoint(evt.getPoint());
			        int col = tablepers.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        	/**
			        	 * Persona seleccionada para hacer el alquiler.
			        	 */
			        	pers = personas.get(row);
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
	
	public void setVisible(boolean isVisible) {
		this.frmAlquilerAlta.setVisible(isVisible);
	}
}
