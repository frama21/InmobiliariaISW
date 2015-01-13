package logica;

import java.util.ArrayList;

public class ZonaGeografica {
	
	private int codigo;
	private ArrayList<Interes> intereses; 
	private ArrayList<Inmueble> inmuebles; 

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

}
