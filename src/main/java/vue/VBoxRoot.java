package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;
import javafx.scene.control.Label;

import java.util.List;

public class VBoxRoot extends VBox {

    public VBoxRoot() {
        Date today = new DateCalendrier();

        StackPane monthStackPane = new StackPane();

        ToggleGroup buttonGroup = new ToggleGroup();

        for (int monthIndex = 1; monthIndex<=12 ; monthIndex++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(monthIndex, today.getAnnee());

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);

            tilePane.setPrefRows(monthCalendar.getDates().size()/7+1);

            tilePane.setId("opaque");

            for (ConstantesCalendrier.Jours jour : ConstantesCalendrier.Jours.values()){
                Label dayLabel = new Label(jour.toString().substring(0,2));
                tilePane.getChildren().add(dayLabel);
            }

            for (DateCalendrier date : monthCalendar.getDates()){
                ToggleButton dateButton = new ToggleButton(Integer.toString(date.getJour()));

                dateButton.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(dateButton);

                dateButton.setUserData(date);
                dateButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("Date selectionné : "+dateButton.getUserData());
                    }
                });

                if (date.getMois() != monthCalendar.getMois()){
                    dateButton.setId("dateOutOfMonth");
                }
                if (date.compareTo(today)==0) dateButton.setId("today");
            }

            tilePane.setAccessibleText(ConstantesCalendrier.Mois.values()[monthIndex-1].toString());
            monthStackPane.getChildren().add(tilePane);
        }

        this.getChildren().add(monthStackPane);
    }


}