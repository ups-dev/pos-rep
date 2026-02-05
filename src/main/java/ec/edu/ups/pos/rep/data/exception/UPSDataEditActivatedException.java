package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

public class UPSDataEditActivatedException extends UPSDataEditException {

	public UPSDataEditActivatedException() {
		super("No se ha podido editar el registro, se encuentra activado.");
	}

	public UPSDataEditActivatedException(String message) {
		super(message);
	}

	public UPSDataEditActivatedException(Throwable cause) {
		super(cause);
	}

}
