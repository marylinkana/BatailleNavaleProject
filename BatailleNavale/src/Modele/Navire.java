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
public class Navire {
    public String type;
    public int taille;
    public int puissance;
    public Coordonnee position;

    public Navire(String type, int taille, int puissance, Coordonnee position) {
        this.type = type;
        this.taille = taille;
        this.puissance = puissance;
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Coordonnee getPosition() {
        return position;
    }

    public void setPosition(Coordonnee position) {
        this.position = position;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    @Override
    public String toString() {
        return "Navire{" + "type=" + type + ", taille=" + taille + ", puissance=" + puissance + ", position=" + position + '}';
    }
    
    public int tirer(){
        return this.getPuissance();
    }
    
    public int subirTir(Navire tireur){
        return tireur.getPuissance();
    }
    
    public Coordonnee seDeplacer(Coordonnee newPosition){
        return newPosition;
    }
    
    
    
    
}
