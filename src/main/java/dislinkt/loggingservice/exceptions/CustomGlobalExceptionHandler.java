package dislinkt.loggingservice.exceptions;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<Object> handleNotFound(HttpServletResponse response) {
		return new ResponseEntity<>("Entity not found.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidToken.class)
	public ResponseEntity<Object> handleInvalidToken(HttpServletResponse response) {
		return new ResponseEntity<>("Invalid token.", HttpStatus.UNAUTHORIZED);
	}
	

}
