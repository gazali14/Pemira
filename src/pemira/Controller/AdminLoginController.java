/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pemira.Controller;

/**
 *
 * @author U53R
 */
import Pemira.View.AdminOptions;
import Pemira.View.Adminlogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pemira.Model.AdminLoginModel;

public class AdminLoginController {
    private AdminLoginModel model;
    private Adminlogin view;

    public AdminLoginController(Adminlogin view) {
        this.model = new AdminLoginModel();
        this.view = view;
    }

    public void authenticate() {
        String username = view.getUsername();
        String password = view.getPassword();

        if (model.authenticate(username, password)) {
            view.showMessage("Login Successful!");
            new AdminOptions().setVisible(true); // Assuming AdminOptions is another JFrame
            view.setVisible(false);
        } else {
            view.showMessage("Login Failed!");
            view.clearFields();
        }
    }
}
