package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

/**
 * Description.
 *
 * @author ups .
 */
public class UPSDataEditFieldDeactivatedException extends UPSDataEditException {

	public UPSDataEditFieldDeactivatedException() {
		super("No se ha podido editar el registro, hay campos que han sido anulados.");
	}

	public UPSDataEditFieldDeactivatedException(String message) {
		super(message);
	}

	public UPSDataEditFieldDeactivatedException(Throwable cause) {
		super(cause);
	}

}
