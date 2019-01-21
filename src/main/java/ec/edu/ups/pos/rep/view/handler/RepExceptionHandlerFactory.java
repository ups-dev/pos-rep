package ec.edu.ups.pos.rep.view.handler;

import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author Wilber Saca
 */
public class RepExceptionHandlerFactory extends ExceptionHandlerFactory {

    public RepExceptionHandlerFactory(final javax.faces.context.ExceptionHandlerFactory parent) {
        super(parent);
    }

    @Override
    public RepExceptionHandler getExceptionHandler() {
        return new RepExceptionHandler(getWrapped().getExceptionHandler());
    }
}
