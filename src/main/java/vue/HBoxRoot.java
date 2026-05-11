package vue;

import javafx.scene.layout.HBox;

public class HBoxRoot extends HBox {
    public HBoxRoot() {
        this.getChildren().addAll(new VBoxCalendrier(), new GridPaneFormulaireReservation());

    }
}
