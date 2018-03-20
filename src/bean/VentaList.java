package bean;

import java.util.ArrayList;
import java.util.List;

public class VentaList {
	private List<Venta> ventas = new ArrayList<Venta>();

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	
	public void addVenta(Venta venta) {
		ventas.add(venta);
	}
	
	public boolean removeVenta(Venta venta) {
		return ventas.remove(venta);
	}
	public int cantidadVentas() {
		return ventas.size();
	}
}
