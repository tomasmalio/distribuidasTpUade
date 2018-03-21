package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Persona;
import bean.Propiedad;
import bean.Venta;

public class VentaAlta extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame frmVentaAlta;
	private JTextField fechaEscritura;
	private JTextField valorEscritura;
	private JTextField comisionVenta;
	private JTextField gastosEscritura;
	private JTable tableProp;
	private JTable tableP;
	
	List<Propiedad> propiedades;
	List<Persona> personas;
	
	private Persona pers;
	private Propiedad prop;
	
	private SistemaInmobiliaria sistema;

	public VentaAlta  (SistemaInmobiliaria s) {
		super();
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
		frmVentaAlta = new JFrame();
		frmVentaAlta.setBounds(100, 100, 320, 600);
		frmVentaAlta.setAlwaysOnTop(true);
		frmVentaAlta.getContentPane().setLayout(null);
		
		JLabel lblPropiedad = new JLabel("Propiedad:");
		lblPropiedad.setBounds(33, 6, 80, 16);
		frmVentaAlta.getContentPane().add(lblPropiedad);
		
		String[] columnNames = {"Calle", "Propietario"};
		tableProp = new JTable();
		tableProp.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {
			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		tableProp.setAutoCreateRowSorter(true);
		tableProp.setRowHeight(20);
		tableProp.getColumnModel().getColumn(0).setMaxWidth(100);
		tableProp.getColumnModel().getColumn(1).setMaxWidth(100);

		JScrollPane scrollPaneVentas = new JScrollPane(tableProp);
		scrollPaneVentas.setBounds(33, 25, 250, 150);
		tableProp.setFillsViewportHeight(true);
		frmVentaAlta.getContentPane().add(scrollPaneVentas);
		
		JLabel lblFechaEscritura = new JLabel("Fecha Escritura:");
		lblFechaEscritura.setBounds(33, 198, 108, 16);
		frmVentaAlta.getContentPane().add(lblFechaEscritura);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fechaEscritura = new JFormattedTextField(dateFormat);
		fechaEscritura.setBounds(150, 193, 130, 26);
		frmVentaAlta.getContentPane().add(fechaEscritura);
		fechaEscritura.setColumns(10);
		
		JLabel lblComisionVenta = new JLabel("Comisión Venta:");
		lblComisionVenta.setBounds(33, 230, 106, 16);
		frmVentaAlta.getContentPane().add(lblComisionVenta);
		
		comisionVenta = new JTextField();
		comisionVenta.setBounds(150, 230, 130, 26);
		frmVentaAlta.getContentPane().add(comisionVenta);
		comisionVenta.setColumns(10);
		
		JLabel lblGastosEscritura = new JLabel("Gastos Escritura:");
		lblGastosEscritura.setBounds(33, 270, 106, 16);
		frmVentaAlta.getContentPane().add(lblGastosEscritura);
		
		gastosEscritura = new JTextField();
		gastosEscritura.setBounds(150, 270, 130, 26);
		frmVentaAlta.getContentPane().add(gastosEscritura);
		gastosEscritura.setColumns(10);
		
		JLabel lblValorEscritura = new JLabel("Valor Escritura:");
		lblValorEscritura.setBounds(33, 310, 106, 16);
		frmVentaAlta.getContentPane().add(lblValorEscritura);
		
		valorEscritura = new JTextField();
		valorEscritura.setBounds(150, 310, 130, 26);
		frmVentaAlta.getContentPane().add(valorEscritura);
		valorEscritura.setColumns(10);
		
		JLabel lblPersona = new JLabel("Persona:");
		lblPersona.setBounds(33, 340, 61, 16);
		frmVentaAlta.getContentPane().add(lblPersona);
		
		String[] columnNamesPers = {"Nombre", "CUIT"};
		tableP = new JTable();
		tableP.setModel(new DefaultTableModel(new Object[][] {}, columnNamesPers) {
			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		tableP.setAutoCreateRowSorter(true);
		tableP.setRowHeight(20);
		tableP.getColumnModel().getColumn(0).setMaxWidth(100);
		tableP.getColumnModel().getColumn(1).setMaxWidth(100);

		JScrollPane scrollPanePersonas = new JScrollPane(tableP);
		scrollPanePersonas.setBounds(33, 364, 250, 149);
		tableP.setFillsViewportHeight(true);
		frmVentaAlta.getContentPane().add(scrollPanePersonas);
		
		JButton btnVenta = new JButton("Vender");
		
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSubmit();
			}
		});
		
		btnVenta.setBounds(175, 530, 117, 29);
		frmVentaAlta.getContentPane().add(btnVenta);
	}
	
	/**
	 * buscar Propiedad
	 * 
	 * Recibo las propiedades para poder identificar cuales
	 * están en venta
	 * 
	 * @return List<Propiedad>
	 */
	private List<Propiedad> buscarPropiedad() {
		List<Propiedad> propiedades = sistema.getPropiedades();
		return propiedades;
	}
	
	public void createTablePropiedades() {
			
		DefaultTableModel model = (DefaultTableModel) tableProp.getModel();
		model.setRowCount(0);
		
		if (propiedades != null) {
			
			for (Propiedad p: propiedades) {
				if (p.getValorVenta()>0) {
					model.addRow(new Object[]{
						p.getCalle(),
						p.getPropietario().getNombre_razon(),
					});
				}
			}
			
			tableProp.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tableProp.rowAtPoint(evt.getPoint());
			        int col = tableProp.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        	/**
			        	 * Propiedad seleccionada para luego venderla
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
		
		DefaultTableModel model = (DefaultTableModel) tableP.getModel();
		model.setRowCount(0);
		
		if (personas != null) {
			
			for (Persona p: personas) {		
				model.addRow(new Object[]{
					p.getNombre_razon(),
					p.getCuil_cuit()
				});
			}

			tableP.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tableP.rowAtPoint(evt.getPoint());
			        int col = tableP.columnAtPoint(evt.getPoint());
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
		this.frmVentaAlta.setVisible(isVisible);
	}
	
	public void onSubmit() {
		try {
			Date fEscritura = new SimpleDateFormat("yyyy-MM-dd").parse(fechaEscritura.getText());
			float vEscritura = Float.parseFloat(valorEscritura.getText());
			float cVenta = Float.parseFloat(comisionVenta.getText());
			float gEscritura = Float.parseFloat(gastosEscritura.getText());
			
			/**
			 * Agregamos una nueva venta
			 */
			Date dateNow = new Date();
			Venta venta = sistema.addVenta(fEscritura, vEscritura, cVenta, gEscritura, dateNow, prop, pers);
			sistema.grabarVenta(venta);
			setVisible(false);
			JOptionPane.showMessageDialog(null, "Venta Publicada Exitosamente!");
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}
