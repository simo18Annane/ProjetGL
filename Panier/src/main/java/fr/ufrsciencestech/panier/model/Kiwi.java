package fr.ufrsciencestech.panier.model;

public class Kiwi implements Fruit{
    private int id;
    private double prix;
    private String origine;

    public Kiwi()
    {
        this.id = 0;
        this.prix = 0.0;  //prix en euros
        this.origine= "";
    }

    public Kiwi(int id, double prix, String origine)
    {
        this.id = id;
        this.prix = prix;
        this.origine = origine;
    }

    public double getPrix(){
        return prix;
    }

    public void setPrix(double prix){
        if(prix < 0)
            this.prix = -prix;
        else
            this.prix=prix;
    }

    public String getOrigine(){
        return origine;
    }
    
    public void setOrigine(String origine){
        if(origine.isEmpty())
            this.origine = "France";
        else
            this.origine=origine;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    @Override
    public String getNom() {
        return "Kiwi";
    }

    @Override
    public String toString(){
        return id + "- Kiwi de " + origine + " à " + prix + " €/kg";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Kiwis sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Kiwi kiwi = (Kiwi) o;
            return (prix == kiwi.prix && origine.equals(kiwi.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Kiwi a des pepins
        return false;
    }

}
