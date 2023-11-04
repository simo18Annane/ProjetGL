/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.Kiwi;

public class KiwiTest {

    @Test
    public void testPrixPositif() {
        Kiwi kiwi = new Kiwi();
        kiwi.setPrix(-1.0); // Prix négatif
        assertEquals(1.0, kiwi.getPrix(), 0.001); // Le prix doit être positif
    }

    @Test
    public void testOrigineVide() {
        Kiwi kiwi = new Kiwi();
        kiwi.setOrigine(""); // Origine vide
        assertEquals("France", kiwi.getOrigine()); // L'origine doit être "France"
    }

    @Test
    public void testToString() {
        Kiwi kiwi = new Kiwi(1, 7.5, "Nouvelle-Zélande");
        String expectedString = "1- Kiwi de Nouvelle-Zélande à 7.5 €/kg";
        assertEquals(expectedString, kiwi.toString());
    }

    @Test
    public void testEquals() {
        Kiwi kiwi1 = new Kiwi(1, 7.5, "Nouvelle-Zélande");
        Kiwi kiwi2 = new Kiwi(1, 7.5, "Nouvelle-Zélande");

        assertTrue(kiwi1.equals(kiwi2));
    }

    @Test
    public void testNotEquals() {
        Kiwi kiwi1 = new Kiwi(1, 7.5, "Nouvelle-Zélande");
        Kiwi kiwi2 = new Kiwi(2, 7.5, "Australie");

        assertFalse(kiwi1.equals(kiwi2));
    }

    @Test
    public void testIsSeedless() {
        Kiwi kiwi = new Kiwi();
        assertFalse(kiwi.isSeedless()); // Un kiwi n'est pas sans pépins
    }
}
