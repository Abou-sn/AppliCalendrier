package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class AppliCalendrier extends Application {

    @Override
    public void start(Stage stage) {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root,1200,800);
        File [] fichierscss = new File("css").listFiles();
        for(File f : fichierscss) scene.getStylesheets().add(f.toURI().toString());
        stage.setScene(scene);
        stage.setTitle("AppliCalendrier");
        stage.show();





    }

    public static void main(String[] args) {
        Application.launch();
    }
}
