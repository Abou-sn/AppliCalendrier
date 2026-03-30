package modele;

import java.util.Calendar;
import java.util.TreeMap;

public class DateCalendrier extends Date implements Comparable <Date> {
    private int jourSemaine;
    private int numeroSemaine;



    public DateCalendrier()  {
        super();
        Calendar today = Calendar.getInstance();
        annee = today.get(Calendar.YEAR);
        mois = today.get(Calendar.MONTH)+1;
        jour = today.get(Calendar.DAY_OF_MONTH);
        numeroSemaine = today.get(Calendar.WEEK_OF_YEAR);

        if (today.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            jourSemaine = 7; // Considérer dimanche comme le 7ème jour
        else jourSemaine = today.get(Calendar.DAY_OF_WEEK)-1;
    }

    public DateCalendrier(int day, int month, int year){

        super(day,month,year);

        Calendar today = Calendar.getInstance();
        today.set(year,month-1,day);

        annee = today.get(Calendar.YEAR);
        mois = today.get(Calendar.MONTH)+1;
        jour = today.get(Calendar.DAY_OF_MONTH);
        numeroSemaine = today.get(Calendar.WEEK_OF_YEAR);

        if (today.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            jourSemaine = 7; // Considérer dimanche comme le 7ème jour
        else jourSemaine = today.get(Calendar.DAY_OF_WEEK)-1;

    }

    public int getNumeroSemaine() {
        return numeroSemaine;
    }
    public int getJourSemaine() {return jourSemaine;}

    @Override
    public DateCalendrier dateDuLendemain(){
        Date dateLend = super.dateDuLendemain();
        return new DateCalendrier(dateLend.jour,dateLend.mois,dateLend.annee);
    }

    @Override
    public DateCalendrier dateDeLaVeille(){
        Date dateVeille = super.dateDeLaVeille();
        return new DateCalendrier(dateVeille.jour,dateVeille.mois,dateVeille.annee);
    }

    @Override
    public String toString() {
        ConstantesCalendrier.Jours [] tabJours = ConstantesCalendrier.Jours.values();
        ConstantesCalendrier.Mois [] tabMois = ConstantesCalendrier.Mois.values();

        return  tabJours[jourSemaine-1].toString() +" " + jour + " " + tabMois[mois -1].toString() +" " + annee ;
    }

}
