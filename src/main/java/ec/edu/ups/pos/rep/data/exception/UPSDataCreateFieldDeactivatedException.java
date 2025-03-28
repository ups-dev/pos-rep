package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataCreateException;

/**
 * Description.
 *
 * @author ups .
 */
public class UPSDataCreateFieldDeactivatedException extends UPSDataCreateException {

	public UPSDataCreateFieldDeactivatedException() {
		super("No se ha podido crear el registro, hay campos que han sido anulados.");
	}

	public UPSDataCreateFieldDeactivatedException(String message) {
		super(message);
	}

	public UPSDataCreateFieldDeactivatedException(Throwable cause) {
		super(cause);
	}

}
