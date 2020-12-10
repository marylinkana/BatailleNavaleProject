/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Navire;
import Modele.Croiseur;
import Modele.Cuirasse;
import Modele.Destroyer;
import Modele.SousMarin;
import Modele.Coordonnee;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nabil
 */
public class Grille {
    
    private ArrayList<Navire> navires = new ArrayList<Navire>();
    private char[][] grille = new char[15][15];
    
    public Coordonnee positionNavire(){
        Random random = new Random();
        int pos1 = (int)random.nextInt(5);
        int pos2 = (int)random.nextInt(5);
        return new Coordonnee(pos1, pos2);
    }
    
    private ArrayList<Navire> genererNavires(){
        Croiseur croiseur = new Croiseur("longueur", new Coordonnee(1, 2), true);
        Cuirasse cuirasse = new Cuirasse("longueur", new Coordonnee(2, 3), true);
        Destroyer destroyer = new Destroyer("longueur", new Coordonnee(3, 4), true);
        SousMarin sousMarin = new SousMarin("longueur", new Coordonnee(4, 5), true);
        this.navires.add(croiseur);
        this.navires.add(cuirasse);
        this.navires.add(destroyer);
        this.navires.add(sousMarin);
        return this.navires;
    }
    
    public void positionner(ArrayList<Navire> navires,int i,int j){
        int x = navires.get(i).getPosition().getAbscisse()-1;
        int y = navires.get(i).getPosition().getOrdonne()-1;
        if(navires.get(i) instanceof Croiseur){
            if(navires.get(i).sens == "longueur"){
                if(i == x && (j >= y && j <= y+8)){
                    grille[i][j] = '€';
                }
                else {
                    grille[i][j] = '~';
                }
            }
            else if(y == j && (i >= x || i <= x+8)){
                    grille[i][j] = '€';
                }
                else {
                    grille[i][j] = '~';
                }
        }
        if(navires.get(i) instanceof Cuirasse){
            if(navires.get(i).sens == "longueur"){
                if(i == x && (j >= y && j <= y+6)){
                        grille[i][j] = '#';
                }
                else {
                    grille[i][j] = '~';
                }
            }
            else if(y == j && (i >= x || i <= x+6)){
                    grille[i][j] = '#';
                }
                else {
                    grille[i][j] = '~';
                }
        }
        if(navires.get(i) instanceof Destroyer){
            if(navires.get(i).sens == "longueur"){
                if(i == x && (j >= y && j <= y+2)){
                        grille[i][j] = '£';
                }
                else {
                    grille[i][j] = '~';
                }
            }
            else if(y == j && (i >= x || i <= x+2)){
                    grille[i][j] = '£';
                }
                else {
                    grille[i][j] = '~';
                }
        }
        if(navires.get(i) instanceof SousMarin){
            if(navires.get(i).sens == "longueur"){
                if(i == x && j == y){
                        grille[i][j] = '@';
                }
                else {
                    grille[i][j] = '~';
                }
            }
            else if(i == x && j == y){
                    grille[i][j] = '@';
                }
                else {
                    grille[i][j] = '~';
                }
        }
        
    }
    

    /** 
     * Fonction initialisant une grille en début de partie
     * avec des ~~
     */

    public void initialiser(){
        for (int i = 0;i < grille.length+1; i++) {
            if(i<9){
                System.out.print(i + "  ");
            }
            else System.out.print(i + " ");
        }
        System.out.print("          ");
        
        for (int k = 0;k < grille.length+1; k++) {
            if(k<9){
                System.out.print(k + "  ");
            }
            else System.out.print(k + " ");
        }
        System.out.println();
        
        
        for (int i = 0;i < grille.length; i++) {
            if(i<9){
                System.out.print(i+1 + "  ");
            }
            else System.out.print(i+1 + " ");
            for (int j = 0;j < grille.length;j++) {
               positionner(genererNavires(), i, j);
               System.out.print(grille[i][j] + "  ");
            }
            System.out.print("         ");
            
            if(i<9){
                System.out.print(i+1 + "  ");
            }
            else System.out.print(i+1 + " ");
            for (int j = 0;j < grille.length;j++) {
               grille[i][j] = '~';
               System.out.print(grille[i][j] + "  ");
            }
            System.out.println();
        } 
    }

}


