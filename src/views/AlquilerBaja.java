package views;

import app.SistemaInmobiliaria;
import bean.Alquiler;
import bean.Persona;
import bean.Propiedad;
import bean.Servicio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlquilerBaja extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JTextField txtBajaAlquiler;
	
	List<Alquiler> alquileres;
	private Alquiler alquiler;
	
	private JTable table;

	public AlquilerBaja  (SistemaInmobiliaria s) {
		super();
		getContentPane().setLayout(null);
		
		txtBajaAlquiler = new JTextField();
		txtBajaAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//llamar al sistema para que se baje el alquiler
				sistema.deleteService(alquiler);
			}
		});
		txtBajaAlquiler.setText("Baja alquiler");
		txtBajaAlquiler.setBounds(314, 246, 130, 26);
		getContentPane().add(txtBajaAlquiler);
		txtBajaAlquiler.setColumns(10);
		sistema = s;
		initialize();
		setVisible(true);
	}
	
	private void initialize () {
		buscarAlquileres();
		createTableAlquileres();
	}
	
	/**
	 * Buscar Alquileres
	 * Obtenemos todas las propiedades que se encuentran en
	 * venta y así mostrarlas
	 * 
	 * @return ArrayList<Venta>
	 */
	private List<Alquiler> buscarAlquileres() {
		List<Alquiler> alquileres = sistema.getAlquileres();
		return alquileres;
	}
	
	public void createTableAlquileres() {
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (alquileres != null) {
			
			for (Alquiler a: alquileres) {
				model.addRow(new Object[]{
						a.getPropiedad(),
						a.getInteresado()
				});
			}
			
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        		alquiler = alquileres.get(row);
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
	
}
