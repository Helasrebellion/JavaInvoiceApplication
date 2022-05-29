package com.example.javainvoiceapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.action.Action;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Label loginFailMsg;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
     //@FXML
    //private Button loginBtn;
    // @FXML
    // private Button createAcctBtn;

    public void loginBtnOnAction(ActionEvent e) {

        if (usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {

            validateLogin();

        } else {
            loginFailMsg.setText("Please enter username and password.");
        }
    }

    public void validateLogin() {
        sample.DatabaseConnection connectNow = new sample.DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + usernameField.getText() + "' AND password = '" + passwordField.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginFailMsg.setText("Test passed");
                } else {
                    loginFailMsg.setText("Login Attempt Failed");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}