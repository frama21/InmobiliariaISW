package logica;

import persistencia.InmuebleDAOImp;
import persistencia.PisoDAOImp;
import excepciones.*;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inmueble in; 
		try{
		InmuebleDAOImp inDAOImp = new InmuebleDAOImp();	
		if (inDAOImp.encontrarInmueblePorCod("In11111111")==null) 
			inDAOImp.crearInmueble(new Inmueble("In11111111","Paz,￼￼￼￼￼￼￼3","Valencia",
					"30/10/2013","550 m2","V",new Cliente("12345678A","Juan","Perez Perez"),new Asesor("123","Pedro Boix Boix")));
		if (inDAOImp.encontrarInmueblePorCod ("In11111112")==null) 
			inDAOImp.crearInmueble(new Inmueble("In11111112","Emilio Baro,￼￼￼￼￼￼￼￼7","Valencia",
					"02/11/2013","150 m2","V",new Cliente("87654321A","Andres","Perez Perez"),new Asesor("321","Paco Boix Boix"))); 
		in=inDAOImp.encontrarInmueblePorCod ("11111111A");
		if(in!=null)
			System.out.print(" Calle: "+in.getCalle()+" Localidad: "+in.getLocalidad()+
					" Fecha Alta: "+in.getFecha_Alta()+" Superficie Total: "+
					in.getSuperficie_Total ()+" Venta(V) / Alquiler(A): "+
					in.getVenta_Alquiler());
		PisoDAOImp piDAOImp= new PisoDAOImp();
		if(piDAOImp.encontrarPisoPorCod("In11111113")==null)
			piDAOImp.crearPiso(new Piso("In11111113","Alfahuir, 7-1o", "Valencia",
					"02/11/2013","95 m2","A","3",new Cliente("43526234C","Fran","Perez Perez"),new Asesor("132","Maria Boix Boix")));
		}catch (DAOExcepcion e){ System.out.print("DAOExcepcion: "+e);
		}
	}

}
