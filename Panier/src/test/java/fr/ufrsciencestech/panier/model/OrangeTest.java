/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.Orange;

public class OrangeTest {

    @Test
    public void testPrixPositif() {
        Orange orange = new Orange();
        orange.setPrix(-1.0); // Prix négatif
        assertEquals(1.0, orange.getPrix(), 0.001); // Le prix doit être positif
    }

    @Test
    public void testOrigineVide() {
        Orange orange = new Orange();
        orange.setOrigine(""); // Origine vide
        assertEquals("France", orange.getOrigine()); // L'origine doit être "France"
    }

    @Test
    public void testToString() {
        Orange orange = new Orange(1, 3.5, "Espagne");
        String expectedString = "1- Orange de Espagne à 3.5 €/kg";
        assertEquals(expectedString, orange.toString());
    }

    @Test
    public void testEquals() {
        Orange orange1 = new Orange(1, 3.5, "Espagne");
        Orange orange2 = new Orange(1, 3.5, "Espagne");

        assertTrue(orange1.equals(orange2));
    }

    @Test
    public void testNotEquals() {
        Orange orange1 = new Orange(1, 3.5, "Espagne");
        Orange orange2 = new Orange(2, 3.5, "Italie");

        assertFalse(orange1.equals(orange2));
    }

    @Test
    public void testIsSeedless() {
        Orange orange = new Orange();
        assertFalse(orange.isSeedless()); // Une orange n'est pas sans pépins
    }
}
