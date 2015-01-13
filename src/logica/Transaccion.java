package logica;

public class Transaccion {
	
	//atributos
	private String precio_final;
	private String fecha;
	private String compra_o_alquiler;
	private Oferta oferta;
	
	public Transaccion(String precio_final,String fecha, String compra_o_alquiler, Oferta oferta){
		this.precio_final = precio_final;
		this.fecha = fecha;
		this.compra_o_alquiler = compra_o_alquiler;
		this.oferta = oferta;
	}
	
	public String getPrecio_final() {
		return precio_final;
	}
	
	public void setPrecio_final(String precio_final) {
		this.precio_final = precio_final;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getCompra_o_alquiler() {
		return compra_o_alquiler;
	}
	
	public void setCompra_o_alquiler(String compra_o_alquiler) {
		this.compra_o_alquiler = compra_o_alquiler;
	}
	
	public Oferta getOferta() {
		return oferta;
	}
	
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	public String toString(){
		return ""+this.getPrecio_final()+","+this.getFecha()+","+this.compra_o_alquiler+","+this.getOferta().toString();
	}

}
