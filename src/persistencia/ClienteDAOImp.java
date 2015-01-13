package persistencia;

import java.sql.*;
import java.util.ArrayList;

import logica.Cliente;
import excepciones.DAOExcepcion;

public class ClienteDAOImp implements IClienteDAO{

	protected ConnectionManager connManager;
	
	   public ClienteDAOImp() throws DAOExcepcion {
			super();
			// TODO Auto-generated constructor stub
			try{
			connManager= new ConnectionManager("practica4");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion(e);
			}
		}

	  public void crearCliente(Cliente cl) throws DAOExcepcion {
			// TODO Auto-generated method stub
					
	  try{
		connManager.connect();
	
		connManager.updateDB("insert into CLIENTE (NIF_CLIENTE, NOMBRE, APELLIDOS) values ('"+cl.getNifCliente()+"','"+cl.getNombre()+"','"+cl.getApellidos()+"')");

		connManager.close();
		} catch (Exception e){
				throw new DAOExcepcion(e);
			}
		}

	 public Cliente encontrarClientePorCod(String cod)throws DAOExcepcion{
	  try{
		  connManager.connect();
		  ResultSet rs=connManager.queryDB("select NOMBRE,APELLIDOS from CLIENTE where NIF_CLIENTE= '"+cod+"'");
		  connManager.close();
		  if (rs.next())
			  return new Cliente(cod,rs.getString("NOMBRE"),rs.getString("APELLIDOS"));
		  else
			  return null;
				
		}catch (SQLException e){
					throw new DAOExcepcion(e);
		}
			
	}
	 
	 public ArrayList<Cliente> encontrarClientes() throws DAOExcepcion{
		 try{
			 ArrayList<Cliente> clientes = new ArrayList<Cliente>();
			 connManager.connect();
			 ResultSet rs = connManager.queryDB("select * from CLIENTE");
			 connManager.close();
			 while(rs.next()){
				 clientes.add(new Cliente(rs.getString("NIF_CLIENTE"),rs.getString("NOMBRE"),rs.getString("APELLIDOS")));
			 }
			 return clientes;
		 }
		 catch(SQLException e){
			 throw new DAOExcepcion(e);
		 }
	 }

	
}
