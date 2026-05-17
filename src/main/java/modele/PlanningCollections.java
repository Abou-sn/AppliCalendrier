package modele;

import java.util.ArrayList;
import java.util.TreeSet;

public class PlanningCollections {
     private ArrayList <Reservation> reservationArrayList;
     private TreeSet <Reservation> reservationTreeSet;

    /**
     * Constructeur qui instancie les Arraylist et TreeSet
     */
     public PlanningCollections (){
         reservationArrayList = new ArrayList<Reservation>();
         reservationTreeSet = new TreeSet<Reservation>();
     }

    /**
     * Méthode qui ajoute une reservation de la classe Reservation au planning.
     * La reservation est ajouté au ArrayList et au TreeSet
     * Renvoi une exception dans le cas ou la reservation est invalide ou incompatible avec ceux déja présentes.
     *
     * @param res la reservation à ajouter.
     * @throws ExceptionPlanning
     */
    public void ajout(Reservation res) throws ExceptionPlanning {
        if (!res.estValide()) throw new ExceptionPlanning(ErreursPlanning.RESERVATION_NON_VALIDE);

        // Vérification ArrayList
        for (Reservation autreRes : reservationArrayList) {
            if (res.compareTo(autreRes) == 0)
                throw new ExceptionPlanning(ErreursPlanning.RESERVATION_INCOMPATIBLE);
        }

        // Vérification TreeSet
        for (Reservation autreRes : reservationTreeSet) {
            if (res.compareTo(autreRes) == 0)
                throw new ExceptionPlanning(ErreursPlanning.RESERVATION_INCOMPATIBLE);
        }

        // Ajout seulement si tout est OK
        reservationArrayList.add(res);
        reservationTreeSet.add(res);
    }

    /**
     * Ajoute dans un treeSet tout les reservations qui ont pout date parDate.
     * @param parDate un objet de type Date
     * @return un Treeset contenant les reservations, null si vide
     */
    public TreeSet <Reservation> getReservations(DateCalendrier parDate) {
        TreeSet <Reservation> reservationsTree = new TreeSet<Reservation>();
        for (Reservation res : reservationTreeSet) {
            if(res.getDate().compareTo(parDate) == 0) reservationsTree.add(res);
        }

        //Si le Treeset est vide donc aucune correspondante, on retourne null
        if (reservationsTree.isEmpty()) return null;
        else return reservationsTree ;
    }

    public TreeSet <Reservation> getReservation(String parString){
        TreeSet <Reservation> reservationsTree = new TreeSet<Reservation>();
        for (Reservation res : reservationTreeSet){
            if (res.getTitre().equals(parString)) reservationsTree.add(res);

        }
        if (reservationsTree.isEmpty()) return null;
        else return reservationsTree ;
    }

    public String toString() {
        String array = "ArrayList : " + reservationArrayList.toString();
        String set =  "TreeSet    : " + reservationTreeSet.toString();

        return array + "\n" + set ;
    }
}
