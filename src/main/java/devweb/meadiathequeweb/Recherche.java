/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devweb.meadiathequeweb;

/**
 *
 * @author Administrateur
 */
public class Recherche {

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    private String auteur="";
    private String type="";
    private String titre="";

    @Override
    public String toString() {
        return "Recherche{" + "auteur=" + auteur + ", type=" + type + ", titre=" + titre + '}';
    }
 

}
