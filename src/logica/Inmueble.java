package logica;
import java.util.*;

public class Inmueble {

    private String Cod_Id;
	private String ventaAlquiler;
    private String calle;
    private String localidad;
    private String fecha_alta;
    private String superficie_total;
    private ArrayList <Visita> visitas;
    private Cliente cliente;
    private ZonaGeografica zonaGeografica;
    private Inmobiliaria inmobiliaria;
    private Hipoteca hipoteca;
    private Asesor asesor;

	public Inmueble(String cod, String calle, String localidad, String fecha_alta,
			String superficie_total, String venta_alquiler, Cliente cliente, Asesor asesor) {
		
		this.Cod_Id = cod;
		this.calle = calle;
		this.localidad = localidad;
		this.fecha_alta = fecha_alta;
		this.superficie_total = superficie_total;
		this.ventaAlquiler = venta_alquiler;
		this.cliente = cliente;
		this.asesor = asesor;
		
	}

	public String getVenta_Alquiler() {
		return ventaAlquiler;
	}

	public void setVenta_Alquiler(String ventaAlquiler) {
		this.ventaAlquiler = ventaAlquiler;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getSuperficie_Total() {
		return superficie_total;
	}

	public void setSuperficie_Total(String superficieTotal) {
		this.superficie_total = superficieTotal;
	}

	public String getFecha_Alta() {
		return fecha_alta;
	}

	public void setFecha_Alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ZonaGeografica getZonaGeografica() {
		return zonaGeografica;
	}

	public void setZonaGeografica(ZonaGeografica zonaGeografica) {
		this.zonaGeografica = zonaGeografica;
	}
	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}
	public Hipoteca getHipoteca() {
		return hipoteca;
	}

	public void setHipoteca(Hipoteca hipoteca) {
		this.hipoteca = hipoteca;
	}
	
	public void agregarVisita(Visita visita){
		visitas.add(visita);
	}
	
	public void borrarVisita(Visita visita){
		visitas.remove(visita);
	}
	
	public Visita buscarVisita(String fecha){
		for(int i=0;i<visitas.size();i++){
			if(visitas.get(i).getFecha() == fecha){
				return visitas.get(i);
			}
		}
		return null;
	}

	public String getCod_Id() {
		return Cod_Id;
	}

	public void setCod_Id(String cod_Id) {
		Cod_Id = cod_Id;
	}

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	
	public String toString(){
		return this.Cod_Id+"-"+this.calle+","+this.localidad;
	}
}
