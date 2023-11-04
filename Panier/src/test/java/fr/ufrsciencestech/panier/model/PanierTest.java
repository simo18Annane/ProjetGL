/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.*;

public class PanierTest {

    @Test
    public void testAjoutFruit() throws Panier.PanierPleinException {//vérifie que le panier a la bonne taille après l'ajout d'un fruit.
        Panier panier = new Panier("Panier1", "Fruit", 3);
        Fruit orange = new Orange(1, 1.0, "Espagne");
        panier.ajout(orange);
        assertEquals(1, panier.getTaillePanier());
    }

    @Test(expected = Panier.PanierPleinException.class)
    public void testAjoutFruitPanierPlein() throws Panier.PanierPleinException {//vérifie que le panier lève une exception lorsque l'ajout est tenté sur un panier plein.
        Panier panier = new Panier("Panier1", "Fruit", 1);
        Fruit orange = new Orange(1, 1.0, "Espagne");
        panier.ajout(orange);
        Fruit kiwi = new Kiwi(2, 1.5, "Nouvelle-Zélande");
        panier.ajout(kiwi); // Le panier est plein, cette ligne doit lever une exception
    }

    @Test
    public void testRetraitFruit() throws Panier.PanierPleinException, Panier.PanierVideException { //vérifie que le panier a la bonne taille après le retrait d'un fruit.
        Panier panier = new Panier("Panier1", "Fruit", 3);
        Fruit orange = new Orange(1, 1.0, "Espagne");
        panier.ajout(orange);
        panier.retrait();
        assertEquals(0, panier.getTaillePanier());
    }

    @Test(expected = Panier.PanierVideException.class)
    public void testRetraitFruitPanierVide() throws Panier.PanierVideException {
        Panier panier = new Panier("Panier1", "Fruit", 3);
        panier.retrait(); // Le panier est vide, cette ligne doit lever une exception
    }

    @Test
    public void testPrixPanier() throws Panier.PanierPleinException {
        Panier panier = new Panier("Panier1", "Fruit", 3);
        Fruit orange = new Orange(1, 1.0, "Espagne");
        Fruit kiwi = new Kiwi(2, 1.5, "France");
        panier.ajout(orange);
        panier.ajout(kiwi);
        assertEquals(2.5, panier.getPrix(), 0.001);//vérifie que le calcul du prix du panier est correct.
    }

  
}

