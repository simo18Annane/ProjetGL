package fr.ufrsciencestech.panier.model;

import java.util.ArrayList;

public class Panier {
    private ArrayList<Fruit> fruits;
    private int contenanceMax;
    private double prixtotale;
    private String name;
    private String type;

    public Panier(String name, String type, int contenanceMax) {
        this.setName(name);
        this.setType(type);
        prixtotale=0;
        //this.fruits = new ArrayList<Fruit>();
        if (contenanceMax < 1) {
            throw new IllegalArgumentException("La contenance maximale doit être supérieure à 0");
        } else {
            this.contenanceMax = contenanceMax;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Fruit f : fruits) {
            result += f.toString() + "\n";
        }
        return result;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public int getTaillePanier() {
        return fruits.size();
    }

    public int getContenanceMax() {
        return contenanceMax;
    }

    public double getPrixtotale() {
        return prixtotale;
    }

    public void setPrixtotale(double prixtotale) {
        for (Fruit fruit:fruits)
            this.prixtotale+= fruit.getPrix();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Fruit getFruit(int i) {
        if (i >= 0 && i < fruits.size()) {
            return fruits.get(i);
        } else {
            return null;
        }
    }

    public void setFruit(int i, Fruit f) {
        if (i >= 0 && i < fruits.size()) {
            fruits.set(i, f);
        }
    }

    public boolean estVide() {
        return fruits.isEmpty();
    }

   
    public boolean estPlein() {
        return fruits.size() >= contenanceMax;
        
    }


    public class PanierPleinException extends Exception {
        public PanierPleinException(String message) {
            super(message);
        }
    }

    public class PanierVideException extends Exception {
        public PanierVideException(String message) {
            super(message);
        }
    }
    //modifier
    public void ajout(Fruit o) throws PanierPleinException {
        if (!estPlein() /*(&& !fruits.contains(o))*/) {
            fruits.add(o);
        } else {
            throw new PanierPleinException("Le panier est plein ou le fruit est déjà présent.");
        }
    }

    public void retrait() throws PanierVideException {
        if (!estVide()) {
            fruits.remove(fruits.size() - 1);
        } else {
            throw new PanierVideException("Le panier est vide, impossible de retirer un fruit.");
        }
    }

    public double getPrix() {
        double prix = 0.0;
        for (Fruit f : fruits) {
            prix += f.getPrix();
        }
        return prix;
    }

    public void boycotteOrigine(String origine) {
        //fruits.removeIf(fruit -> fruit.getOrigin().equals(origine));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Panier panier = (Panier) o;

        if (contenanceMax != panier.contenanceMax)
            return false;
        return fruits != null ? fruits.equals(panier.fruits) : panier.fruits == null;
    }

    /*
    public static void main(String[] args) {
        // Tests de la classe Panier
        Panier p = new Panier("",5);

        Orange o1 = new Orange(0.2, "Espagne");
        Orange o2 = new Orange(0.3, "France");
        //Banane b1 = new Banane(0.25, "Équateur");
        Papaye papaye = new Papaye(1.5, "Brésil");

        try {
            p.ajout(o1);
            p.ajout(o2);
            //p.ajout(b1);
            p.ajout(papaye);

            System.out.println("Contenu du panier :");
            System.out.println(p);

            System.out.println("Prix total du panier : " + p.getPrix() + " euros");

            System.out.println("Boycott des oranges d'Espagne :");
            p.boycotteOrigine("Espagne");
            System.out.println(p);

            p.retrait();
            System.out.println("Retrait d'un fruit :");
            System.out.println(p);

            System.out.println("Test d'égalité de paniers : " + p.equals(p));

        } catch (Exception e) {
            System.err.println(e);
        }
    }*/
}