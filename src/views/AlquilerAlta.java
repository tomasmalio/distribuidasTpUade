package views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.SistemaInmobiliaria;
import bean.Propiedad;

import javax.swing.JTable;

public class AlquilerAlta {

	private JFrame frmAlquilerAlta;
	private JTextField textFechaDesde;
	private JTextField textFechaHasta;
	private JTable table;
	
	private SistemaInmobiliaria sistema;

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
		buscarPropiedad("");
		createTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlquilerAlta = new JFrame();
		frmAlquilerAlta.setBounds(100, 100, 450, 300);
		frmAlquilerAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlquilerAlta.getContentPane().setLayout(null);
		
		JLabel lblFechaDesde = new JLabel("Fecha desde: ");
		lblFechaDesde.setBounds(36, 40, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaDesde);
		
		textFechaDesde = new JTextField();
		textFechaDesde.setBounds(155, 35, 130, 26);
		frmAlquilerAlta.getContentPane().add(textFechaDesde);
		textFechaDesde.setColumns(10);
		
		JLabel lblFechaHasta = new JLabel("Fecha hasta:");
		lblFechaHasta.setBounds(36, 87, 85, 16);
		frmAlquilerAlta.getContentPane().add(lblFechaHasta);
		
		textFechaHasta = new JTextField();
		textFechaHasta.setBounds(155, 82, 130, 26);
		frmAlquilerAlta.getContentPane().add(textFechaHasta);
		textFechaHasta.setColumns(10);
		
		JLabel lblPropiedad = new JLabel("Propiedad");
		lblPropiedad.setBounds(36, 146, 80, 16);
		frmAlquilerAlta.getContentPane().add(lblPropiedad);
	}
	private List<Propiedad> buscarPropiedad(String busqueda) {
		List<Propiedad> propiedades = new List<>(sistema.getPropiedades());
		List<Propiedad> propAlquiler= new ArrayList<Propiedad>();

		for(Propiedad p: propiedades) 
			if(p.getValorAlquiler()>0) {
				propAlquiler
			}
		}
		return propiedades;
	}
	
	public void createTable() {
			
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		if (resultado != null) {
			

			for(Propiedad p: propiedades) 
				if(p.getValorAlquiler()>0) {
					model.addRow(new Object[]{
							calle,
							p.getArticulo().getNombre(),
							"$" + precio,
							categoria
					});
				}
			}

			for(Publicacion p : resultado){
	
				String categoria =(p.getArticulo() instanceof Producto) ? "Producto" : "Servicio";
				String tipoPublicacion = (p instanceof Subasta) ? "subasta-16.png" : "compra-inmediata-16.png";
				String precio = Float.toString(p.getPrecio());

				/**
				 * TODO checkear el tema de la subasta
				 */
				model.addRow(new Object[]{
						tipoPub,
						p.getArticulo().getNombre(),
						"$" + precio,
						categoria
				});
			}				

			table.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = table.rowAtPoint(evt.getPoint());
			        int col = table.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        		Publicacion p = resultado.get(row);

			        		VerPublicacion articuloSeleccionado = new VerPublicacion(p);	
			        		articuloSeleccionado.setVisible(true);
			        		frame.dispose();
			        }
			    }
			});
		} else {
			JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
		}
		
		btnBuscar.setEnabled(true);
	}
	
	public void setVisible(boolean isVisible) {
		this.frame.setVisible(isVisible);
	}
}
