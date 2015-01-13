package persistencia;
import java.sql.*;
import java.util.*;

import logica.Asesor;
import excepciones.DAOExcepcion;

public class AsesorDAOImp implements IAsesorDAO{
	protected ConnectionManager connManager;
	
	   public AsesorDAOImp() throws DAOExcepcion {
			super();
			try{
			connManager= new ConnectionManager("practica4");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion(e);
			}
		}

	  public void crearAsesor(Asesor as) throws DAOExcepcion {					
		  try{
			  connManager.connect();
			  connManager.updateDB("insert into ASESOR (CODIGO_EMPLEADO, NOMBRE) values ('"+as.getCodigo_emp()+"','"+as.getNombre()+"')");
			//codigo para pruevas, susceptible de ser borrado.  connManager.updateDB("insert into VISITA (ID_VISITA, FECHA, INMUEBLE, CLIENTE, ASESOR) values ('"+(new String("2542896"))+"','"+(new String("20-5-2014"))+"','"+(new String("waka"))+"','"+(new String("5454448G"))+"','"+(new String("65656562"))+"')");
			  connManager.close();
		  }
		  catch (Exception e){
			  throw new DAOExcepcion(e);
		  }
	  }

	  public Asesor encontrarAsesorPorCod(String cod)throws DAOExcepcion{
		  try{
			  connManager.connect();
			  ResultSet rs=connManager.queryDB("select NOMBRE from ASESOR where CODIGO_EMPLEADO= '"+cod+"'");
			  connManager.close();
			  if (rs.next())
				  return new Asesor(cod,rs.getString("NOMBRE"));
			  else
				  return null;				
		  }
		  catch (SQLException e){
			  throw new DAOExcepcion(e);
		  }
	  }
	 
	  public ArrayList<Asesor> encontrarAsesores() throws DAOExcepcion{
		  try{
			  ArrayList<Asesor> asesores = new ArrayList<Asesor>();
			  connManager.connect();
			  ResultSet rs = connManager.queryDB("select * from ASESOR");
			  connManager.close();
			  while(rs.next()){
				  asesores.add(new Asesor(rs.getString("CODIGO_EMPLEADO"),rs.getString("NOMBRE")));
			  }
			  return asesores;
		  }
		  catch (SQLException e){
			  throw new DAOExcepcion(e);
		  }
	  }
}
