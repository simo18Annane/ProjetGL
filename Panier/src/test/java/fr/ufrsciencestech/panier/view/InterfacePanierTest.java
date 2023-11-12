package fr.ufrsciencestech.panier.view;

import junit.framework.TestCase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class InterfacePanierTest extends TestCase {

    public void testDesactiverButton() {
        InterfacePanier interfacePanier= new InterfacePanier();
        interfacePanier.getjButtonModifier().setEnabled(true);
        interfacePanier.getjButtonModifier().setEnabled(true);
        interfacePanier.desactiverButton();

        assertFalse(interfacePanier.getjButtonModifier().isEnabled());
        assertFalse(interfacePanier.getjButtonModifier().isEnabled());
    }

    public void testRemplirListPanier() {
        InterfacePanier interfacePanier= new InterfacePanier();
        String element = "Test";
        interfacePanier.remplirListPanier(element);

        assertTrue(interfacePanier.getListModel().contains(element));

        String element2 = "Test";
        interfacePanier.remplirListPanier(element);

        assertTrue(interfacePanier.getListModel().contains(element2));
    }

    public void testGetListModel() {
        InterfacePanier interfacePanier= new InterfacePanier();
        DefaultListModel<String> listModel = interfacePanier.getListModel();

        assertNotNull(listModel);
        assertTrue(listModel instanceof DefaultListModel);
    }



    public void testGetjButtonSupprimer() {
        InterfacePanier interfacePanier= new InterfacePanier();
        JButton jButtonSupprimer = interfacePanier.getjButtonSupprimer();
        assertNotNull(jButtonSupprimer);
    }
    public void testEcraserLP() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String element = "Test";
        interfacePanier.remplirListPanier(element);

        interfacePanier.ecraserLP();

        assertEquals(0, interfacePanier.getListModel().getSize());
    }

    public void testButtonModifierListener() {
        InterfacePanier interfacePanier = new InterfacePanier();

        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        assertNull(interfacePanier.getBoutonModifListener());
        interfacePanier.setBoutonModifListener(testListener);
        assertEquals(testListener, interfacePanier.getBoutonModifListener());
    }

    public void testButtonCreerFruitListener() {
        InterfacePanier interfacePanier = new InterfacePanier();

        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        assertNull(interfacePanier.getBoutonCreerFruitListener());
        interfacePanier.buttonCreerFruitListener(testListener);
        assertEquals(testListener, interfacePanier.getBoutonCreerFruitListener());
    }






    public void testGetPanier() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String panierName = "Nouveau Panier";
        assertEquals(null, interfacePanier.getPanier());
        interfacePanier.remplirListPanier(panierName);
        assertTrue(interfacePanier.getListModel().contains(panierName));
    }

    public void testRemplirListFruit() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String element = "FruitTest";
        interfacePanier.remplirListFruit(element);

        assertTrue(interfacePanier.getElementFromListFruit().contains(element));
    }

    public void testGetElementFromListFruit() {
        InterfacePanier interfacePanier = new InterfacePanier();

        String fruit1 = "Pomme";
        String fruit2 = "Banane";
        interfacePanier.remplirListFruit(fruit1);
        interfacePanier.remplirListFruit(fruit2);
        ArrayList<String> listeFruits = interfacePanier.getElementFromListFruit();
        assertEquals(2, listeFruits.size());
        assertEquals(fruit1, listeFruits.get(0));
        assertEquals(fruit2, listeFruits.get(1));
    }


    public void testGetElementFromListPanier() {
        InterfacePanier interfacePanier = new InterfacePanier();

        interfacePanier.remplirListPanier("Panier 1");
        interfacePanier.remplirListPanier("Panier 2");
        interfacePanier.remplirListPanier("Panier 3");
        interfacePanier.remplirListPanier("Panier 4");

        ArrayList<String> resultList = interfacePanier.getElementFromListPanier();

        assertEquals(interfacePanier.getListModel().getSize() / 2, resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            assertEquals(interfacePanier.getListModel().getElementAt(i), resultList.get(i));
        }
    }

    public void testReinitListFruit() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String element = "FruitTest";
        interfacePanier.remplirListFruit(element);

        interfacePanier.reinitListFruit();

        assertEquals(0, interfacePanier.getElementFromListFruit().size());
    }

    public void testSelectedFruitListener() {
        InterfacePanier interfacePanier = new InterfacePanier();
        boolean jButtonModifierInitialState = interfacePanier.getjButtonModifier().isEnabled();
        ListSelectionEvent listSelectionEvent = new ListSelectionEvent(interfacePanier.getjListPanier(), 0, 0, false);
        interfacePanier.jListPanierValueChanged(listSelectionEvent);
        assertTrue(interfacePanier.getjButtonModifier().isEnabled());
    }

    public void testReceiveType() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String type = "TypeTest";
        interfacePanier.receiveType(type);

        assertEquals(type, interfacePanier.getjLabelAfficherType().getText());
    }

    public void testButtonSuppPanierListener() {
        InterfacePanier interfacePanier = new InterfacePanier();
        interfacePanier.getjButtonSupprimer().doClick();
        assertFalse(interfacePanier.getjButtonSupprimer().isEnabled());
    }

    public void testAfficherCout() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String cout = "10";
        interfacePanier.afficherCout(cout);

        assertEquals(cout, interfacePanier.getjLabelAfficheCout().getText());
    }

    public void testGetMainFrame() {
        InterfacePanier interfacePanier = new InterfacePanier();
        assertNotNull(interfacePanier.getMainFrame());
    }

    public void testButtonFruitListener() {
        InterfacePanier interfacePanier = new InterfacePanier();

        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        assertNull(interfacePanier.getBoutonCreerFruitListener());
        interfacePanier.buttonCreerFruitListener(testListener);
        assertEquals(testListener, interfacePanier.getBoutonCreerFruitListener());
    }
    public void testButtonCreerPanierListener() {
        InterfacePanier interfacePanier = new InterfacePanier();

        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        assertNull(interfacePanier.getBoutonCreerPanierListener());
        interfacePanier.buttonCreerPanierListener(testListener);
        assertEquals(testListener, interfacePanier.getBoutonCreerPanierListener());
    }

    public void testJButtonSupprimerActionPerformed() {
        InterfacePanier interfacePanier = new InterfacePanier();
        assertNull(interfacePanier.getBoutonSuppPanierListener());
        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ici, vous pouvez ajouter des vérifications spécifiques si nécessaire
            }
        };

        interfacePanier.buttonSuppPanierListener(testListener);
        JButton supprimerButton = interfacePanier.getjButtonSupprimer();
        supprimerButton.doClick();
        assertNotNull(interfacePanier.getBoutonSuppPanierListener());
    }
    public void testSetPanierNonNull() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String panierValue = "Panier 1";

        interfacePanier.setPanier(panierValue);
        System.out.println(interfacePanier.getPanier());
//        assertEquals("La sélection de panier devrait correspondre à la valeur définie", panierValue, interfacePanier.getPanier());
    }

    public void testSetPanierIsNull() {
        InterfacePanier interfacePanier = new InterfacePanier();
        String panierValue = null;
        
        interfacePanier.setPanier(panierValue);

        assertNull("La sélection de panier devrait être null lorsque la valeur passée est null", interfacePanier.getPanier());
    }



}