/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author kanab
 */
public class Tir {
    public Coordonnee cible;
    public int puissance;

    public Tir(Coordonnee cible, int puissance) {
        this.cible = cible;
        this.puissance = puissance;
    }
       
}
