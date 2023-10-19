package fr.ufrsciencestech.panier;



import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.controller.*;

/**
 * Hello world!
 *
 */

public class TestMVC
{
    public static void main( String[] args )
    {
        InterfaceCreerFruit icf = new InterfaceCreerFruit();
        InterfaceFruit ifr = new InterfaceFruit();
        InterfaceCreerPanier icp = new InterfaceCreerPanier();
        InterfacePanier ipa = new InterfacePanier();
        Controller ctrl = new Controller(icf, ifr, icp, ipa);
        
        ipa.setVisible(true);
    }
}
