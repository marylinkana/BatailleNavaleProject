package Vue;
import Modele.Coordonnee;
import Modele.Croiseur;
import Modele.Cuirasse;
import Modele.Destroyer;
import Modele.SousMarin;
import java.io.* ;

public class Jeux{
    
    /*
     * Permet de génerer et de jouer une partie
     */
    public Jeux() throws IOException{
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        Grille fonction = new Grille();

        String grille[][] = new String[16][16] ;
        String grilleOrdi[][] = new String[16][16] ;
        String grilleCachee[][] = new String[16][16] ; 
        String nomDuJoueur = "";
        String adversaire = "" ;
        int ligne = 0 ;
        int colonne = 0 ; 
        int coordonnee = 0 ;  
        int compteur = 1 ;
        int touche = 0 ;
        int toucheA = 0 ;
        int col = 0 ;
        int ln = 0 ;
        int choix = 0 ;
        int ok  = 0 ;
        int continuer = 0 ; 
        int ligneCiblee = 0 ;
        int colonneCiblee = 0 ;

        /*
         * Création des 2 grilles
         */
        for (int i = 0 ; i < 16 ; i++){
            for (int j = 0 ; j < 16 ; j++){
                grille[i][j] = "~  " ;
                grilleOrdi[i][j] = "~  " ;
                grilleCachee[i][j] = "~  " ;              
            }
        }
        for (int i = 0 ; i < 16 ; i++) {
            if(i<10){
                grille[i][0] = i + "" ; // nombres en Abscisse
                grille[0][i] = i + "  " ; // nombres en Ordonnee			
                grilleOrdi[i][0] = i + "" ;// nombres en Abscisse
                grilleOrdi[0][i] = i + "  " ; // nombres en Ordonnee	
                grilleCachee[i][0] = i + "" ; // nombres en Abscisse
                grilleCachee[0][i] = i + "  " ; // nombres en Ordonnee
            }
            else{
                grille[i][0] = i + "" ; // nombres en Ordonnee
                grille[0][i] = i + " " ; // nombres en Ordonnee			
                grilleOrdi[i][0] = i + "" ; // nombres en Ordonnee
                grilleOrdi[0][i] = i + " " ; // nombres en Ordonnee	
                grilleCachee[i][0] = i + "" ; // nombres en Ordonnee
                grilleCachee[0][i] = i + " " ; // nombres en Ordonnee
            }
			
        }

        /*
         * Placement des bateaux de l'ordinateur
         */
        fonction.Ordi(grilleOrdi) ;

        System.out.println("\nJOUER CONTRE L'ORDINATEUR,") ;

        System.out.println("\nEntrez votre nom") ;
        nomDuJoueur = in.readLine() ;	
        System.out.println() ;
        
        /*
         * Placement des bateaux du joueur
         */
        fonction.Joueur(grille, nomDuJoueur) ;			

        do
        {

            System.out.println("   " + nomDuJoueur.toUpperCase() + "                                                               " + "BOOT" + "\n") ;
            fonction.doubleGrille(grille, grilleCachee) ;		

            if (compteur % 2 == 1){	
                do
                {
                    int action;
                    int taille;
                    do
                    {
                        System.out.println("\nAction : \n 1: Tirer \n 2: Déplacer") ;
                        action = Integer.parseInt(in.readLine()) ;
                    }
                    while (action != 1 && action != 2) ;
                    
                    if(action == 1){
                        ligneCiblee = fonction.abscisse() ;	
                        colonneCiblee = fonction.ordonnee() ;
                    }
                    else{
                        do
                        {
                            System.out.println("\nEntez la taille du navire à déplacer") ;
                            taille = Integer.parseInt(in.readLine()) ;
                        }
                        while (taille!=9 && taille!=7 && taille!=3 && taille!=1);
                        fonction.deplacerNavire(grille, taille);
                    }
                                        
                }
                while (grilleCachee[ligneCiblee][colonneCiblee] == "   " || grilleCachee[ligneCiblee][colonneCiblee] == "X  ") ;

                if (grilleOrdi[ligneCiblee][colonneCiblee] == "~  ")
                {
                    grilleCachee[ligneCiblee][colonneCiblee] = "   " ;	
                }
                else if (grilleOrdi[ligneCiblee][colonneCiblee] == "   ")
                {
                    grilleCachee[ligneCiblee][colonneCiblee] = "   " ;	
                }	
                else
                {
                    grilleCachee[ligneCiblee][colonneCiblee] = "X  " ;
                    toucheA = toucheA + 1 ;
                }
                compteur = compteur + 1 ;	
            }
            else
            {
                if(continuer == 0) 
                {
                    do
                    {
                        ligne = (int)(Math.random() * (15) + 1) ;
                        colonne = (int)(Math.random() * (15) + 1) ;	
                    }					
                    while(grille[ligne][colonne] == "   " || grille[ligne][colonne] == "X  ") ;


                    if (grille[ligne][colonne] == "~  ")
                    {
                        grille[ligne][colonne] = "   " ;
                        continuer = 0 ;	
                    }
                    else if (grille[ligne][colonne] == "   ")
                    {
                        grille[ligne][colonne] = "   " ;
                        continuer = 0 ;	
                    }	
                    else
                    {
                        grille[ligne][colonne] = "X  " ;
                        touche = touche + 1 ;
                        continuer = 1 ;
                        ln = ligne ;
                        col = colonne ;
                        choix = 1 ;
                    }
                }
                else
                {
                    if (choix == 1 && ln - 1 == 0)
                    {
                        choix = choix + 1 ;	
                        ln = ligne ;
                        col = colonne ;
                        continuer = 1; 
                    } 
                    if (choix == 2 && col - 1 == 0)
                    {
                        choix = choix + 1 ;	
                        col = colonne ;
                        ln = ligne ;
                        continuer = 1 ;
                    }
                    if(choix == 3 && col + 1 == 16)
                    {
                        choix = choix + 1 ;	
                        col = colonne ;
                        ln = ligne ;
                        continuer = 1 ;	
                    }
                    if(choix == 4 && ln + 1 == 16)
                    {
                        choix = 0 ;	
                        col = colonne ;
                        ln = ligne ;
                        continuer = 0 ;	
                    }	 			

                    switch (choix) 
                    {
                        case 1 :
                            if (grille[ln-1][col] == "~  ")
                            {
                                grille[ln-1][col] = "   " ;
                                choix = choix + 1 ;
                                ln = ligne ;
                                col = colonne ;	
                                continuer = 1;								
                            }
                            else if(grille[ln-1][col] == "   " || grille[ln-1][col] == "X  ")
                            {
                                ln = ln - 1 ;
                                col = col ;		
                            }
                            else
                            {
                                grille[ln-1][col] = "X  " ;
                                touche = touche + 1 ;
                                ln = ln - 1 ;
                                col = col ;
                                continuer = 1;	
                            }
                        break ;

                        case 2 :
                            if (grille[ln][col-1] == "~  ")
                            {
                                grille[ln][col-1] = "   " ;
                                choix = choix + 1 ;	
                                ln = ligne ;
                                col = colonne ;	
                                continuer = 1;						
                            }
                            else if(grille[ln][col-1] == "   " || grille[ln][col-1] == "X  ")
                            {
                                ln = ln ;
                                col = col - 1 ;		
                            }
                            else
                            {
                                grille[ln][col-1] = "X  " ;
                                touche = touche + 1 ;
                                ln = ln ;
                                col = col - 1 ;
                                continuer = 1;	
                            }
                        break ;	

                        case 3 :
                            if (grille[ln][col+1] == "~  ")
                            {
                                grille[ln][col+1] = "   " ;
                                choix = choix + 1 ;	
                                ln = ligne ;
                                col = colonne ;
                                continuer = 1;									
                            } 
                            else if(grille[ln][col+1] == "   " || grille[ln][col+1] == "X  ")
                            {
                                ln = ln ;
                                col = col + 1 ;		
                            }
                            else 
                            {
                                grille[ln][col+1] = "X  " ;
                                touche = touche + 1 ;
                                ln = ln ;
                                col = col+1 ;
                                continuer = 1;	
                            }
                        break ;	

                        case 4 :
                            if (grille[ln+1][col] == "~  ")
                            {
                                grille[ln+1][col] = "   " ;
                                choix = 0 ;
                                ok = 0 ;
                                ln = ligne ;
                                col = colonne ;	
                                continuer = 0 ;								
                            }
                            else if(grille[ln+1][col] == "   " || grille[ln+1][col] == "X  ")
                            {
                                ln = ln + 1;
                                col = col ;		
                            }
                            else
                            {
                                grille[ln+1][col] = "X  " ;
                                touche = touche + 1 ;
                                ln = ln + 1 ;
                                col = col ;	
                                continuer = 1;	
                            }
                        break;	 
                    }
                }
                compteur = compteur + 1;
            }
        }
        while(touche != 2 && toucheA != 2);
        
        fonction.doubleGrille(grille, grilleCachee);
        fonction.doubleGrille(grille, grilleOrdi);
        if (toucheA == 2) 
        {
            System.out.println(nomDuJoueur + " : WINNER");
        }
        else
        {
            System.out.println(nomDuJoueur + " : GAME OVER");
        }	
    }
    
}

