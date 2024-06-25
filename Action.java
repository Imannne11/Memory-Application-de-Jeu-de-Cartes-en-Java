/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author msi
 */
public abstract class Action {
    
private Joueur j; // joueur à l'origine de l'action
private String descriptif; //nature de l'action
 private String deroulement; // description de ce qui s’est passé durant l’action

//constructeur par défaut qui initialise les attributs à des valeurs par défaut
public Action(){
this.j=null;
this.descriptif="";//initialisation du descriptif à une chaine de caracteres vide 
this.deroulement="";//initialisation du deroulement à une chaine de caracteres vide
        }

public Action(Joueur j, String d) {
 // constructeur avec deux paramètres (j et d) pour créer des objets de ce type
//dans l’application
this.j=j;
this.descriptif = d;
this.deroulement =""; //initialisation du deroulement à une chaine de caracteres vide
}

// accesseurs (get, set) qui permettent de connaître les valeurs des propriétés(attributs) de l’action
public Joueur getJ(){ 
return this.j;
}
public void setJ (Joueur j){
    this.j=j;
}
public void setDescriptif(String d) {
        this.descriptif = d;
    }
public void setDeroulement(String de) {
        this.deroulement = de;
    }
public String getDescriptif() {
        return this.descriptif;
    }
public String getDeroulement() {
        return this.deroulement;
    }

    //méthode qui permet d’obtenir toutes les informations sur l’action sous
//forme d’une chaîne de caractères
    public String toString() {
        String s="";
        s+="Action effectué par"+this.j.getPseudo()+"\n";//ajout pseudo du joueur à la chaine de caracteres
        s+="Descriptif"+this.descriptif+"\n";//ajout du descriptif à la chaine de caracteres
        s+="Déroulement"+this.deroulement+"\n";//ajout du deroulement à la chaine de caracteres
        return s;//on retourne les information del'action 
    }
    
    //une méthode abstraite « execute() » qui ne prend pas de paramètres mais retourne un entier
//indiquant comment s’est passée l’action
    public abstract int execute();
   
        }