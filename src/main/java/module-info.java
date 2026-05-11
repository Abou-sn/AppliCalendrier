module com.example.applicalendrier {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.example.applicalendrier to javafx.fxml;
    exports vue;
}