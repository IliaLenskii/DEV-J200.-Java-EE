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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ilia
 */
@Entity
@Table(name = "TABLETOTEXT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabletotext.findAll", query = "SELECT t FROM Tabletotext t"),
    @NamedQuery(name = "Tabletotext.findById", query = "SELECT t FROM Tabletotext t WHERE t.id = :id"),
    @NamedQuery(name = "Tabletotext.findByVal", query = "SELECT t FROM Tabletotext t WHERE t.val = :val")})
public class Tabletotext implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255)
    @Column(name = "VAL")
    private String val;

    public Tabletotext() {
    }

    public Integer getId() {
        return id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
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
        if (!(object instanceof Tabletotext)) {
            return false;
        }
        Tabletotext other = (Tabletotext) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitymy.Tabletotext[ id=" + id + " ]";
    }
    
}
