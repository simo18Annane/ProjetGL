/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author mehdi
 */


import org.junit.Test;
import static org.junit.Assert.*;

public class BananeFactoryTest {

    @Test
    public void testCreerFruit() {
        BananeFactory factory = new BananeFactory();
        Fruit fruit = factory.creerFruit();
        assertTrue(fruit instanceof Banane);
    }
}

