package logica;

import java.util.ArrayList;

public class Inmobiliaria {

	private String Nombre;
	private ArrayList<Inmueble> inmuebles; 
	private ArrayList<Cliente> clientes;
	private ArrayList<Asesor> asesores;
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
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
	
	public void agregarCliente(Cliente cliente){
		clientes.add(cliente);
	}
	
	public void borrarCliente(Cliente cliente){
		clientes.remove(cliente);
	}
	
	public Cliente buscarCliente(String nombre){
		for(int i=0;i<clientes.size();i++){
			if(clientes.get(i).getNombre().equals(nombre)){
				return clientes.get(i);
			}
		}
		return null;
	}
	
	public void agregarAsesor(Asesor asesor){
		asesores.add(asesor);
	}
	
	public void borrarAsesor(Asesor asesor){
		asesores.remove(asesor);
	}
	
	public Asesor buscarAsesor(String codigo_emp){
		for(int i=0;i<asesores.size();i++){
			if(asesores.get(i).getCodigo_emp() == codigo_emp){
				return asesores.get(i);
			}
		}
		return null;
	}
	
}
