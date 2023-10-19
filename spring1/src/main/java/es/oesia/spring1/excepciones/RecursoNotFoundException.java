package es.oesia.spring1.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = " la persona no ha sido encontrada")
public class RecursoNotFoundException extends RuntimeException{

	public RecursoNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecursoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RecursoNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RecursoNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RecursoNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
