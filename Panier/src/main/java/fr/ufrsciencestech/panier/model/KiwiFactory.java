/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author HP
 */
public class KiwiFactory implements FruitFactory{

    @Override
    public Fruit creerFruit() {
        return new Kiwi();
    }
    
}
