package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import modele.PlanningCollections;
import vue.HBoxRoot;

public class Controleur  implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = new HBoxRoot().getPlanning();
    }
}
