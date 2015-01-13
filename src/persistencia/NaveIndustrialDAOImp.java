package persistencia;

import java.sql.*;

import logica.*;
import excepciones.DAOExcepcion;

public class NaveIndustrialDAOImp extends InmuebleDAOImp implements INaveIndustrialDAO{
	
	protected ConnectionManager connManager;
	private IAsesorDAO asesorDAO;
	private IClienteDAO clienteDAO;
	
	   public NaveIndustrialDAOImp() throws DAOExcepcion {
			super();
			// TODO Auto-generated constructor stub
			try{
			connManager= new ConnectionManager("practica4");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion(e);
			}
		}

	  public void crearNaveIndustrial(NaveIndustrial ni) throws DAOExcepcion {
			// TODO Auto-generated method stub
					
		  try{
			  crearInmueble(new Inmueble(ni.getCod_Id(), ni.getCalle(), ni.getLocalidad(), ni.getFecha_Alta(), ni.getSuperficie_Total(), ni.getVenta_Alquiler(), ni.getCliente(), ni.getAsesor())); 
			  connManager.connect();
			  connManager.updateDB("insert into NAVEINDUSTRIAL (COD_ID, CALIFICACION, NUM_PUERTAS) values ('"+ni.getCod_id()+"','"+ni.getCalificacion()+"','"+ni.getNum_puertas()+"')");
			  connManager.close();
		  }
		  catch (Exception e){
			  throw new DAOExcepcion(e);
		  }
	  }

	 public NaveIndustrial encontrarNaveIndustrialPorCod(String cod)throws DAOExcepcion{
		 try{
		  Inmueble in = encontrarInmueblePorCod(cod);
		  if(in!=null){
			  connManager.connect();
			  System.out.println("select NUM_PUERTAS,CALIFICACION from NAVEINDUSTRIAL where COD_ID= '"+cod+"'");
			  ResultSet rs=connManager.queryDB("select NUM_PUERTAS,CALIFICACION from NAVEINDUSTRIAL where COD_ID= '"+cod+"'");
			  connManager.close();
			  if (rs.next()){
				  Cliente c = clienteDAO.encontrarClientePorCod(rs.getString("CLIENTE"));
			  	  Asesor a = asesorDAO.encontrarAsesorPorCod(rs.getString("ASESOR"));
				  return new NaveIndustrial(cod,in.getCalle(),in.getLocalidad(),in.getFecha_Alta(),in.getSuperficie_Total(),in.getVenta_Alquiler(),rs.getString("NUM_PUERTAS"),rs.getString("CALIFICACION"),c,a);
			  }
			  else
				  return null;
		  }
		  return null;
	  }catch (SQLException e){
		  throw new DAOExcepcion(e);
	  }
			
	}

}
