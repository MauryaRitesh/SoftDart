module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.Client to javafx.fxml;
    exports com.example.Client;

}