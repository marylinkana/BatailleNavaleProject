/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import Vue.Grille;
import java.util.Scanner;

/**
 *
 * @author kanab
 */
public class Navire {
    public String type;
    public String sens;
    public int taille;
    public int puissance;
    public Coordonnee position;
    public boolean intact;
    
    

    public Navire(String type, String sens, int taille, int puissance, Coordonnee position,boolean intact) {
        this.type = type;
        this.sens = sens;
        this.taille = taille;
        this.puissance = puissance;
        this.position = position;
        this.intact = intact;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
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
    public Navire choisirNavire(ArrayList<Navire> navires){
        
        Scanner scanner1 = new Scanner(System.in);
        for (int i = 0;i < navires.size()+1; i++) {
            
            System.out.print("Numéro : " + i + " navire : " + navires.get(i));
            
        }
        System.out.println("Choisissez un numéro de navire.");
        int numero = scanner1.nextInt();
        return navires.get(numero);
    
    }
}
