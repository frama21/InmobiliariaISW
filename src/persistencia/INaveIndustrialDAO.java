package persistencia;

import logica.NaveIndustrial;
import excepciones.DAOExcepcion;

public interface INaveIndustrialDAO {

	public NaveIndustrial encontrarNaveIndustrialPorCod(String cod)throws DAOExcepcion;
	public void crearNaveIndustrial (NaveIndustrial ni)throws DAOExcepcion;
	
}
