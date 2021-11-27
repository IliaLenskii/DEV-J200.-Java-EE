/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.xml.bind.annotation.XmlRootElement;

// SELECT SUM(VAL) FROM TABLETOINT;

/**
 *
 * @author ilia
 */
@Entity
@Table(name = "TABLETOINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabletoint.findAll", query = "SELECT t FROM Tabletoint t"),
    @NamedQuery(name = "Tabletoint.findById", query = "SELECT t FROM Tabletoint t WHERE t.id = :id"),
    @NamedQuery(name = "Tabletoint.findByVal", query = "SELECT t FROM Tabletoint t WHERE t.val = :val"),
    @NamedQuery(name = "Tabletoint.getSumByVal", query = "SELECT SUM(t.val) sumVal FROM Tabletoint t")})
public class Tabletoint implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VAL")
    private Integer val;

    public Tabletoint() {
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
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
        if (!(object instanceof Tabletoint)) {
            return false;
        }
        Tabletoint other = (Tabletoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitymy.Tabletoint[ id=" + id + " ]";
    }
    
}
