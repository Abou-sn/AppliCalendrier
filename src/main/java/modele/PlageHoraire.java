package modele;

public class PlageHoraire implements Comparable<PlageHoraire>{
    private final static int DUREE_MIN = 30;
    private Horaire chDebut;
    private Horaire chFin;

    /**
     *
     * @param parDebut
     * @param parFin
     */
    public PlageHoraire(Horaire parDebut, Horaire parFin) {
        chDebut = parDebut;
        chFin = parFin;
    }

     /**
     * Regarde si la plage horarire est valide
     * @return un Booléen
     */
    public boolean estValide() {
        int heureDebut = chDebut.toMinutes();
        int heureFin = chFin.toMinutes();

        return heureFin-heureDebut >= DUREE_MIN;
    }

    /**
     * Calcule la durée de la plage horarire en minutes
     *
     * @return Int
     */
    public int duree() {
        return chFin.toMinutes() - chDebut.toMinutes();
    }

    /**
     * Vérifie si les plage horarire sont avant ou après
     * @param parPlage
     * @return INT
     */
    public int compareTo(PlageHoraire parPlage) {
        if (this.duree() < parPlage.duree()) return -1;
        else if (this.duree() > parPlage.duree()) return 1;
        else return 0;
    }


    public String toString() {
        return chDebut + " - " + chFin + " durée : "+ this.duree()/60+"h" + this.duree()%60 + " minutes";
    }

}

