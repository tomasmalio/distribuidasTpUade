package views;

import app.SistemaInmobiliaria;
import bean.Alquiler;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AlquilerBaja extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	
	List<Alquiler> alquileres;
	private Alquiler alquiler;
	
	private JTable table;
	private JButton btnBajaAlquiler;

	public AlquilerBaja  (SistemaInmobiliaria s) {
		super();	
		sistema = s;
		alquileres= buscarAlquileres();	
		initialize();
		createTableAlquileres();
		setVisible(true);
	}
	
	@SuppressWarnings("serial")
	private void initialize () {
		getContentPane().setLayout(null);	

		String[] columnNames = {"Calle", "Nombre"};
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {
			    public Class<?> getColumnClass(int column) {
			        switch(column) {
			            default: return Object.class;
			        }
			    }
		});
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(130);

		JScrollPane scrollPaneAlquileres = new JScrollPane(table);
		scrollPaneAlquileres.setBounds(71, 46, 283, 152);
		table.setFillsViewportHeight(true);
		getContentPane().add(scrollPaneAlquileres);
		
		btnBajaAlquiler = new JButton("Baja Alquiler");
		btnBajaAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.deleteService(alquiler);
			}
		});
		btnBajaAlquiler.setBounds(165, 246, 117, 29);
		getContentPane().add(btnBajaAlquiler);
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
						a.getPropiedad().getCalle(),
						a.getInteresado().getNombre_razon()
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
