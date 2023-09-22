package com.example.sigortafx;

import com.example.sigortafx.Abstarcts.Person;
import com.example.sigortafx.Abstarcts.Sigorta;
import com.example.sigortafx.Classes.Customer.Customers;
import com.example.sigortafx.Classes.SigortaMain;
import com.example.sigortafx.Classes.Sigortas.DaskSigorta;
import com.example.sigortafx.Classes.Sigortas.TrafikSigorta;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Ada Yazılım!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        SigortaMain.getInstance().readSigortasFromFile();
        SigortaMain.getInstance().readUsersFromFile();

        launch();
    }

    @Override
    public void stop() throws Exception {
        SigortaMain.getInstance().writeSigortasToFile();
        SigortaMain.getInstance().writeToUsersToFile();
        super.stop();
    }
}


