package fr.ufrsciencestech.panier.model;
/**
 *
 * @author mehdi
 */
import org.junit.Test;
import static org.junit.Assert.*;
import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.FruitFactory;

public class FruitFactoryTest {

    @Test
    public void testCreerBanane() {
        FruitFactory factory = new FruitFactory();
        Fruit fruit = factory.creerFruit("Banane");
        assertTrue(fruit instanceof Banane);
    }

    @Test
    public void testCreerFraise() {
        FruitFactory factory = new FruitFactory();
        Fruit fruit = factory.creerFruit("Fraise");
        assertTrue(fruit instanceof Fraise);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFruitInvalide() {
        FruitFactory factory = new FruitFactory();
        factory.creerFruit("PommeGéante"); // Cela devrait lever une exception IllegalArgumentException
    }
}

