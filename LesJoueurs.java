
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
public class LesJoueurs {
     private ArrayList<Joueur> lstJ;  // lstJ de type ArrayList qui permet de gérer une collection de joueur 
    
     // constructeur par défaut qui permet d'initialiser l'attribut de la classe
    public LesJoueurs() {
        this.lstJ = new ArrayList<Joueur>();//initialise l'attribut lstJ
    }
    
    
     public Joueur getJoueur(int i){
         if(i>=0 && i<this.lstJ.size())//condition pour que i est inferieure a la taille et positif
             return this.lstJ.get(i);//si oui on affiche le joueur d'indice i
         else 
             return null;//si non on retourne le null (rien)
     }
     public int getIndiceJoueur(Joueur j){
         int ind=this.lstJ.indexOf(j);//recupere l'indice du joueur j
         return ind;//retourne l'indice
     }
     public void ajouteJoueur(Joueur j){
         if(j!=null)//verifie si le joueur n'est pas nul
             this.lstJ.add(j);//ajoute le joueur dans le tableau lstJ
     }
     
     public int getNbJoueurs(){
         return this.lstJ.size();//recupere la taille du tableau 
     } 
     
    public Joueur rechJoueur(String p){
        Joueur j = null;//declaration d'un joueur j
        for(int i=0;i<this.getNbJoueurs();i++)//boucle qui permet de parcouir le tableau  lstJ
            if(p == lstJ.get(i).getPseudo())//verifie si le pseudo du joueur est compatible avec p
                j = this.lstJ.get(i);//si oui on l'affecte a l'attribut j
        return j;//retourne j
    } 
    
    public void supprimeJoueur(Joueur j){  // methode pour supprimer le joueur passer en parametre 
        for(int i=0;i<lstJ.size();i++)//parcours de la liste lstJ
        {
            if(lstJ.get(i).getPseudo().equals(j.getPseudo()))//si le joueur d'indice i est celui en parametre 
                    lstJ.remove(i);   //on le supprime de la liste lstJ
   
        }
            
    }
    
    //methode qui permet d'afficher les informations des joueurs de la liste
    public String toString(){
        String s = "";
        for(int i=0; i<getNbJoueurs(); i++)
            s+=i+" "+getJoueur(i).toString();
       return s;
    }
    
    public LesJoueurs getGagnants()   
        {
       int max=getJoueur(0).getScore(); // initialiser max par le score du premier joueur 
        for(int i=1; i<getNbJoueurs();i++) // parcours de la liste 
            if (getJoueur(i).getScore()>max) // si le score du joueur d'indice i est supèrieure a max 
                max=this.getJoueur(i).getScore(); // on affecte le score de ce joueur à max 
        LesJoueurs lst=new LesJoueurs(); // création d'une nouvelle liste 
        for(int i=0; i<getNbJoueurs();i++) // le parcour de la liste
            if (getJoueur(i).getScore()==max) // si le score du joueur d'indice i est égale à max 
                lst.ajouteJoueur(getJoueur(i)); // on ajoute ce joueur à la liste lst 
        return lst; // retourner cette liste 
        }
}
