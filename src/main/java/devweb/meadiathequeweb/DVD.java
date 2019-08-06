/*
 * 
 */
package devweb.meadiathequeweb;

import devweb.basedonnee.ManagerBase;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author D. Colombani <dc@webformation.fr>
 */
public class DVD extends Media {

    private int duree;

    /**
     * Get the value of duree
     *
     * @return the value of duree (in seconds)
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Set the value of duree
     *
     * @param duree new value of duree in seconds)
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    public DVD(String Titre, String Auteur, int duree) throws Exception {
        super(Titre, Auteur);
        setDuree(duree);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.duree;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (this.duree != other.duree) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() +" : DVD{" +  "duree=" + duree + '}';
    }
        @Override
    public void enregistre(PrintStream p) {
        StringBuilder sb = new StringBuilder("D");
        sb.append(";");
        sb.append(getTitre());
        sb.append(";");
        sb.append(getAuteur());
        sb.append(";");
        sb.append(duree);
        p.println(sb.toString());
    }
    
        @Override
    public String getRequete() {
        // @todo  mettre le nom de la table en paramtere
        StringBuilder sb = new StringBuilder("INSERT into DVD (auteur, titre, duree)");
        sb.append(" values ('");
        sb.append(getAuteur());
        sb.append("','");
        sb.append(getTitre());
        sb.append("','");
        sb.append(duree);
        sb.append("')");
        return sb.toString();
    }
        public static ArrayList<Media> getAll() {
        ArrayList<Media> catalogue = new ArrayList<>();
        try {
            Connection c = ManagerBase.getManagerBase().getConnection();
            Statement st = c.createStatement();
            String req = "select titre, auteur, duree from dvd";
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                try {
                    DVD l = new DVD(res.getString("titre"), res.getString("auteur"),res.getInt("duree"));
                    catalogue.add(l)
;                } catch (Exception ex) {
                    Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catalogue;
    }
}
