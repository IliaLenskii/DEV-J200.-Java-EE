package entitymy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ilia
 */
@Entity
@Table(name = "FINALLAB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finallab.findAll", query = "SELECT f FROM Finallab f"),
    @NamedQuery(name = "Finallab.findById", query = "SELECT f FROM Finallab f WHERE f.id = :id"),
    @NamedQuery(name = "Finallab.findByName", query = "SELECT f FROM Finallab f WHERE f.name = :name"),
    @NamedQuery(name = "Finallab.findByVal", query = "SELECT f FROM Finallab f WHERE f.val = :val"),
    @NamedQuery(name = "Finallab.findByLike", query = "SELECT f FROM Finallab f WHERE f.name LIKE :name")
})
public class Finallab implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VAL")
    private int val;

    public Finallab() {}

    public Finallab(Integer id) {
        this.id = id;
    }
    
    public Finallab(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
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
        if (!(object instanceof Finallab)) {
            return false;
        }
        Finallab other = (Finallab) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitymy.Finallab[ id=" + id + " ]";
    }    

    public String toStringToLi() {
        return "<li>"+ name +" - "+ val +"</li>";
    }
}
