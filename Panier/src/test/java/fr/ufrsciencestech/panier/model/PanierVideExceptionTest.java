/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.*;

public class PanierVideExceptionTest {

    @Test
    public void testMessage() {
        PanierVideException exception = new PanierVideException();
        assertEquals("Suppression impossible car le panier est vide !", exception.getMessage());
    }

    
}

