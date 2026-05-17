package modele;

public class Reservation implements Comparable <Reservation>{
    private String chTitre;
    private Date chDate ;
    private PlageHoraire chPlageHoraire;
    /**
     * Constructeur de la classe Reservation
     *
     * @param parTitre Intitulé de la réservation
     * @param parDate Date de la Réservation
     * @param parPlageHoraire Créneau de la réservation
     */
    public Reservation(String parTitre, Date parDate, PlageHoraire parPlageHoraire ) {
        chTitre = parTitre;
        chDate = parDate;
        chPlageHoraire = parPlageHoraire;
    }
    /**
     *
     * @param parReservation La reservation à comparer avec l'objet appelant
     * @return -1 si this est avant parReservation 1 si this est après et 0 dans les autres cas
     */
    public int compareTo(Reservation parReservation) {
        if (this.chDate.compareTo(parReservation.chDate)==0) return chPlageHoraire.compareTo(parReservation.chPlageHoraire);
        else return chDate.compareTo(parReservation.chDate);
    }

    /**
     * Une reservation est valide si sa date et sa plage horaire le sont.
     *
     * @return True si la reservation est valide False sinon
     */
    public boolean estValide() {
        return chPlageHoraire.estValide() && Date.estValide(chDate.getJour(),chDate.getMois(),chDate.getAnnee());
    }

    public Date getDate() {
        return chDate;
    }
    public String getTitre(){return chTitre;}

    /**
     * Affiche la reservation sous forme de chaine de caractère
     *
     * @return String de la forme Titre, Date, Plage horaire, durée
     */
    public String toString() {
        return chTitre + ", " + chDate + ", " + chPlageHoraire;
    }
}
