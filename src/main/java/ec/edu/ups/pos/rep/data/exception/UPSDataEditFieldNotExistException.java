package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

public class UPSDataEditFieldNotExistException extends UPSDataEditException {

	public UPSDataEditFieldNotExistException() {
		super("No se ha podido editar el registro, hay campos que ya no existen.");
	}

	public UPSDataEditFieldNotExistException(String message) {
		super(message);
	}

	public UPSDataEditFieldNotExistException(Throwable cause) {
		super(cause);
	}

}
