/*
 * 
 */
package devweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author D. Colombani <dc@webformation.fr>
 */
@Entity
@Table(name = "lecteurcomplet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecteurcomplet.findAll", query = "SELECT l FROM Lecteurcomplet l"),
    @NamedQuery(name = "Lecteurcomplet.findById", query = "SELECT l FROM Lecteurcomplet l WHERE l.id = :id"),
    @NamedQuery(name = "Lecteurcomplet.findByIdentifiant", query = "SELECT l FROM Lecteurcomplet l WHERE l.identifiant = :identifiant"),
    @NamedQuery(name = "Lecteurcomplet.findByMotdepasse", query = "SELECT l FROM Lecteurcomplet l WHERE l.motdepasse = :motdepasse")})
public class Lecteurcomplet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "identifiant")
    private String identifiant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "motdepasse")
    private String motdepasse;
    @JoinColumn(name = "idVille", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ville idVille;

    public Lecteurcomplet() {
    }

    public Lecteurcomplet(Integer id) {
        this.id = id;
    }

    public Lecteurcomplet(Integer id, String motdepasse) {
        this.id = id;
        this.motdepasse = motdepasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Ville getIdVille() {
        return idVille;
    }

    public void setIdVille(Ville idVille) {
        this.idVille = idVille;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecteurcomplet)) {
            return false;
        }
        Lecteurcomplet other = (Lecteurcomplet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.authentification.Lecteurcomplet[ id=" + id + " ]";
    }
    
}
