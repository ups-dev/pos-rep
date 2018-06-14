package ec.edu.ups.pos.rep.bean.validator.ins;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ups
 */
@FacesValidator("cedulaValidator")
public class ValidationBeanCedula implements Validator {

    String tipoDocumento;
    boolean cedulaCorrecta = false;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Object param = uic.getAttributes().get("tipoDocumento");
        Object validaNulo = uic.getAttributes().get("validaNulo");
        String cedula = o.toString();
        try {
            if (validaNulo.toString().equals("0") && cedula.equals("")) {
                cedulaCorrecta = true;
            } else {
                if (param.equals("C")) {
                    validarCedula(cedula);
                } else if (param.equals("R") && cedula.length() == 13) {
                    if (cedula.endsWith("001")) {
                        String ruc = cedula.substring(0, 10);
                        validarCedula(ruc);
                    }
                } else {
                    cedulaCorrecta = true;
                }
            }

        } catch (NumberFormatException nfe) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cedula Invalida",
                    cedula + " no es una cedula valida;"));
        } catch (Exception err) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cedula Invalida",
                    cedula + " no es una cedula valida;"));
        }
        if (!cedulaCorrecta) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cedula Invalida",
                    cedula + " no es una cedula valida;"));
        }
        cedulaCorrecta = true;
    }

    public void validarCedula(String cedula) {
        if (cedula.length() == 10) // ConstantesApp.LongitudCedula
        {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito < 6) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = 0;
                int digito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                } else if ((10 - (suma % 10)) == verificador) {
                    cedulaCorrecta = true;
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } else {
            cedulaCorrecta = false;
        }
    }

    public boolean isCedulaCorrecta() {
        return cedulaCorrecta;
    }

    public void setCedulaCorrecta(boolean cedulaCorrecta) {
        this.cedulaCorrecta = cedulaCorrecta;
    }

}
