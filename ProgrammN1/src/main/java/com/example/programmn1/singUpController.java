package com.example.programmn1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class singUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passText;

    @FXML
    private Button singUpButton;

    @FXML
    private TextField singUpCountry;

    @FXML
    private TextField singUpLastName;

    @FXML
    private CheckBox singUpMen;

    @FXML
    private TextField singUpName;

    @FXML
    private CheckBox singUpWom;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        singUpButton.setOnAction(actionEvent -> {
            dbHandler.singUpUser(singUpName.getText(), singUpLastName.getText(),
                    loginText.getText(), passText.getText(), singUpCountry.getText(),
                    "Male");
        });
    }

}

