package fr.ufrsciencestech.panier.view;

import junit.framework.TestCase;
import org.junit.Before;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class InterfaceFruitTest extends TestCase {
    private InterfaceFruit interfaceFruit;


    public void setUp() {
        interfaceFruit = new InterfaceFruit();
    }

    public void testDesactiverButtonSupp() {
        interfaceFruit.desactiverButtonSupp();
        assertFalse(interfaceFruit.getjButtonSupp().isEnabled());
    }

    public void testDesactiverButtonModif() {
        interfaceFruit.desactiverButtonModif();
        assertFalse(interfaceFruit.getjButtonModifierPoid().isEnabled());
    }

    public void testRemplirComboBox() {
        String element = "Apple";
        interfaceFruit.remplirComboBox(element);

        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) interfaceFruit.getjComboBoxFruit().getModel();

        assertTrue(comboBoxModel.getIndexOf(element) != -1);
    }

    public void testGetElementFromComboBox() {
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) interfaceFruit.getjComboBoxFruit().getModel();
comboBoxModel.addElement("Apple");
        comboBoxModel.addElement("Banana");
        comboBoxModel.addElement("Cherry");
ArrayList<String> result = interfaceFruit.getElementFromComboBox();
        assertEquals(3, result.size());
        assertEquals("Apple", result.get(0));
        assertEquals("Banana", result.get(1));
        assertEquals("Cherry", result.get(2));

    }

    public void testEcraserLF() {
        interfaceFruit.remplirComboBox("Apple");
        interfaceFruit.ecraserLF();

        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) interfaceFruit.getjComboBoxFruit().getModel();

        assertEquals(0, comboBoxModel.getSize());
    }

    public void testButtonRechercherListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonRechercherListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonRechercheListener());
    }

    public void testGetFilterText() {
        interfaceFruit.getjTextField1().setText("Test Filter Text");
        assertEquals("Test Filter Text", interfaceFruit.getFilterText());
    }

    public void testReinitFiltre() {
        interfaceFruit.getjTextField1().setText("Test");
        interfaceFruit.reinitFiltre();
        assertFalse(interfaceFruit.getjTextField1().getText().equals("Test"));
    }

    public void testButtonSuppFiltreListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonSuppFiltreListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonSuppFiltreListener());
    }

    public void testGetFilter() {
        interfaceFruit.getjComboBox1().setSelectedItem("Origine");
        assertFalse(interfaceFruit.getjComboBox1().getSelectedItem().toString().equals("Fruit"));
        assertTrue(interfaceFruit.getjComboBox1().getSelectedItem().toString().equals("Origine"));
    }

    public void testButtonAjoutBoycottListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonAjoutBoycottListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonAjoutBoycottListener());
    }

    public void testGetListeBoycott() {
        DefaultListModel<String> listModel = interfaceFruit.getListeBoycott();
        assertNotNull(listModel);
    }

    public void testReceivePanier() {
        interfaceFruit.receivePanier("Test Panier");
        assertTrue(interfaceFruit.getjLabelNomPanier().getText().equals("Test Panier"));
    }

    public void testButtonAjoutFruitListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonAjoutFruitListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonAjoutFruitListener());
    }

    public void testRecupererFruit() {
        DefaultComboBoxModel<String> comboBoxModel = (DefaultComboBoxModel<String>) interfaceFruit.getjComboBoxFruit().getModel();
        comboBoxModel.addElement("1 - Apple");
        comboBoxModel.addElement("2 - Banana");
        comboBoxModel.addElement("3 - Cherry");
        interfaceFruit.getjComboBoxFruit().setSelectedItem("2 - Banana");
        int result = interfaceFruit.recupererFruit();
        assertEquals(2, result);
    }

    public void testGetIdFruit() {
        DefaultListModel<String> listModel = (DefaultListModel<String>) interfaceFruit.getjListFruit().getModel();
        listModel.addElement("1 - Apple");
        listModel.addElement("2 - Banana");
        listModel.addElement("3 - Cherry");
        interfaceFruit.getjListFruit().setSelectedValue("2 - Banana", true);
        int result = interfaceFruit.getIdFruit();
        assertEquals(2, result);
    }

    public void testGetPoid() {
        interfaceFruit.getPoids().setText(null);
        assertTrue(interfaceFruit.getPoid()==1);
        interfaceFruit.getPoids().setText("5.15");
        assertTrue(interfaceFruit.getPoid()==5.15);
    }

    public void testReinitPoid() {
        interfaceFruit.getPoids().setText("5.15");
        interfaceFruit.reinitPoid();
        assertTrue(interfaceFruit.getPoids().getText().isEmpty());
    }

    public void testRemplirListFruit() {
       assertTrue(interfaceFruit.getListFruit().isEmpty());
       interfaceFruit.remplirListFruit("Pera");
       interfaceFruit.remplirListFruit("Fraise");
       assertTrue(interfaceFruit.getListFruit().size()==2);
    }

    public void testReinitListFruit() {
        interfaceFruit.remplirListFruit("Pera");
        interfaceFruit.remplirListFruit("Fraise");
        interfaceFruit.reinitListFruit();
        assertTrue(interfaceFruit.getListFruit().size()==0);
    }

    public void testReceiveMessageRetour() {
        interfaceFruit.receiveMessageRetour("Test 1");
        assertTrue(interfaceFruit.getMessageRetour().getText().equals("Test 1"));
    }

    public void testButtonSuppFruitListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonSuppFruitListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonSuppFruitListener());
    }

    public void testReinitListBoycott() {
        DefaultListModel<String> listModel = (DefaultListModel<String>) interfaceFruit.getjListBoycot().getModel();
        listModel.addElement("Country 1");
        listModel.addElement("Country 2");
        listModel.addElement("Country 3");
        interfaceFruit.reinitListBoycott();
        assertTrue(listModel.isEmpty());
    }

    public void testGetMainFrame() {
        JFrame mainFrame = interfaceFruit.getMainFrame();
        assertNotNull(mainFrame);
    }

    public void testGetNewPoid() {
        interfaceFruit.getNvPoid().setText(null);
        assertTrue(interfaceFruit.getNewPoid()==1);
        interfaceFruit.getNvPoid().setText("5.15");
        assertTrue(interfaceFruit.getNewPoid()==5.15);
    }

    public void testReinitNPoid() {
        interfaceFruit.getNvPoid().setText("5.15");
        interfaceFruit.reinitNPoid();
        assertTrue(interfaceFruit.getNvPoid().getText().isEmpty());

    }

    public void testButtonModifPoidListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonModifPoidListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonModifPoidListener());
    }

    public void testButtonQuitterListener() {
        ActionListener listener = mock(ActionListener.class);
        interfaceFruit.buttonQuitterListener(listener);
        assertEquals(listener, interfaceFruit.getBoutonQuitterListener());
    }
}