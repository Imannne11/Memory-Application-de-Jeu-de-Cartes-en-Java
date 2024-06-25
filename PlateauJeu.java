/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
public class PlateauJeu {
    private int tab [ ][ ];//attribut qui gere un tableau d'entier
    private int nbp; //attribut de type int 
    private int nblig;//attribuit de type int qui gere le nombre de ligne
    private int nbcol;//attribuit de type int qui gere le nombre de colonne
    
// constructeur standard
    public PlateauJeu(int n){  
        //initialiser les attributs de la classe par des valeurs données
        this.nbp=n;
        this.nblig=(int)(Math.sqrt(nbp*2));
        this.nbcol=nbp*2/nblig;
        this.tab= new int[this.nblig][this.nbcol];
        initPlateauJeu(); //appel de la fonction initPlateau pour l'initialiser
    }

  // constructeur par défaut
    public PlateauJeu(){ 
      //initialiser les attributs de la classe par des valeurs prédefinies 
        this(4); // appel du constructeur standard
    }
    
 
 //accesseur des attributs de la classe
 public int getNblig() { return this.nblig; }
 public int getNbcol() { return this.nbcol; }
 public int getNbp() { return this.nbp; }
 public int getCase(int l, int c) { return tab[l][c]; }
 public int getNbc() { return this.nblig*this.nbcol/2; }

 public void initPlateauJeu(){ //initialiser le tableau
        int k=0;
        for(int i=0;i<this.nblig;i++)//parcours en ligne
            for(int j=0;j<this.nbcol;j++)//parcours en colonnes 
                tab[i][j]=(k++)%this.nbp;
        melange(); //appel de la methode melanger
    }
 
  //methode qui rend les cellules invalides
    public void invalide(int l1, int c1, int l2, int c2){ 
        tab[l1][c1] = -1;
        tab[l2][c2] = -1;
        nbp--; //modifier le nombre de personnage en retranchant 1
        
    }
 
      //methode qui permet de melanger les cases du tableau
 public void melange(){
     for(int i=1;i<=1000;i++)//parcurs de la boucle 
     {
         //donner des valeurs aleatoires au lignes l1 et l2 et au colonnes c1 et c2
     int l1 = (int) (nblig*Math.random());
     int c1 = (int) (nbcol*Math.random());
     int l2 = (int) (nblig*Math.random());
     int c2 = (int) (nbcol*Math.random());
     //echange entre tab[l1][c1] et  tab[l2][c2] à l'aisde d'une variable intermediaire temp
     int tmp = tab[l1][c1];
     tab[l1][c1] = tab[l2][c2];
     tab[l2][c2] = tmp;
 }
 }
 //méthode qui vérifie si les cartes sont valides ( différent de -1)
 public boolean estValide(int ligne, int colonne){
   return tab[ligne][colonne] !=-1;
 }

//méthode qui vérifie s'ils restent des cartes (toutes les cases différent de -1)
 public boolean jeuVide(){
    return nbp==0; 
}
 
  //methode qui invalide toutes les cases du tableau
    public void termineJeu(){ 
        for(int l=0;l<nblig;l++)//parcours de la boucle 
            for(int c=0;c<nbcol;c++)
                tab[l][c] = -1;
        nbp=0; //rendre le nombre du personnage 0
    }
 
 
 
}
