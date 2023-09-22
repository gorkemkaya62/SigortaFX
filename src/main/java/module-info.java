module com.example.sigortafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.sigortafx to javafx.fxml;
    exports com.example.sigortafx;
    exports com.example.sigortafx.Controllers;
    opens com.example.sigortafx.Controllers to javafx.fxml;
}