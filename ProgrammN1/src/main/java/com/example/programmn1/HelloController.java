package com.example.programmn1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.programmn1.animations.Shake;
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
        } );

        // что будет происходить при нажатии на кнопку зарегаться

        loginButton.setOnAction(actionEvent -> {
            openNewScene("singUp.fxml");
        });
    }



    // Авторизация
    private void logitUser(String login, String pass) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(login);
        user.setPassword(pass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        // проходим все пользователей которые были возвращены с помощью getUser
        // next - позволяет пройти по все пользовательм и посчитать сколько их есть
        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }

        // если так то есть пользователь
        if (counter >= 1) {
            openNewScene("ilLogin.fxml");
        }
        else {
            Shake userLoginAnim = new Shake(loginText);
            Shake passLoginAnim = new Shake(passText);
            userLoginAnim.playAnim();
            passLoginAnim.playAnim();
        }
    }

    //Открытие  нового окна
    public void openNewScene(String window){
        loginButton.getScene().getWindow().hide(); // прячем окно

        // открываем нужное окно
        FXMLLoader loader  = new FXMLLoader();
        // место где находится файл
        loader.setLocation(getClass().getResource(window));

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
    }
}
