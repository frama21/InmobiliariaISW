package logica;

public class Hipoteca {
	private float cantidad_pendiente;
	private String banco;
	private Inmueble inmueble;
	
	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public float getCantidad_pendiente() {
		return cantidad_pendiente;
	}

	public void setCantidad_pendiente(float cantidad_pendiente) {
		this.cantidad_pendiente = cantidad_pendiente;
	}
}
