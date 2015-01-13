package persistencia;

import logica.Cliente;
import java.util.*;
import excepciones.*;

public interface IClienteDAO {

	public Cliente encontrarClientePorCod(String cod)throws DAOExcepcion;
	public void crearCliente (Cliente c)throws DAOExcepcion;
	public ArrayList<Cliente> encontrarClientes() throws DAOExcepcion;
	
}
