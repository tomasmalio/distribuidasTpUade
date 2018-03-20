package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Propiedad;
import bean.Servicio;
import bean.Venta;

public class VentaBaja extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JTextField bajaVenta;
	private JTable table;
	
	List<Venta> ventas;
	private Venta venta;

	public VentaBaja (SistemaInmobiliaria s) {
		super();
		getContentPane().setLayout(null);
		
		bajaVenta = new JTextField();
		bajaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Llama al sistema para que se baje la venta
				 */
				sistema.deleteService(venta);
			}
		});
		bajaVenta.setText("Baja venta");
		bajaVenta.setBounds(314, 246, 130, 26);
		getContentPane().add(bajaVenta);
		bajaVenta.setColumns(10);
		sistema = s;
		initialize();
	}
	
	private void initialize () {
		buscarPropiedadesEnVenta();
		createTableVentas();
		setVisible(true);
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
}
