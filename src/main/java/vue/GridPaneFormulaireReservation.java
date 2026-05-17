package vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modele.Date;
import modele.DateCalendrier;

public class GridPaneFormulaireReservation extends GridPane {
    private final int heureDebutDefault = 7;
    private final int heureFinDefault = 18;
    private final int minutesDefault = 0;
    private Label dateSelect;
    private Button buttonEnregistrer;
    private Button buttonAnnuler;
    private TextField coursTextF ;
    private ComboBox<Integer> heuresDebut;
    private ComboBox<Integer> minutesDebut;
    private ComboBox<Integer> heuresFin;
    private ComboBox<Integer> minutesFin;

    public void initialisation(){
        Date today = new DateCalendrier();
        setPadding(new Insets(55,10,0,50));
        setHgap(15);
        setVgap(15);

        dateSelect = new Label(today.toString()); dateSelect.setId("dateSelect");
        dateSelect.setUserData(today);
        HBox dateSelectHBox = new HBox(dateSelect);
        dateSelectHBox.setAlignment(Pos.CENTER);
        dateSelectHBox.setPadding(new Insets(10, 0, 10, 0));
        dateSelectHBox.setSpacing(25);
        dateSelectHBox.setId("dateSelectHBox");

        add(dateSelectHBox,0,0,6,1);


        //Label du Cours et le champ d'entrée
        Label coursLabel = new Label("_Cours"); coursLabel.setId("labelCours");
        coursTextF = new TextField();

        coursLabel.setLabelFor(coursTextF); // associer le label au TF
        coursLabel.setMnemonicParsing(true);

        Platform.runLater(()-> coursTextF.requestFocus());

        add(coursLabel,0,1);
        add(coursTextF,1,1,5,1);

        Label horaireLabel = new Label("Horaire"); horaireLabel.setId("labelHoraire");
        add(horaireLabel,0,2); add(new Label("de"),1,2); add (new Label("à"),1,3);

        heuresDebut = new ComboBox<>(); heuresDebut.setValue(heureDebutDefault);
        minutesDebut = new ComboBox<>(); minutesDebut.setValue(minutesDefault);

        heuresFin = new ComboBox<>(); heuresFin.setValue(heureFinDefault);
        minutesFin = new ComboBox<>(); minutesFin.setValue(minutesDefault);

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

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setSpacing(25);
        buttonHBox.setPadding(new Insets(10, 0, 10, 0));

        buttonEnregistrer = new Button("_Enregistrer"); buttonEnregistrer.setAccessibleText("buttonEnregistrer");
        buttonEnregistrer.setMnemonicParsing(true);
        buttonAnnuler = new Button("_Annuler"); buttonAnnuler.setAccessibleText("buttonAnnuler");
        buttonAnnuler.setMnemonicParsing(true);

        buttonEnregistrer.setOnAction(HBoxRoot.getControleur());
        buttonAnnuler.setOnAction(HBoxRoot.getControleur());

        buttonHBox.getChildren().addAll(buttonEnregistrer,buttonAnnuler);

        add(buttonHBox,0,4,6,1);
    }

    public Label getDateSelect() {
        return dateSelect;
    }
    public int getHeureDebutDefault() {
        return heureDebutDefault;
    }
    public int getHeureFinDefault() {
        return heureFinDefault;
    }
    public int getMinutesDefault() {
        return minutesDefault;
    }
    public TextField getCoursTextF() {
        return coursTextF;
    }
    public ComboBox<Integer> getHeuresDebut() {
        return heuresDebut;
    }
    public ComboBox<Integer> getMinutesDebut() {
        return minutesDebut;
    }
    public ComboBox<Integer> getHeuresFin() {
        return heuresFin;
    }
    public ComboBox<Integer> getMinutesFin() {
        return minutesFin;
    }
    public Button getButtonEnregistrer() {
        return buttonEnregistrer;
    }
    public Button getButtonAnnuler() {
        return buttonAnnuler;
    }

    public GridPaneFormulaireReservation() {
        setGridLinesVisible(false);

        initialisation();

    }
}
