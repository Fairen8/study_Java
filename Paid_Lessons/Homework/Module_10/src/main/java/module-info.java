module com.example.module_10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.module_10 to javafx.fxml;
    exports com.example.module_10;
    exports com.example.module_10.controlles;
    opens com.example.module_10.controlles to javafx.fxml;
    exports com.example.module_10.model;
    opens com.example.module_10.model to javafx.fxml;
}