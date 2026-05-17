package modele;

public class Horaire {

    private int heure;
    private int quartHeure;

    public Horaire(int parHeure, int parQuartHeure) {
        heure = parHeure;
        quartHeure = parQuartHeure;
    }

    public int toMinutes() {
        return heure * 60 + quartHeure;
    }

    public int getHeure() {
        return heure;
    }

    public int getQuartHeure() {
        return quartHeure;
    }

    public void setHeure(int parHeure) {
        heure = parHeure;
    }

    public void setQuartHeure(int parQuartHeure) {
        quartHeure = parQuartHeure;
    }

    public String toString() {
        return heure + "h" + quartHeure;
    }
}