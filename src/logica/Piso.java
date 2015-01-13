package logica;

public class Piso extends Inmueble{
	
	//atributos
	private String num_habitaciones;
	private PlazaGaraje plazaGaraje;
	

	public Piso(String cod, String calle, String localidad, String fecha_Alta,
			String superficie_Total, String venta_Alquiler, String num_habitaciones, Cliente c, Asesor a) {
		super(cod,calle,localidad,fecha_Alta,superficie_Total,venta_Alquiler,c,a);
		this.num_habitaciones = num_habitaciones;
	}

	public String getNum_Habitaciones() {
		return num_habitaciones;
	}

	public void setNum_Habitaciones(String num_habitaciones) {
		this.num_habitaciones = num_habitaciones;
	}

	public PlazaGaraje getPlazaGaraje() {
		return plazaGaraje;
	}

	public void setPlazaGaraje(PlazaGaraje plazaGaraje) {
		this.plazaGaraje = plazaGaraje;
	}

}
