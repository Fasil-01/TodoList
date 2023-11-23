package todolist.model;

public class Todo {
    private String nom;
    private  int id =0;
    private Etat etat;
    private Priorite priorite;
    private static int count = 0;

    public Todo(String nom,Priorite priorite) {
        this.id = ++count;
        this.nom = nom;
        this.etat = Etat.EN_ATTENTE;
        this.priorite = priorite;
    }
    public Todo(){
        
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Etat getEtat() {
        return etat;
    }
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
     public  int getId() {
        return id;
    }
    public Priorite getPriorite() {
        return priorite;
    }
    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

}
