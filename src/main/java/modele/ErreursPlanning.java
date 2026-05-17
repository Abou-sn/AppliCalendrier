package modele;

public enum ErreursPlanning {
    RESERVATION_NON_VALIDE("La reservation n'est pas valide, veuillez la corriger."),
    PLANNING_PLEIN("Le planning est plein"),
    RESERVATION_INCOMPATIBLE("Il ne peut y avoir 2 réservation à ce créneau");

    private final String message;

    ErreursPlanning(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
