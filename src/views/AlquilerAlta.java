package views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class AlquilerAlta {

	private JFrame frmAlquilerAlta;
	private JTextField textFechaDesde;
	private JTextField textFechaHasta;
	private JTable table;
	List<Propiedad> propiedades;
	List<Persona> personas;
	
	private SistemaInmobiliaria sistema;
	private JTextField textComision;
	private JTextField textSellado;
	
	private Persona pers;
	private Propiedad prop;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AlquilerAlta window = new AlquilerAlta();
//					window.frmAlquilerAlta.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AlquilerAlta(SistemaInmobiliaria s) {
		initialize();
		sistema= s;
		buscarPropiedad();
		buscarPersonas();
		createTablePropiedades();
		createTablePersonas();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlquilerAlta = new JFrame();
		frmAlquilerAlta.setBounds(100, 100, 551, 524);
		frmAlquilerAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlquilerAlta.getContentPane().setLayout(null);
		
		JLabel lblFechaDesde = new JLabel("Fecha desde: ");
		lblFechaDesde.setBounds(6, 218, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaDesde);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		textFechaDesde = new JFormattedTextField(dateFormat);
		textFechaDesde.setBounds(103, 213, 130, 26);
		frmAlquilerAlta.getContentPane().add(textFechaDesde);
		textFechaDesde.setColumns(10);
		
		JLabel lblFechaHasta = new JLabel("Fecha hasta:");
		lblFechaHasta.setBounds(6, 283, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaHasta);
		
		textFechaHasta = new JFormattedTextField(dateFormat);
		textFechaHasta.setBounds(103, 278, 130, 26);
		frmAlquilerAlta.getContentPane().add(textFechaHasta);
		textFechaHasta.setColumns(10);
		
		JLabel lblPropiedad = new JLabel("Propiedad");
		lblPropiedad.setBounds(213, 6, 80, 16);
		frmAlquilerAlta.getContentPane().add(lblPropiedad);
		
		JButton btnAlquilar = new JButton("Alquilar");
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date fdesde = new SimpleDateFormat("yyyy-MM-dd").parse(textFechaDesde.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Date fhasta = new SimpleDateFormat("yyyy-MM-dd").parse(textFechaHasta.getText());
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				float gestion= Float.parseFloat(textComision.getText());
				float sellado= Float.parseFloat(textSellado.getText());
				
				//llamar al sistema para generar el alquiler.
				
				
				
			}
		});
		btnAlquilar.setBounds(417, 467, 117, 29);
		frmAlquilerAlta.getContentPane().add(btnAlquilar);
		
		JLabel lblComision = new JLabel("Comision");
		lblComision.setBounds(245, 218, 61, 16);
		frmAlquilerAlta.getContentPane().add(lblComision);
		
		JLabel lblGastoSellado = new JLabel("Gasto sellado");
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
		
		JLabel lblPersona = new JLabel("Persona");
		lblPersona.setBounds(213, 332, 61, 16);
		frmAlquilerAlta.getContentPane().add(lblPersona);
	}
	private List<Propiedad> buscarPropiedad() {
		propiedades = new ArrayList<>(sistema.getPropiedades());
		return propiedades;
	}
	
	public void createTablePropiedades() {
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (propiedades != null) {
			
			for(Propiedad p: propiedades) 
				if(p.getValorAlquiler()>0) {
					model.addRow(new Object[]{
							p.getCalle(),
							p.getPropietario().getNombre_razon(),
					});
				}

			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        		 prop = propiedades.get(row);
			        			//Propiedad seleccionada para desp pasar a alquilada.
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
	
	private List<Persona> buscarPersonas() {
		personas = new ArrayList<>(sistema.getPersonas());
		return personas;
	}
	
	public void createTablePersonas() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (personas != null) {
			
			for(Persona p: personas) 			
					model.addRow(new Object[]{
							p.getNombre_razon(),
							p.getCuil_cuit()
					});
				

			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        		 pers = personas.get(row);
			        			//Persona seleccionada para hacer el alquiler.
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
