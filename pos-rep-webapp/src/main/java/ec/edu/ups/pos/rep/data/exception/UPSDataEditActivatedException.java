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
