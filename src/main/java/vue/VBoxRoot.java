package vue;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.DateCalendrier;
import javafx.scene.control.Label;

public class VBoxRoot extends VBox {

    public VBoxRoot() {
        int mois = 3;
        int annee = 2026;

        Label dateLabel = new Label("Mois : "+"Mars" + " Annee : "+annee);
        this.getChildren().add(dateLabel);

        CalendrierDuMois cal = new CalendrierDuMois (mois,annee);
        VBox vbox = new VBox();
        for (DateCalendrier d : cal.getDates()){
            Label date = new Label(d.toString());
            vbox.getChildren().add(date);

        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);

        this.getChildren().add(scrollPane);




    }
    }

