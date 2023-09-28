package api.littlesekii.crudier.exception;

public class DatabaseEntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DatabaseEntityNotFoundException(String message) {
		super(message);
	}

}
