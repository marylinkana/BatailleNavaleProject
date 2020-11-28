/*******************************************************************************************

 Nom du programme	: InfoJeu.java
 Auteur				: Zufferey Matthieu, 1hc
 Version 			: 2.0			
 Date				: 10 mars 2002			
 Description		: Information sur le jeu bataille navale
 Préconditions		: Aucune
 
********************************************************************************************/

import java.io.* ;

public class InfoJeu
	{

	InfoJeu() throws IOException
		{
          	
           	System.out.println("==========") ;				
			System.out.println(" INFO JEU") ;
			System.out.println("==========\n") ;
			System.out.println("\n- niveau facile :") ;
			System.out.println("\tUn peu trop facile, si vous perdez vous etes mauvais.");
			System.out.println("\tL'ordi choisit aleatoirement les coordonnees. Une fois qu'il");
			System.out.println("\ttouche le bateau, il ne va pas chercher a cote mais recherchera");
			System.out.println("\ta nouveau aleatoirement.");
			System.out.println("\n- niveau moyen :") ;
			System.out.println("\tAssez facile, si vous perdez vous etes toujours mauvais.");
			System.out.println("\tL'ordi choisit aleatoirement les coordonnees mais une fois qu'il");
			System.out.println("\ttouche le bateau, il cherchera a cote mais vous fera");
			System.out.println("\tquelques cadeaux, vous fairez");
			System.out.println("\n- niveau difficile :") ;
			System.out.println("\tEn cours de developpement\n\n") ;   
        
		}
						
	}
