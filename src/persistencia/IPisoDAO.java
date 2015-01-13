package persistencia;
import excepciones.*;
import logica.Piso;
import java.util.List;


public interface IPisoDAO {

	public Piso encontrarPisoPorCod(String cod)throws DAOExcepcion;
	public void crearPiso(Piso p)throws DAOExcepcion;
	public List<Piso> encontrarPisos() throws DAOExcepcion;
}
