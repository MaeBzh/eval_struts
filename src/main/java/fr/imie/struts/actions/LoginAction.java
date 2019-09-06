package fr.imie.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.struts.javaBeans.User;
import fr.imie.struts.repositories.UserRepository;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private String email;
    private String password;
    private Map<String, Object> session;
    private HttpServletRequest request;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public LoginAction() {
    }

    public String login() throws Exception {
        String result = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(this.email, this.password)) {
            try {
                UserRepository userRepository = new UserRepository();
                User connectedUser = userRepository.getWithEmail(this.email, this.password);
                this.session.put("user", connectedUser);
                result = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                result = ActionSupport.ERROR;
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return result;
    }

    public String logout() {
        this.session.remove("user");
        this.request.getSession().invalidate();
        return ActionSupport.SUCCESS;
    }


    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
