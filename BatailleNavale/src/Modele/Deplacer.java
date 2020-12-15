/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.IOException;

/**
 *
 * @author nabil
 */
public class Deplacer {
    
    /*
     * Vérification du déplacement en abscisse
     */
    public static int abscisse(int taille, int direction, int abscisse, int sens) throws IOException
    {
        if(sens == 1){
            if(direction == 1){
                if(abscisse-1 >= 1){
                    abscisse--;
                }
                else System.out.println("Déplacement impossible");
            }
            if(direction == 2){
                if(abscisse+1 <= 15){
                    abscisse++;
                }
                else System.out.println("Déplacement impossible");
            }
        }
        else{
            if(direction == 1){
                if(abscisse-1 >= 1){
                    abscisse--;
                }
                else System.out.println("Déplacement impossible");
            }
            if(direction == 2){
                if(abscisse+taille <= 15){
                    abscisse++;
                }
                else System.out.println("Déplacement impossible");
            }  
        }
        return abscisse ;
    }
    
    /*
     * Vérification du déplacement en ordonnée
     */
    public static int ordonnee(int taille, int direction, int ordonnee, int sens) throws IOException 
    {   
        if(sens == 1){
            if(direction == 3){
                if(ordonnee-1 >= 1){
                    ordonnee--;
                }
                else System.out.println("Déplacement impossible");
            }
            if(direction == 4){
                if(ordonnee+taille <= 15){
                    ordonnee++;
                }
                else System.out.println("Déplacement impossible");
            }
        }
        else{
            if(direction == 3){
                if(ordonnee-1 >= 1){
                    ordonnee--;
                }
                else System.out.println("Déplacement impossible");
            }
            if(direction == 4){
                if(ordonnee+1 <= 15){
                    ordonnee++;
                }
                else System.out.println("Déplacement impossible");
            }
        }
        return ordonnee ;
    }
    
}
