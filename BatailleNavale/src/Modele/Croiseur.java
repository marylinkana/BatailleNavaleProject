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
public class Croiseur extends Navire {

    public Croiseur(int sens, Coordonnee position) {
        super("Croiseur", "\04  ", sens, 5, 4, position, true);
    }

    @Override
    public Coordonnee seDeplacer(Coordonnee newPosition) {
        return super.seDeplacer(newPosition); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tir tirer(Coordonnee cible) {
        return super.tirer(cible); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
             
}
