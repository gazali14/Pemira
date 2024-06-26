package pemira.Controller;

/**
 *
 * @author Gazali
 */

import Pemira.View.UserLogin;
import Pemira.View.VoterOptions;
import pemira.Model.UserLoginModel;
import java.sql.SQLException;

public class UserLoginController {
    private UserLoginModel model;
    private UserLogin view;

    public UserLoginController(UserLogin view) {
        this.model = new UserLoginModel();
        this.view = view;
    }

    public void authenticate() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (model.authenticate(username, password)) {
            view.showMessage("Login berhasil!");
            new VoterOptions(username).setVisible(true);
            view.setVisible(false);
        } else {
            view.showMessage("Login Gagal! Username atau password salah");
            view.clearFields();
        }
    }
}