package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.controller.Controller;
import fr.ufrsciencestech.panier.model.*;
import fr.ufrsciencestech.panier.view.*;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {
    private Controller ctrl;
    private ConnexionBDD cnxdb;
    private InterfaceFruit ifr;
    private InterfaceCreerFruit icf;
    private InterfaceCreerPanier icp;
    private InterfacePanier ipa;
    @Before
    public void setUp(){
        icf = new InterfaceCreerFruit();
        ifr = new InterfaceFruit();
        icp = new InterfaceCreerPanier();
        ipa = new InterfacePanier();
        ctrl = new Controller("jdbc:sqlite:../bddprojetgl.db",icf, ifr, icp, ipa);
        cnxdb = new ConnexionBDD("jdbc:sqlite:../bddprojetgl.db");
        ipa.setVisible(false);

    }

    @Test
    public void testRemplirLF(){
        Object[][] tabFruit=cnxdb.listeFruit();
        List<Fruit> lfruit=ctrl.tabToList(tabFruit);
        ctrl.remplirLF();
        assertEquals(ifr.getElementFromComboBox().toString(),lfruit.toString());
    }
    @Test
    public void testRemplirLFbyname(){
        String filtertype="Fruit",filtervalue="Orange";
        Object[][] tabFruit=cnxdb.getFruitByName(filtervalue,filtertype);
        List<Fruit> lfruit=ctrl.tabToList(tabFruit);
        ctrl.remplirLFbyname(filtervalue,filtertype);
        assertEquals(ifr.getElementFromComboBox().toString(),lfruit.toString());
        ifr.ecraserLF();
        filtertype="Origine";filtervalue="Maroc";
        tabFruit=cnxdb.getFruitByName(filtervalue,filtertype);
        lfruit=ctrl.tabToList(tabFruit);
        ctrl.remplirLFbyname(filtervalue,filtertype);
        assertEquals(ifr.getElementFromComboBox().toString(),lfruit.toString());
    }
    @Test
    public void testRemplirLP(){
        List<String>listePanier=cnxdb.listePanier();
        ctrl.remplirLP();
        assertEquals(ipa.getElementFromListPanier().toString(),listePanier.toString());
    }

    @Test
    public void testFruitOfPanier(){
        List<String> Fruit=cnxdb.getFruitFromPanier("test");
        ipa.setPanier("test");
        ctrl.fruitOfPanier();
        assertEquals(Fruit.toString(), ipa.getElementFromListFruit().toString());
    }
    @Test
    public void testCloseConnesction(){
        ctrl.fermerCnxBDD();
        ctrl.remplirLP();
    }

}
