package vue;

import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import javafx.scene.control.Label;

public class VBoxRoot extends VBox {

    public VBoxRoot() {
        DateCalendrier d1 = new DateCalendrier();
        DateCalendrier d2 = d1.dateDuLendemain();

        Label l1 = new Label(d1.toString());
        Label l2 = new Label(d2.toString());

        this.getChildren().addAll(l1,l2);
    }
    }

