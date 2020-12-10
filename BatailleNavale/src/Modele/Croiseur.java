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
        super("Croiseur", sens, 5, 4, position);
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
    public void setPuissance(int puissance) {
        super.setPuissance(puissance); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPuissance() {
        return super.getPuissance(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(Coordonnee position) {
        super.setPosition(position); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordonnee getPosition() {
        return super.getPosition(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTaille(int taille) {
        super.setTaille(taille); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTaille() {
        return super.getTaille(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSens(int sens) {
        super.setSens(sens); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSens() {
        return super.getSens(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setType(String type) {
        super.setType(type); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        return super.getType(); //To change body of generated methods, choose Tools | Templates.
    }

    
             
}
