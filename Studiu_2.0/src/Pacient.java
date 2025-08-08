import java.io.Serializable;

public class Pacient implements Serializable {
    private String Id, Nume, Prenume, Patronimic, Adresa, Telefon, Secție, Diagnoză;
    private int Nr_polita;

    Pacient(){}

    //setters
    public void setId(String Id){ this.Id = Id;}
    public void setNume(String Nume){ this.Nume = Nume;}
    public void setPrenume(String Prenume){ this.Prenume = Prenume;}
    public void setPatronimic(String Patronimic){ this.Patronimic = Patronimic;}
    public void setAdresa(String Adresa){ this.Adresa = Adresa;}
    public void setTelefon(String Telefon){ this.Telefon = Telefon;}
    public void setNr_polita(int Nr_polita){ this.Nr_polita = Nr_polita;}
    public void setSecție(String Secție){ this.Secție = Secție;}
    public void setDiagnoză(String Diagnoză){ this.Diagnoză = Diagnoză;}

    //getters
    String getId(){ return Id;}
    String getNume(){ return Nume;}
    String getPrenume(){ return Prenume;}
    String getPatronimic(){ return Patronimic;}
    String getAdresa(){ return Adresa;}
    String getTelefon(){ return Telefon;}
    int getNr_polita(){ return Nr_polita;}
    String getSecție(){ return Secție;}
    String getDiagnoză(){ return Diagnoză;}

    @Override
    public String toString() {
        return getId() + " " + getNume() + " " + getPrenume() + " " + getPatronimic() + " " + getAdresa() + " " + getTelefon() + " " + getNr_polita() + " " + getSecție() + " " + getDiagnoză();
    }
}