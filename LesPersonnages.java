
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
public class LesPersonnages {
     private ArrayList<Personnage> persos;//attribut de type arrayList, qui permet de gerer les personnages

    public ArrayList<Personnage> getPersos() {
        return this.persos;//return le tableau persos
    }
    //constructeur par default
    public LesPersonnages() {
      this.persos = new ArrayList<Personnage>();//initialise l'attribut
     }
         
     public int getTaille() { 
         return this.persos.size(); //retourne la taille du tableau
     }
     
    public int getScore(){   
        int sc = 0;//declaration de sc
        for(int i=0; i<getTaille(); i++)
           sc+=getPerso(i).getValeur();//ajoute le score du personnage i du tableau
        return sc;//retourne le score
    }
      
    public void ajoutePerso(Personnage p){
        if(p != null)
            this.persos.add(p);//ajoute un peronnage au tableau persos
    }
    
    public void ajoutePersos(LesPersonnages lp){
        for(int i=0;i<lp.getTaille();i++){//boucle qui parcoure le tableau lp
            Personnage p = lp.getPerso(i);//recupere le personnage i du tableau lp 
            this.persos.add(p);//ajoute ce joueur dans le tableau persos
        }
    }
          
    public Personnage getPerso(int i){
        if (i>=0 && i<this.persos.size())//condition pour que i est inferieure a la taille et positif
             return this.persos.get(i);//retourne le personnage d'indice i 
        else return null;//sinon retourne null
    }
    
    public ArrayList<String> getFamilles(){
        int i=0;//declaration de i
       ArrayList lstFamille = new ArrayList<String>();//declaration d'un nouveau tableau
       for(int a = 0;a<getTaille();a++){
           lstFamille.add(this.persos.get(a).getFamille());//rempli le tableau avec la famille des joueurs du tableau persos
       }
       while(i<lstFamille.size()){//tant que i est a la taille du tableau lstFamille
                int j=0;// attribut de type int initialisé a 0
                boolean bool = false;// attribut de type boolean initialisé a false
                while(i>j && bool == false){
                 if(lstFamille.get(i).equals(lstFamille.get(j))){
                     lstFamille.remove(i);//si la famille d'indice i du tableau lstFamille est egale la famille d'indice j du tableau  
                     bool = true;// fixe boolean a true pour arreter la boucle while 
                 }
                 else
                     j++;// si elles sont différentes on incrémente j
               }
                if(!bool)// si boolean est false
                    i++;//on incremente i
       }
        return lstFamille;//retourne le tableau 
      }
    
    //methode qui retourne une collection de personnages qui ont la meme famille f passée en parametre
    public LesPersonnages getPersosFamille(String f) 
    {   LesPersonnages lp = new LesPersonnages(); //creation d'une nouvelle liste de type Lespersonnages
        for(int i=0; i<getTaille(); i++) //parcours de la liste
            if(getPerso(i).getFamille().equals(f)) // si le personnage d'indice i a la meme famille f passée en parametre
                lp.ajoutePerso(getPerso(i)); // on l'ajoute dans la liste 
        return lp;  //retourner la liste
    }
    
  
   // methode qui supprime le personnage qui est passer en parametre
    public void retirePerso(Personnage p)
    { 
        int i=0; //declaration et initialisation de la varibale i par 0
        boolean trouve = false;  //creation d'une variable trouve et l'initialiser par false
        while(i<getTaille() && !trouve){ //parcourir la liste et s'assurer que trouve est encore false
          if (getPerso(i).getNom().equals(p.getNom())){ // si le personnage d'indice i à le meme pseudo du personnage p passé en parametre
              this.persos.remove(i);  //on le supprime de la lsite
              trouve = true; //affecter true à la variable 
          }
          else i++; // sinon passer à l'autre personnage de la liste
        }      
    }
    
    // methode qui retourne une collection des personnages qui ont la meme famille f passé en parametre 
     //et qui ont éte supprimé de la liste persos
    public LesPersonnages retirePersosFamille(String f)
   { LesPersonnages lcr = new LesPersonnages(); // creation de lcr de type les personnages 
        int i = 0;
        while(i<getTaille()){ // parcours de la liste 
            if (getPerso(i).getFamille().equals(f)) { // si le personnage d'indice i a la meme famille f passée en parametre
                lcr.ajoutePerso(getPerso(i)); //ajouter ce personnage dans la liste crée
                this.persos.remove(i);  //supprimer  le personnage de la liste this.persos
            }
            else i++;//passage à l'autre personnage de la liste
        }
        return lcr;// retourner la liste 
    } 
    
    public void retireCartes()
    { 
           persos.clear();//retire tous les personnages dans le tableau persos
    }
    
	@Override
        //affiche les informations des personnages de le tableau persos
    public String toString() { //redifinion de la methode toString
        String s = "";//variable s de type String 
        for(int i=0; i<getTaille(); i++)// parcours la liste 
            s+=i+"- "+getPerso(i).toString(); //ajout des informations de chaque personnage dans la variable s
       return s;// retourner s
    }
    
    //constructeur avec parametre
    public LesPersonnages(int nc) {
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
      if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ //   6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
       }
    }
    
}