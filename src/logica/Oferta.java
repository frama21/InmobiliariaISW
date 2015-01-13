package logica;


public class Oferta {

	private String Cod_Id;
	private String precio;
	private String fecha;
	private Transaccion transaccion;
	private Visita visita;
	
	public Oferta(String id,String precio, String fecha, Visita visita){
		this.Cod_Id = id;
		this.precio = precio;
		this.fecha = fecha;
		this.visita = visita;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public Transaccion getTransaccion() {
		return transaccion;
	}
	
	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}
	
	public Visita getVisita() {
		return visita;
	}
	
	public void setVisita(Visita visita) {
		this.visita = visita;
	}
	
	public String toString(){
		return this.Cod_Id+"-"+this.precio+","+this.fecha;
	}

	public String getCod_Id() {
		return Cod_Id;
	}

	public void setCod_Id(String cod_Id) {
		Cod_Id = cod_Id;
	}
	
	
}
