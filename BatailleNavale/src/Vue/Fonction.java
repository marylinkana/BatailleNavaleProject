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
     * ORGANISE LES GRILLES
     */
    public void firstPrint(String a [][])
    {
        for (int i = 0 ; i < 16 ; i++){
            for (int j = 0 ; j < 16 ; j++){
                if (j == 0 && i == 0){
                    System.out.print("    ") ;
                }
                else if(j == 0 && i > 9){
                    System.out.print(a[i][j] + "  ") ;
                }                
                else if(j == 0 && i < 10){
                    System.out.print(a[i][j] + "   ") ;
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
     * Positionne les grilles cote à cote
     */
    public void secondPrint(String a [][], String b [][])
    {
        for (int i = 0 ; i < 16 ; i++)
        {
            for (int j = 0 ; j < 16 ; j++)
            {
                if (j == 0 && i == 0){
                    System.out.print("    ") ;
                }
                else if(j == 0 && i > 9){
                    System.out.print(a[i][j] + "  ") ;
                }                
                else if(j == 0 && i < 10){
                    System.out.print(a[i][j] + "   ") ;
                }
                else{
                    System.out.print(a[i][j]) ;
                }
            }

            System.out.print("                 ") ;

            for (int k = 0 ; k < 16 ; k++)
            {
                if (k == 0 && i == 0){
                    System.out.print("    ") ;
                }
                else if(k == 0 && i > 9){
                    System.out.print(b[i][k] + "  ") ;
                }                
                else if(k == 0 && i < 10){
                    System.out.print(b[i][k] + "   ") ;
                }
                else{
                    System.out.print(b[i][k]) ;
                }
            }
            System.out.println() ;
        }
        System.out.println() ;
     }
     
    /*
     * Place les Navires du joueur
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
                                if(grille[navire.getPosition().getAbscisse()][j] != "~  ")
                                {
                                    erreur = 0 ;
                                    i = navire.getPosition().getOrdonne() + nbre ;
                                }
                            }

                            if (erreur != 0)
                            {
                                for (int j = navire.getPosition().getOrdonne() ; j < (navire.getPosition().getOrdonne() + nbre) ; j++)
                                {
                                    grille[navire.getPosition().getAbscisse()][j] = navire.getSymbole();
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
                                if(grille[j][navire.getPosition().getOrdonne()] != "~  ")
                                {
                                    erreur = 0 ;
                                    i = navire.getPosition().getAbscisse() + nbre ;
                                }
                            }

                            if (erreur != 0)
                            {
                                for (int j = navire.getPosition().getAbscisse() ; j < (navire.getPosition().getAbscisse() + nbre) ; j++)
                                {
                                    grille[j][navire.getPosition().getOrdonne()] = navire.getSymbole() ;
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
        
        Navire navire = new Navire();      
        
        do
        {
           int i = 0 ;
           int sens = (int)(Math.random() * (2) + 1) ;
           int abscisse = (int)(Math.random() * (15) + 1) ;
           int ordonnee = (int)(Math.random() * (15) + 1) ;
           
           if(nbre == 9){
            navire = new Croiseur(sens, new Coordonnee(abscisse, ordonnee));
            }        
            if(nbre == 7){
                navire = new Cuirasse(sens, new Coordonnee(abscisse, ordonnee));
            }        
            if(nbre == 3){
                navire = new Destroyer(sens, new Coordonnee(abscisse, ordonnee));
            }        
            if(nbre == 1){
                navire = new SousMarin(sens, new Coordonnee(abscisse, ordonnee));
            }

           erreur = 1 ;

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
                           i = navire.getPosition().getOrdonne() ;

                           for (int j = navire.getPosition().getOrdonne() ; j < (navire.getPosition().getOrdonne() + nbre) ; j++)
                           {
                               if(grille[navire.getPosition().getAbscisse()][j] != "~  ")
                               {
                                   erreur = 0 ;
                                   i = navire.getPosition().getOrdonne() + nbre ;
                               }
                           }

                           if (erreur != 0)
                           {
                               for (int j = navire.getPosition().getOrdonne() ; j < (navire.getPosition().getOrdonne() + nbre) ; j++)
                               {
                                   grille[navire.getPosition().getAbscisse()][j] = navire.getSymbole() ;

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
                               if(grille[j][navire.getPosition().getOrdonne()] != "~  ")
                               {
                                   erreur = 0 ;
                                   i = abscisse + nbre ;
                               }
                           }

                           if (erreur != 0)
                           {
                               for (int j = navire.getPosition().getAbscisse() ; j < (navire.getPosition().getAbscisse() + nbre) ; j++)
                               {
                                   grille[j][navire.getPosition().getOrdonne()] = navire.getSymbole() ;
                               }
                               i = navire.getPosition().getAbscisse() + nbre ;
                           }
                       }
                       while(i < navire.getPosition().getAbscisse() + nbre );
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
        fonction.firstPrint(grille) ;
        fonction.navireJoueur(grille, 9) ;

        /*
         * Choix des coordonnées pour les Cuirasses 7 cases
         */
        for(int i=0; i<2; i++){
            System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
            System.out.println("Placer vos Cuirassés\n") ;
            fonction.firstPrint(grille) ;
            fonction.navireJoueur(grille, 7) ; 
        }
        

        /*
         * Choix des coordonnées pour les 3 Destroyers à 1 cases
         */   
        for(int i=0; i<3; i++){
            System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
            System.out.println("Placer vos Destroyer\n") ;
            fonction.firstPrint(grille) ;
            fonction.navireJoueur(grille, 3) ;  
        }
        
        /*
         * Choix des coordonnées pour les 4 SousMarins à 1 cases
         */
        for(int i=0; i<4; i++){
            System.out.println("\n\n\n\n\n" + vous.toUpperCase() + " : COMPLETEZ VOTRE GRILLE DE JEU\n") ;
            System.out.println("Placer vos SousMarins\n") ;
            fonction.firstPrint(grille) ;
            fonction.navireJoueur(grille, 1) ;
        }
    }

    /*
     * Positionnement aléatoire des navire de l'ordinateur
     */
    public void Ordi(String [][] grilleOrdi) throws IOException
    {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;

       Fonction fonction = new Fonction();

       /*
        *Positionement du Croiseur � 9 cases
        */	
        fonction.navireOrdi(grilleOrdi, 9);
       
       /*
        *Positionement des Cuirasse � 7 cases
        */
        for(int i = 0; i < 2; i++){
            fonction.navireOrdi(grilleOrdi, 7);
        }
       
       /*
        *Positionement des Destroyer � 3 cases
        */ 
        for(int i = 0; i < 3; i++){
            fonction.navireOrdi(grilleOrdi, 3);
        }
       
       /*
        *Positionement des SousMarin � 1 case
        */
        for(int i = 0; i < 4; i++){
            fonction.navireOrdi(grilleOrdi, 1) ;
        }
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
