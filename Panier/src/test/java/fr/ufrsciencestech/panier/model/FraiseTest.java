/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.Fraise;


public class FraiseTest {
    @Test
    public void testPrixPositif(){
        
        Fraise fraise = new Fraise();
        fraise.setPrix(-5.0);//Prix negatif
        assertEquals(5.0,fraise.getPrix(),0.001);// le prix doit etre positif
    }

    @Test
    public void testOrigineVide(){
        Fraise fraise = new Fraise();
        fraise.setOrigine("");//origine vide
        assertEquals("France",fraise.getOrigine()); //L'origine doit être "France"
    }
    
    @Test
    public void testToString(){
        Fraise fraise = new Fraise(1,7.5,"Espagne");
        String StringTest="1- Fraise de Espagne à 7.5 €/kg";
        assertEquals(StringTest,fraise.toString());
    }
    
    @Test
    
    public void testEquals(){
        Fraise fraise1 = new Fraise(1,7.0,"Espagne");
        Fraise fraise2 = new Fraise(1,7.0,"Espagne");
        assertTrue(fraise1.equals(fraise2));
    }
    

     
     @Test
     public void testIsSeedless(){
         Fraise fraise=new Fraise();
         assertFalse(fraise.isSeedless());
     }


}
