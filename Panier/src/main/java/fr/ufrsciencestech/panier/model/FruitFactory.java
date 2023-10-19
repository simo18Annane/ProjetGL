package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.Banane;
import fr.ufrsciencestech.panier.model.Fraise;

public class FruitFactory {
    /*public Fruit creerFruit(String fruit) {
        if(fruit.equalsIgnoreCase("Orange")) {
            return new Orange(2.5, "Italie");
        } else if(fruit.equalsIgnoreCase("Banane")) {
            return new Banane(2.5, "Côte d'Ivoire");
        } else if(fruit.equalsIgnoreCase("Pomme")) {
            return new Pomme(2.5, "France");
        } else if(fruit.equalsIgnoreCase("Fraise")) {
            return new Fraise(2.5, "Espagne");
        } else if(fruit.equalsIgnoreCase("Papaye")) {
            return new Papaye(2.5, "Rép. Dom.");
        } else {
            throw new IllegalArgumentException("Fruit invalide");
        }
    }*/
    
    public Fruit creerFruit(String fruit){
        if(fruit.equalsIgnoreCase("Banane"))
            return new Banane();
        else if(fruit.equalsIgnoreCase("Fraise"))
            return new Fraise();
        else if(fruit.equalsIgnoreCase("Kiwi"))
            return new Kiwi();
        else if(fruit.equalsIgnoreCase("Orange"))
            return new Orange();
        else if(fruit.equalsIgnoreCase("Papaye"))
            return new Papaye();
        else if(fruit.equalsIgnoreCase("Pomme"))
            return new Pomme();
        else
            throw new IllegalArgumentException("Fruit invalide");
    }
}
