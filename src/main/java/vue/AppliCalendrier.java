package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppliCalendrier extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root,300,80);
        stage.setScene(scene);
        stage.setTitle("AppliCalendrier");
        stage.show();


    }

    public static void main(String[] args) {
        Application.launch();
    }
}
