/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
public class Bataille extends Action {
    private Joueur adversaire;//attribut nommé « adversaire » de type « Joueur » pour représenter l’adversaire du joueur couran
    
    //constructeur avec deux paramètres (le joueur courant et l’adversaire)
    public Bataille(Joueur jc, Joueur ja){
        super(jc,"Bataille");//Ce constructeur appelle le constructeur avec paramètres de la classe « Action »
                        //avec comme valeur de descriptif, la valeur « Bataille ».
        this.adversaire=ja;//initialisation de l'attribut adversaire 
    }
    
    //L’accesseur en lecture de l'attribut adversaire 
    public Joueur getAdversaire(){
        return this.adversaire;
    }
    
    public int execute(){
        int res=0;
        if(this.getJ().getPaquet().getTaille() > 0 && this.adversaire.getPaquet().getTaille() >0)
        //Si le joueur courant et son adversaire possèdent encore des cartes
        {
        res = -1;//Initialisation de la valeur du résultat à -1
        Personnage c1 = this.getJ().getPaquet().getPerso(0);//Récupération de la 1ère carte du paquet du joueur courant dans une instance nommée
                                                                //c1, de type Personnage
        Personnage c2 = this.adversaire.getPaquet().getPerso(0);//Récupération de la 1ère carte du paquet de l’adversaire dans une instance nommée c2,
                                                    //de type Personnage
        this.getJ().getPaquet().retirePerso(c1);//Suppression de la carte c1, du paquet du joueur courant
        this.adversaire.getPaquet().retirePerso(c2);//Suppression de la carte c2, du paquet de l’adversaire
        if(c1.getValeur() == c2.getValeur())
            //Si les valeurs des deux cartes sont identiques
        {
            res = 0;//le résultat est affecté à 0
            //chacune des cartes est remise à la fin du paquet du joueur auquel elle appartenait
            this.getJ().getPaquet().ajoutePerso(c1);
            this.adversaire.getPaquet().ajoutePerso(c2);
        }
        else if(c1.getValeur() > c2.getValeur())//Si la valeur de c1 est supérieure à celle de c2
        {
            res = 1;//Le résultat est affecté à 1
            //Les deux cartes sont ajoutées au joueur courant (les ajouts sont faits par défaut en
            //fin de liste, ce qui simule le fait de mettre une carte en dessous du paquet)
            this.getJ().getPaquet().ajoutePerso(c1);
            this.getJ().getPaquet().ajoutePerso(c2);
        }
        else//sinon
        {
            res = 2;//Le resulatat est affecté a 2
            //Les deux cartes sont ajoutées à l’adversaire
            this.adversaire.getPaquet().ajoutePerso(c1);
            this.adversaire.getPaquet().ajoutePerso(c2);
        }
    }
    if(this.getJ().getPaquet().getTaille() == 0 && this.adversaire.getPaquet().getTaille() == 0)
//Si le joueur courant ou l’adversaire n’a plus de cartes
    { //La valeur du déroulement (attribut de la classe) est affectée à un message indiquant quel joueur 
       //a joué contre qui et qui a gagné (sous forme d’une chaine de caractères).
        String s="";
        s+="Bataille "+this.getJ().getPseudo()+"\n";
        s+="contre "+this.adversaire.getPseudo()+"\n";
        if(this.getJ().getPaquet().getTaille() > 0)
            s+="gagnée !" +"\n";
        else
            s+="perdue !"+"\n";
        this.setDeroulement(s);
    }
    return res;//La valeur du résultat est renvoyée
    }
}
