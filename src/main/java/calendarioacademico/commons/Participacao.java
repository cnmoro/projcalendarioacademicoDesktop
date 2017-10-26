/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarioacademico.commons;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moro
 */
@Entity
@Table(name = "participacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participacao.findAll", query = "SELECT p FROM Participacao p")
    , @NamedQuery(name = "Participacao.findById", query = "SELECT p FROM Participacao p WHERE p.id = :id")
    , @NamedQuery(name = "Participacao.findByUsuario", query = "SELECT p FROM Participacao p WHERE p.idusuario = :idusuario")
    , @NamedQuery(name = "Participacao.findByFeedback", query = "SELECT p FROM Participacao p WHERE p.feedback = :feedback")})
public class Participacao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "feedback")
    private String feedback;
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "idevento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evento idevento;

    public Participacao() {
    }

    public Participacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        String oldFeedback = this.feedback;
        this.feedback = feedback;
        changeSupport.firePropertyChange("feedback", oldFeedback, feedback);
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        Usuario oldIdusuario = this.idusuario;
        this.idusuario = idusuario;
        changeSupport.firePropertyChange("idusuario", oldIdusuario, idusuario);
    }

    public Evento getIdevento() {
        return idevento;
    }

    public void setIdevento(Evento idevento) {
        Evento oldIdevento = this.idevento;
        this.idevento = idevento;
        changeSupport.firePropertyChange("idevento", oldIdevento, idevento);
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
        if (!(object instanceof Participacao)) {
            return false;
        }
        Participacao other = (Participacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "calendarioacademico.commons.Participacao[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
