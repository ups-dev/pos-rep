package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

/**
 * Description.
 *
 * @author ups .
 */
public class UPSDataEditRemovedException extends UPSDataEditException {

	public UPSDataEditRemovedException() {
		super("No se ha podido editar el registro, ha sido eliminado.");
	}

	public UPSDataEditRemovedException(String message) {
		super(message);
	}

	public UPSDataEditRemovedException(Throwable cause) {
		super(cause);
	}

}
