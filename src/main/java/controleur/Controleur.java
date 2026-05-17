package controleur;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import modele.*;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;

public class Controleur  implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        //la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton button = (ToggleButton) event.getSource();
            DateCalendrier dateSelect = (DateCalendrier) button.getUserData();
            System.out.println("Date selectionnée : " + dateSelect);
            Label labelDateSelect = reservationPane.getDateSelect();
            labelDateSelect.setText(dateSelect.toString());
            labelDateSelect.setUserData(dateSelect);

        }

        if (event.getSource() instanceof Button){
            if ((Button) event.getSource() == reservationPane.getButtonEnregistrer()){
                System.out.println("Enregistrement");

                String intitule = reservationPane.getCoursTextF().getText();
                DateCalendrier date = (DateCalendrier) reservationPane.getDateSelect().getUserData();

                Horaire hDebut = new Horaire(reservationPane.getHeuresDebut().getValue(), reservationPane.getMinutesDebut().getValue());
                Horaire hFin = new Horaire(reservationPane.getHeuresFin().getValue(), reservationPane.getMinutesFin().getValue());
                PlageHoraire plageHoraire = new PlageHoraire(hDebut,hFin);

                Reservation res = new Reservation(intitule,date,plageHoraire);
                System.out.println(res);

                try {
                    planning.ajout(res);
                    System.out.println(planning);
                } catch (ExceptionPlanning e) {
                    System.out.println(e.getMessage());
                }

            }

            else if ((Button) event.getSource() == reservationPane.getButtonAnnuler()){
                System.out.println("Annulation");
                TextField tf = reservationPane.getCoursTextF();
                tf.clear();
                Platform.runLater(()-> tf.requestFocus());

                ComboBox<Integer> hd = reservationPane.getHeuresDebut();
                hd.setValue(reservationPane.getHeureDebutDefault());
                ComboBox<Integer> hf = reservationPane.getHeuresFin();
                hf.setValue(reservationPane.getHeureFinDefault());
                ComboBox<Integer> md = reservationPane.getMinutesDebut();
                md.setValue(reservationPane.getMinutesDefault());
                ComboBox<Integer> mf = reservationPane.getMinutesFin();
                mf.setValue(reservationPane.getMinutesDefault());
            }
        }
    }
}
