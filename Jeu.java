/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
public class Jeu {
  private LesPersonnages lesPers;//Les personnages utilisés pour les cartes
  private LesJoueurs lesj;//Les joueurs qui ont été choisis ou ajoutés pour la partie en cours
  private PlateauJeu monPl;//Le plateau de jeu décrit à l’aide d’une instance de la classe « PlateauJeu » 
                        //et qui modélise l’état du jeu
  private Action act; //L’action que va réaliser le joueur (selon les cartes du joueur qui est en train de jouer)
  private int indc; //indice du joueur courant
  
//un constructeur avec paramètres
    public Jeu(LesPersonnages lesPers, LesJoueurs lesj,int nbc){
     this.lesPers= lesPers;
     this.lesj = lesj;
     this.monPl= new PlateauJeu(nbc);
     this.act=null;
     this.indc= nbc;
 }
 //les  accesseurs (get, set) qui permettent de connaître les valeurs des propriétés de l’action
 public int getIndc(){
     return this.indc;
 }
 
 public LesJoueurs getLesJ(){
     return this.lesj;
 }

 public PlateauJeu getPlateau(){
     return this.monPl;
 }
 public void setJoueurCourant(int n){
    this.indc = n;
}
 //méthode qui permet de récuperer le joueur qui est entrain de jouer
 public Joueur getJoueurCourant(){
     return lesj.getJoueur(indc);
 }
 
 //méthode qui permet de récuperer l'indice de type int du joueur suivant 
public int getIndSuivant(int ic){
    return(ic+1)%this.lesj.getNbJoueurs();
}
//methode qui teste si le jeu est terminé (c’est-à-dire si toutes les cartes sont invalidées) 
public boolean finJeu(){
    return this.monPl.jeuVide();
}
// la méthode de traitement d’un tour de jeu lorsque
//le joueur courant a retourné deux cartes identiques, c’est-à-dire a gagné un personnage.
public int traiterTour(Joueur jc,int s){
       int bonus=-1;//Initialisation de la valeur du bonus à -1
       Personnage p = lesPers.getPerso(s);//Récupération du personnage gagné 
       jc.ajoutePersoPaquet(p);//Ajout de ce personnage dans le paquet du joueur courant
       String fp = p.getFamille();//Récupération de la famille du personnage gagné 
        int npj=jc.getPaquet().getPersosFamille(fp).getTaille();//Récupération du nombre de personnages de cette famille 
                                                                //dans le paquet du joueur courant
        int npf=lesPers.getPersosFamille(fp).getTaille();//Récupération du nombre de personnages de cette famille nommée fp
        if (npj==npf)//Si le joueur a une famille complète
        {
            if(fp.equals(jc.getFamille()))//Si cette famille est la famille préférée du joueur,
                    bonus=0;//le bonus vaut 0
       else{
            boolean valide=true;
            for(int i=0;i<this.lesj.getNbJoueurs();i++){
                if(lesj.getJoueur(i).getPaquet().getTaille()==0)//Si les autres joueurs ont des cartes
                    valide=false;                
            }
            if(valide==true){ 
            if (fp.equals("rares")||fp.equals("communs"))//Si la famille gagnée est « rares » ou « communs »
                bonus=1;//le bonus vaut 1
            else if(fp.equals("epique")||fp.equals("legendaires"))//Si la famille gagnée est « legendaires » ou «epiques »

                bonus=2;//le bonus vaut 2
            else 
                bonus=3;//le bonus vaut 3
                }
            }
    }
        return bonus;//Renvoie de la valeur « bonus »
}


}

