/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.Papaye;

public class PapayeTest {

    @Test
    public void testPrixPositif() {
        Papaye papaye = new Papaye();
        papaye.setPrix(-1.0); // Prix négatif
        assertEquals(1.0, papaye.getPrix(), 0.001); // Le prix doit être positif
    }

    @Test
    public void testOrigineVide() {
        Papaye papaye = new Papaye();
        papaye.setOrigine(""); // Origine vide
        assertEquals("France", papaye.getOrigine()); // L'origine doit être "France"
    }

    @Test
    public void testToString() {
        Papaye papaye = new Papaye(1, 2.5, "Rép. Dom.");
        String expectedString = "1- Papaye de Rép. Dom. à 2.5 €/kg";
        assertEquals(expectedString, papaye.toString());
    }

    @Test
    public void testEquals() {
        Papaye papaye1 = new Papaye(1, 2.5, "Rép. Dom.");
        Papaye papaye2 = new Papaye(1, 2.5, "Rép. Dom.");

        assertTrue(papaye1.equals(papaye2));
    }

 

    @Test
    public void testIsSeedless() {
        Papaye papaye = new Papaye();
        assertTrue(papaye.isSeedless()); // Une papaye est sans pépins
    }
}
