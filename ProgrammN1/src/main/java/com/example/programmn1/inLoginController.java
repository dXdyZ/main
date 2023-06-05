package com.example.programmn1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class inLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button unloginButton;

    @FXML
    void initialize() {
        unloginButton.setOnAction(actionEvent -> {
            unloginButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));

            try {
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }

            Parent rootUn = loader.getRoot();
            Stage stageUn = new Stage();
            stageUn.setScene(new Scene(rootUn));
            stageUn.showAndWait();
        });

    }
}


