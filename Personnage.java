
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
public class Personnage {
    private String famille; //attribut de type String qui gere la famille du personnage
    private String nom;//attribut de type String qui gere le nom du personnage
    private int valeur;//attribut de type int qui gere le score du personnage
    private Image photo;//attribut de type Image qui gere la photo du personnage

    //constructeur qui sert à initialiser les attributs de la classe par des valeurs données en parametres
    public Personnage(String f, String nom, int v) {
        this.famille = f;
        this.nom = nom;
        this.valeur = v;
        this.photo =  new ImageIcon(getClass().getResource("/img/"+nom+".jpg")).getImage();
    }
    // constructeur par défaut qui sert a initialiser les attributs de la classe par des valeurs prédefinies 
     public Personnage() { 
        this.famille = "anonyme";//famille vide 
        this.nom = "anonyme";//nom vide 
        this.valeur = 0;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();//initialisation de l'attribut photo 
    }
    //accesseur en lecture et en ecriture pour les attributs de la classe Joueur
    public void setPhoto(Image p) {
        this.photo = p;
    }

    public String getFamille() {
        return this.famille;
    }

    public int getValeur() {
        return valeur;
    }

    public String getNom() {
        return nom;
    }

    public Image getPhoto() {
        return photo;
    }  

    public void setFamille(String f) {
        this.famille = f;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public void setValeur(int v) {
        this.valeur = v;
   }
   
     public String toString(){ // redifinition de la methode toString pour afficher les informations du personnage 
        String res = this.nom+" de la famille "+this.famille+", valeur: "+this.valeur;
        return res;//retourne les informations du personnage sous forme de chaine de caractères 
        
    }

   
    
    
    
}
 