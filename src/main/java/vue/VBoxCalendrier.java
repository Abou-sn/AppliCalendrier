package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;
import javafx.scene.control.Label;

import javax.swing.*;

import java.util.List;

public class VBoxCalendrier extends VBox {

    public VBoxCalendrier() {
        Date today = new DateCalendrier();

        StackPane monthStackPane = new StackPane();

        ToggleGroup buttonGroup = new ToggleGroup();

        for (int monthIndex = 1; monthIndex<=12 ; monthIndex++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(monthIndex, today.getAnnee());

            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setHgap(10);

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
        List <Node> listeMois = monthStackPane.getChildren();
        String moisCourant = ConstantesCalendrier.Mois.values()[today.getMois()-1].toString();
        while (!listeMois.getLast().getAccessibleText().equals(moisCourant)) {
            listeMois.get(0).toFront();
        } // Affichage du mois courant

        Button firstButton = new Button("<<");
        Button lastButton = new Button(">>");
        Button prevButton = new Button("<");
        Button nextButton = new Button(">");

        nextButton.setId("nextButton"); prevButton.setId("prevButton");
        prevButton.setOnAction(event -> {
            System.out.println("Mois précédent");
            List<Node> liste = monthStackPane.getChildren();
            liste.get(liste.size()-1).toBack();
        });

        nextButton.setOnAction(event -> {
            System.out.println("Mois suivant");
            List<Node> liste = monthStackPane.getChildren();
            liste.get(0).toFront();
        });

        HBox buttonHBox = new HBox();
        buttonHBox.setSpacing(25);
        buttonHBox.getChildren().addAll(firstButton,prevButton, nextButton,lastButton);
        buttonHBox.setId("buttonHBox");

        this.getChildren().add(monthStackPane);
        this.getChildren().add(buttonHBox);

    }


}