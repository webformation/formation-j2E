
/*
 * 
 */
package devweb.meadiathequeweb;

import java.io.PrintStream;

/**
 *
 * @author D. Colombani <dc@webformation.fr>
 */
/*
 * 
 */
public class Livre extends Media {

    private int nbPage;

    public Livre(String Titre, String Auteur, int nbPage) throws Exception {
        super(Titre, Auteur);
        setNbPage(nbPage);
    }

    /**
     * Get the value of nbPage
     *
     * @return the value of nbPage
     */
    public int getNbPage() {
        return nbPage;
    }

    /**
     * Set the value of nbPage
     *
     * @param nbPage new value of nbPage
     */
    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.nbPage;
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
        final Livre other = (Livre) obj;
        if (this.nbPage != other.nbPage) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + " : Livre{" + "nbPage=" + nbPage + '}';
    }

    @Override
    public void enregistre(PrintStream p) {
        StringBuilder sb = new StringBuilder("L");
        sb.append(";");
        sb.append(getTitre());
        sb.append(";");
        sb.append(getAuteur());
        sb.append(";");
        sb.append(nbPage);
        p.println(sb.toString());
    }

    @Override
    public String getRequete() {
        // @todo  mettre le nom de la table en paramtere
        StringBuilder sb = new StringBuilder("INSERT into livre (auteur, titre, nbpage)");
        sb.append(" values ('");
        sb.append(getAuteur());
        sb.append("','");
        sb.append(getTitre());
        sb.append("','");
        sb.append(nbPage);
        sb.append("')");
        return sb.toString();
    }

}
