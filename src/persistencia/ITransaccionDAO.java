package persistencia;

import java.util.ArrayList;

import logica.*;
import excepciones.*;

public interface ITransaccionDAO {
	
	public void crearTransaccion(Transaccion t, String id)throws DAOExcepcion;
	public boolean comprobarOfertaTransaccion(String oferta)throws DAOExcepcion;
	public ArrayList<Transaccion> encontrarTransacciones()throws DAOExcepcion;

}
