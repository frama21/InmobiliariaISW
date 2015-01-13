package persistencia;
import java.util.*;

import logica.Asesor;
import excepciones.DAOExcepcion;

public interface IAsesorDAO {

	public Asesor encontrarAsesorPorCod(String cod)throws DAOExcepcion;
	public void crearAsesor (Asesor a)throws DAOExcepcion;
	public ArrayList<Asesor> encontrarAsesores()throws DAOExcepcion;
	
}
