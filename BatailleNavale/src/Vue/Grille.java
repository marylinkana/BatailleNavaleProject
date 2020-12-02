/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author nabil
 */
public class Grille {
    
    private int hauteur;
    private int largeur;
    private int[][] cases;

    public Grille() {

    }
  

    /** 
     * Ci-dessous une fonction qui permet d'évaluer la case correspondant aux 
     * coordonnées j,k .
     */
    public int Case(Grille grille,int j,int k)
    {
        return cases[j][k];
    }

    /**
     * Fonction permettant de changer la valeur d'une case
     */

    public void changerCase(Grille grille,int j,int k,int valeur)
    {
        cases[j][k] = valeur;
    }

    /** 
     * Fonction gérant les symboles, le symbole * correspond à un débris
     */

    /**
     * public char symbole(int x)
    {
        if(x == Mer || x == Navire)
        {
            return’~’;
        }
        else if(x == Touche)
        {
            return’X’;
        }
        
    }

    /** 
     * Fonction gérant l'affichage de la grille
     */

    public void afficherGrille(Grille grille)
    {
        for(int j=0; j<14; ++j)
        {
            for(int k=0; k<14; ++k)
            {
                System.out.print("~");
            }
            System.out.println();
        }
    }

    /** 
     * Fonction initialisant une grille en début de partie
     * avec des ~~
     */

    public void initialiserGrille(Grille grille)
    {
        for(int j=0; j<14; ++j)
        {
            for(int k=0; k<14; ++k)
            {
                Case(grille,j,k);
            }
        }
    }
    
    public static void main(String[] args){
        System.out.println("bataillenavalenab.Grille.main()");
         char[][] gr = new char[15][15];
        for (int i = 0;i < gr.length+1; i++) {
            if(i<9){
                System.out.print(i + "  ");
            }
            else System.out.print(i + " ");
        }
        System.out.print("          ");
        
        for (int k = 0;k < gr.length+1; k++) {
            if(k<9){
                System.out.print(k + "  ");
            }
            else System.out.print(k + " ");
        }
        System.out.println();
        
        
        for (int i = 0;i < gr.length; i++) {
            if(i<9){
                System.out.print(i+1 + "  ");
            }
            else System.out.print(i+1 + " ");
            for (int j = 0;j < gr.length;j++) {
               gr[i][j] = '~';
               System.out.print(gr[i][j] + "  ");
            }
            System.out.print("         ");
            
            if(i<9){
                System.out.print(i+1 + "  ");
            }
            else System.out.print(i+1 + " ");
            for (int j = 0;j < gr.length;j++) {
               gr[i][j] = '~';
               System.out.print(gr[i][j] + "  ");
            }
            System.out.println();
        }  
    }
    
}


