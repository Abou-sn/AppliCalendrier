package vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;
import javafx.scene.control.Label;

import java.util.List;

public class VBoxRoot extends VBox {

    public VBoxRoot() {
        DateCalendrier today = new DateCalendrier();

        StackPane monthsStackPane = new StackPane();
        for (int month = 1; month <= 12; month++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(month,today.getAnnee());
            ScrollPane monthScroll = new ScrollPane();
            VBox datesBox = new VBox();

            monthScroll.setContent(datesBox);
            monthScroll.setAccessibleText(ConstantesCalendrier.Mois.values()[month-1].toString());

            for (DateCalendrier date : monthCalendar.getDates()) {
                Label dateLabel = new Label(date.toString());
                datesBox.getChildren().add(dateLabel); // Ajouter à la Vbox courante locale, les dates du mois.
                if (date.getMois() != month) {
                    dateLabel.setId("dateOutOfMonth");
                }
                if (date.compareTo(today) == 0) {
                    dateLabel.setId("today");
                }

            }
            monthsStackPane.getChildren().add(monthScroll);


        }

        List<Node> listScrolls = monthsStackPane.getChildren();
        while (listScrolls.get(0).getAccessibleText().compareTo(ConstantesCalendrier.Mois.values()[today.getMois()].toString()) !=0) {
            listScrolls.get(0).toFront();

        }

        this.getChildren().add(monthsStackPane);

    }
}

