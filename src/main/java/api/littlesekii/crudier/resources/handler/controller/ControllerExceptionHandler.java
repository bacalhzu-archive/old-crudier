package api.littlesekii.crudier.resources.handler.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import api.littlesekii.crudier.exception.DatabaseEntityNotFoundException;
import api.littlesekii.crudier.exception.DatabaseIntegrityViolationException;
import api.littlesekii.crudier.exception.InvalidRequestParamException;
import api.littlesekii.crudier.resources.handler.ResponseError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
//	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//	public ResponseEntity<ResponseError> methodArgumentTypeMismatchException(
//		MethodArgumentTypeMismatchException e, HttpServletRequest req) {
//		ResponseError err = new ResponseError();
//		err.setTimestamp(Instant.now());
//		err.setStatus(HttpStatus.BAD_REQUEST.value());
//		err.setError("ArgumentTypeMismatchException");
//		err.setMessage(e.getMessage());
//		err.setPath(req.getRequestURI());
//		
//		return ResponseEntity.status(err.getStatus()).body(err);
//	}
//	
	
	@ExceptionHandler(DatabaseEntityNotFoundException.class)
	public ResponseEntity<ResponseError> databaseEntityNotFoundException(
			DatabaseEntityNotFoundException e, HttpServletRequest req
	) {
		ResponseError err = new ResponseError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("DatabaseEntityNotFoundException");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(DatabaseIntegrityViolationException.class)
	public ResponseEntity<ResponseError> databaseIntegrityViolationException(
			DatabaseIntegrityViolationException e, HttpServletRequest req
	) {
		ResponseError err = new ResponseError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("DatabaseIntegrityViolationException");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(InvalidRequestParamException.class)
	public ResponseEntity<ResponseError> invalidRequestParamException(
			InvalidRequestParamException e, HttpServletRequest req
	) {
		ResponseError err = new ResponseError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("InvalidRequestParamException");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
}

