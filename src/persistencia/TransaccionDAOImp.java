package persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;

import logica.*;
import excepciones.*;

public class TransaccionDAOImp implements ITransaccionDAO{

	IOfertaDAO ofertaDAO;
	ConnectionManager connManager;
	
	public TransaccionDAOImp() throws DAOExcepcion {
		super();
		try{
			ofertaDAO = new OfertaDAOImp();
			connManager= new ConnectionManager("practica4");
		}
		catch (ClassNotFoundException e){
			throw new DAOExcepcion(e);
		}
	}
	
	public void crearTransaccion(Transaccion t, String id)throws DAOExcepcion{
		try{
			connManager.connect();
			connManager.queryDB("insert into TRANSACCION (ID_TRANSACCION,COMPRA_O_ALQUILER,FECHA,OFERTA,PRECIO_FINAL) values ('"+id+"','"+t.getCompra_o_alquiler()+"','"+t.getFecha()+"','"+t.getOferta().getCod_Id()+"','"+t.getPrecio_final()+"')");
			connManager.close();
		}
		catch(Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	public ArrayList<Transaccion> encontrarTransacciones()throws DAOExcepcion{
		try{
			ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from transaccion");
			connManager.close();
			while(rs.next()){
				Oferta o = ofertaDAO.encontrarOfertaPorCod(rs.getString("OFERTA"));
				transacciones.add(new Transaccion(rs.getString("PRECIO_FINAL"),rs.getString("FECHA"),rs.getString("COMPRA_O_ALQUILER"),o));
			}
			return transacciones;
		}
		catch(Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
	public boolean comprobarOfertaTransaccion(String oferta)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from transaccion where oferta = '"+oferta+"'");
			connManager.close();
			if(rs.next())
				return true;
			return false;
		}
		catch(Exception e){
			throw new DAOExcepcion(e);
		}
	}
	
}
