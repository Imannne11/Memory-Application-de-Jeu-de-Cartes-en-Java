/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
    public class Transfert extends Action {
        private Joueur cible;//de type Joueur est qui est celui à qui les cartes vont être prises
        private String fp; //famille de la carte sélectionnée
        private LesPersonnages cartesTransferees; // de type LesPersonnages et qui désigne toutes les cartes de la famille choisies prises à la cible 
       
        //constructeur pardefaut 
        public LesPersonnages getCartesTransferees() {
            return this.cartesTransferees;
        }
        //getter de l'attribut cible
        public Joueur getJoueurCible(){ return this.cible; }
        
        // constructeur avec parametres 
        public Transfert(Joueur j, Joueur a, String f) {
            super(j, "Transfert de cartes");//appel du constructeur de la classe super 
            //initialisation des attributs avec les valeurs en parametres 
            this.cible = a;
            this.fp=f;
            this.cartesTransferees= new LesPersonnages();
        }
        
        //methode qui assure le transfert de cartes entre le joueur courant et la cible
        public int execute(){
            int res;
            if(this.fp !=null)//si la famille « fp » existe et n’est pas null 
            { //on  retire les cartes de la famille « fp » du paquet du joueur cible en les stockant dans l’instance cartestransferees 
                this.cartesTransferees = this.cible.getPaquet().getPersosFamille(fp);
                this.getJ().getPaquet().ajoutePersos(cartesTransferees);//On ajoute dans le paquet du joueur courant les cartes qui ont été retirées du paquet du joueur cible
                this.setDeroulement(this.getJ().getPseudo()+ " a pris la famille de cartes "+ this.fp+" de "+this.cible.getPseudo());
                //•	On affecte à l’attribut déroulement un message indiquant quel joueur a pris quelle famille de cartes à quel autre joueur
            }
            if(this.cartesTransferees.getTaille() == 0)//si aucune carte n’a été transférée
                res = 0;//on renvoie 0
            else//sinon 
                res = this.cartesTransferees.getTaille();//on renvoie  le nombre de cartes transférées.
            
            return res;//la méthode renvoie res à la fin 
    }
    }