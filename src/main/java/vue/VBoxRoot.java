package vue;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;
import javafx.scene.control.Label;

public class VBoxRoot extends VBox {

    public VBoxRoot() {
        DateCalendrier today = new DateCalendrier();
        int month = today.getMois();
        int year = today.getAnnee();
        CalendrierDuMois monthCalendar = new CalendrierDuMois(month, year);

        Label titleLabel = new Label(ConstantesCalendrier.Mois.values()[month-1] + " " + year);
        VBox.setMargin(titleLabel, new Insets(14));
        this.getChildren().add(titleLabel);


        StackPane monthStackPane = new StackPane();
        VBox.setMargin(monthStackPane, new Insets(4));
        this.getChildren().add(monthStackPane);

        for (DateCalendrier date : monthCalendar.getDates()) {
            VBox datesBox = new VBox();

            Label dateLabel = new Label(date.toString());
            VBox.setMargin(dateLabel, new Insets(8));
            datesBox.getChildren().add(dateLabel);
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(datesBox);
            monthStackPane.getChildren().add(scrollPane);

            // ajout des attributs id pour la feuille de style
            if (date.getMois() != month) {
                dateLabel.setId("dateOutOfMonth");
            }
            if (date.compareTo(today) == 0) {
                dateLabel.setId("today");
            }
        }
    }
}

