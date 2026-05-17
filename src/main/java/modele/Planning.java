package modele;


public class Planning {
    private Reservation[] tabReservations;
    private static final int TAILLE_TAB = 3;

    public Planning(int parTailleTab) {
        tabReservations = new Reservation[parTailleTab];
    }

    /**
     * Vérifie si un tableau de reservations est plein ou non
     * @return Un booleen qui indique si le tableau est plein ou non
     */
    private boolean estPlein(){
        Reservation[] tab = this.tabReservations;

        for (Reservation reservation : tab) {
            if (reservation == null) return false;
        }
        return true ;
    }

    public void ajout(Reservation reservation) throws ExceptionPlanning {
        if (reservation.estValide()) {

            for (Reservation autreReservation  : tabReservations) { // Vérifie que la reservation est compatible avec les autres existante
                if (autreReservation != null) {
                    if (reservation.compareTo(autreReservation) == 0) {
                        throw new ExceptionPlanning(ErreursPlanning.RESERVATION_INCOMPATIBLE);
                    }
                }
            }

            for(int i = 0 ; i< tabReservations.length; i++){
                if (estPlein()) throw new ExceptionPlanning(ErreursPlanning.PLANNING_PLEIN);

                else if (tabReservations[i] == null){
                    tabReservations[i] = reservation;
                    return;
                }


            }
        }

        else throw new ExceptionPlanning(ErreursPlanning.RESERVATION_NON_VALIDE);

    }

    public Reservation getReservation(Date parDate){
        for (Reservation res : tabReservations){
            if (res.getDate().compareTo(parDate) == 0) return res;
        }
        return null;
    }

    public Reservation[] getReservations(Date parDate) {
        int tailleTab = 0;
        for (Reservation res : tabReservations){
            if (res.getDate().compareTo(parDate) == 0) tailleTab++;
        }

        Reservation[] tab = new Reservation[tailleTab];
        int i = 0;
        for (Reservation res : tabReservations){
            if (res.getDate().compareTo(parDate) == 0) tab[i++] = res;
        }
        return tab;

    }

    public int plusAncienneReservation(int parDebut, int parFin) {

        int indicePlusPetit = parDebut;
        Reservation plusAncienne = tabReservations[parDebut];

        for (int i = parDebut; i < parFin; i++) {
            if (tabReservations[i].compareTo(plusAncienne) < 0) {
                indicePlusPetit = i;
                plusAncienne = tabReservations[i];
            }
        }

        return indicePlusPetit;
    }


    public String toString() {
            String resultat = " ----------- Planning ----------- :\n";

            for (Reservation res : tabReservations) {
                if (res != null) {
                    resultat = resultat + "- "+ res + "\n";
                }
            }

            return resultat;
    }
}

