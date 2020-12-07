/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.util.Scanner;
import Vue.Grille;


/**
 *
 * @author kanab
 */
public class Menu {
    
        public static void main(String[] args){
            int menu;
            do{
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("Menu");
                System.out.println("1 : Jouer une partie");
                System.out.println("2 : Charger une partie");
                System.out.println("3 : Aide");
                System.out.println("0 : Quitter");

                menu = scanner3.nextInt();

                switch(menu){
                    case 0: 
                        System.out.println("Bataille Navale NK vous dit à bientôt");
                        break;                 
                    case 1: 
                        System.out.println("jouer");
                        break;                
                    case 2: 
                        Grille grille = new Grille();
                        grille.initialiser();
                        break;
                    case 3:
                        System.out.println("aide");
                        break;

                    default : System.out.println("Commande non autorisée");
                }
            }while (menu > 3);
        }
    
}
