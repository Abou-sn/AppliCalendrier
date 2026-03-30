package modele;

import java.util.Scanner;
public class Date {
    protected int jour;
    protected int mois;
    protected int annee;

    /**
     * constructeur de la classe Date, qui instancie une date précise
     *
     *
     *
     * @parameter int parJour, le jour en question
     * @parameter int parMois, le ois de l'année
     * @parameter int parAnnee, l'année donnée
     */
    public Date(int parJour, int parMois, int parAnnee) {
        jour =  parJour;
        mois = parMois;
        annee = parAnnee;
    }
    /**
     * constructeur de la classe Date, qui instancie le premier janvier de l'année
     *
     *
     *
     * @parameter int parAnnee, l'année donnée
     */
    public Date(int parAnnee) {
        annee = parAnnee;
        jour = 1;
        mois = 1;
    }

    public Date() {

    }

    public int getJour() {
        return jour;
    }
    public int getMois() {
        return mois;
    }
    public int getAnnee() {
        return annee;
    }
    /**
     * déclare si une année est bissextile
     *
     *
     *
     * @parameter int parAn, l'année en question
     * @return Boolean, vrai si l'année est bissextile, faux sinon
     */
    public static boolean estBissextile(int parAn) {
        return parAn % 400 == 0 || (parAn % 4 == 0 && parAn % 100 != 0);
    }
    /**
     * donne le dernier jour d'un mois une certaine année
     *
     *
     * @parameter int parMois, le mois concerné
     * @parameter int parAn, l'année concernée
     * @return int, le dernier jour du mois à l'année renseignée
     */
    public static int dernierJourMois(int parMois, int parAn) {
        int nombreJoursMois = 30 ;
        if (parMois == 1 ||parMois == 3 || parMois == 5 || parMois == 7 || parMois == 8 || parMois == 10 || parMois == 12) {
            nombreJoursMois += 1;
        }
        else if (parMois == 2) {
            if (estBissextile(parAn)) {
                nombreJoursMois -= 1;
            }
            else nombreJoursMois -= 2;
        }
        return nombreJoursMois;
    }
    /**
     * vérifie si la date est valide
     *
     *
     *
     *
     * @return Boolean, vrai si la date existe et faux si elle n'existe pas
     */
    public static boolean estValide(int parJour, int parMois, int parAnnee) {
        int nombreJoursMois = dernierJourMois(parMois, parAnnee);
        return parJour >= 1 && parMois >= 1 && parMois <= 12 && parAnnee >= 1583 && parJour <= nombreJoursMois;
    }
    /**
     * instancie un objet Date avec les valeurs données dans le scanner
     *
     *
     *
     *
     * @return Date, la date donnée
     */
    public static Date lireDate(){
        Scanner scanner = new Scanner(System.in);

        int lireJour = scanner.nextInt();
        int lireMois = scanner.nextInt();
        int lireAn = scanner.nextInt();
        return  new Date(lireJour, lireMois, lireAn);
    }
    /**
     * compare deux dates, this et parDate
     *
     *
     *
     * @parameter Date parDate, la Date à laquelle on compare this Date
     * @return -1 si this Date précède parDate, 1 si this Date vient après parDate, 0 si elles sont égales
     */
    public int compareTo (Date parDate) {
        if (parDate.annee > annee) {
            return -1;
        }
        if  (parDate.annee == annee) {
            if (parDate.mois > mois) {
                return -1;
            }
            if (parDate.mois == mois) {
                if (parDate.jour > jour) {
                    return -1;
                }
                if (parDate.jour == jour) {
                    return 0;
                }
                else return 1;
            }
            else return 1;
        }
        else return 1;
    }


    /**
     * renvoie la date qui suit celle de l'objet qui appelle
     *
     *
     *
     *
     * @return Date, la date du lendemain
     */
    public Date dateDuLendemain (){
        if (!estValide(jour,mois,annee)) {
            System.out.println("la date n'est pas valide");
            return null;
        }
        if (dernierJourMois(mois, annee) == jour) {
            if (mois == 12) {
                return new Date(1, 1, annee + 1);
            }
            else return new Date(1, mois + 1, annee);
        }
        return new Date(jour+1, mois, annee);
    }


    /**
     * renvoie la date qui précède celle de l'objet qui appelle
     *
     * @return Date, la date de la veille
     */
    public Date dateDeLaVeille (){
        if (!estValide(jour,mois,annee)) {
            System.out.println("la date n'est pas valide");
            return null;
        }
        if (1 == jour) {
            if (mois == 1) {
                return new Date(31, 12, annee - 1);
            }
            return new Date(dernierJourMois(mois-1, annee), mois-1, annee);
        }
        return  new Date(jour -1, mois, annee);
    }

    public String toString() {
        return  jour + "/" + mois + "/" + annee;
    }


}