
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
//cette classe represente un joueur 
public class Joueur {
    //Les arttributs qui represent les proprietes d'un joueur
    private String pseudo;  // pseudo du joueur 
    private String famille; // famille du joueur 
    private LesPersonnages paquet; // paquet de type les personnages qui permet de stocker les personnages gagnées par le joueur 
    private ImageIcon photo; // la photo du joueur 
    
    //accesseur en lecture et en ecriture des attributs de la classe Joueur
    public String getPseudo() { 
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFamille() {
        return this.famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public LesPersonnages getPaquet() {
        return this.paquet;
    }

    public void setPaquet(LesPersonnages paquet) {
        this.paquet = paquet;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

// constructeur avec parametre ,on donne comme parametre le pseudo et le nom
    //sert a initialiser les attributs de la classe par des valeurs données
    public Joueur(String famille, String pseudo) 
    {
        this.pseudo = pseudo;//affecte la valeur pseudo passé en parametre a l'attribut
        this.famille = famille;
        this.paquet = new LesPersonnages();//initialise l'attribut avec le constructeur par defaut de la classe LesPersonnages
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));
    }
    
     // constructeur par défaut sert a initialiser les attributs de la classe par des valeurs prédefinies 
     public Joueur(){ 
        this.pseudo="";//pseudo vide 
        this.famille="";//famille vide 
        paquet=new LesPersonnages();// creation de paquet de type LesPersonnages 
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));//initialisation de l'attribut photo
    }
    
    // redifinition de la méthode toString afin d'afficher les informations du joueur
    public String toString(){ 
        String s="";
        s+="Pseudo " +this.pseudo+"\n";
        s+="Nom de famille préféré " +this. famille+"\n";
        s+="Paquet de personage " +this. paquet+"\n";
        return s;//retourne les informations du joueur sous forme de chaine de caractères 
}
    
    public int getScore(){
        return this.paquet.getScore();//retourne le score de tous les personages dans le paquet
    }
    
     // methode qui sere ajouter un nouveau personnage au paquet du joueu
    public void ajoutePersoPaquet(Personnage p) {
         this.paquet.ajoutePerso(p);//ajoute un personnage au paquet
 }
    
    public void initPaquetTest(){ //methode qui permet d'ajouter des personnages afin de tester la jdialog visupersonnageDlg
    Personnage p1 = new Personnage("communs", "assault-trooper", 10);
    ajoutePersoPaquet(p1);//ajoute le personnage au paquet
    Personnage p2 = new Personnage("communs", "commando", 20);
    ajoutePersoPaquet(p2);
    Personnage p3 = new Personnage("rares", "absolute-zero", 10);
    ajoutePersoPaquet(p3);   
    }
    
}
