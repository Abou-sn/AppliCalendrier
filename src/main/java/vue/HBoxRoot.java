package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import modele.PlanningCollections;

public class HBoxRoot extends HBox {
    private static PlanningCollections planning;
    private static Controleur controleur;
    private static VBoxCalendrier calendrierPane;
    private static GridPaneFormulaireReservation reservationPane;

    public HBoxRoot() {

        planning = new PlanningCollections();
        controleur = new Controleur();
        calendrierPane = new VBoxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();
        getChildren().addAll(calendrierPane,reservationPane);

    }

    public PlanningCollections getPlanning() {
        return planning;
    }
    public Controleur getControleur() {
        return controleur;
    }
    public VBoxCalendrier getCalendrierPane() {
        return calendrierPane;
    }
    public GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }
}