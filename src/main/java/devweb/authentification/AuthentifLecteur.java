/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devweb.authentification;

import devweb.basedonnee.ManagerBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Administrateur
 */
public class AuthentifLecteur {
    public static boolean isLecteur(String nom, String mdp) {
        Connection c = ManagerBase.getManagerBase().getConnection();
        try {
            Statement stmt = c.createStatement();
            String requete = "select count(*) from lecteur where identifiant ='" 
                    + nom + "' and motdepasse = '" + mdp + "'";
            ResultSet resultat = stmt.executeQuery(requete);
            if (resultat.next()) {
                int nb = resultat.getInt(1);
                return nb == 1; 
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(AuthentifLecteur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
