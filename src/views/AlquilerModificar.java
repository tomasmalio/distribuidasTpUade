package views;

import app.SistemaInmobiliaria;
import bean.Alquiler;
import bean.Propiedad;
import bean.Servicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlquilerModificar extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JTextField txtComision;
	private JTextField txtSellado;
	private JTextField txtBajaAlquiler;
	
	private List<Alquiler> alquileres;
	private Alquiler alquiler;
	
	private JTable table;
	private JLabel lblComision = new JLabel("Comision gestion");
	private JLabel lblSellado = new JLabel("Gastos sellado");
	
	
	public AlquilerModificar (SistemaInmobiliaria s) {
		super();
		getContentPane().setLayout(null);
		
		JLabel lblAlquileres = new JLabel("Alquileres");
		lblAlquileres.setBounds(180, 23, 80, 16);
		getContentPane().add(lblAlquileres);
		
		lblComision.setEnabled(false);
		lblComision.setBounds(33, 220, 117, 16);
		getContentPane().add(lblComision);
		

		lblSellado.setEnabled(false);
		lblSellado.setBounds(33, 274, 117, 16);
		getContentPane().add(lblSellado);
		
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
		sistema = s;
		initialize();
	}
	
	private void initialize () {
		buscarAlquileres();
		createTableAlquileres();
	}
	
	private List<Alquiler> buscarAlquileres() {
		List<Alquiler> alquileres = sistema.getAlquileres();
		return alquileres;
	}
	
	public void createTableAlquileres() {
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (alquileres != null) {
			
			for (Servicio a: alquileres) {
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
						txtComision.setVisible(true);
						txtSellado.setVisible(true);
						lblComision.setVisible(true);
						lblSellado.setVisible(true);
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
