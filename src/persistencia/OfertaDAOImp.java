package persistencia;

import java.sql.*;
import java.util.ArrayList;

import logica.*;
import excepciones.*;

public class OfertaDAOImp implements IOfertaDAO{
	
	protected ConnectionManager connManager;
	private IVisitaDAO visitaDAO;
	
	public OfertaDAOImp() throws DAOExcepcion {
		super();
		try{
			visitaDAO = new VisitaDAOImp();
			connManager= new ConnectionManager("practica4");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	
	public void crearOferta(Oferta o)throws DAOExcepcion{
		try{
			connManager.connect();
			connManager.queryDB("insert into Oferta (ID_OFERTA,FECHA,VISITA,PRECIO) values ('"+o.getCod_Id()+"','"+o.getFecha()+"','"+o.getVisita().toString().split("-")[0]+"','"+o.getPrecio()+"')");
			connManager.close();
		}
		catch(Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	public ArrayList<Oferta> encontrarOfertaPorVisita(String visita)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from OFERTA where VISITA= '"+visita+"'");
			connManager.close();
			ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
			Visita vis = visitaDAO.encontrarVisitaPorCod(visita);
			if(rs.next())
				ofertas.add(new Oferta(rs.getString("ID_OFERTA"),rs.getString("PRECIO"),rs.getString("FECHA"),vis));
			return ofertas;
		  }
		  catch (Exception e){
			  throw new DAOExcepcion(e);
		  }
	}
	
	public Oferta encontrarOfertaPorCod(String cod)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from OFERTA where ID_OFERTA= '"+cod+"'");
			connManager.close();
			Visita vis = visitaDAO.encontrarVisitaPorCod(cod);
			if(rs.next())
				return new Oferta(cod,rs.getString("PRECIO"),rs.getString("FECHA"),vis);
			else
				return null;
		  }
		  catch (Exception e){
			  throw new DAOExcepcion(e);
		  }
	}

}
