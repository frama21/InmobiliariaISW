package excepciones;

@SuppressWarnings("serial")
public class DAOExcepcion extends Exception{

	public DAOExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public DAOExcepcion(Exception e) {
		super(e.getMessage());
		// TODO Auto-generated constructor stub
	}

}
