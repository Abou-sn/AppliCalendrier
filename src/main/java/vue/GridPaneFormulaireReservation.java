package vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GridPaneFormulaireReservation extends GridPane {
    private final int heureDebutDefault = 7;
    private final int heureFinDefault = 18;
    private final int minutesDefault = 0;

    public void initialisation(){
        setPadding(new Insets(55,10,0,50));
        setHgap(15);
        setVgap(15);

        Label dateSelect = new Label("DateSelectionné");
        add(dateSelect,0,0,6,1);


        //Label du Cours et le champ d'entrée
        add(new Label("Cours"),0,1);
        add(new TextField(),1,1,5,1);

        add(new Label("Horaire"),0,2); add(new Label("de"),1,2); add (new Label("à"),1,3);

        ComboBox<Integer> heuresDebut = new ComboBox<>(); heuresDebut.setValue(heureDebutDefault);
        ComboBox<Integer> minutesDebut = new ComboBox<>(); minutesDebut.setValue(minutesDefault);

        ComboBox<Integer> heuresFin = new ComboBox<>(); heuresFin.setValue(heureFinDefault);
        ComboBox<Integer> minutesFin = new ComboBox<>(); minutesFin.setValue(minutesDefault);

        for(int i = heureDebutDefault; i< heureFinDefault +1; i++){
            heuresDebut.getItems().add(i);
            heuresFin.getItems().add(i);
        } // Ajouter les heures dans la liste déroulante des heures

        for (int i = 0; i < 4; i++) {
            int quartDheure = i*15;
            minutesDebut.getItems().add(quartDheure);
            minutesFin.getItems().add(quartDheure);
        }

        add(heuresDebut,2,2); add(new Label("h"),3,2);add(minutesDebut,4,2); add(new Label("min"),5,2); //ajout de la liste des heures début
        add(heuresFin,2,3); add(new Label("h"),3,3);add(minutesFin,4,3);add(new Label("min"),5,3); //Pareil pour heures de fin

    }

    public GridPaneFormulaireReservation() {
        setGridLinesVisible(true);
        initialisation();
    }
}
