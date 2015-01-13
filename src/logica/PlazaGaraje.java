package logica;

public class PlazaGaraje extends Inmueble {

	//atributos
	private String caracter;
	private Piso piso;
	private CasaPueblo casaPueblo;
	
	public PlazaGaraje(String cod, String calle, String localidad, String fecha_Alta,
			String superficie_Total, String venta_Alquiler, String caracter,
			Piso piso, CasaPueblo casaPueblo,Cliente c, Asesor a){
		
		super(cod,calle,localidad,fecha_Alta,superficie_Total,venta_Alquiler,c,a);
		this.caracter = caracter;
		this.piso = piso;
		this.casaPueblo = casaPueblo;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public Piso getPiso() {
		return piso;
	}

	public void setPiso(Piso piso) {
		this.piso = piso;
	}

	public CasaPueblo getCasaPueblo() {
		return casaPueblo;
	}

	public void setCasaPueblo(CasaPueblo casaPueblo) {
		this.casaPueblo = casaPueblo;
	}
	
}
