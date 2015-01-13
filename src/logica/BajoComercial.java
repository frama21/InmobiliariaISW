package logica;

public class BajoComercial extends Inmueble{

	private String num_puertas;
	
	public BajoComercial(String cod, String calle, String localidad, String fecha_Alta,
			String superficie_Total, String venta_Alquiler, String num_puertas, Cliente c, Asesor a){
		super(cod,calle,localidad,fecha_Alta,superficie_Total,venta_Alquiler,c,a);
		this.num_puertas = num_puertas;
	}

	public String getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(String num_puertas) {
		this.num_puertas = num_puertas;
	}
	
	
}
