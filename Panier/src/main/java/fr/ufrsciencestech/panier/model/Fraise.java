package fr.ufrsciencestech.panier.model;

public class Fraise implements Fruit {
    private double prix;
    private String origine;

    public Fraise()
    {
        this.prix = 0.0;  //prix en euros
        this.origine= "";
    }

    public Fraise(double prix, String origine)
    {
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

    @Override
    public String getNom() {
        return "Fraise";
    }

    @Override
    public String toString(){
        return "Fraise de " + origine + " à " + prix + " €/kg";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Fraises sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Fraise fraise = (Fraise) o;
            return (prix == fraise.prix && origine.equals(fraise.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Fraise a des pepins
        return false;
    }

}
