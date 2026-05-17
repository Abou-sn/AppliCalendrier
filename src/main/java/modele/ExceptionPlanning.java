package modele;

public class ExceptionPlanning extends Exception {

    private final ErreursPlanning typeErreur;

    /**
     * Constructeur de l'exception
     * @param typeErreur le type de l'erreur à lever
     */
    public ExceptionPlanning(ErreursPlanning typeErreur) {
        this.typeErreur = typeErreur;
    }

    public ErreursPlanning getTypeErreur(){
        return typeErreur;
    }


}
