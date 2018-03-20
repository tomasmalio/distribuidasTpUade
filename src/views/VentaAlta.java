package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Persona;
import bean.Propiedad;

public class VentaAlta extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame frmVentaAlta;
	private JTextField fechaEscritura;
	private JTextField valorEscritura;
	private JTextField comisionVenta;
	private JTextField gastosEscritura;
	private JTable table;
	
	List<Propiedad> propiedades;
	List<Persona> personas;
	
	private Persona pers;
	private Propiedad prop;
	
	private SistemaInmobiliaria sistema;

	public VentaAlta  (SistemaInmobiliaria s) {
		super();
		sistema = s;
		buscarPropiedad();
		buscarPersonas();
		createTablePropiedades();
		createTablePersonas();
		initialize();
		setVisible(true);
	}
	
	private void initialize() {
		frmVentaAlta = new JFrame();
		frmVentaAlta.setBounds(100, 100, 551, 524);
		frmVentaAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentaAlta.getContentPane().setLayout(null);
		
		JLabel lblFechaEscritura = new JLabel("Fecha Escritura:");
		lblFechaEscritura.setBounds(6, 218, 85, 16);
		frmVentaAlta.getContentPane().add(lblFechaEscritura);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fechaEscritura = new JFormattedTextField(dateFormat);
		fechaEscritura.setBounds(103, 213, 130, 26);
		frmVentaAlta.getContentPane().add(fechaEscritura);
		fechaEscritura.setColumns(10);
		
		JLabel lblPropiedad = new JLabel("Propiedad:");
		lblPropiedad.setBounds(213, 6, 80, 16);
		frmVentaAlta.getContentPane().add(lblPropiedad);
		
		JLabel lblComisionVenta = new JLabel("Comisión Venta:");
		lblComisionVenta.setBounds(245, 218, 61, 16);
		frmVentaAlta.getContentPane().add(lblComisionVenta);
		
		comisionVenta = new JTextField();
		comisionVenta.setBounds(358, 213, 130, 26);
		frmVentaAlta.getContentPane().add(comisionVenta);
		comisionVenta.setColumns(10);
		
		JLabel lblGastosEscritura = new JLabel("Gastos Escritura:");
		lblGastosEscritura.setBounds(245, 283, 90, 16);
		frmVentaAlta.getContentPane().add(lblGastosEscritura);
		
		gastosEscritura = new JTextField();
		gastosEscritura.setBounds(358, 278, 130, 26);
		frmVentaAlta.getContentPane().add(gastosEscritura);
		gastosEscritura.setColumns(10);
		
		JLabel lblValorEscritura = new JLabel("Valor Escritura:");
		lblValorEscritura.setBounds(245, 283, 90, 16);
		frmVentaAlta.getContentPane().add(lblValorEscritura);
		
		valorEscritura = new JTextField();
		valorEscritura.setBounds(358, 278, 130, 26);
		frmVentaAlta.getContentPane().add(valorEscritura);
		valorEscritura.setColumns(10);
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(213, 332, 61, 16);
		frmVentaAlta.getContentPane().add(lblPersona);
		
		JButton btnVenta = new JButton("Vender");
		
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date fEscritura = new SimpleDateFormat("yyyy-MM-dd").parse(fechaEscritura.getText());
					float vEscritura = Float.parseFloat(valorEscritura.getText());
					float cVenta = Float.parseFloat(comisionVenta.getText());
					float gEscritura = Float.parseFloat(gastosEscritura.getText());
					
					/**
					 * Agregamos una nueva venta
					 */
					Date dateNow = new Date();
					sistema.addVenta(fEscritura, 
									vEscritura,
									cVenta,
									gEscritura,
									dateNow, 
									prop, 
									pers
								);
					frmVentaAlta.dispose();
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnVenta.setBounds(417, 467, 117, 29);
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
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
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
			
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
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
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (personas != null) {
			
			for (Persona p: personas) {		
				model.addRow(new Object[]{
					p.getNombre_razon(),
					p.getCuil_cuit()
				});
			}

			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
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
}
