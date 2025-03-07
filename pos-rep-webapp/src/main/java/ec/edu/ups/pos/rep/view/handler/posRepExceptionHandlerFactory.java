package ec.edu.ups.pos.rep.view.handler;

import javax.faces.context.ExceptionHandlerFactory;

public class posRepExceptionHandlerFactory extends ExceptionHandlerFactory {

	public posRepExceptionHandlerFactory(final ExceptionHandlerFactory parent) {
		super(parent);
	}

	@Override
	public posRepExceptionHandler getExceptionHandler() {
		return new posRepExceptionHandler(getWrapped().getExceptionHandler());
	}

}
