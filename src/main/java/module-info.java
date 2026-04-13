module com.example.applicalendrier {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.applicalendrier to javafx.fxml;
    exports vue;
}