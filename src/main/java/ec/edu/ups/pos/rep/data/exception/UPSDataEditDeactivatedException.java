package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

/**
 * Description.
 *
 * @author ups .
 */
public class UPSDataEditDeactivatedException extends UPSDataEditException {

	public UPSDataEditDeactivatedException() {
		super("No se ha podido editar el registro, se encuentra desactivado.");
	}

	public UPSDataEditDeactivatedException(String message) {
		super(message);
	}

	public UPSDataEditDeactivatedException(Throwable cause) {
		super(cause);
	}

}
