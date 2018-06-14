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
