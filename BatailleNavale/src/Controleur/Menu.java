package Controleur;

import Vue.Grille;
import Vue.Jeux;
import java.io.* ;

public class Menu{
    
    /*
     * Permet de quitter le jeux
     */
    public static int quitter(int confirm) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do
        {
            System.out.println("\nSouhaitez-vous quitter le jeu ?");
            System.out.println("1: non ");
            System.out.println("2: oui ");
            confirm = Integer.parseInt(in.readLine());
        }
        while (confirm < 1 || confirm > 2);

        return confirm;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        int menu = 0 ;
        int confirm = 0 ; 
        boolean erreur = false ;

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
                    new Jeux();
                    confirm = quitter(confirm) ;	
                break ;

                case 0 :
                    confirm = quitter(confirm) ;	
                break ;
            }

        }while (confirm != 2) ;

        System.exit(0) ;                   

    }

}
