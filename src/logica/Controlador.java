package logica;

import java.util.*;

import excepciones.*;
import persistencia.DAL;

public class Controlador {

	private DAL dal = null;
	
	private static Controlador control = null;	
	
	private Controlador()throws LogicaExcepcion{
		try{
			dal = DAL.dameDAL();
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public static Controlador getInstance() throws LogicaExcepcion {
		if(control == null)
			control = new Controlador();
		return control;
	}
	
	public ArrayList<Asesor> encontrarAsesores() throws LogicaExcepcion{
		try{
			return dal.encontrarAsesores();
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Cliente> encontrarClientes() throws LogicaExcepcion{
		try{
			return dal.encontrarClientes();
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearPiso(Piso p)throws LogicaExcepcion{
		try{
			if(dal.encontrarPisoPorCod(p.getCod_Id())==null){
				dal.crearPiso(p);
			}
			else{
				throw new LogicaExcepcion("PISO EXISTE");
			}
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearAsesor(Asesor a)throws LogicaExcepcion{
		try{
			if(dal.encontrarAsesorPorCod(a.getCodigo_emp())==null){
				dal.crearAsesor(a);
			}
			else{
				throw new LogicaExcepcion("ASESOR EXSITE");
			}
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearCliente(Cliente c)throws LogicaExcepcion{
		try{
			if(dal.encontrarClientePorCod(c.getNifCliente())==null){
				dal.crearCliente(c);
			}
			else{
				throw new LogicaExcepcion("CLIENTE EXISTE");
			}
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearNaveIndustrial(NaveIndustrial ni) throws LogicaExcepcion{
		try{
			if(dal.encontrarNaveIndustrialPorCod(ni.getCod_id())==null){
				dal.crearNaveIndustrial(ni);
			}
			else{
				throw new LogicaExcepcion("NAVE INDUSTRIAL EXISTE");
			}
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Inmueble> encontrarInmuebles()throws LogicaExcepcion{
		try{
			return dal.encontrarInmuebles();
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Inmueble> encontrarInmueblesPorCliente(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarInmueblesPorCliente(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Inmueble> encontrarInmueblesPorAsesor(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarInmueblesPorAsesor(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public Cliente encontrarClientePorCod(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarClientePorCod(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public Asesor encontrarAsesorPorCod(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarAsesorPorCod(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Oferta> encontrarOfertaPorVisita(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarOfertaPorVisita(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Visita> encontrarVisitasPorInmueble(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarVisitasPorInmueble(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearTransaccion(Transaccion t, String id)throws LogicaExcepcion{
		try{
			dal.crearTransaccion(t,id);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearOferta(Oferta o)throws LogicaExcepcion{
		try{
			dal.crearOferta(o);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public void crearVisita(Visita v)throws LogicaExcepcion{
		try{
			dal.crearVisita(v);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public Oferta encontrarOfertaPorCod(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarOfertaPorCod(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public Visita encontrarVisitaPorCod(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarVisitaPorCod(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Visita> encontrarVisitasPorAsesor(String asesor)throws LogicaExcepcion{
		try{
			return dal.encontrarVisitasPorAsesor(asesor);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public Inmueble encontrarInmueblePorCod(String cod)throws LogicaExcepcion{
		try{
			return dal.encontrarInmueblePorCod(cod);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public boolean comprobarOfertaTransaccion(String oferta)throws LogicaExcepcion{
		try{
			return dal.comprobarOfertaTransaccion(oferta);
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
	public ArrayList<Transaccion> encontrarTransacciones()throws LogicaExcepcion{
		try{
			return dal.encontrarTransacciones();
		}
		catch(DAOExcepcion e){
			throw new LogicaExcepcion(e);
		}
	}
	
}
