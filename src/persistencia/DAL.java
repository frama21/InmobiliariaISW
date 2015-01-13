package persistencia;
import excepciones.*;
import logica.*;

import java.util.*;

public class DAL {

	private static DAL dal;
	private IAsesorDAO asesorDAO;
	private IClienteDAO clienteDAO;
	private IPisoDAO pisoDAO;
	private IInmuebleDAO inmuebleDAO;
	private INaveIndustrialDAO naveIndustrialDAO;
	private IOfertaDAO ofertaDAO;
	private IVisitaDAO visitaDAO;
	private ITransaccionDAO transaccionDAO;
	
	private DAL() throws DAOExcepcion{
		asesorDAO = new AsesorDAOImp();
		clienteDAO = new ClienteDAOImp();
		pisoDAO = new PisoDAOImp();
		inmuebleDAO = new InmuebleDAOImp();
		naveIndustrialDAO = new NaveIndustrialDAOImp();
		ofertaDAO = new OfertaDAOImp();
		visitaDAO = new VisitaDAOImp();
		transaccionDAO = new TransaccionDAOImp();
		ofertaDAO = new OfertaDAOImp();
	}
	
	public static DAL dameDAL() throws DAOExcepcion{
		if(dal == null){
			dal = new DAL();
		}
		return dal;
	}
	
	public void crearPiso(Piso p) throws DAOExcepcion{
		pisoDAO.crearPiso(p);
	}
	
	public void crearAsesor(Asesor a) throws DAOExcepcion{
		asesorDAO.crearAsesor(a);
	}
	
	public void crearNaveIndustrial(NaveIndustrial ni) throws DAOExcepcion{
		naveIndustrialDAO.crearNaveIndustrial(ni);
	}
	
	public void crearCliente(Cliente c) throws DAOExcepcion{
		clienteDAO.crearCliente(c);
	}

	public void crearVisita(Visita v)throws DAOExcepcion{
		visitaDAO.crearVisita(v);
	}
	
	public void crearOferta(Oferta o)throws DAOExcepcion{
		ofertaDAO.crearOferta(o);
	}
	
	public Piso encontrarPisoPorCod(String cod) throws DAOExcepcion{
		return pisoDAO.encontrarPisoPorCod(cod);
	}
	
	public ArrayList<Inmueble> encontrarInmueblesPorCliente(String cod)throws DAOExcepcion{
		return inmuebleDAO.encontrarInmueblesPorCliente(cod);
	}
	
	public ArrayList<Inmueble> encontrarInmueblesPorAsesor(String cod)throws DAOExcepcion{
		return inmuebleDAO.encontrarInmueblesPorAsesor(cod);
	}
	
	public ArrayList<Asesor> encontrarAsesores() throws DAOExcepcion{
		return asesorDAO.encontrarAsesores();
	}
	
	public ArrayList<Cliente> encontrarClientes() throws DAOExcepcion{
		return clienteDAO.encontrarClientes();
	}
	
	public ArrayList<Inmueble> encontrarInmuebles() throws DAOExcepcion{
		return inmuebleDAO.encontrarInmuebles();
	}
	
	public Cliente encontrarClientePorCod(String cod) throws DAOExcepcion{
		return clienteDAO.encontrarClientePorCod(cod);
	}
	
	public Asesor encontrarAsesorPorCod(String cod) throws DAOExcepcion{
		return asesorDAO.encontrarAsesorPorCod(cod);
	}
	
	public NaveIndustrial encontrarNaveIndustrialPorCod(String cod) throws DAOExcepcion{
		return naveIndustrialDAO.encontrarNaveIndustrialPorCod(cod);
	}
	
	public ArrayList<Oferta> encontrarOfertaPorVisita(String cod)throws DAOExcepcion{
		return ofertaDAO.encontrarOfertaPorVisita(cod);
	}
	
	public Visita encontrarVisitaPorCod(String cod)throws DAOExcepcion{
		return visitaDAO.encontrarVisitaPorCod(cod);
	}
	
	public ArrayList<Visita> encontrarVisitasPorInmueble(String cod)throws DAOExcepcion{
		return visitaDAO.encontrarVisitasPorInmueble(cod);
	}
	
	public void crearTransaccion(Transaccion t, String id)throws DAOExcepcion{
		transaccionDAO.crearTransaccion(t,id);
	}
	
	public Oferta encontrarOfertaPorCod(String cod)throws DAOExcepcion{
		return ofertaDAO.encontrarOfertaPorCod(cod);
	}
	
	public ArrayList<Visita> encontrarVisitasPorAsesor(String asesor)throws DAOExcepcion{
		return visitaDAO.encontrarVisitasPorAsesor(asesor);
	}
	
	public Inmueble encontrarInmueblePorCod(String cod)throws DAOExcepcion{
		return inmuebleDAO.encontrarInmueblePorCod(cod);
	}
	
	public boolean comprobarOfertaTransaccion(String oferta)throws DAOExcepcion{
		return transaccionDAO.comprobarOfertaTransaccion(oferta);
	}
	
	public ArrayList<Transaccion> encontrarTransacciones()throws DAOExcepcion{
		return transaccionDAO.encontrarTransacciones();
	}
	
	
}
