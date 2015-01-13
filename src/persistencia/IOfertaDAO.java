package persistencia;

import logica.*;

import java.util.*;

import excepciones.*;

public interface IOfertaDAO {
	public void crearOferta(Oferta o)throws DAOExcepcion;
	public ArrayList<Oferta> encontrarOfertaPorVisita(String cod)throws DAOExcepcion;
	public Oferta encontrarOfertaPorCod(String cod)throws DAOExcepcion;
}
