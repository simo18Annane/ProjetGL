/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
        //remplirLF();
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
                
                if(cnxdb.insertFruit(name, price, origin)){
                    //fr.ecraserLF();
                    //remplirLF();
                    cf.retourResultat("Fruit ajouté avec succés");
                    cf.reinit();
                }else {
                    cf.retourResultat("Le fruit existe deja");
                }
               
                
                cnxdb.closeConnection();
            }
        });
        
        //l'action sur le bouton valider pour creer un panier
        viewCP.buttonValiderListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                panier = new Panier(cp.getNom(), cp.gettype(), cp.getCapacite());
                if(cnxdb.insertPanier(panier.getName(), panier.getType(), panier.getContenanceMax(), panier.getPrixtotale())){
                    ip.ecraserLP();
                    remplirLP(); 
                    cp.reinit();
                    cp.dispose();
                }else {
                    cp.retourResultat("ce panier existe deja");
                }
                cnxdb.closeConnection();
                
            }
        });
        
        
        //l'action sur le bouton modifier dans l'interface du panier
        viewIP.buttonModifierListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                fr.setVisible(true);
                fr.ecraserLF();
                remplirLF();
                fr.receivePanier(ip.getPanier() + ": capacité max = " + cnxdb.getMaxCapacity(ip.getPanier()));               
                fr.reinitListFruit();
                fruitOfPanier();
                cnxdb.closeConnection();
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
        
        //l'action sur le bouton ajouter un fruit au panier dans InterfaceFruit
        viewIF.buttonAjoutFruitListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                //l'ajout du fruit
                String nomPanier = ip.getPanier();
                int idFruit = fr.recupererFruit();
                double poid = fr.getPoid();
                BigDecimal att1 = BigDecimal.valueOf(cnxdb.getPrixFruit(idFruit));
                BigDecimal att2 = BigDecimal.valueOf(poid);
                BigDecimal res = att1.multiply(att2);
                res =  res.setScale(2, RoundingMode.HALF_UP);
                double valeur = res.doubleValue();
                String messageRetour = cnxdb.insertFruitToPanier(nomPanier, idFruit, poid, valeur);
                ip.afficherCout(String.valueOf(cnxdb.getCout(ip.getPanier())));
                fr.receiveMessageRetour(messageRetour);
                //afficher la liste 
                fr.reinitListFruit();
                fruitOfPanier();
                fr.reinitPoid();
                fr.desactiverButtonModif();
                fr.desactiverButtonSupp();
                ip.reinitListFruit();
                fruitOfMain();
                
                cnxdb.closeConnection();
            }
        });
        
        //l'action sur la selection d'un panier dans interfacePanier qui affiche le contenu du panier dans la meme interface
        viewIP.selectedFruitListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ip.reinitListFruit();
                cnxdb = new ConnexionBDD();
                /*List<String> fruit;
                fruit = cnxdb.getFruitFromPanier(ip.getPanier());
                for (String f: fruit){
                    ip.remplirListFruit(f);
                }*/
                fruitOfMain();
                ip.receiveType(cnxdb.typePanier(ip.getPanier()));
                ip.afficherCout(String.valueOf(cnxdb.getCout(ip.getPanier())));
                cnxdb.closeConnection();
            }
        });
        
        //l'action sur le bouton supprimer un panier
        viewIP.buttonSuppPanierListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                if(cnxdb.deletePanier(ip.getPanier())){
                    ip.ecraserLP();
                    remplirLP();
                    ip.desactiverButton();
                }
                cnxdb.closeConnection();
            }
        });
        
        //la suppression d'un fruit dans un panier
        viewIF.buttonSuppFruitListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                cnxdb.deleteFruitFromPanier(ip.getPanier(), fr.getIdFruit());
                ip.afficherCout(String.valueOf(cnxdb.getCout(ip.getPanier())));
                fr.reinitListFruit();
                fruitOfPanier();
                ip.reinitListFruit();
                fruitOfMain();
                fr.desactiverButtonSupp();
                fr.desactiverButtonModif();
                cnxdb.closeConnection();
            }
        });
        
        //reinitialiser de list des fruits proposés
        fr.getMainFrame().addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                fr.reinitListBoycott();
                
            }
        });
        
        //l'action sur le bouton modifier le poid
        viewIF.buttonModifPoidListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                cnxdb.updatePoidFruit(ip.getPanier(), fr.getIdFruit(), fr.getNewPoid());
                ip.afficherCout(String.valueOf(cnxdb.getCout(ip.getPanier())));
                fr.reinitListFruit();
                fruitOfPanier();
                fr.desactiverButtonSupp();
                fr.desactiverButtonModif();
                ip.reinitListFruit();
                fruitOfMain();
                fr.reinitNPoid();
                cnxdb.closeConnection();
            }
        });
        
        //l'action sur le bouton quitter panier
        viewIF.buttonQuitterListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fr.reinitListBoycott();
                fr.desactiverButtonModif();
                fr.desactiverButtonSupp();
                fr.dispose();
            }
        });
        
        //supprimer le filtre des fruits
        viewIF.buttonSuppFiltreListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                fr.reinitFiltre();
                fr.ecraserLF();
                remplirLF();
                cnxdb.closeConnection();
            }
        });
        
    }
    
    //transferer le tableau à une liste
    public List<Fruit> tabToList(Object[][] tab){
        List<Fruit> lst = new ArrayList<> ();
        for(int i=0; i < tab.length; i++){
            switch ((String) tab[i][1]){
                case "Banane":{
                    lst.add(new Banane((int)tab[i][0], (Double) tab[i][2], (String) tab[i][3]));
                } break;
                case "Fraise":{
                    lst.add(new Fraise((int)tab[i][0], (Double) tab[i][2], (String) tab[i][3]));
                } break;
                case "Kiwi":{
                    lst.add(new Kiwi((int)tab[i][0], (Double) tab[i][2], (String) tab[i][3]));
                } break;
                case "Orange":{
                    lst.add(new Orange((int)tab[i][0], (Double) tab[i][2], (String) tab[i][3]));
                } break;
                case "Papaye":{
                    lst.add(new Papaye((int)tab[i][0], (Double) tab[i][2], (String) tab[i][3]));
                } break;
                case "Pomme":{
                    lst.add(new Pomme((int)tab[i][0], (Double) tab[i][2], (String) tab[i][3]));
                } break;
            }
        }
        return lst;
    }

   
    //recuperer la liste du fruit depuis la bdd et remplir la liste proposée dans InterfaceFruit
    public void remplirLF(){
        //this.cnxdb = new ConnexionBDD();
        Object[][] tabFruit;
        tabFruit = cnxdb.listeFruit();
        List<Fruit> lst = tabToList(tabFruit);
        for (Fruit f : lst){
            fr.remplirComboBox(f.toString());
        }
        //cnxdb.closeConnection();
        
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
    
    //récuperer la list des fruits d'un panier pour InterfaceFruit
    public void fruitOfPanier(){
        //this.cnxdb = new ConnexionBDD();
        List<String> fruit;
        fruit = cnxdb.getFruitFromPanier(ip.getPanier());
        for (String f: fruit){
            fr.remplirListFruit(f);
        }
        //cnxdb.closeConnection();
    }
    
    //récuperer la list des fruits d'un panier pour InterfaceFruit
    public void fruitOfMain(){
        //this.cnxdb = new ConnexionBDD();
        List<String> fruit;
        fruit = cnxdb.getFruitFromPanier(ip.getPanier());
        for (String f: fruit){
            ip.remplirListFruit(f);
        }
        //cnxdb.closeConnection();
    }
    
    
}
