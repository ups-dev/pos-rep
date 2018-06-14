package ec.edu.ups.pos.rep.view.handler;

import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author Wilber Saca
 */
public class RepExceptionHandlerFactory extends ExceptionHandlerFactory {

    private final javax.faces.context.ExceptionHandlerFactory parent;

    public RepExceptionHandlerFactory(final javax.faces.context.ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public RepExceptionHandler getExceptionHandler() {
        return new RepExceptionHandler(this.parent.getExceptionHandler());
    }
}
