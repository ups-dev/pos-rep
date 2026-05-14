package ec.edu.ups.pos.rep.view.handler;

import javax.faces.context.ExceptionHandler;

import ec.edu.ups.util.jsf.handlers.UPSExceptionHandler;

public class posRepExceptionHandler extends UPSExceptionHandler {

	public posRepExceptionHandler(ExceptionHandler wrapped) {
		super(wrapped);
	}

	@Override
	public void processErrorException(Throwable t) {
		// Imprimir el error en la consola
		t.printStackTrace(System.err);
	}

}
