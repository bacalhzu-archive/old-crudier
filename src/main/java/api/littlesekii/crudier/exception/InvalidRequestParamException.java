package api.littlesekii.crudier.exception;

public class InvalidRequestParamException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidRequestParamException(String msg) {
		super(msg);
	}
}
