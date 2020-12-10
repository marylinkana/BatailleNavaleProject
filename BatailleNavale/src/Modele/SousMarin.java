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
public class SousMarin extends Navire {

    public SousMarin(int sens, Coordonnee position) {
        super("SousMarin", "@  ", sens, 1, 1, position, true);
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

    @Override
    public String getSymbole() {
        return super.getSymbole(); //To change body of generated methods, choose Tools | Templates.
    }

}
