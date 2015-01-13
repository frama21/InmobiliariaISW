package persistencia;

import logica.*;
import java.util.*;
import excepciones.*;

public interface IVisitaDAO {
	
	public Visita encontrarVisitaPorCod(String cod)throws DAOExcepcion;
	public ArrayList<Visita> encontrarVisitasPorInmueble(String cod)throws DAOExcepcion;
	public ArrayList<Visita> encontrarVisitasPorAsesor(String asesor)throws DAOExcepcion;
	public void crearVisita(Visita v)throws DAOExcepcion;
	
}
