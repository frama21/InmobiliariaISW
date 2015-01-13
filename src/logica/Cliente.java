package logica;

import java.util.*;

public class Cliente {
	private String nifCliente;
	private String nombre;
	private String apellidos;
	private ArrayList<Interes> intereses; 
	private ArrayList<Inmueble> inmuebles; 
	private Inmobiliaria inmobiliaria;
	private ArrayList<Visita> visitas;
	private ArrayList<ZonaGeografica> zonaGeografica;
	
	public Cliente(String nif, String nom, String ap){
		this.nifCliente = nif;
		this.nombre = nom;
		this.apellidos = ap;
	}

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarIntereses(Interes interes){
		this.intereses.add(interes);
	}
	
	public void borrarIntereses(Interes interes){
		this.intereses.remove(interes);
	}
	
	public Interes buscarInteres(float precio_max){
		for(int i=0;i<intereses.size();i++){
			if(intereses.get(i).getPrecio_maximo_alquiler() == precio_max){
				return intereses.get(i); 
			}
		}
		return null;
	}
	
	public void agregarInmueble(Inmueble inmueble){
		inmuebles.add(inmueble);
	}
	
	public void borrarInmueble(Inmueble inmueble){
		inmuebles.remove(inmueble);
	}
	
	public Inmueble buscarInmueble(String calle){
		for(int i=0;i<inmuebles.size();i++){
			if(inmuebles.get(i).getCalle().equals(calle)){
				return inmuebles.get(i);
			}
		}
		return null;
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
	
	public void agregarZonaGeografia(ZonaGeografica zonaGeografica){
		this.zonaGeografica.add(zonaGeografica);
	}
	
	public void borrarZonaGeografica(ZonaGeografica zonaGeografica){
		this.zonaGeografica.remove(zonaGeografica);
	}
	
	public ZonaGeografica buscarZonaGeografica(int codigo){
		for(int i=0;i<this.zonaGeografica.size();i++){
			if(this.zonaGeografica.get(i).getCodigo() == codigo){
				return this.zonaGeografica.get(i);
			}
		}
		return null;
	}

	public String getNifCliente() {
		return nifCliente;
	}

	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String toString(){
		return this.getNifCliente()+"-"+this.getApellidos()+","+this.getNombre();
	}
	
}
