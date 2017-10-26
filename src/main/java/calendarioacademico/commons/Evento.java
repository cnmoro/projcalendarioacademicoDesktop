package calendarioacademico.commons;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author moro
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findById", query = "SELECT e FROM Evento e WHERE e.id = :id")
    , @NamedQuery(name = "Evento.findByNome", query = "SELECT e FROM Evento e WHERE e.nome = :nome")
    , @NamedQuery(name = "Evento.findByHoras", query = "SELECT e FROM Evento e WHERE e.horas = :horas")
    , @NamedQuery(name = "Evento.findBySemanaacademica", query = "SELECT e FROM Evento e WHERE e.semanaacademica = :semanaacademica")
    , @NamedQuery(name = "Evento.findByAutor", query = "SELECT e FROM Evento e WHERE e.autor = :autor")
    , @NamedQuery(name = "Evento.findByLat", query = "SELECT e FROM Evento e WHERE e.lat = :lat")
    , @NamedQuery(name = "Evento.findByLon", query = "SELECT e FROM Evento e WHERE e.lon = :lon")
    , @NamedQuery(name = "Evento.findByEndereco", query = "SELECT e FROM Evento e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Evento.findByDatainicio", query = "SELECT e FROM Evento e WHERE e.datainicio = :datainicio")
    , @NamedQuery(name = "Evento.findByDatafim", query = "SELECT e FROM Evento e WHERE e.datafim = :datafim")})
public class Evento implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horas")
    private int horas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semanaacademica")
    private boolean semanaacademica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "autor")
    private String autor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lat")
    private Double lat;
    @Column(name = "lon")
    private Double lon;
    @Size(max = 200)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datafim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafim;
    @Lob
    @Column(name = "documento")
    private byte[] documento;
    @OneToMany(mappedBy = "eventopai")
    private Collection<Evento> eventoCollection;
    @JoinColumn(name = "eventopai", referencedColumnName = "id")
    @ManyToOne
    private Evento eventopai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idevento")
    private Collection<Participacao> participacaoCollection;

    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, String nome, int horas, boolean semanaacademica, String autor, Date datainicio, Date datafim) {
        this.id = id;
        this.nome = nome;
        this.horas = horas;
        this.semanaacademica = semanaacademica;
        this.autor = autor;
        this.datainicio = datainicio;
        this.datafim = datafim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        int oldHoras = this.horas;
        this.horas = horas;
        changeSupport.firePropertyChange("horas", oldHoras, horas);
    }

    public boolean getSemanaacademica() {
        return semanaacademica;
    }

    public void setSemanaacademica(boolean semanaacademica) {
        boolean oldSemanaacademica = this.semanaacademica;
        this.semanaacademica = semanaacademica;
        changeSupport.firePropertyChange("semanaacademica", oldSemanaacademica, semanaacademica);
    }

    public String getSemanaacademicastring() {
        if (semanaacademica) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        String oldAutor = this.autor;
        this.autor = autor;
        changeSupport.firePropertyChange("autor", oldAutor, autor);
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        Double oldLat = this.lat;
        this.lat = lat;
        changeSupport.firePropertyChange("lat", oldLat, lat);
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        Double oldLon = this.lon;
        this.lon = lon;
        changeSupport.firePropertyChange("lon", oldLon, lon);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        Date oldDatainicio = this.datainicio;
        this.datainicio = datainicio;
        changeSupport.firePropertyChange("datainicio", oldDatainicio, datainicio);
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        Date oldDatafim = this.datafim;
        this.datafim = datafim;
        changeSupport.firePropertyChange("datafim", oldDatafim, datafim);
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        byte[] oldDocumento = this.documento;
        this.documento = documento;
        changeSupport.firePropertyChange("documento", oldDocumento, documento);
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public Evento getEventopai() {
        return eventopai;
    }

    public void setEventopai(Evento eventopai) {
        Evento oldEventopai = this.eventopai;
        this.eventopai = eventopai;
        changeSupport.firePropertyChange("eventopai", oldEventopai, eventopai);
    }

    @XmlTransient
    public Collection<Participacao> getParticipacaoCollection() {
        return participacaoCollection;
    }

    public void setParticipacaoCollection(Collection<Participacao> participacaoCollection) {
        this.participacaoCollection = participacaoCollection;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
