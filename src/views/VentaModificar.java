package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Venta;

public class VentaModificar extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JTextField txtComision;
	private JTextField txtGastoEscritura;
	private JTextField txtValorEscritura;

	private JTable table;
	private JLabel lblVentas;
	private JLabel lblComision;
	private JLabel lblGastoEscritura;
	private JLabel lblValorEscritura;
	private JFrame frame;
	private JButton btnModificar;
	
	private List<Venta> ventas;
	private Venta venta;
	
	public VentaModificar  (SistemaInmobiliaria s) {
		super();
		sistema = s;	
		ventas = buscarVentas();
		initialize();
		createTableAlquileres();
		setVisible(true);
	}
	
	@SuppressWarnings("serial")
	private void initialize () {
		buscarVentas();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 480);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(null);
		
		lblVentas = new JLabel("Ventas");
		lblVentas.setBounds(33, 23, 80, 16);
		getContentPane().add(lblVentas);
		frame.getContentPane().add(lblVentas);
		
		lblComision = new JLabel("Comisión Venta:");
		lblComision.setEnabled(false);
		lblComision.setBounds(33, 252, 117, 16);
		getContentPane().add(lblComision);
		frame.getContentPane().add(lblComision);

		lblGastoEscritura = new JLabel("Gastos Escritura");
		lblGastoEscritura.setEnabled(false);
		lblGastoEscritura.setBounds(33, 298, 117, 16);
		getContentPane().add(lblGastoEscritura);
		frame.getContentPane().add(lblGastoEscritura);
		
		lblValorEscritura = new JLabel("Valor Escritura");
		lblValorEscritura.setEnabled(false);
		lblValorEscritura.setBounds(33, 339, 117, 16);
		getContentPane().add(lblValorEscritura);
		frame.getContentPane().add(lblValorEscritura);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSubmit(); 
			}
		});
		btnModificar.setBounds(175, 400, 117, 29);
		getContentPane().add(btnModificar);
		frame.getContentPane().add(btnModificar);
		String[] columnNames = {"Calle", "Nombre"};
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, columnNames) {
			@Override
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
		scrollPaneVenta.setBounds(33, 51, 250, 180);
		table.setFillsViewportHeight(true);
		getContentPane().add(scrollPaneVenta);
		frame.getContentPane().add(scrollPaneVenta);
		txtComision = new JTextField();
		txtComision.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				venta.setComisionVenta(Float.parseFloat(txtComision.getText()));
			}
		});
		txtComision.setEditable(false);
		txtComision.setEnabled(false);
		txtComision.setBounds(155, 247, 130, 26);
		getContentPane().add(txtComision);
		frame.getContentPane().add(txtComision);
		txtComision.setColumns(10);
		
		txtGastoEscritura = new JTextField();
		txtGastoEscritura.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				venta.setGastosEscritura(Float.parseFloat(txtGastoEscritura.getText()));
			}
		});
		txtGastoEscritura.setEnabled(false);
		txtGastoEscritura.setEditable(false);
		txtGastoEscritura.setBounds(155, 293, 130, 26);
		getContentPane().add(txtGastoEscritura);
		frame.getContentPane().add(txtGastoEscritura);
		txtGastoEscritura.setColumns(10);
		
		
		txtValorEscritura = new JTextField();
		txtValorEscritura.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				venta.setValorEscritura(Float.parseFloat(txtValorEscritura.getText()));
			}
		});
		txtValorEscritura.setEnabled(false);
		txtValorEscritura.setEditable(false);
		txtValorEscritura.setBounds(155, 334, 130, 26);
		getContentPane().add(txtValorEscritura);
		frame.getContentPane().add(txtValorEscritura);
		txtValorEscritura.setColumns(10);
		
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
					a.getPropiedad().getCalle(),
					a.getInteresado().getNombre_razon()
				});
			}
			
			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        		venta = ventas.get(row);
				    		txtComision.setEditable(true);
				    		txtComision.setEnabled(true);
						txtComision.setText(Float.toString(venta.getComisionVenta()));
						
						txtGastoEscritura.setEditable(true);
						txtGastoEscritura.setEnabled(true);
						txtGastoEscritura.setText(Float.toString(venta.getGastosEscritura()));
						
						txtValorEscritura.setEditable(true);
						txtValorEscritura.setEnabled(true);
						txtValorEscritura.setVisible(true);
						txtValorEscritura.setText(Float.toString(venta.getValorEscritura()));
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
	
	public void setVisible(boolean isVisible) {
		this.frame.setVisible(isVisible);
	}
	
	public void onSubmit() {
		venta.setValorEscritura(Float.parseFloat(txtValorEscritura.getText()));
		venta.setGastosEscritura(Float.parseFloat(txtGastoEscritura.getText()));
		sistema.grabarVenta(venta);
		setVisible(false);
		JOptionPane.showMessageDialog(null, "Venta modificada exitosamente!");
	}
}
