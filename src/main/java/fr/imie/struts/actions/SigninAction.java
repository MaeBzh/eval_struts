package fr.imie.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.struts.javaBeans.User;
import fr.imie.struts.repositories.UserRepository;
import javassist.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class SigninAction extends ActionSupport implements SessionAware{

    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;
    private Map<String, Object> session;

    public SigninAction() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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


    public String signin() throws Exception {
        String result = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(this.firstname, this.lastname, this.address, this.email, this.password)) {
            try {
                UserRepository userRepository = new UserRepository();
                User user = new User();
                user.setFirstname(this.firstname);
                user.setLastname(this.lastname);
                user.setAddress(this.address);
                user.setEmail(this.email);
                user.setPassword(this.password);
                user.setAdmin(false);
                userRepository.create(user);
                this.session.put("user", user);
                result = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                result = ActionSupport.ERROR;
                this.addActionError("Une erreur est survenue !");
            }
        }
        return result;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
