module com.example.module_8 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.module_8 to javafx.fxml;
    exports com.example.module_8;
}