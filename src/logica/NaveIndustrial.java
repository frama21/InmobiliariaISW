package logica;

public class NaveIndustrial extends Inmueble{

	//atributos
	private String cod_id;
	private String num_puertas;
	private String calificacion;
	
	public NaveIndustrial(String cod, String calle, String localidad, String fecha_Alta,
			String superficie_Total, String venta_Alquiler, String num_puertas, 
			String calificacion, Cliente c, Asesor a){
		super(cod,calle,localidad,fecha_Alta,superficie_Total,venta_Alquiler, c, a);
		this.setCod_id(cod);
		this.num_puertas = num_puertas;
		this.calificacion = calificacion;
	}
	
	
	public String getNum_puertas() {
		return num_puertas;
	}
	public void setNum_puertas(String num_puertas) {
		this.num_puertas = num_puertas;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}


	public String getCod_id() {
		return cod_id;
	}


	public void setCod_id(String cod_id) {
		this.cod_id = cod_id;
	}
	
	
}
