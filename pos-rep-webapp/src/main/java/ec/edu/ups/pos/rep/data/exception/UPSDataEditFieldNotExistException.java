/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

/**
 * Description.
 *
 * @author ups .
 */
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
