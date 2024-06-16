/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pemira.Controller;

/**
 *
 * @author U53R
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
            new VoterOptions(username).setVisible(true); // Assuming VoterOptions is another JFrame
            view.setVisible(false);
        } else {
            view.showMessage("Login Gagal! Username atau password salah");
            view.clearFields();
        }
    }
}