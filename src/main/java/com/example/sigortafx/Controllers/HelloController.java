package com.example.sigortafx.Controllers;

import com.example.sigortafx.Abstarcts.Person;
import com.example.sigortafx.Classes.SigortaMain;
import com.example.sigortafx.HelloApplication;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField emailTXT;

    @FXML
    private JFXButton loginBTN;

    @FXML
    private PasswordField passwordTXT;

    @FXML
    private JFXButton registerBTN;
    @FXML
    private Label statusTXT;

    @FXML
    void loginPress(ActionEvent event) {
        Optional<Person> person = SigortaMain.getInstance().getPersons().stream().filter(e -> e.getEmail().equals(emailTXT.getText())).findFirst();
        if(person.isPresent())
        {
            Person person1 = person.get();
            if(person1.getTC().equals(passwordTXT.getText()))
            {
                statusTXT.setText("Giriş başarılı");
                SigortaMain.getInstance().setPerson(person1);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerMain.fxml"));
                    Parent parent =  fxmlLoader.load();
                    Scene scene = new Scene(parent, 900,600);
                    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            statusTXT.setText("E mail veya Şifre Hatalı");
        }
    }

    @FXML
    void registerPress(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent,900,600);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void setStatusTXT(String text)
    {
        statusTXT.setText(text);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBTN.setDisable(true);
        if(emailTXT.getText() != null && passwordTXT.getText() != null)
        {
            loginBTN.setDisable(false);
        }
    }
    public void checkAvailable()
    {


    }
}