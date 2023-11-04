/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ConnexionBDD {

    private static final String URL = "jdbc:sqlite:../bddprojetgl.db";
    private Connection connection;

    //Connexion à la base de donnée
    public ConnexionBDD() {
        try{
            connection = DriverManager.getConnection(URL);
            System.out.println("Connexion à la BDD établie ");
        } catch(SQLException e) {
            System.err.println("Erreur de connexion à la BDD"+e.getMessage());
        }
    }
    public ConnexionBDD(String url) {
        try{
            connection = DriverManager.getConnection(url);
            System.out.println("Connexion à la BDD établie ");
        } catch(SQLException e) {
            System.err.println("Erreur de connexion à la BDD"+e.getMessage());
        }
    }

    //Fermeture de la connexion à la base de donnée
    public void closeConnection() {
        try {
            if(connection != null){
                connection.close();
                System.out.println("Connexion à la BDD fermée");
            }
        } catch(SQLException e){
            System.out.println("Erreur lors de la fermeture de la connexion à la BDD");
        }
    }
    
    //verifier si un fruit existe deja dans la bdd
    public boolean verifFruit(String nom, double prix, String origine){
        String requete = "SELECT COUNT(*) FROM fruit WHERE name = ? AND price = ? AND origin = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete)){
            preparedStatement.setString(1, nom);
            preparedStatement.setDouble(2, prix);
            preparedStatement.setString(3, origine);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e){
            System.out.println("Erreur lors de la vérification de l'existence du fruit dans la bdd: "+ e.getMessage());
        }
        return false;
    }
    
    //insertion d'un nouveau fruit dans la table fruit du BDD (Création d'un fruit)
    public boolean insertFruit(String nom, double prix, String origine){
        if(!verifFruit(nom, prix, origine)){
            String requete = "INSERT INTO fruit (name, price, origin) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setDouble(2, prix);
                preparedStatement.setString(3, origine);

                int rows = preparedStatement.executeUpdate();
                if(rows > 0){
                    System.out.println("Données insérées avec succés.");
                } else {
                    System.out.println("Aucune donnée insérée");
                }

            } catch (SQLException e){
                System.err.println("Erreur lors de l'insertion de données à la BDD: " + e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    
    //nombre du fruit dans la table bdd fruit
    public int nombreLigne(String table){
        String requete = "SELECT COUNT(*) FROM " + table;
        int row = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()){
                row = resultSet.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }
    
    //nombre du fruit dans la table bdd fruit dans le cas du filtrage
    public int nombreLigne(String table, String filtre, String text){
        String requete = "SELECT COUNT(*) FROM " + table + " WHERE "+ filtre + "='" + text + "'";
        int row = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()){
                row = resultSet.getInt(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }
    
    
    //récuperer les fruits depuis la table Fruit de BDD (proposer liste de fruit)
    public Object[][] listeFruit() {
        
        String requete = "SELECT * FROM fruit";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            int rowCount = nombreLigne("fruit");
            Object[][] fruits = new Object[rowCount][4];
            int index = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("name");
                double prix = resultSet.getDouble("price");
                String origine = resultSet.getString("origin");
                
                fruits[index][0] = id;
                fruits[index][1] = nom;
                fruits[index][2] = prix;
                fruits[index][3] = origine;
                index++;
            }
            return fruits;
        } catch (SQLException e){
            System.err.println("Erreur lors de la recuperation des données " + e.getMessage());
        }
        
        return new Object[0][0];
    }
    
    //verifier si un panier existe deja dans la bdd
    public boolean verifPanier(String nom){
        String requete = "SELECT COUNT(*) FROM panier WHERE name = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete)){
            preparedStatement.setString(1, nom);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e){
            System.out.println("Erreur lors de la vérification de l'existence du panier dans la bdd: " + e.getMessage());
        }
        return false;
    }
    
    //creation d'un nouveau panier
    public boolean insertPanier(String nom, String type, int capacité, double value){
        if(!verifPanier(nom)){
            String requete = "INSERT INTO panier (name, type, maxcapacity, value) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(requete)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, type);
                preparedStatement.setInt(3, capacité);
                preparedStatement.setDouble(4, value);


                int rows = preparedStatement.executeUpdate();
                if(rows > 0){
                    System.out.println("Données insérées avec succés.");
                } else {
                    System.out.println("Aucune donnée insérée");
                }

            } catch (SQLException e){
                System.err.println("Erreur lors de l'insertion de données à la BDD: " + e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }
    
    //pour recuperer la liste des paniers depuis la bdd du panier (liste des paniers disponibles)
    public List<String> listePanier() {
        List<String> panier = new ArrayList<>();
        
        String requete = "SELECT * FROM panier";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                String nom = resultSet.getString("name");
                
                panier.add(nom);
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la recuperation des données " + e.getMessage());
        }
        
        return panier;
    }
    
    //recuperer le type de chaque panier
    public String typePanier(String nom){
        String typePanier = "";
        String requete = "SELECT type FROM panier WHERE name='" + nom + "'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if(resultSet.next()){
                typePanier = resultSet.getString("type");
                
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la récuperation des données: " + e.getMessage());
        }
        return typePanier;
    }
    
    //pour trier les fruits en utilisant le filtre fruit
    public Object[][] getFruitByName(String text, String filter) {
        String requete = "";
        int rowCount = 0;
        switch (filter){
            case "Fruit":{
                requete = "SELECT * FROM fruit WHERE name='" + text +"'";
                rowCount = nombreLigne("fruit", "name", text);
            } break;
            case "Origine":{
                requete = "SELECT * FROM fruit WHERE origin='" + text +"'";
                rowCount = nombreLigne("fruit", "origin", text);
            } break;  
        }
        
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery()){
            Object [][] fruits = new Object[rowCount][4];
            int index = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("name");
                double prix = resultSet.getDouble("price");
                String origine = resultSet.getString("origin");
                
                fruits[index][0] = id;
                fruits[index][1] = nom;
                fruits[index][2] = prix;
                fruits[index][3] = origine;
                index++;
            }
            return fruits;
        } catch (SQLException e){
            System.err.println("Erreur lors de la recuperation des données " + e.getMessage());
        }
        
        return new Object[0][0];
    }
    
    //recuperer le prix/kg pour un fruit avec un id
    public double getPrixFruit(int id){
        double prix = 0;
        String requete = "SELECT price FROM fruit WHERE id='" + id +"'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()){
                prix = resultSet.getDouble("price");
            }
        } catch (SQLException e){
            System.err.println("Ereur lors de la récuperation du prix");
        }
        return prix;
    }
    
    //verifier si un fruit existe deja dans un panier avant de l'ajouter
    public boolean verifFruitPanier(String nom, int id){
        String requete = "SELECT COUNT(*) FROM operation WHERE name = ? AND idFruit = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete)){
            preparedStatement.setString(1,nom);
            preparedStatement.setInt(2, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la verification: " + e.getMessage());
        }
        return false;
    }
    
    //ajouter un fruit à un panier
    public String insertFruitToPanier(String nom, int id, double poid, double valeur){
        if(!verifFruitPanier(nom, id)){
            String requete = "INSERT INTO operation (name, idFruit, poid, value) VALUES (?, ?, ?, ?)";
            if(getLengthPanier(nom) < getMaxCapacity(nom)){
                try (PreparedStatement preparedStatement = connection.prepareStatement(requete)){
                    preparedStatement.setString(1, nom);
                    preparedStatement.setInt(2, id);
                    preparedStatement.setDouble(3, poid);
                    preparedStatement.setDouble(4, valeur);

                    int rows = preparedStatement.executeUpdate();
                    if(rows > 0){
                        System.out.println("données insérées avec succés");
                    } else {
                        System.out.println("Aucune donnée insérée");
                    }
                } catch (SQLException e){
                    System.err.println("Erreurlors de l'insertion de données à la bdd: " + e.getMessage());
                }
                updateValuePanier(nom);
                return "";
            } else {
                return "le panier est plein";
            }
        } else{
            return "le fruit existe deja dans le panier";
        }
    }
    
    //recuperer les fruits d'un panier à partir le nom du panier pour la page d'accueil
    public List<String> getFruitFromPanier(String nom){
        List<String> fruit = new ArrayList<>();
        
        String requete = "SELECT o.poid, o.value, o.idFruit, f.name, f.price, f.origin FROM operation o INNER JOIN fruit f ON o.idFruit = f.id WHERE o.name = '" + nom + "'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                double poid = resultSet.getDouble("poid");
                double valeur = resultSet.getDouble("value");
                int id = resultSet.getInt("idFruit");
                String nomFruit = resultSet.getString("name");
                double prix = resultSet.getDouble("price");
                String origine = resultSet.getString("origin");
                
                String affichage = id + "- " + nomFruit + " de " + origine + " ---------- " + poid + " Kg * " + prix + "€ = " + valeur + "";
                fruit.add(affichage);
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la récuperation des données");
        }
        return fruit;
    }
    
    //recuperer la capacité max d'un panier à partir de son nom
    public int getMaxCapacity(String nom){
        int cap = -1;
        String requete = "SELECT maxcapacity FROM panier WHERE name ='" + nom + "'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()){
                cap = resultSet.getInt("maxcapacity");
                
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la récuperation des données: " + e.getMessage());
        }
        
        return cap;
    }
    
    //recuperer la taille d'un panier à partir du table operation
    public int getLengthPanier(String nom){
        int length = 0;
        String requete = "Select COUNT(*) FROM operation WHERE name ='" + nom +"'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            if(resultSet.next()){
                length = resultSet.getInt(1);
            }
        } catch (SQLException e){
            System.out.println("Erreur lors de la vérification: " + e.getMessage());
        }
        return length;
    }
    
    //supprimer un panier
    public boolean deletePanier(String nom){
        String requetePanier = "DELETE FROM panier WHERE name = ?";
        String requeteOperation = "DELETE FROM operation WHERE name = ?";
        try(PreparedStatement panierStatement = connection.prepareStatement(requetePanier);
                PreparedStatement operationStatement = connection.prepareStatement(requeteOperation)){
            panierStatement.setString(1, nom);
            operationStatement.setString(1, nom);
            int rows = panierStatement.executeUpdate();
            int rowsOp = operationStatement.executeUpdate();
            if(rows > 0){
                System.out.println("Panier supprimer avec succès");
                return true;
            } else {
                System.out.println("Aucun panier supprimé (panier introuvable).");
                return false;
            }
           
            
        } catch (SQLException e){
            System.err.println("Erreur lors de la suppression du panier: " + e.getMessage());
            return false;
        }
    }
    
    //recuperer le cout d'un panier à partir de son nom
    public double getCout(String nom){
        double cout = 0;
        String requete = "SELECT value FROM panier WHERE name ='" + nom + "'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()){
                cout = resultSet.getDouble("value");
                
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la récuperation des données: " + e.getMessage());
        }
        
        return cout;
    }
    
    //calculer le cout d'un panier
    public double calculerCout(String nom){
        double cout = 0;
        String requete = "SELECT value FROM operation WHERE name ='" + nom + "'";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete);
                ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                BigDecimal att1 = BigDecimal.valueOf(cout);
                BigDecimal att2 = BigDecimal.valueOf(resultSet.getDouble("value"));
                BigDecimal res = att1.add(att2);
                res =  res.setScale(2, RoundingMode.HALF_UP);
                cout = res.doubleValue();
                
                
            }
        } catch (SQLException e){
            System.err.println("Erreur lors de la récuperation des données: " + e.getMessage());
        }
        
        return cout;
    }
    
    //mettre à jour le cout dans la table bdd panier
    public void updateValuePanier(String nom){
        double cout = calculerCout(nom);
        String requete = "UPDATE panier SET value = ? WHERE name = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete)){
            preparedStatement.setDouble(1, cout);
            preparedStatement.setString(2, nom);
            
            int rows = preparedStatement.executeUpdate();
           
        } catch (SQLException e){
            System.err.println("Erreur lors de la mise à jour du cout du panier: " + e.getMessage());
        }
    }
    
    //supprimer un fruit d'un panier
    public void deleteFruitFromPanier(String nom, int id){
        String requete = "DELETE FROM operation WHERE name = ? AND idFruit = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete)){
            preparedStatement.setString(1, nom);
            preparedStatement.setInt(2, id);
            
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erreur lors de la suppression du fruit: " + e.getMessage());
        }
        updateValuePanier(nom);
    }
    
    //mettre à jour le poid d'un fruit dans un panier
    public void updatePoidFruit(String nom, int id, double poid){
        double newValue = getNewValue(id, poid);
        String requete = "UPDATE operation SET poid = ? , value = ? WHERE name = ? AND idFruit = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(requete)){
            preparedStatement.setDouble(1, poid);
            preparedStatement.setDouble(2,newValue);
            preparedStatement.setString(3, nom);
            preparedStatement.setInt(4,id);
            
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erreur lors de la mise à jour du poid d'un fruit: " + e.getMessage());
        }
        updateValuePanier(nom);
    }
    
    //calculer nouveau value d'un fruit apres la modification du poid
    public double getNewValue(int id, double poid){
        BigDecimal att1 = BigDecimal.valueOf(getPrixFruit(id));
        BigDecimal att2 = BigDecimal.valueOf(poid);
        BigDecimal res = att1.multiply(att2);
        res =  res.setScale(2, RoundingMode.HALF_UP);
        double valeur = res.doubleValue();
        return valeur;
    }
}
