package com.example.sigortafx.Controllers;

import com.example.sigortafx.Abstarcts.Sigorta;
import com.example.sigortafx.Classes.Customer.Customers;
import com.example.sigortafx.Classes.SigortaMain;
import com.example.sigortafx.HelloApplication;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerMainController implements Initializable {
    @FXML
    private JFXButton kullanimlarımBTN;

    @FXML
    private JFXListView<Sigorta> listView;

    @FXML
    private JFXButton tumSigortalarBTN;
    @FXML
    private Label userNameTXT;
    @FXML
    private AnchorPane daskPane;
    @FXML
    private RadioButton HayirRadioButon;
    @FXML
    private JFXTextArea adresTXT;
    @FXML
    private JFXButton basvurBTN;
    @FXML
    private RadioButton evetRadioButton;
    @FXML
    private Label sigortaTURTXT;
    @FXML
    private Label teklifTXT;
    @FXML
    private TextField evDegeriTXT;
    @FXML
    private Label hataTXT;
    @FXML
    private AnchorPane trafikPane;
    @FXML
    private DatePicker arabaYil;
    @FXML
    private TextField plateTXT;
    @FXML
    private Label teklifTrafikTXT;
    @FXML
    private Button trafikBasvurBTN;
    @FXML
    private Label guncelTeklifTXT;
    @FXML
    private AnchorPane showUsesPane;
    @FXML
    private TextField ArabaDegeriTXT;
    @FXML
    private JFXListView<Sigorta> listViewUses;
    @FXML
    private Label hataTrafik;
    @FXML
    private Button logoutBTN;

    private boolean isDayanikli;
    private boolean isTheseMyUses;
    private boolean isBiggerThan13;


    @FXML
    void kullanimlarımPress(ActionEvent event) {
        isTheseMyUses = true;
        daskPane.setVisible(false);
        trafikPane.setVisible(false);
        showUsesPane.setVisible(true);
        listView.setVisible(false);
        listViewUses.setVisible(true);
        listViewUses.setItems(SigortaMain.getInstance().getPerson().getSigortas());
    }

    @FXML
    void tumSigortalarPress(ActionEvent event) {
        isTheseMyUses = false;
        listViewUses.setVisible(false);
        showUsesPane.setVisible(false);
        listView.setVisible(true);
        listView.setItems(SigortaMain.getInstance().getSigortas());
    }
    @FXML
    void basvurPress(ActionEvent event) {
        try{

            SigortaMain.getInstance().sigortaBasvurDask((Customers) SigortaMain.getInstance().getPerson(), listView.getSelectionModel().getSelectedItem(), adresTXT.getText(), isDayanikli);
            SigortaMain.getInstance().getPerson().setTeklifDask(Double.parseDouble(teklifTXT.getText()));
            hataTXT.setText("Başarılı");

        }catch (Exception e)
        {
            hataTXT.setText(e.getMessage());
        }
    }
    @FXML
    void trafikBasvurPress(ActionEvent event) {
        try
        {
            SigortaMain.getInstance().sigortaBasvurTrafik((Customers) SigortaMain.getInstance().getPerson(), listView.getSelectionModel().getSelectedItem(), plateTXT.getText(), isBiggerThan13);
            SigortaMain.getInstance().getPerson().setTeklifTrafik(Double.parseDouble(teklifTrafikTXT.getText()));
            hataTrafik.setText("Başarılı");
        }catch (Exception e)
        {
            hataTrafik.setText(e.getMessage());
        }
    }

    @FXML
    void logoutPress(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent, 900,600);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        daskPane.setVisible(false);
        trafikPane.setVisible(false);
        showUsesPane.setVisible(false);
        basvurBTN.setDisable(true);
        listView.setVisible(false);
        listViewUses.setVisible(false);
        trafikBasvurBTN.setDisable(true);
        if(!isTheseMyUses)
        {
            listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sigorta>() {
                @Override
                public void changed(ObservableValue<? extends Sigorta> observableValue, Sigorta sigorta, Sigorta t1) {
                    if(listView.getSelectionModel().getSelectedItem() != null)
                    {
                        String tur = listView.getSelectionModel().getSelectedItem().getTur();
                        if("DASK".equals(tur))
                        {
                            System.out.println(listView.getSelectionModel().getSelectedItem().getTur());
                            daskPane.setVisible(true);
                            trafikPane.setVisible(false);
                            ToggleGroup toggleGroup = new ToggleGroup();
                            HayirRadioButon.setToggleGroup(toggleGroup);
                            evetRadioButton.setToggleGroup(toggleGroup);
                            toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                                basvurBTN.setDisable(false);
                                if (toggleGroup.getSelectedToggle() != HayirRadioButon)
                                {
                                    try {
                                        teklifTXT.setText(Double.toString(listView.getSelectionModel().getSelectedItem().teklifYap(true, Double.parseDouble(evDegeriTXT.getText()))));
                                        isDayanikli = true;
                                    }catch (NumberFormatException e)
                                    {
                                        hataTXT.setText("Ev değeri girilmeli");
                                    }
                                }
                                else if (toggleGroup.getSelectedToggle() != evetRadioButton)
                                {
                                    try {
                                        teklifTXT.setText(Double.toString(listView.getSelectionModel().getSelectedItem().teklifYap(false, Double.parseDouble(evDegeriTXT.getText()))));
                                        isDayanikli = false;
                                    }catch (NumberFormatException e)
                                    {
                                        hataTXT.setText("Ev değeri girilmeli");
                                    }
                                }
                            });
                        }
                        else if("Trafik".equals(tur))
                        {
                            daskPane.setVisible(false);
                            trafikPane.setVisible(true);
                            arabaYil.valueProperty().addListener(new ChangeListener<LocalDate>() {
                                @Override
                                public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                                    trafikBasvurBTN.setDisable(false);
                                    if(SigortaMain.getInstance().yilHesapla(arabaYil.getValue()) < 13)
                                    {
                                        isBiggerThan13 = false;
                                        teklifTrafikTXT.setText(Double.toString(listView.getSelectionModel().getSelectedItem().teklifYap(false,Double.parseDouble(ArabaDegeriTXT.getText()))));
                                    }else{
                                        isBiggerThan13 = true;
                                        teklifTrafikTXT.setText(Double.toString(listView.getSelectionModel().getSelectedItem().teklifYap(true,Double.parseDouble(ArabaDegeriTXT.getText()))));
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
                listViewUses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sigorta>() {
                    @Override
                    public void changed(ObservableValue<? extends Sigorta> observableValue, Sigorta sigorta, Sigorta t1) {
                        daskPane.setVisible(false);
                        trafikPane.setVisible(false);
                        String tur = listViewUses.getSelectionModel().getSelectedItem().getTur();
                        System.out.println(tur);
                        if("DASK".equals(tur))
                        {
                            showUsesPane.setVisible(true);
                            guncelTeklifTXT.setText(Double.toString(SigortaMain.getInstance().getPerson().getTeklifDask()));
                        }else if("Trafik".equals(tur))
                        {
                            showUsesPane.setVisible(true);
                            guncelTeklifTXT.setText(Double.toString(SigortaMain.getInstance().getPerson().getTeklifTrafik()));
                        }
                    }
                });




        userNameTXT.setText(SigortaMain.getInstance().getPerson().getName());
    }
}
