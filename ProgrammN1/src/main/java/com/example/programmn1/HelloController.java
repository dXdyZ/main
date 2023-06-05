package com.example.programmn1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button inLoginButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passText;

    @FXML
    void initialize() {
        inLoginButton.setOnAction(actionEvent -> {
            //удаляем лишние пробелы и т.д
            String login = loginText.getText().trim();
            String pass = passText.getText().trim();

            //проверка на пустату
            if (!login.equals("") && !pass.equals(""))
                logitUser(login, pass);
            else
                System.out.println("Error");

            // что будет происходить при нажатии на кнопку зарегаться
            inLoginButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ilLogin.fxml"));
            try {
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //ждать пока окно отабразится
            stage.showAndWait();


        } );

        // что будет происходить при нажатии на кнопку зарегаться
        loginButton.setOnAction(actionEvent -> {
            loginButton.getScene().getWindow().hide(); // прячем окно

            // открываем нужное окно
            FXMLLoader loader  = new FXMLLoader();
            // место где находится файл
            loader.setLocation(getClass().getResource("singUp.fxml"));

            //загрузка файла
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //ждать пока окно отабразится
            stage.showAndWait();
        });
    }

    private void logitUser(String login, String pass) {
    }

}
