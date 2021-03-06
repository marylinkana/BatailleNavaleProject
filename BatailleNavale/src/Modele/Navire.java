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
    private String type;
    private String symbole;
    private int sens;
    private int taille;
    private int puissance;
    private Coordonnee position;
    private boolean actif;

    public Navire(String type, String symbole, int sens, int taille, int puissance, Coordonnee position, boolean actif) {
        this.type = type;
        this.symbole = symbole;
        this.sens = sens;
        this.taille = taille;
        this.puissance = puissance;
        this.position = position;
        this.actif = actif;
    }
      
    public Navire(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
    
    public int getSens() {
        return sens;
    }

    public void setSens(int sens) {
        this.sens = sens;
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

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    @Override
    public String toString() {
        return "Navire{" + "type=" + type + ", sens=" + sens + ", taille=" + taille + ", puissance=" + puissance + ", position=" + position + '}';
    }
    
    public Tir tirer(Coordonnee cible){
        return new Tir(cible, this.getPuissance());
    }
    
    public Coordonnee seDeplacer(Coordonnee newPosition){
        return newPosition;
    }  
    
}
