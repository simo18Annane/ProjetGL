package fr.ufrsciencestech.panier.model;

public class Banane implements Fruit{
    private int id;
    private double prix;
    private String origine;
	
    public Banane() 
    {
        this.id = 0;
        this.prix = 0.0;  //prix en euros
        this.origine= "";
    }
    
    public Banane(int id, double prix, String origine) 
    {
        this.id = id;
	this.prix = prix;
        this.origine = origine;
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	if (prix < 0)
            this.prix = -prix;
        else
            this.prix = prix;
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
        return "Banane";
    }


    @Override
    public String toString(){
        return id + "- Banane de " + origine + " à " + prix + " €/kg";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Bananes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Banane or = (Banane) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Banane a des pepins
        return false;
    }

}
