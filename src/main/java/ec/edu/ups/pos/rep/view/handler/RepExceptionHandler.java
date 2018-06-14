package ec.edu.ups.pos.rep.view.handler;

import ec.edu.ups.notification.core.DefaultNotification;
import ec.edu.ups.notification.core.Notification;
import ec.edu.ups.notification.core.message.EmailNotificationMessage;
import ec.edu.ups.notification.core.message.builder.MessageBuilder;
import ec.edu.ups.notification.jsf.context.NotificationRequestContext;
import ec.edu.ups.pos.rep.data.utils.EvaRepConstants;
import ec.edu.ups.util.UPSUtils;
import ec.edu.ups.util.jsf.handlers.UPSExceptionHandler;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ProjectStage;
import javax.faces.context.ExceptionHandler;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.omnifaces.util.Faces;

/**
 *
 * @author Wilber Saca
 */
public class RepExceptionHandler extends UPSExceptionHandler {

    public RepExceptionHandler(ExceptionHandler wrapped) {
        super(wrapped);
    }

    @Override
    public void processErrorException(Throwable t) {
        //Enviamos los correos sólo en Producción y Pruebas
        if (!Faces.getContext().isProjectStage(ProjectStage.Development)) {
            try {
                NotificationRequestContext nrc = NotificationRequestContext.getCurrentInstance();

                Notification n = new DefaultNotification();

                EmailNotificationMessage enm = MessageBuilder.createEmail()
                        .setSender(new InternetAddress("notificaciones@ups.edu.ec", EvaRepConstants.APPLICATION_NAME))
                        .addRecipient(Message.RecipientType.TO, EvaRepConstants.EMAIL_TO_ERROR.toArray(new String[EvaRepConstants.EMAIL_TO_ERROR.size()]))
                        .addRecipient(Message.RecipientType.CC, EvaRepConstants.EMAIL_CC_ERROR.toArray(new String[EvaRepConstants.EMAIL_CC_ERROR.size()]))
                        .setSubject("Error - " + EvaRepConstants.APPLICATION_NAME)
                        .setMessage(UPSUtils.decorateEmailErrorMessage(null, UPSUtils.getStackTrace(t)));

                n.addMessage(enm);

                nrc.getNotificationManager().execute(n);

            } catch (UnsupportedEncodingException | AddressException ex) {
                Logger.getLogger(RepExceptionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
