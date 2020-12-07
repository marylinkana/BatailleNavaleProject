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
    private char[][] tailleGrille = new char[15][15];
    
    private Coordonnee positionNavire(){
        Random random = new Random();
        random.nextInt(15);
        return new Coordonnee(random.nextInt(), random.nextInt());
    }
    
    private ArrayList<Navire> genererNavires(){
        Croiseur croiseur = new Croiseur("longeur", positionNavire());
        Cuirasse cuirasse = new Cuirasse("longeur", positionNavire());
        Destroyer destroyer = new Destroyer("longeur", positionNavire());
        SousMarin sousMarin = new SousMarin("longeur", positionNavire());
        this.navires.add(croiseur);
        this.navires.add(cuirasse);
        this.navires.add(destroyer);
        this.navires.add(sousMarin);
        return this.navires;
    }
    
    public void positionner(ArrayList<Navire> navires,int i,int j){
        for(int l = 0; l < navires.size(); l++){
            if( i == navires.get(i).getPosition().getAbscisse() || j== navires.get(i).getPosition().getOrdonne()){
                if(navires.get(i) instanceof Croiseur){
                    tailleGrille[i][j] = '*';
                }
                if(navires.get(i) instanceof Cuirasse){
                    tailleGrille[i][j] = '#';
                }
                if(navires.get(i) instanceof Destroyer){
                    tailleGrille[i][j] = '+';
                }
                if(navires.get(i) instanceof Destroyer){
                    tailleGrille[i][j] = '@';
                }
            }
            else {
                tailleGrille[i][j] = '~';
            }
        }
        
    }
    

    /** 
     * Fonction initialisant une grille en début de partie
     * avec des ~~
     */

    public void initialiser(){
        System.out.println("bataillenavalenab.Grille.main()");
        for (int i = 0;i < tailleGrille.length+1; i++) {
            if(i<9){
                System.out.print(i + "  ");
            }
            else System.out.print(i + " ");
        }
        System.out.print("          ");
        
        for (int k = 0;k < tailleGrille.length+1; k++) {
            if(k<9){
                System.out.print(k + "  ");
            }
            else System.out.print(k + " ");
        }
        System.out.println();
        
        
        for (int i = 0;i < tailleGrille.length; i++) {
            if(i<9){
                System.out.print(i+1 + "  ");
            }
            else System.out.print(i+1 + " ");
            for (int j = 0;j < tailleGrille.length;j++) {
               positionner(genererNavires(), i, j);
               System.out.print(tailleGrille[i][j] + "  ");
            }
            System.out.print("         ");
            
            if(i<9){
                System.out.print(i+1 + "  ");
            }
            else System.out.print(i+1 + " ");
            for (int j = 0;j < tailleGrille.length;j++) {
               tailleGrille[i][j] = '~';
               System.out.print(tailleGrille[i][j] + "  ");
            }
            System.out.println();
        } 
    }

}


