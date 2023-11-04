
/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.*;
public class PanierPleinExceptionTest {

    @Test
    public void testMessage() {
        PanierPleinException exception = new PanierPleinException();
        assertEquals("Ajout impossible car le panier est plein !", exception.getMessage());
    }

   
}

