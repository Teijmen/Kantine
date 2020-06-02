package KantineSimulatieBasis.src.main.java;

public class Student extends Persoon{

    private int studentnr;
    private String studierichting;

    public Student(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentnr, String studierichting) {
        super(bsn, voornaam, achternaam, geboortedatum, geslacht);
        this.studentnr = studentnr;
        this.studierichting = studierichting;
    }

    public Student() {

    }

    public int getStudentnr() {
        return studentnr;
    }

    public void setStudentnr(int studentnr) {
        this.studentnr = studentnr;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }

    @Override
    public String toString(){//overriding the toString() method
        return "Student";
    }
}
