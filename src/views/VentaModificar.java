package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Alquiler;
import bean.Servicio;
import bean.Venta;

public class VentaModificar extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JTextField txtComision;
	private JTextField txtGastoEscritura;
	private JTextField txtValorEscritura;

	private JTable table;
	private JLabel lblComision;
	private JLabel lblGastoEscritura;
	private JLabel lblValorEscritura;
	
	private List<Venta> ventas;
	private Venta venta;
	
	public VentaModificar  (SistemaInmobiliaria s) {
		super();
		sistema = s;
		
		getContentPane().setLayout(null);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setBounds(180, 23, 80, 16);
		getContentPane().add(lblVentas);
		
		JLabel lblComision = new JLabel("Comisión Venta:");
		lblComision.setEnabled(false);
		lblComision.setBounds(33, 220, 117, 16);
		getContentPane().add(lblComision);

		JLabel lblGastoEscritura = new JLabel("Gastos Escritura");
		lblGastoEscritura.setEnabled(false);
		lblGastoEscritura.setBounds(33, 274, 117, 16);
		getContentPane().add(lblGastoEscritura);
		
		JLabel lblValorEscritura = new JLabel("Valor Escritura");
		lblValorEscritura.setEnabled(false);
		lblValorEscritura.setBounds(33, 328, 117, 16);
		getContentPane().add(lblValorEscritura);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hacer que el sist tome datos de los text fields y modifique el alquiler
				sistema.modifyService(venta); 
			}
		});
		btnModificar.setBounds(378, 327, 117, 29);
		getContentPane().add(btnModificar);
		
		txtComision = new JTextField();
		txtComision.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				venta.setComisionVenta(Float.parseFloat(txtComision.getText()));
			}
		});
		txtComision.setEditable(false);
		txtComision.setEnabled(false);
		txtComision.setBounds(173, 215, 130, 26);
		getContentPane().add(txtComision);
		txtComision.setColumns(10);
		
		txtGastoEscritura = new JTextField();
		txtGastoEscritura.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				venta.setGastosEscritura(Float.parseFloat(txtGastoEscritura.getText()));
			}
		});
		txtGastoEscritura.setEnabled(false);
		txtGastoEscritura.setEditable(false);
		txtGastoEscritura.setBounds(173, 269, 130, 26);
		getContentPane().add(txtGastoEscritura);
		txtGastoEscritura.setColumns(10);
		
		
		txtValorEscritura = new JTextField();
		txtValorEscritura.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				venta.setValorEscritura(Float.parseFloat(txtValorEscritura.getText()));
			}
		});
		txtValorEscritura.setEnabled(false);
		txtValorEscritura.setEditable(false);
		txtValorEscritura.setBounds(173, 269, 130, 26);
		getContentPane().add(txtValorEscritura);
		txtValorEscritura.setColumns(10);
		
		initialize();
	}
	
	private void initialize () {
		buscarVentas();
		createTableAlquileres();
		setVisible(true);
	}
	
	private List<Venta> buscarVentas() {
		List<Venta> ventas = sistema.getVentas();
		return ventas;
	}
	
	public void createTableAlquileres() {
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (ventas != null) {
			
			for (Venta a: ventas) {
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
			        	venta = ventas.get(row);
						txtComision.setVisible(true);
						txtComision.setText(Float.toString(venta.getComisionVenta()));
						
						txtGastoEscritura.setVisible(true);
						txtGastoEscritura.setText(Float.toString(venta.getGastosEscritura()));
						
						txtValorEscritura.setVisible(true);
						txtValorEscritura.setText(Float.toString(venta.getValorEscritura()));
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
}
