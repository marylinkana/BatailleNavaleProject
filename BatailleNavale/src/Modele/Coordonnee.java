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
public class Coordonnee {
    public int abscisse;
    public int ordonne;

    public Coordonnee(int abscisse, int ordonne) {
        this.abscisse = abscisse;
        this.ordonne = ordonne;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public int getOrdonne() {
        return ordonne;
    }

    public void setOrdonne(int ordonne) {
        this.ordonne = ordonne;
    }

    @Override
    public String toString() {
        return "Coordonnee{" + "abscisse=" + abscisse + ", ordonne=" + ordonne + '}';
    }
    
    
}
