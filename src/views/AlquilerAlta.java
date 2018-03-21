package views;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Persona;
import bean.Propiedad;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class AlquilerAlta {
	private JFrame frmAlquilerAlta;
	private JTextField textFechaDesde;
	private JTextField textFechaHasta;
	private JTable tablePropiedades;
	private JTable tablePersonas;
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
		propiedades = buscarPropiedad();
		personas = buscarPersonas();
		initialize();
		createTablePropiedades();
		createTablePersonas();
		setVisible(true);
	}

	@SuppressWarnings("serial")
	private void initialize() {

		frmAlquilerAlta = new JFrame();
		frmAlquilerAlta.setBounds(100, 100, 320, 600);
		frmAlquilerAlta.setAlwaysOnTop(true);
		frmAlquilerAlta.getContentPane().setLayout(null);
		
		JLabel lblPropiedad = new JLabel("Propiedad:");
		lblPropiedad.setBounds(33, 6, 80, 16);
		frmAlquilerAlta.getContentPane().add(lblPropiedad);
		
		String[] columnNames = {"Calle", "Propietario"};
		tablePropiedades = new JTable();
		tablePropiedades.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {

			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		tablePropiedades.setAutoCreateRowSorter(true);
		tablePropiedades.setRowHeight(20);
		tablePropiedades.getColumnModel().getColumn(0).setMaxWidth(100);
		tablePropiedades.getColumnModel().getColumn(1).setMaxWidth(100);

		JScrollPane scrollPanePropiedades = new JScrollPane(tablePropiedades);
		scrollPanePropiedades.setBounds(33, 35, 250, 150);
		tablePropiedades.setFillsViewportHeight(true);
		frmAlquilerAlta.getContentPane().add(scrollPanePropiedades);
		
		JLabel lblFechaDesde = new JLabel("Fecha Desde:");
		lblFechaDesde.setBounds(33, 198, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaDesde);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		textFechaDesde = new JFormattedTextField(dateFormat);
		textFechaDesde.setBounds(33, 220, 110, 26);
		frmAlquilerAlta.getContentPane().add(textFechaDesde);
		textFechaDesde.setColumns(10);
		
		JLabel lblFechaHasta = new JLabel("Fecha Hasta:");
		lblFechaHasta.setBounds(175, 198, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaHasta);
		
		textFechaHasta = new JFormattedTextField(dateFormat);
		textFechaHasta.setBounds(175, 220, 110, 26);
		frmAlquilerAlta.getContentPane().add(textFechaHasta);
		textFechaHasta.setColumns(10);
		
		JLabel lblComision = new JLabel("Comisión:");
		lblComision.setBounds(33, 265, 90, 16);
		frmAlquilerAlta.getContentPane().add(lblComision);
		
		textComision = new JTextField();
		textComision.setBounds(150, 263, 135, 26);
		frmAlquilerAlta.getContentPane().add(textComision);
		textComision.setColumns(10);
		
		JLabel lblGastoSellado = new JLabel("Gasto Sellado:");
		lblGastoSellado.setBounds(33, 305, 90, 16);
		frmAlquilerAlta.getContentPane().add(lblGastoSellado);
		
		textSellado = new JTextField();
		textSellado.setBounds(150, 300, 135, 26);
		frmAlquilerAlta.getContentPane().add(textSellado);
		textSellado.setColumns(10);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(33, 340, 61, 16);
		frmAlquilerAlta.getContentPane().add(lblPersona);
		
		String[] columnNamesPers = {"Nombre", "CUIT"};
		tablePersonas = new JTable();
		tablePersonas.setModel(new DefaultTableModel(new Object[][] {}, columnNamesPers) {
			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		tablePersonas.setAutoCreateRowSorter(true);
		tablePersonas.setRowHeight(20);
		tablePersonas.getColumnModel().getColumn(0).setMaxWidth(100);
		tablePersonas.getColumnModel().getColumn(1).setMaxWidth(100);

		JScrollPane scrollPanePersonas = new JScrollPane(tablePersonas);
		scrollPanePersonas.setBounds(33, 364, 250, 149);
		tablePersonas.setFillsViewportHeight(true);
		frmAlquilerAlta.getContentPane().add(scrollPanePersonas);
		
		JButton btnAlquilar = new JButton("Alquilar");
		
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSubmit();
			}
		});
		
		btnAlquilar.setBounds(175, 530, 117, 29);
		frmAlquilerAlta.getContentPane().add(btnAlquilar);
	}
	
	private List<Propiedad> buscarPropiedad() {
		List<Propiedad> propiedades = sistema.getPropiedades();
		return propiedades;
	}
	
	public void createTablePropiedades() {
			
		DefaultTableModel model = (DefaultTableModel) tablePropiedades.getModel();
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
			
			tablePropiedades.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tablePropiedades.rowAtPoint(evt.getPoint());
			        int col = tablePropiedades.columnAtPoint(evt.getPoint());
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
		
		DefaultTableModel model = (DefaultTableModel) tablePersonas.getModel();
		model.setRowCount(0);
		
		if (personas != null) {
			
			for (Persona p: personas) {		
				model.addRow(new Object[]{
					p.getNombre_razon(),
					p.getCuil_cuit()
				});
			}

			tablePersonas.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tablePersonas.rowAtPoint(evt.getPoint());
			        int col = tablePersonas.columnAtPoint(evt.getPoint());
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
	
	public void onSubmit() {
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
			sistema.grabarAlquileres(sistema.getAlquileres());
			frmAlquilerAlta.setVisible(false);
			JOptionPane.showMessageDialog(null, "Alquiler Publicado Exitosamente!");
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}
