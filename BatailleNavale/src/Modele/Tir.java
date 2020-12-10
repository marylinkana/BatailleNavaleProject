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

import Modele.Coordonnee;
import java.util.Scanner;



public class Tir {
    public Coordonnee cible;
    public int puissance;
    public int existe;
    

    public Tir(Coordonnee cible, int puissance) {
        this.cible = cible;
        this.puissance = puissance;
    }
    
    public int Caseexiste(Coordonnee cible){ // verifie si la case est dans la grille
        
       
        if((0<cible.abscisse && cible.abscisse<=15) && (0<cible.ordonne && cible.ordonne<=15)){
            existe = 1;
                    
        }
        else{
            existe = 0;
            
        }
        return existe;
    }
    
    public int[] Cibler(Coordonnee cible){ // methode demandant à l'utilisateur la coordonnée de la case
        Scanner scanner = new Scanner( System.in );
        cible.abscisse=0;
        cible.ordonne=0;
        int[] Case = new int[2];
        
        while(Caseexiste(cible)==1){
            System.out.print("Choisissez la ligne du tir ");
            cible.abscisse = scanner.nextInt();
            Case[1]=cible.abscisse;
            System.out.print("Choisissez la colonne Sdu tir ");
            cible.ordonne = scanner.nextInt();
            Case[2]=cible.ordonne;
        }
        return Case;
    }
    
       
}
