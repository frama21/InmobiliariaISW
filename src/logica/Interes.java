package logica;

public class Interes {
	
	private double precio_maximo_compra;
	private double precio_maximo_alquiler;
	private ZonaGeografica zonaGeografica;
	private Cliente cliente;
	
	
	public double getPrecio_maximo_compra() {
		return precio_maximo_compra;
	}
	
	public void setPrecio_maximo_compra(double precio_maximo_compra) {
		this.precio_maximo_compra = precio_maximo_compra;
	}
	
	public double getPrecio_maximo_alquiler() {
		return precio_maximo_alquiler;
	}
	
	public void setPrecio_maximo_alquiler(double precio_maximo_alquiler) {
		this.precio_maximo_alquiler = precio_maximo_alquiler;
	}
	
	public ZonaGeografica getZonaGeografica() {
		return zonaGeografica;
	}
	
	public void setZonaGeografica(ZonaGeografica zonaGeografica) {
		this.zonaGeografica = zonaGeografica;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
