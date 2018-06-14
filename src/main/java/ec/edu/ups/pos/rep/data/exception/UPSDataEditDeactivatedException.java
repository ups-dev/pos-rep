/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataEditException;

/**
 *
 * @author ups
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
