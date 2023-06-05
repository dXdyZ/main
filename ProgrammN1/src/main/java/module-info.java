module com.example.programmn1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.programmn1 to javafx.fxml;
    exports com.example.programmn1;
}