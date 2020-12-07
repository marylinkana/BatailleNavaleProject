/*******************************************************************************************

 Nom du programme	: Facile.java
 Auteur				: Zufferey Matthieu, 1hc			
 Version 			: 2.0
 Date				: 24 mars 2002			
 Description		: C'est le niveau facile de la bataille navale
 Pr�conditions		: Aucune
 
********************************************************************************************/

import java.io.* ;

public class Facile
	{

	public static void main(String [] args) throws IOException
		{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		Methode fonction = new Methode() ;
		
		//Cr�ation de toutes les variables	
		String grille[][] = new String[11][11] ;
        String grilleOrdi[][] = new String[11][11] ;
        String grilleCachee[][] = new String[11][11] ; 
        String vous = "";
        String adversaire = "" ;
        int ligne = 0 ;
        int colonne = 0 ; 
        int coordonnee = 0 ;  
        int compteur = 1 ;
        int touche = 0 ;
        int toucheA = 0 ; 
        boolean erreur ;

        
        
	    //Cr�ation des deux grilles de jeu
	    //D'abord les �toiles
	    for (int i = 0 ; i < 11 ; i++)
	        {
	        for (int j = 0 ; j < 11 ; j++)
	        	{
	        	grille[i][j] = "*" ;
	        	grilleOrdi[i][j] = "*" ;
	        	grilleCachee[i][j] = "*" ;
	        	}	
	        }
	     
	    //Puis les nombres                    
		for (int i = 0 ; i < 11 ; i++) 
			{
			grille[i][0] = i + "" ;
			grille[0][i] = i + "" ;			
			grilleOrdi[i][0] = i + "" ;
			grilleOrdi[0][i] = i + "" ;	
			grilleCachee[i][0] = i + "" ;
			grilleCachee[0][i] = i + "" ;			
			}

		/**********************
		 Les b�teaux de l'ordi
		***********************/

		//Methode placant les bateaux de l'ordi sur sa grille
		fonction.Ordi(grilleOrdi) ;
				


		//Titre de la partie
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n======================================") ;
		System.out.println("JOUER CONTRE L'ORDINATEUR, mode facile") ;
		System.out.println("======================================") ;
		
		//Nom du joueur 1
		System.out.println("\n\nEntrez votre nom") ;
		vous = in.readLine() ;	
		System.out.println() ;


		/**********************
		Les b�teaux du joueur 1
		**********************/


		//Appelle la fonction qui g�re le placement des bateaux du joueur 1	
		fonction.User(grille, vous) ;			

		//Demande entre le joueur 1 et l'ordi pour savoir qui commence
		do
			{
			erreur = false ;	
				
			try
				{
				do
					{
					System.out.println("\nQui commence : 1. "+ vous + "    2. l'ordi") ;
					compteur = Integer.parseInt(in.readLine()) ;
					}
				while (compteur < 1 || compteur > 2) ;
				}
			catch (NumberFormatException e)
				{
				erreur = true ;	
				}
			}
		while(erreur != false) ;

		//Boucle qui r�p�te tant que tout les b�teaux du joueur 1 ou du joueur 2 sont
		//coul�s	
		do
			{
			//Affiche un titre			
			System.out.println("   " + vous.toUpperCase() + "              " + "l'ordi" + "\n") ;
			
			//Affiche les deux grilles de jeu			
			fonction.SecondPrint(grille, grilleCachee) ;		
							
			//Compteur mod 2 pour que les joueurs jouent chacun � leur tour.				
			if (compteur % 2 == 1) 
				{	
				do
					{
					//Appelle la fonction d'entr�e de coordonn�e pour la ligne du joueur 
					ligne = fonction.Ligne(ligne) ;	
					//Puis de la colonne
					colonne = fonction.Colonne(colonne) ;
					}
				while (grilleCachee[ligne][colonne] == " " || grilleCachee[ligne][colonne] == "X") ;
				
				//Touch� ou � c�t�, suivant le cas
				if (grilleOrdi[ligne][colonne] == "*")
					{
					grilleCachee[ligne][colonne] = " " ;	
					}	
				else if (grilleOrdi[ligne][colonne] == "\04")
						{
						grilleCachee[ligne][colonne] = "X" ;
						toucheA = toucheA + 1 ;
						}
							
				compteur = compteur + 1 ;	
				}
			else
				{
				do
					{
					//Appelle la fonction d'entr�e de coordonn�e pour la ligne de l'ordi
					ligne = (int)(Math.random() * (10) + 1) ;
					//Puis la colonne
					colonne = (int)(Math.random() * (10) + 1) ;	
					}					
				while(grille[ligne][colonne] == " " || grille[ligne][colonne] == "X") ;
	
				//Touch� ou � c�t�, suivant le cas
				if (grille[ligne][colonne] == "*")
					{
					grille[ligne][colonne] = " " ;	
					}	
				else if (grille[ligne][colonne] == "\04")
						{
						grille[ligne][colonne] = "X" ;
						touche = touche + 1 ;
						}
				compteur = compteur + 1 ;
				
				}	 		
			}
		while(touche != 17 && toucheA != 17) ;
		
		
		//Vous dis si vous avez perdu ou gagner		
		if (toucheA == 17) 
			{
			fonction.SecondPrint(grille, grilleCachee) ;
			System.out.println("\n" + vous + " : vous avez gagne\n") ;	
			}
		else
			{
			fonction.SecondPrint(grille, grilleCachee) ;
			System.out.println("\n" + vous + " : vous avez perdu\n") ;
			}	
							
	}
}

