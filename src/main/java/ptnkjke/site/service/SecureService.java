package ptnkjke.site.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Lopatin on 12.06.2014.
 */
@Service
public class SecureService {

    private String testingPassword = "admin", testingLogin = "admin";

    public boolean isAuth(HttpSession session) {
        return session.getAttribute("auth") != null;
    }

    public boolean auth(String login, String password, HttpSession session) {
        if (login.equals(testingLogin) && password.equals(testingPassword)) {
            session.setAttribute("auth", "auth");
            return true;
        }

        return false;
    }
}
