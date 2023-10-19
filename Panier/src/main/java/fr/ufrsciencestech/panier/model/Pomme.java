package fr.ufrsciencestech.panier.model;

public class Pomme implements Fruit {
    private double prix;
    private String origine;
	
    public Pomme() 
    {
        this.prix = 0.0;  //prix en euros
        this.origine= "";
    }
    
    public Pomme(double prix, String origine) 
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
            this.origine = origine;
    }

    @Override
    public String getNom() {
        return "Pomme";
    }

    @Override
    public String toString(){
        return "Pomme de " + origine + " à " + prix + " €/kg";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Pommes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Pomme or = (Pomme) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Pomme a des pepins
        return false;
    }



}
