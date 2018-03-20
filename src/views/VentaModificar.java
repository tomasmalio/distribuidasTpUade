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

	private JTable table;
	
	private List<Venta> ventas;
	private Venta venta;
	
	public VentaModificar  (SistemaInmobiliaria s) {
		super();
		sistema = s;
		
		getContentPane().setLayout(null);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setBounds(180, 23, 80, 16);
		getContentPane().add(lblVentas);
		
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(33, 220, 117, 16);
		getContentPane().add(lblNewLabel);
		

		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(33, 274, 117, 16);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hacer que el sist tome datos de los text fields y modifique el alquiler
				sistema.modifySerivce(alquiler, "alquiler"); 
			}
		});
		btnModificar.setBounds(378, 327, 117, 29);
		getContentPane().add(btnModificar);
		
		txtComision = new JTextField();
		txtComision.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				alquiler.setComisionGestion(Float.parseFloat(txtComision.getText()));
			}
		});
		txtComision.setEditable(false);
		txtComision.setEnabled(false);
		txtComision.setBounds(173, 215, 130, 26);
		getContentPane().add(txtComision);
		txtComision.setColumns(10);
		
		txtSellado = new JTextField();
		txtSellado.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				alquiler.setGastosSellado(Float.parseFloat(txtSellado.getText()));
			}
		});
		txtSellado.setEnabled(false);
		txtSellado.setEditable(false);
		txtSellado.setBounds(173, 269, 130, 26);
		getContentPane().add(txtSellado);
		txtSellado.setColumns(10);
		
		initialize();
	}
	
	private void initialize () {
		buscarVentas();
		createTableAlquileres();
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
						txtSellado.setVisible(true);
						lblNewLabel.setVisible(true);
						lblNewLabel_1.setVisible(true);
						txtComision.setText(Float.toString(alquiler.getComisionGestion()));
						txtSellado.setText(Float.toString(alquiler.getGastosSellado()));
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
	}
}
