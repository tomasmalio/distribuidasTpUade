package views;

import app.SistemaInmobiliaria;
import bean.Alquiler;
import bean.Servicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlquilerModificar extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private SistemaInmobiliaria sistema;
	private JTextField txtComision;
	private JTextField txtSellado;
	private JFrame frmAlquilerModificar;
	private List<Alquiler> alquileres;
	private Alquiler alquiler;
	private JTable table;
	private JLabel lblComision = new JLabel("Comision gestion");
	private JLabel lblSellado = new JLabel("Gastos sellado");
	
	public AlquilerModificar (SistemaInmobiliaria s) {
		super();
		sistema = s;
		alquileres= buscarAlquileres();
		initialize();
		createTableAlquileres();
		setVisible(true);
	}
	
	@SuppressWarnings("serial")
	private void initialize () {
		
		frmAlquilerModificar = new JFrame();
		frmAlquilerModificar.setBounds(100, 100, 320, 480);
		frmAlquilerModificar.setAlwaysOnTop(true);
		frmAlquilerModificar.getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblAlquileres = new JLabel("Alquileres");
		lblAlquileres.setBounds(33, 23, 80, 16);
		getContentPane().add(lblAlquileres);
		frmAlquilerModificar.getContentPane().add(lblAlquileres);
		
		lblComision.setEnabled(false);
		lblComision.setBounds(33, 312, 117, 16);
		getContentPane().add(lblComision);
		frmAlquilerModificar.getContentPane().add(lblComision);

		lblSellado.setEnabled(false);
		lblSellado.setBounds(33, 359, 117, 16);
		getContentPane().add(lblSellado);
		frmAlquilerModificar.getContentPane().add(lblSellado);
		
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

		JScrollPane scrollPanePublicaciones = new JScrollPane(table);
		scrollPanePublicaciones.setBounds(33, 51, 250, 236);
		table.setFillsViewportHeight(true);
		getContentPane().add(scrollPanePublicaciones);
		frmAlquilerModificar.getContentPane().add(scrollPanePublicaciones);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSubmit();
			}
		});
		btnModificar.setBounds(175, 400, 117, 29);
		getContentPane().add(btnModificar);
		frmAlquilerModificar.getContentPane().add(btnModificar);
		
		txtComision = new JTextField();
		txtComision.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				alquiler.setComisionGestion(Float.parseFloat(txtComision.getText()));
			}
		});
		txtComision.setEditable(false);
		txtComision.setEnabled(false);
		txtComision.setBounds(162, 307, 130, 26);
		getContentPane().add(txtComision);
		frmAlquilerModificar.getContentPane().add(txtComision);
		txtComision.setColumns(10);
		
		txtSellado = new JTextField();
		txtSellado.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				alquiler.setGastosSellado(Float.parseFloat(txtSellado.getText()));
			}
		});
		txtSellado.setEnabled(false);
		txtSellado.setEditable(false);
		txtSellado.setBounds(162, 354, 130, 26);
		getContentPane().add(txtSellado);
		frmAlquilerModificar.getContentPane().add(txtSellado);
		txtSellado.setColumns(10);
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
				    		txtComision.setEditable(true);
				    		txtComision.setEnabled(true);
				    		txtSellado.setEnabled(true);
				    		txtSellado.setEditable(true);
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

	public void setVisible(boolean isVisible) {
		this.frmAlquilerModificar.setVisible(isVisible);
	}
	
	private void onSubmit() {
		alquiler.setComisionGestion(Float.parseFloat(txtComision.getText()));
		alquiler.setGastosSellado(Float.parseFloat(txtSellado.getText()));
		sistema.grabarAlquiler(alquiler);
		setVisible(false);
		JOptionPane.showMessageDialog(null, "Alquiler modificado exitosamente!");
	}
}
