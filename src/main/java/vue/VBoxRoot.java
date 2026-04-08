package vue;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.Date;
import modele.DateCalendrier;
import javafx.scene.control.Label;

public class VBoxRoot extends VBox {

    public VBoxRoot() {
        int mois = 4 ;
        int annee = 2026;
        DateCalendrier ajd = new DateCalendrier();
        System.out.println(ajd);

        Label dateLabel = new Label("Avril " +annee);
        this.getChildren().add(dateLabel);

        CalendrierDuMois cal = new CalendrierDuMois (mois,annee);
        VBox vbox = new VBox();
        for (DateCalendrier d : cal.getDates()){
            Label date = new Label(d.toString());
            if (d.compareTo(ajd) == 0) {
                date.setId("today");
            }
            vbox.getChildren().add(date);

        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);

        this.getChildren().add(scrollPane);

        VBoxRoot.setMargin(dateLabel,new Insets(15));

    }
    }

