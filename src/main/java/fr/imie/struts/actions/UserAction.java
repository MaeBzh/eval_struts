package fr.imie.struts.actions;

import com.opensymphony.xwork2.ActionSupport;
import fr.imie.struts.javaBeans.User;
import fr.imie.struts.repositories.UserRepository;
import org.apache.struts2.interceptor.SessionAware;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserAction extends ActionSupport {

    private User user;
    private List<User> usersList = new ArrayList<User>();

    public UserAction() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Display user details
     *
     * @param userId the id of the user we want to display details
     * @return success if user found, else error
     * @throws Exception
     */
    public String getClientDetails(@NotNull int userId) throws Exception {
        String result;
        UserRepository userRepository = new UserRepository();
        this.user = userRepository.get(userId);
        if (this.user != null) {
            result = ActionSupport.SUCCESS;
        } else {
            result = ActionSupport.ERROR;
        }

        return result;
    }

    /**
     * Display the list of users
     *
     * @return success if users' list found, else error
     * @throws Exception
     */
    public String getUsersList() throws Exception {
        String result;
        UserRepository userRepository = new UserRepository();
        this.usersList = userRepository.getAll();
        if (this.usersList != null) {
            result = ActionSupport.SUCCESS;
        } else {
            result = ActionSupport.ERROR;
        }
        return result;
    }
}
