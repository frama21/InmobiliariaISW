package logica;

public class Visita {
	
	private String Cod_Id;
	private String fecha;
	private Oferta oferta;
	private Asesor asesor;
	private Inmueble inmueble;
	private Cliente cliente;
	
	public Visita(String id, String fecha, Inmueble inmueble, Cliente cliente, Asesor asesor){
		this.setCod_Id(id);
		this.fecha = fecha;
		this.inmueble = inmueble;
		this.cliente = cliente;
		this.asesor = asesor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String toString(){
		return this.Cod_Id+"-"+this.fecha;
	}

	public String getCod_Id() {
		return Cod_Id;
	}

	public void setCod_Id(String cod_Id) {
		Cod_Id = cod_Id;
	}
}
