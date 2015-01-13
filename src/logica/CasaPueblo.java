package logica;

public class CasaPueblo extends Inmueble{
	
	///atributos
	private String superficie_patio;
	private String numero_plantas;
	private String superficie_plantas;
	private PlazaGaraje plazaGaraje;
	
	public CasaPueblo(String cod, String calle, String localidad, String fecha_Alta,
			String superficie_Total, String venta_Alquiler, String superficie_patio,
			String num_plantas,String superficie_plantas, PlazaGaraje plazaGaraje, Cliente c, Asesor a){
		super(cod,calle,localidad,fecha_Alta,superficie_Total,venta_Alquiler,c,a);
		this.superficie_patio = superficie_patio;
		this.numero_plantas = num_plantas;
		this.superficie_plantas = superficie_plantas;
		this.plazaGaraje = plazaGaraje;
	}
	
	public String getSuperficie_patio() {
		return superficie_patio;
	}
	
	public void setSuperficie_patio(String superficie_patio) {
		this.superficie_patio = superficie_patio;
	}
	
	public String getNumero_plantas() {
		return numero_plantas;
	}
	
	public void setNumero_plantas(String numero_plantas) {
		this.numero_plantas = numero_plantas;
	}
	
	public String getSuperficie_plantas() {
		return superficie_plantas;
	}
	
	public void setSuperficie_plantas(String superficie_plantas) {
		this.superficie_plantas = superficie_plantas;
	}
	
	public PlazaGaraje getPlazaGaraje() {
		return plazaGaraje;
	}
	
	public void setPlazaGaraje(PlazaGaraje plazaGaraje) {
		this.plazaGaraje = plazaGaraje;
	}
}
