/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;


/**
 *
 * @author HP
 */
public class Controller {
    
    private ConnexionBDD cnxdb;
    private FruitFactory fruitfactory;
    private InterfaceCreerFruit cf;
    private InterfaceFruit fr;
    private InterfaceCreerPanier cp;
    private InterfacePanier ip;
    private Fruit banane;
    private Fruit fraise;
    private Fruit kiwi;
    private Fruit orange;
    private Fruit papaye;
    private Fruit pomme;
    private Panier panier;
    

    
    
    
   
    public Controller(InterfaceCreerFruit viewCF, InterfaceFruit viewIF, InterfaceCreerPanier viewCP, InterfacePanier viewIP){
        this.cf = viewCF;
        this.fr = viewIF;
        this.cp = viewCP;
        this.ip = viewIP;
        fruitfactory = new FruitFactory();
       //pour remplir la liste du fruit dans InterfaceCreerFruit
        this.banane = this.fruitfactory.creerFruit("Banane");
        cf.remplirComboBox(this.banane.getNom());
        this.fraise = this.fruitfactory.creerFruit("Fraise");
        cf.remplirComboBox(this.fraise.getNom());
        this.kiwi = this.fruitfactory.creerFruit("Kiwi");
        cf.remplirComboBox(this.kiwi.getNom());
        this.orange = this.fruitfactory.creerFruit("Orange");
        cf.remplirComboBox(this.orange.getNom());
        this.papaye = this.fruitfactory.creerFruit("Papaye");
        cf.remplirComboBox(this.papaye.getNom());
        this.pomme = this.fruitfactory.creerFruit("Pomme");
        cf.remplirComboBox( this.pomme.getNom());
        
        
        
        //pour remplir la liste du fruit proposée
        remplirLF();
        //pour remplir la liste des paniers disponibles
        remplirLP();
        
        //l'action sur le bouton valider pour creer un fruit
        viewCF.buttonValiderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                String name = "";
                double price = 0;
                String origin = "";
                switch (cf.getChampFruit()){
                    case "Banane":{
                        banane.setPrix(cf.getChampPrix());
                        banane.setOrigine(cf.getChampOrigine());
                        name = banane.getNom();
                        price = banane.getPrix();
                        origin = banane.getOrigine();
                    } break;
                    case "Fraise":{
                        fraise.setPrix(cf.getChampPrix());
                        fraise.setOrigine(cf.getChampOrigine());
                        name = fraise.getNom();
                        price = fraise.getPrix();
                        origin = fraise.getOrigine();
                    } break;
                    case "Kiwi":{
                        kiwi.setPrix(cf.getChampPrix());
                        kiwi.setOrigine(cf.getChampOrigine());
                        name = kiwi.getNom();
                        price = kiwi.getPrix();
                        origin = kiwi.getOrigine();
                    } break;
                    case "Orange":{
                        orange.setPrix(cf.getChampPrix());
                        orange.setOrigine(cf.getChampOrigine());
                        name = orange.getNom();
                        price = orange.getPrix();
                        origin = orange.getOrigine();
                    } break;
                    case "Papaye":{
                        papaye.setPrix(cf.getChampPrix());
                        papaye.setOrigine(cf.getChampOrigine());
                        name = papaye.getNom();
                        price = papaye.getPrix();
                        origin = papaye.getOrigine();
                    } break;
                    case "Pomme":{
                        pomme.setPrix(cf.getChampPrix());
                        pomme.setOrigine(cf.getChampOrigine());
                        name = pomme.getNom();
                        price = pomme.getPrix();
                        origin = pomme.getOrigine();
                    } break;
                    
                }
                
                cnxdb.insertFruit(name, price, origin);
                cnxdb.closeConnection();
                fr.ecraserLF();
                remplirLF();
            }
        });
        
        //l'action sur le bouton valider pour creer un panier
        viewCP.buttonValiderListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                panier = new Panier(cp.getNom(), cp.gettype(), cp.getCapacite());
                cnxdb.insertPanier(panier.getName(), panier.getType(), panier.getContenanceMax(), panier.getPrixtotale());
                cnxdb.closeConnection();
                ip.ecraserLP();
                remplirLP();
            }
        });
        
        
        //l'action sur le bouton modifier dans l'interface du panier
        viewIP.buttonModifierListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fr.setVisible(true);
            }
        });
        
        //l'action sur le bouton (jmenu) creer fruit dans l'interface du panier
        viewIP.buttonCreerFruitListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cf.setVisible(true);
            }
        });
        
        //l'action sur le bouton (jmenu) creer panier dans l'interface du panier
        viewIP.buttonCreerPanierListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cp.setVisible(true);
            }
        });
        
        //l'action sur le bouton recherche fruit avec filtre
        viewIF.buttonRechercherListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               String filter = fr.getFilter();
               switch (filter){
                    case "Fruit":{
                        fr.ecraserLF();
                        remplirLFbyname(fr.getFilterText(), filter);
                    } break;
                    case "Origine":{
                        fr.ecraserLF();
                        remplirLFbyname(fr.getFilterText(), filter);
                    } break;
                }
           }
        });
        
        //l'action sur le bouton d'ajouter et supprimer un pays à boycotter dans classe InterfaceFruit
        viewIF.buttonAjoutBoycottListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                DefaultListModel<String> listPays = fr.getListeBoycott();
                cnxdb = new ConnexionBDD();
                Object[][] tabFruit;
                tabFruit = cnxdb.listeFruit();
                List<Fruit> fruits = tabToList(tabFruit);
                for(String pays : Collections.list(listPays.elements())){
                    Iterator<Fruit> it = fruits.iterator();
                    while(it.hasNext()){
                        Fruit fruit = it.next();
                        if(fruit.getOrigine().equals(pays)){
                            it.remove();
                        }
                    }
                }
                fr.ecraserLF();
                for (Fruit f : fruits){
                    fr.remplirComboBox(f.toString());
                }
                cnxdb.closeConnection();
            }
        });
        
    }
    
    //transferer le tableau à une liste
    public List<Fruit> tabToList(Object[][] tab){
        List<Fruit> lst = new ArrayList<> ();
        for(int i=0; i < tab.length; i++){
            switch ((String) tab[i][0]){
                case "Banane":{
                    lst.add(new Banane((Double) tab[i][1], (String) tab[i][2]));
                } break;
                case "Fraise":{
                    lst.add(new Fraise((Double) tab[i][1], (String) tab[i][2]));
                } break;
                case "Kiwi":{
                    lst.add(new Kiwi((Double) tab[i][1], (String) tab[i][2]));
                } break;
                case "Orange":{
                    lst.add(new Orange((Double) tab[i][1], (String) tab[i][2]));
                } break;
                case "Papaye":{
                    lst.add(new Papaye((Double) tab[i][1], (String) tab[i][2]));
                } break;
                case "Pomme":{
                    lst.add(new Pomme((Double) tab[i][1], (String) tab[i][2]));
                } break;
            }
        }
        return lst;
    }

   
    //recuperer la liste du fruit depuis la bdd et remplir la liste proposée dans InterfaceFruit
    public void remplirLF(){
        this.cnxdb = new ConnexionBDD();
        Object[][] tabFruit;
        tabFruit = cnxdb.listeFruit();
        List<Fruit> lst = tabToList(tabFruit);
        for (Fruit f : lst){
            fr.remplirComboBox(f.toString());
        }
        cnxdb.closeConnection();
        
    }
    
    //recuperer la liste du fruit depuis la bdd en utilisant le filtre du nom
    public void remplirLFbyname(String text, String filter){
        this.cnxdb = new ConnexionBDD();
        Object[][] tabFruit;
        tabFruit = cnxdb.getFruitByName(text, filter);
        List<Fruit> lst = tabToList(tabFruit);
        for (Fruit f : lst){
            fr.remplirComboBox(f.toString());
        }
        cnxdb.closeConnection();
    }
    
    //recuperer la liste des paniers depuis la bdd et remplir la liste des paniers disponibles dans InterfacePanier
    public void remplirLP(){
        this.cnxdb = new ConnexionBDD();
        List<String> panier;
        panier = cnxdb.listePanier();
        for (String name : panier){
            ip.remplirListPanier(name);
        }
        cnxdb.closeConnection();
    }
}
