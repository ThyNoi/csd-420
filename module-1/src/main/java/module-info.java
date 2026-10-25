module com.example.javafxtester {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.javafxtester to javafx.fxml;
    exports com.example.javafxtester;
}