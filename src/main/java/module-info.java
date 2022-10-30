module com.example.softdart {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.softdart to javafx.fxml;
    exports com.example.softdart;
}