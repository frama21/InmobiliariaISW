package logica;
//eeee
public class Adosado extends CasaPueblo{
	
	private String gastos_comunidad;
	
	public Adosado(String cod, String calle, String localidad, String fecha_Alta,
			String superficie_Total, String venta_Alquiler, String superficie_patio,
			String num_plantas,String superficie_plantas, PlazaGaraje plazaGaraje,
			String gastosComunidad, Cliente c, Asesor a){
		super(cod,calle,localidad,fecha_Alta,superficie_Total,venta_Alquiler,
				superficie_patio,num_plantas, superficie_plantas,plazaGaraje, c, a);
		this.gastos_comunidad = gastosComunidad;
	}
	

	public String getGastos_comunidad() {
		return gastos_comunidad;
	}

	public void setGastos_comunidad(String gastos_comunidad) {
		this.gastos_comunidad = gastos_comunidad;
	}

}
