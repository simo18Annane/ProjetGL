package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Panier;
import junit.framework.TestCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InterfaceCreerFruitTest extends TestCase {

    private InterfaceCreerFruit icf;
    private Fruit banane;
    private Fruit fraise;
    private Fruit kiwi;
    private Fruit orange;
    private Fruit papaye;
    private Fruit pomme;
    private Panier panier;


    public void setUp() throws Exception {
        super.setUp();
        icf=new InterfaceCreerFruit();
    }

    public void testRemplirComboBox() {
        String elementToAdd = "Apple";
        icf.remplirComboBox(elementToAdd);
        assertEquals(elementToAdd, icf.getListFruit().getItemAt(0));
    }

    public void testButtonValiderListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = "";
                double price = 0;
                String origin = "";
                switch (icf.getChampFruit()){
                    case "Banane":{
                        banane.setPrix(icf.getChampPrix());
                        banane.setOrigine(icf.getChampOrigine());
                        name = banane.getNom();
                        price = banane.getPrix();
                        origin = banane.getOrigine();
                    } break;
                    case "Fraise":{
                        fraise.setPrix(icf.getChampPrix());
                        fraise.setOrigine(icf.getChampOrigine());
                        name = fraise.getNom();
                        price = fraise.getPrix();
                        origin = fraise.getOrigine();
                    } break;
                    case "Kiwi":{
                        kiwi.setPrix(icf.getChampPrix());
                        kiwi.setOrigine(icf.getChampOrigine());
                        name = kiwi.getNom();
                        price = kiwi.getPrix();
                        origin = kiwi.getOrigine();
                    } break;
                    case "Orange":{
                        orange.setPrix(icf.getChampPrix());
                        orange.setOrigine(icf.getChampOrigine());
                        name = orange.getNom();
                        price = orange.getPrix();
                        origin = orange.getOrigine();
                    } break;
                    case "Papaye":{
                        papaye.setPrix(icf.getChampPrix());
                        papaye.setOrigine(icf.getChampOrigine());
                        name = papaye.getNom();
                        price = papaye.getPrix();
                        origin = papaye.getOrigine();
                    } break;
                    case "Pomme":{
                        pomme.setPrix(icf.getChampPrix());
                        pomme.setOrigine(icf.getChampOrigine());
                        name = pomme.getNom();
                        price = pomme.getPrix();
                        origin = pomme.getOrigine();
                    } break;

                }
            }
        };

        icf.buttonValiderListener(listener);
        assertEquals(listener, icf.getBoutonValiderListener());
    }

    public void testGetChampFruit() {
        String selectedFruit = "Banana";
        icf.remplirComboBox(selectedFruit);
        icf.getListFruit().setSelectedItem(selectedFruit);

        // Act: Call the method to retrieve the selected fruit
        String result = icf.getChampFruit();

        // Assert: Check that the method returns the selected fruit
        assertEquals(selectedFruit, result);
    }

    public void testGetChampPrix() {
        double expectedPrice = 5.99;
        icf.getjTextFieldPrix().setText(Double.toString(expectedPrice));

        // Check that the retrieved price matches what we set
        assertEquals(expectedPrice, icf.getChampPrix(), 0.001); // Tolerance for double comparison

    }

    public void testGetChampOrigine() {
        String expectedOrigine = "USA";
        icf.getjTextFieldOrigine().setText(expectedOrigine);

        // Check that the retrieved origine matches what we set
        assertEquals(expectedOrigine, icf.getChampOrigine());

    }

    public void testRetourResultat() {
        String res = "Test Result";

        // Call the method
        icf.retourResultat(res);

        // Delay for 5 seconds to allow the Timer to execute
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Use SwingUtilities.invokeLater to check the result on the Swing Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Assert that the label's text is cleared after the timer
                assertEquals("", icf.getResultat().getText());
            }
        });
    }



    public void testReinit() {
        icf.getjTextFieldPrix().setText("5.99");
        icf.getjTextFieldOrigine().setText("USA");

        icf.reinit();

        // Check that the text fields have been cleared
        assertEquals("", icf.getjTextFieldPrix().getText());
        assertEquals("", icf.getjTextFieldOrigine().getText());
    }
}