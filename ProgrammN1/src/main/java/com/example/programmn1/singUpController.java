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
            singUpNewUser();
        });
    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

            String firstName = singUpName.getText();
            String lastName = singUpLastName.getText();
            String userName = loginText.getText();
            String password = passText.getText();
            String location = singUpCountry.getText();
            String gender = "";

            if (singUpMen.isSelected()) // если он выбран
                gender = "Мужской";
            else
                gender = "Женский";

            User user = new User(firstName, lastName, userName, password,
                    location, gender);

            dbHandler.singUpUser(user);
    }

}

