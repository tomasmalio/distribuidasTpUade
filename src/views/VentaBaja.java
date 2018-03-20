package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Venta;

public class VentaBaja extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JFrame frmVentaBaja;
	private JButton btnBajaVenta;
	private JTable table;
	
	List<Venta> ventas;
	private Venta venta;

	public VentaBaja (SistemaInmobiliaria s) {
		super();		
		sistema = s;		
		ventas = buscarPropiedadesEnVenta();
		initialize();
		createTableVentas();
		setVisible(true);		
	}
	
	private void initialize () {
		
		frmVentaBaja = new JFrame();
		frmVentaBaja.setBounds(100, 100, 682, 632);
		frmVentaBaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentaBaja.getContentPane().setLayout(null);
		
		btnBajaVenta = new JButton("Baja Alquiler");
		btnBajaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Llama al sistema para que se baje la venta
				 */
				sistema.deleteService(venta);
			}
		});
		btnBajaVenta.setBounds(165, 246, 117, 29);
		frmVentaBaja.getContentPane().add(btnBajaVenta);
		
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
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);

		JScrollPane scrollPaneVenta = new JScrollPane(table);
		scrollPaneVenta.setBounds(48, 19, 359, 215);
		table.setFillsViewportHeight(true);
		frmVentaBaja.getContentPane().add(scrollPaneVenta);
	}
	
	/**
	 * Buscar Propiedades En Venta
	 * Obtenemos todas las propiedades que se encuentran en
	 * venta y así mostrarlas
	 * 
	 * @return ArrayList<Venta>
	 */
	private List<Venta> buscarPropiedadesEnVenta() {
		List<Venta> ventas = sistema.getVentas();
		return ventas;
	}
	
	/**
	 * Construimos una tabla para mostrar las propiedades
	 * que se encuentran en venta.
	 * Una vez que se clickea en una propiedad pasaremos a realizar
	 * la baja de la misma.
	 */
	public void createTableVentas() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (ventas != null) {
			
			for (Venta v: ventas) {
				model.addRow(new Object[]{
						v.getPropiedad(),
						v.getInteresado()
				});
			}
			
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        	venta = ventas.get(row);
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
	
	public void setVisible(boolean isVisible) {
		this.frmVentaBaja.setVisible(isVisible);
	}
}
