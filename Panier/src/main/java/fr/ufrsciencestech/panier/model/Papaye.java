/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author HP
 */
public class Papaye implements Fruit{
    private double prix;
    private String origine;
    
    public Papaye(){
        this.prix = 0.0;
        this.origine = "";
    }

    public Papaye(double prix, String origine) {
        this.prix = prix;
        this.origine = origine;
    }


    public double getPrix() {
        return prix;
    }
    
    public void setPrix(double prix) {
        if(prix < 0)
            this.prix = -prix;
        else
            this.prix = prix;
    }

    public String getOrigine() {
        return origine;
    }
    
    public void setOrigine(String origine) {
        if(origine.isEmpty())
            this.origine = "France";
        else
            this.origine = origine;
    }

    @Override
    public String getNom() {
        return "Papaye";
    }
    
    @Override
    public String toString() {
        return "Papaye de " + origine + " à " + prix + " €/kg";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Papayes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Papaye papaye = (Papaye) o;
            return (prix == papaye.prix && origine.equals(papaye.origine));
        }
        return false;
    }

    
    @Override
    public boolean isSeedless() {
        return true; // Papaye sans pépins
    }
}
