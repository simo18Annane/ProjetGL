package fr.ufrsciencestech.panier.view;
import java.lang.ClassNotFoundException;
import junit.framework.TestCase;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InterfaceCreerPanierTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testButtonValiderListener() {

        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        InterfaceCreerPanier interfaceCreerPanier= new InterfaceCreerPanier();

        interfaceCreerPanier.buttonValiderListener(testListener);

        ActionEvent testEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Command");
        testListener.actionPerformed(testEvent);
    }

    public void testGetNom() {
        InterfaceCreerPanier interfaceCreerPanier= new InterfaceCreerPanier();
        String expectedNom = "Fruits";
        interfaceCreerPanier.getjTextFieldNom().setText(expectedNom);

        String nom = interfaceCreerPanier.getNom();

        assertEquals(expectedNom, nom);
    }

    public void testGettype() {
        InterfaceCreerPanier interfaceCreerPanier= new InterfaceCreerPanier();
        String expectedType = "Jus";
        interfaceCreerPanier.getjTextFieldType().setText(expectedType);

        String type = interfaceCreerPanier.gettype();

        assertEquals(expectedType, type);
    }

    public void testRetourResultat() {
        InterfaceCreerPanier interfaceCreerPanier= new InterfaceCreerPanier();
        String expectedResultSuccess = "Succès!";
        interfaceCreerPanier.retourResultat(expectedResultSuccess);

        assertEquals(expectedResultSuccess, interfaceCreerPanier.getResultat().getText());
        String expectedResultFailure = "Échec!";
        interfaceCreerPanier.retourResultat(expectedResultFailure);

        assertEquals(expectedResultFailure, interfaceCreerPanier.getResultat().getText());
    }

    public void testRetourResultatTimer() {
        InterfaceCreerPanier interfaceCreerPanier = new InterfaceCreerPanier();
        String expectedRes = "Résultat attendu";

        interfaceCreerPanier.retourResultat(expectedRes);

        String actualRes = interfaceCreerPanier.getResultat().getText();
        assertEquals(expectedRes, actualRes);

        try {
            Thread.sleep(6000); // Attendre 6 secondes pour que le Timer s'exécute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals("", interfaceCreerPanier.getResultat().getText());
    }

    public void testReinit() {
        String expectedNom = "Fruits";
        String expectedType = "Frais";
        int expectedCapacite = 100;
        InterfaceCreerPanier interfaceCreerPanier= new InterfaceCreerPanier();

        interfaceCreerPanier.getjTextFieldNom().setText(expectedNom);
        interfaceCreerPanier.getjTextFieldType().setText(expectedType);
        interfaceCreerPanier.getjTextFieldCapaciteMax().setText(String.valueOf(expectedCapacite));

        interfaceCreerPanier.reinit();

        assertEquals("", interfaceCreerPanier.getjTextFieldNom().getText());
        assertEquals("", interfaceCreerPanier.getjTextFieldType().getText());
        assertEquals("", interfaceCreerPanier.getjTextFieldCapaciteMax().getText());
    }

    public void testJButtonAbandonnerActionPerformed() {
        InterfaceCreerPanier interfaceCreerPanier = new InterfaceCreerPanier();
        JButton abandonButton = interfaceCreerPanier.getjButtonAbandonner();
        abandonButton.doClick();

        assertFalse(interfaceCreerPanier.isVisible());
    }


    public void testJButtonValiderAction() {
        InterfaceCreerPanier interfaceCreerPanier = new InterfaceCreerPanier();
        assertNull(interfaceCreerPanier.getBoutonValiderListener());
        ActionListener testListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        interfaceCreerPanier.buttonValiderListener(testListener);
        JButton validerButton = interfaceCreerPanier.getjButtonValider();
        validerButton.doClick();
        assertNotNull(interfaceCreerPanier.getBoutonValiderListener());
    }

    public void testMainMethod() {
        UIManager.LookAndFeelInfo[] originalLookAndFeel = UIManager.getInstalledLookAndFeels();
UIManager.setInstalledLookAndFeels(new UIManager.LookAndFeelInfo[0]);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            InterfaceCreerPanier.main(new String[]{});
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(e instanceof ClassNotFoundException);
            assertEquals("Mocking exception for UIManager", e.getMessage());
        } finally {
            UIManager.setInstalledLookAndFeels(originalLookAndFeel);
        }

    }

    public void testMainMethodUpdate() {
        InterfaceCreerPanier.main(new String[]{});
        assertTrue(true);
    }
    public void testGetCapacite() {
        InterfaceCreerPanier interfaceCreerPanier = new InterfaceCreerPanier();

        int expectedPositiveCapacite = 100;
        interfaceCreerPanier.getjTextFieldCapaciteMax().setText(String.valueOf(expectedPositiveCapacite));

        int positiveCapacite = interfaceCreerPanier.getCapacite();
        assertEquals(expectedPositiveCapacite, positiveCapacite);

        interfaceCreerPanier.getjTextFieldCapaciteMax().setText("0");
        int zeroCapacite = interfaceCreerPanier.getCapacite();
        assertEquals(0, zeroCapacite);

        interfaceCreerPanier.getjTextFieldCapaciteMax().setText("-5");
        int negativeCapacite = interfaceCreerPanier.getCapacite();
        assertEquals(-5, negativeCapacite);
    }


}