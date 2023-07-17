module com.example.module_9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.module_9 to javafx.fxml;
    exports com.example.module_9;
    exports com.example.module_9.controlles;
    opens com.example.module_9.controlles to javafx.fxml;
    exports com.example.module_9.model;
    opens com.example.module_9.model to javafx.fxml;
}