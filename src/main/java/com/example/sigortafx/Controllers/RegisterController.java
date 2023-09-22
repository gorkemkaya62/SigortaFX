package com.example.sigortafx.Controllers;

import com.example.sigortafx.Classes.SigortaMain;
import com.example.sigortafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField emailTXT;

    @FXML
    private TextField nameTXT;

    @FXML
    private PasswordField passwordRepeatTXT;

    @FXML
    private PasswordField passwordTXT;

    @FXML
    private Button registerBTN;

    @FXML
    private Label statusTXT;

    @FXML
    private TextField surnameTXT;

    @FXML
    void registerPress(ActionEvent event) {

        try {
            SigortaMain.getInstance().addUser(nameTXT.getText(), surnameTXT.getText(), emailTXT.getText(), passwordTXT.getText(), passwordRepeatTXT.getText());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Parent parent = fxmlLoader.load();
                Scene scene = new Scene(parent,900,600);
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(scene);
                HelloController helloController = fxmlLoader.getController();
                helloController.setStatusTXT("Başarılı bir şekilde kayıt olundu..");
                primaryStage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }catch (RuntimeException e)
        {
            statusTXT.setText(e.getMessage());
        }

    }
    @FXML
    void goBackPress(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent,900,600);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
