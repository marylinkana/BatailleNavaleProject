package Vue;

import java.io.*;
import Modele.*;


public class Fonction{
    
    /*
     * Permet de gérer le positionnement en longueur ou en largeur
     */
    public int Coordonnee(int a) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        boolean erreur ;

        do
        {
            erreur = false ;
            try
            {
                do
                {
                    System.out.println("Le voulez-vous en :\n1. longeur\n2. hauteur") ;
                    a = Integer.parseInt(in.readLine()) ;
                }
                while (a < 1 || a > 2) ;
            }
            catch (NumberFormatException e){
                System.out.println("Veuillez entrer un entier\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

        return a ;
    }
    
    /*
     * Choix de la ligne de départ
     */
    public int Ligne(int a) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        boolean erreur = false ;

        do
        {
           erreur = false ;

            try
            {
                do
                {
                    System.out.println("\nEntrez la ligne de depart") ;
                    a = Integer.parseInt(in.readLine()) ;
                }
                while (a < 1 || a > 15) ;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un entier entre 1 et 10\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

       return a ;
    }
    
    /*
     * Choix de la colonne de départ
     */
    public int Colonne(int a) throws IOException 
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        boolean erreur = false ;

        do
        {
            erreur = false ;

            try
            {
                do
                {
                    System.out.println("\nEntrez la colonne de depart") ;
                    a = Integer.parseInt(in.readLine()) ;
                }
                while (a < 1 || a > 15) ;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un entier entre 1 et 15\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

        return a ;
    }
    
    /*
     * Positionne la première grille
     */
    public void FirstPrint(String a [][])
    {
        for (int i = 0 ; i < 16 ; i++){
            for (int j = 0 ; j < 16 ; j++){
                if (j == 0 && i == 0){
                    System.out.print("   ") ;
                }
                else if(j == 0 && i == 15){
                    System.out.print(a[i][j] + " ") ;
                }
                else if(j == 0 && i > 0){
                    System.out.print(a[i][j] + "  ") ;
                }
                else{
                    System.out.print(a[i][j]) ;
                }
            }
            System.out.println() ;
        }
        System.out.println() ;
    }

    /*
     * Positionne les deux grilles cote à cote
     */
    public void SecondPrint(String a [][], String b [][])
    {
        for (int i = 0 ; i < 16 ; i++)
        {
            for (int j = 0 ; j < 16 ; j++)
            {
                if (j == 0 && i == 0)
                {
                    System.out.print("   ") ;
                }
                else
                {
                    if (j == 0 && i == 15)
                    {
                        System.out.print(a[i][j] + " ") ;
                    }
                    else
                    {
                        if(j == 0)
                        {
                            System.out.print(a[i][j] + "  ") ;
                        }
                        else
                        {
                            System.out.print(a[i][j]) ;
                        }
                    }
                }
            }

            System.out.print("         ") ;

            for (int k = 0 ; k < 16 ; k++)
            {
                if (i == 0 && k == 0)
                {
                    System.out.print("  ") ;
                }
                else
                {
                    if (k == 0 && i == 15)
                    {
                        System.out.print(b[i][k] + " ") ;
                    }
                    else
                    {
                        if(k == 0)
                        {
                            System.out.print(b[i][k] + "  ") ;
                        }
                        else
                        {
                            System.out.print(b[i][k]) ;
                        }
                    }
                }
            }
            System.out.println() ;
        }
        System.out.println() ;
     }
     
    /*
     * Place les Navire du joueur
     */
    public void navireJoueur(String [][] grille, int nbre) throws IOException
    {
        Fonction fonction = new Fonction();

        int erreur = 0 ;
        int coordonnee = 0 ;

        int ligne = 0 ;
        int colonne = 0 ;
        int i = 0 ;

        coordonnee = fonction.Coordonnee(coordonnee) ;

        do
        {
            erreur = 1 ;

            ligne = fonction.Ligne(ligne) ;

            colonne = fonction.Colonne(colonne) ;


            switch (coordonnee)
            {
                case 1 :
                {
                    if((colonne + nbre) > 16)
                    {
                        erreur = 0 ;
                    }
                    else
                    {
                        do
                        {
                            i = colonne ;

                            for (int j = colonne ; j < (colonne + nbre) ; j++)
                            {
                                if(grille[ligne][j] == "\04")
                                {
                                    erreur = 0 ;
                                    i = colonne + nbre ;
                                }
                            }

                            if (erreur != 0)
                            {
                                for (int j = colonne ; j < (colonne + nbre) ; j++)
                                {
                                    grille[ligne][j] = "\04" ;
                                }
                                i = colonne + nbre ;
                            }
                        }
                        while(i < colonne + nbre );
                    }
                }
                break ;

                case 2 :
                {
                    if((ligne + nbre) > 16)
                    {
                            erreur = 0 ;
                    }
                    else
                    {
                        do
                        {
                            i = ligne ;

                            for (int j = ligne ; j < (ligne + nbre) ; j++)
                            {
                                if(grille[j][colonne] == "\04")
                                {
                                    erreur = 0 ;
                                    i = ligne + nbre ;
                                }
                            }

                            if (erreur != 0)
                            {
                                for (int j = ligne ; j < (ligne + nbre) ; j++)
                                {
                                    grille[j][colonne] = "\04" ;
                                }
                                i = ligne + nbre ;
                            }
                        }
                        while(i < ligne + nbre);
                    }
                }
                break ;
            }
        }
        while(erreur != 1) ;
    }
     
    /*
     * Place les navires de l'ordinateur dans la grille
     */
    public void navireOrdi(String grille [][], int nbre)
    {
        int erreur = 0 ;

        do
        {
           int i = 0 ;
           int coordonnee = (int)(Math.random() * (2) + 1) ;
           int ligne = (int)(Math.random() * (15) + 1) ;
           int colonne = (int)(Math.random() * (15) + 1) ;

           erreur = 1 ;

           switch (coordonnee)
           {
               case 1 :
               {
                   if((colonne + nbre) > 11)
                   {
                           erreur = 0 ;
                   }
                   else
                   {
                       do
                       {
                           i = colonne ;

                           for (int j = colonne ; j < (colonne + nbre) ; j++)
                           {
                               if(grille[ligne][j] == "\04")
                               {
                                   erreur = 0 ;
                                   i = colonne + nbre ;
                               }
                           }

                           if (erreur != 0)
                           {
                               for (int j = colonne ; j < (colonne + nbre) ; j++)
                               {
                                   grille[ligne][j] = "\04" ;

                               }
                               i = colonne + nbre ;
                           }
                       }
                       while(i < colonne + nbre );
                   }
               }
               break ;

               case 2 :
               {
                   if((ligne + nbre) > 16)
                   {
                       erreur = 0 ;
                   }
                   else
                   {
                       do
                       {
                           i = ligne ;

                           for (int j = ligne ; j < (ligne + nbre) ; j++)
                           {
                               if(grille[j][colonne] == "\04")
                               {
                                   erreur = 0 ;
                                   i = ligne + nbre ;
                               }
                           }

                           if (erreur != 0)
                           {
                               for (int j = ligne ; j < (ligne + nbre) ; j++)
                               {
                                   grille[j][colonne] = "\04" ;
                               }
                               i = ligne + nbre ;
                           }
                       }
                       while(i < ligne + nbre );
                   }
               }
               break ;
           }
       }
       while(erreur != 1) ;
    }

    /*
     * Permet de quitter le jeux
     */
    public int Quitter(int confirm) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        do
        {
            System.out.println("\nSouhaitez-vous quitter le jeu ?") ;
            System.out.println("1: non ") ;
            System.out.println("2: oui ") ;
            confirm = Integer.parseInt(in.readLine()) ;
        }
        while (confirm < 1 || confirm > 2) ;

        return confirm ;
    }

    /*
     * Permet à l'utilisateur de positionner ses navire
     */
    public void Joueur(String [][] grille, String vous) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

        Fonction fonction = new Fonction() ;

        /*
         * Choix des coordonnées pour le croisseur 9 cases
         */	
        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre Croiseur\n") ;

        fonction.FirstPrint(grille) ;

        fonction.navireJoueur(grille, 9) ;

        /*
         * Choix des coordonn�es pour le Cuirassé 7 cases
         */
        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre Cuirassé \n") ;

        fonction.FirstPrint(grille) ;

        fonction.navireJoueur(grille, 4) ;

        //Choix des coordonn�es pour le Destroyer 3 cases			

        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre Destroyer 7\n") ;

        fonction.FirstPrint(grille) ;

        fonction.navireJoueur(grille, 3) ;

        //Choix des coordonn�es pour le SousMarin 1 cases

        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre bateau a 2 cases\n") ;

        fonction.FirstPrint(grille) ;

        fonction.navireJoueur(grille, 1) ;
    }


    public void Ordi(String [][] grilleOrdi) throws IOException
    {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

       Fonction fonction = new Fonction() ;

       /*
        *Choix des coordonn�es pour le Croiseur � 9 cases
        */	
       fonction.navireOrdi(grilleOrdi, 9) ;
       /*
        *Choix des coordonn�es pour le Croiseur � 7 cases
        */
       fonction.navireOrdi(grilleOrdi, 7) ;
       /*
        *Choix des coordonn�es pour le Croiseur � 3 cases
        */ 
       fonction.navireOrdi(grilleOrdi, 3) ;;
       /*
        *Choix des coordonn�es pour le Croiseur � 1 case
        */
       fonction.navireOrdi(grilleOrdi, 1) ;
    }
     
    public void Grille(int colonne, int ligne, String [][] grilleCachee) throws IOException
    {
        for (int i = 0 ; i < ligne ; i++)
        {
            for (int j = 0 ; j < colonne ; j++)
            {
                if(i == ligne-1 && colonne > 0)
                {
                    System.out.print(grilleCachee[i][j]+ " ") ;
                }
                else if(i > 0 && j > 0 || j == (colonne-1))
                {
                    System.out.print(grilleCachee[i][j]+ "  ") ;
                }
                else
                {
                    System.out.print(grilleCachee[i][j]+ " ") ;
                }
            }
            System.out.println() ;
        }
    }
}
