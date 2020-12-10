package Controleur;

import Vue.Fonction;
import Vue.Jeux;
import java.io.* ;

public class Menu{

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        int menu = 0 ;
        int confirm = 0 ; 
        boolean erreur = false ;

        Fonction fonction = new Fonction() ;

        do{
            do{
                try{ 
                    System.out.println("MENU\n") ;
                    System.out.println("1: Jouer") ;
                    System.out.println("0: Quitter le jeu\n") ;
                    menu = Integer.parseInt(in.readLine()) ;
                }
                catch (NumberFormatException e){
                    System.out.println("\nVeuillez entrer 1 pour jouer et 0 pour quitter");
                    erreur = true ;	
                }
            }while (erreur != false && (menu < 1 || menu > 7)) ;

            switch (menu){
                case 1 :
                    Jeux grille = new Jeux();
                    confirm = fonction.Quitter(confirm) ;	
                break ;

                case 0 :
                    confirm = fonction.Quitter(confirm) ;	
                break ;
            }

        }while (confirm != 2) ;

        System.exit(0) ;                   

    }

}
