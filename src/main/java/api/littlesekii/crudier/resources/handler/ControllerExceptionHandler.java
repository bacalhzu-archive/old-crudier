package api.littlesekii.crudier.resources.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ResponseError> methodArgumentTypeMismatchException(
		MethodArgumentTypeMismatchException e, HttpServletRequest req) {
		ResponseError err = new ResponseError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("ArgumentTypeMismatchException");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseError> entityNotFoundException(
			EntityNotFoundException e, HttpServletRequest req) {
		ResponseError err = new ResponseError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("EntityNotFoundException");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
}
