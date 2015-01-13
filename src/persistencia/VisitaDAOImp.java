package persistencia;

import logica.*;
import excepciones.*;

import java.sql.*;
import java.util.*;

public class VisitaDAOImp implements IVisitaDAO{

	protected ConnectionManager connManager;
	private IInmuebleDAO inmuebleDAO;
	private IClienteDAO clienteDAO;
	private IAsesorDAO asesorDAO;
	
	public VisitaDAOImp() throws DAOExcepcion{
		try{
			connManager= new ConnectionManager("practica4");
			inmuebleDAO = new InmuebleDAOImp();
			clienteDAO = new ClienteDAOImp();
			asesorDAO = new AsesorDAOImp();
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	
	public void crearVisita(Visita v)throws DAOExcepcion{
		 try{
			 connManager.connect();
             connManager.queryDB("insert into VISITA (ID_VISITA,ASESOR,CLIENTE,FECHA,INMUEBLE) values ('"+v.getCod_Id()+"','"+v.getAsesor().getCodigo_emp()+"','"+v.getCliente().getNifCliente()+"','"+v.getFecha()+"','"+v.getInmueble().getCod_Id()+"')");
             connManager.close();
     }
     catch(Exception e){
             throw new DAOExcepcion(e);
     }
	}
	
	public ArrayList<Visita> encontrarVisitasPorInmueble(String inmueble)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * FROM VISITA where INMUEBLE = '"+inmueble+"'");
			connManager.close();
			ArrayList<Visita> visitas = new ArrayList<Visita>();
			while(rs.next()){
				Inmueble in = inmuebleDAO.encontrarInmueblePorCod(inmueble);
				Cliente cl = clienteDAO.encontrarClientePorCod(rs.getString("CLIENTE"));
				Asesor as = asesorDAO.encontrarAsesorPorCod(rs.getString("ASESOR"));
				visitas.add(new Visita(rs.getString("ID_VISITA"),rs.getString("FECHA"),in,cl,as));
			}
			return visitas;
		}
		catch(SQLException e){
			throw new DAOExcepcion(e);
		}
	}
	
	public Visita encontrarVisitaPorCod(String cod)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * FROM VISITA where ID_VISITA = '"+cod+"'");
			connManager.close();
			if(rs.next()){
				Inmueble in = inmuebleDAO.encontrarInmueblePorCod(rs.getString("INMUEBLE"));
				Cliente cl = clienteDAO.encontrarClientePorCod(rs.getString("CLIENTE"));
				Asesor as = asesorDAO.encontrarAsesorPorCod(rs.getString("ASESOR"));
				return new Visita(cod,rs.getString("FECHA"),in,cl,as);
			}
			else{
				return null;
			}
		}
		catch(SQLException e){
			throw new DAOExcepcion(e);
		}
	}

	public ArrayList<Visita> encontrarVisitasPorAsesor(String asesor)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from VISITA where ASESOR = '"+asesor+"'");
			connManager.close();
			ArrayList<Visita> visitas = new ArrayList<Visita>();
			while(rs.next()){
				Inmueble in = inmuebleDAO.encontrarInmueblePorCod(rs.getString("INMUEBLE"));
				Cliente cl = clienteDAO.encontrarClientePorCod(rs.getString("CLIENTE"));
				Asesor as = asesorDAO.encontrarAsesorPorCod(asesor);
				visitas.add(new Visita(rs.getString("ID_VISITA"),rs.getString("FECHA"),in,cl,as));
			}
			return visitas;
		}
		catch(SQLException e){
			throw new DAOExcepcion(e);
		}
	}
	
}
