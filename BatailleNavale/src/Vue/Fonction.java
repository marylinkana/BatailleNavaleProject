package Vue;

import java.io.*;
import Modele.*;


public class Fonction{
    
    /*
     * Permet de gérer le positionnement en longueur ou en largeur
     */
    public int sensNavire() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        int sens = 0;
        boolean erreur ;

        do
        {
            erreur = false ;
            try
            {
                do
                {
                    System.out.println("Le voulez-vous en :\n1: longeur\n2: hauteur") ;
                    sens = Integer.parseInt(in.readLine()) ;
                }
                while (sens < 1 || sens > 2) ;
            }
            catch (NumberFormatException e){
                System.out.println("Veuillez entrer un entier\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

        return sens ;
    }
    
    /*
     * Choix de la ligne de départ
     */
    public int abscisse() throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        int abscisse = 0;
        boolean erreur = false ;

        do
        {
           erreur = false ;

            try
            {
                do
                {
                    System.out.println("\nEntrez la ligne de depart") ;
                    abscisse = Integer.parseInt(in.readLine()) ;
                }
                while (abscisse < 1 || abscisse > 15) ;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un entier entre 1 et 10\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

       return abscisse ;
    }
    
    /*
     * Choix de la colonne de départ
     */
    public int ordonnee() throws IOException 
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        int ordonnee = 0;
        boolean erreur = false ;

        do
        {
            erreur = false ;

            try
            {
                do
                {
                    System.out.println("\nEntrez la colonne de depart") ;
                    ordonnee = Integer.parseInt(in.readLine()) ;
                }
                while (ordonnee < 1 || ordonnee > 15) ;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Veuillez entrer un entier entre 1 et 15\n");
                erreur = true ;
            }
        }
        while(erreur != false) ;

        return ordonnee ;
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
        
        Navire navire = new Navire();
        
        int sens = fonction.sensNavire() ;
                       
        int erreur = 0 ;
        int i = 0 ;
        
        do
        {
            erreur = 1 ;

            if(nbre == 9){
                navire = new Croiseur(sens, new Coordonnee(fonction.abscisse(), fonction.ordonnee()));
            }        
            if(nbre == 7){
                navire = new Cuirasse(sens, new Coordonnee(fonction.abscisse(), fonction.ordonnee()));
            }        
            if(nbre == 3){
                navire = new Destroyer(sens, new Coordonnee(fonction.abscisse(), fonction.ordonnee()));
            }        
            if(nbre == 1){
                navire = new SousMarin(sens, new Coordonnee(fonction.abscisse(), fonction.ordonnee()));
            }
            
            switch (sens)
            {
                case 1 :
                {
                    if((navire.getPosition().getOrdonne() + nbre) > 16)
                    {
                        erreur = 0 ;
                    }
                    else
                    {
                        do
                        {
                            i = navire.getPosition().getOrdonne();

                            for (int j = navire.getPosition().getOrdonne() ; j < (navire.getPosition().getOrdonne() + nbre) ; j++)
                            {
                                if(grille[navire.getPosition().getAbscisse()][j] == "\04")
                                {
                                    erreur = 0 ;
                                    i = navire.getPosition().getOrdonne() + nbre ;
                                }
                            }

                            if (erreur != 0)
                            {
                                for (int j = navire.getPosition().getOrdonne() ; j < (navire.getPosition().getOrdonne() + nbre) ; j++)
                                {
                                    grille[navire.getPosition().getAbscisse()][j] = "\04" ;
                                }
                                i = navire.getPosition().getOrdonne() + nbre ;
                            }
                        }
                        while(i < navire.getPosition().getOrdonne() + nbre );
                    }
                }
                break ;

                case 2 :
                {
                    if((navire.getPosition().getAbscisse() + nbre) > 16)
                    {
                        erreur = 0 ;
                    }
                    else
                    {
                        do
                        {
                            i = navire.getPosition().getAbscisse() ;

                            for (int j = navire.getPosition().getAbscisse() ; j < (navire.getPosition().getAbscisse() + nbre) ; j++)
                            {
                                if(grille[j][navire.getPosition().getOrdonne()] == "\04")
                                {
                                    erreur = 0 ;
                                    i = navire.getPosition().getAbscisse() + nbre ;
                                }
                            }

                            if (erreur != 0)
                            {
                                for (int j = navire.getPosition().getAbscisse() ; j < (navire.getPosition().getAbscisse() + nbre) ; j++)
                                {
                                    grille[j][navire.getPosition().getOrdonne()] = "\04" ;
                                }
                                i = navire.getPosition().getAbscisse() + nbre ;
                            }
                        }
                        while(i < navire.getPosition().getAbscisse() + nbre);
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
           int abscisse = (int)(Math.random() * (15) + 1) ;
           int ordonnee = (int)(Math.random() * (15) + 1) ;

           erreur = 1 ;

           switch (coordonnee)
           {
               case 1 :
               {
                   if((ordonnee + nbre) > 11)
                   {
                        erreur = 0 ;
                   }
                   else
                   {
                       do
                       {
                           i = ordonnee ;

                           for (int j = ordonnee ; j < (ordonnee + nbre) ; j++)
                           {
                               if(grille[abscisse][j] == "\04")
                               {
                                   erreur = 0 ;
                                   i = ordonnee + nbre ;
                               }
                           }

                           if (erreur != 0)
                           {
                               for (int j = ordonnee ; j < (ordonnee + nbre) ; j++)
                               {
                                   grille[abscisse][j] = "\04" ;

                               }
                               i = ordonnee + nbre ;
                           }
                       }
                       while(i < ordonnee + nbre );
                   }
               }
               break ;

               case 2 :
               {
                   if((abscisse + nbre) > 16)
                   {
                       erreur = 0 ;
                   }
                   else
                   {
                       do
                       {
                           i = abscisse ;

                           for (int j = abscisse ; j < (abscisse + nbre) ; j++)
                           {
                               if(grille[j][ordonnee] == "\04")
                               {
                                   erreur = 0 ;
                                   i = abscisse + nbre ;
                               }
                           }

                           if (erreur != 0)
                           {
                               for (int j = abscisse ; j < (abscisse + nbre) ; j++)
                               {
                                   grille[j][ordonnee] = "\04" ;
                               }
                               i = abscisse + nbre ;
                           }
                       }
                       while(i < abscisse + nbre );
                   }
               }
               break ;
           }
       }
       while(erreur != 1) ;
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
         * Choix des coordonnées pour le Cuirassé 7 cases
         */
        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre Cuirassé \n") ;

        fonction.FirstPrint(grille) ;
        fonction.navireJoueur(grille, 7) ;

        /*
         * Choix des coordonnées pour le Destroyer 3 cases
         */        
        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre Destroyer 7\n") ;

        fonction.FirstPrint(grille) ;
        fonction.navireJoueur(grille, 3) ;

        /*
         * Choix des coordonnées pour le SousMarin 1 cases
         */
        System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
        System.out.println("Placer votre SousMarin\n") ;

        fonction.FirstPrint(grille) ;
        fonction.navireJoueur(grille, 1) ;
    }


    public void Ordi(String [][] grilleOrdi) throws IOException
    {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

       Fonction fonction = new Fonction() ;

       /*
        *Positionement du Croiseur � 9 cases
        */	
       fonction.navireOrdi(grilleOrdi, 9) ;
       
       /*
        *Positionement du Croiseur � 7 cases
        */
       fonction.navireOrdi(grilleOrdi, 7) ;
       
       /*
        *Positionement du Croiseur � 3 cases
        */ 
       fonction.navireOrdi(grilleOrdi, 3) ;
       
       /*
        *Positionement du Croiseur � 1 case
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

}
