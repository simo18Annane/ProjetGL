/**
 *
 * @author mehdi
 */

import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.Pomme;

public class PommeTest {
    
    @Test
    public void testPrixPositif() {
        Pomme pomme = new Pomme();
        pomme.setPrix(-4.0); // Prix négatif
        assertEquals(4.0, pomme.getPrix(), 0.001); // Le prix doit être positif
    }

    @Test
    public void testOrigineVide() {
        Pomme pomme = new Pomme();
        pomme.setOrigine(""); // Origine vide
        assertEquals("France", pomme.getOrigine()); // L'origine doit être "France"
    }

    @Test
    public void testToString() {
        Pomme pomme = new Pomme(1, 2.5, "France");
        String expectedString = "1- Pomme de France à 2.5 €/kg";
        assertEquals(expectedString, pomme.toString());
    }

    @Test
    public void testEquals() {
        Pomme pomme1 = new Pomme(1, 4.5, "France");
        Pomme pomme2 = new Pomme(1, 4.5, "France");

        assertTrue(pomme1.equals(pomme2));
    }

    @Test
    public void testNotEquals() {
        Pomme pomme1 = new Pomme(1, 2.5, "France");
        Pomme pomme2 = new Pomme(2, 2.5, "Espagne");

        assertFalse(pomme1.equals(pomme2));
    }

    @Test
    public void testIsSeedless() {
        Pomme pomme = new Pomme();
        assertFalse(pomme.isSeedless()); // Une pomme n'est pas sans pépins
    }
    
    
    
    
    
    
    
    
    
    
}
