package controller;
import model.LoginModel;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class LoginController implements ActionListener {
    private LoginModel model;
    private LoginView view;
    public LoginController(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void setModel(LoginModel model){
        this.model = model;
    }
    public void setView(LoginView view){
        this.view = view;
    }
}
