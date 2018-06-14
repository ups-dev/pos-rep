/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.pos.rep.data.exception;

import ec.edu.ups.util.exceptions.UPSDataCreateException;

/**
 *
 * @author ups
 */
public class UPSDataCreateFieldNotExistException extends UPSDataCreateException {

    public UPSDataCreateFieldNotExistException() {
        super("No se ha podido crear el registro, hay campos que ya no existen.");
    }

    public UPSDataCreateFieldNotExistException(String message) {
        super(message);
    }

    public UPSDataCreateFieldNotExistException(Throwable cause) {
        super(cause);
    }
}
