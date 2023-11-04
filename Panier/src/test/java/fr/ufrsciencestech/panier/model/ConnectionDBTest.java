package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.ConnexionBDD;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionDBTest {
    private ConnexionBDD cnxdb;
    @Before
    public void setUp(){
        cnxdb = new ConnexionBDD("jdbc:sqlite:../bddprojetgl.db");
    }

    @Test
    public void testverifFruit(){
        assertTrue(cnxdb.verifFruit("Orange",2.36,"Belgique"));
        assertFalse(cnxdb.verifFruit("Orange",2.34,"Belgique"));
    }
    @Test
    public void testInsertFruit(){
        int rand=(int)(Math.random()*399);
        assertFalse(cnxdb.insertFruit("Orange",2.36,"Belgique"));
        assertTrue(cnxdb.insertFruit("Kaki"+rand,2.6,"Milan"));
    }

    @Test
    public void testVerifPanier(){
        assertFalse(cnxdb.verifPanier(""));
        assertTrue(cnxdb.verifPanier("test"));
    }

    @Test
    public void testInsertPanier(){
        int rand=(int)(Math.random()*99)+1;
        assertFalse(cnxdb.insertPanier("test","",10,0.0));
        assertTrue(cnxdb.insertPanier("testa"+rand,"salade fruit",10,5.0));
    }
    @Test
    public void testGetPrixFruit(){
        assertTrue(cnxdb.getPrixFruit(3)==1.49);
    }
    @Test
    public void testVerifFruitPanier(){
        assertFalse(cnxdb.verifFruitPanier("test",5));
        assertTrue(cnxdb.verifFruitPanier("test",1));
    }
    @Test
    public void testInsertFruitToPanier(){
        assertEquals(cnxdb.insertFruitToPanier("messiPanier",2,2,2.98),"le panier est plein");
        assertEquals(cnxdb.insertFruitToPanier("test",1,2,2.98),"le fruit existe deja dans le panier");
        assertEquals(cnxdb.insertFruitToPanier("test",(int)(Math.random()*199)+1,1,2.09),"");
    }

    @Test
    public void testDeletePanier(){
        cnxdb.insertPanier("test200","test",10,0.0);
        cnxdb.insertFruitToPanier("test200",(int)(Math.random()*99)+1,1,2.09);
        cnxdb.insertFruitToPanier("test200",(int)(Math.random()*99)+1,1,2.09);
        cnxdb.insertFruitToPanier("test200",(int)(Math.random()*99)+1,1,2.09);
        cnxdb.insertFruitToPanier("test200",(int)(Math.random()*99)+1,1,2.09);
        assertTrue(cnxdb.deletePanier("test200"));
        assertFalse(cnxdb.deletePanier("test200"));
    }
    @Test
    public void testDeleteFruitFromPanier(){
        cnxdb.insertFruitToPanier("testa100",1,1,2.09);
        cnxdb.deleteFruitFromPanier("testa100",1);
    }
    @Test
    public void testUpdatePoidFruit(){
        int rand=(int)(Math.random()*99)+1;
        cnxdb.insertFruitToPanier("testa100",rand,1,2.09);
        cnxdb.updatePoidFruit("testa100",rand,((double)rand)/10);
    }

}
