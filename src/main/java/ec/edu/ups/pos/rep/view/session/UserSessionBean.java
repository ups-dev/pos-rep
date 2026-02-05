package ec.edu.ups.pos.rep.view.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.jsf.security.ups.context.SecurityRequestContext;
import ec.edu.ups.jsf.security.ups.util.SecurityUtils;
import ec.edu.ups.jsf.security.ups.web.session.UserInfo;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {

	public UserInfo getUserInfo() {
		return SecurityRequestContext.getCurrentInstance().getUserSession().getUserInfo();
	}

	public void logout() {
		SecurityUtils.logout();
	}

}
