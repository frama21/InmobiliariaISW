package persistencia;
import excepciones.*;
import java.util.*;
import logica.Inmueble;

public interface IInmuebleDAO {

	public Inmueble encontrarInmueblePorCod(String cod)throws DAOExcepcion;
	public ArrayList<Inmueble> encontrarInmueblesPorCliente(String cod)throws DAOExcepcion;
	public ArrayList<Inmueble> encontrarInmueblesPorAsesor(String cod)throws DAOExcepcion;
	public void crearInmueble (Inmueble i)throws DAOExcepcion;
	public ArrayList<Inmueble> encontrarInmuebles()throws DAOExcepcion;

}
