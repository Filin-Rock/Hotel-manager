/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmdb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rock
 */
@Entity
@Table(name = "tasks", catalog = "hotel_manager_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t"),
    @NamedQuery(name = "Tasks.findByIDts", query = "SELECT t FROM Tasks t WHERE t.iDts = :iDts"),
    @NamedQuery(name = "Tasks.findByIdPerson", query = "SELECT t FROM Tasks t WHERE t.idPerson = :idPerson"),
    @NamedQuery(name = "Tasks.findByIdApart", query = "SELECT t FROM Tasks t WHERE t.idApart = :idApart"),
    @NamedQuery(name = "Tasks.findByDateIncoming", query = "SELECT t FROM Tasks t WHERE t.dateIncoming = :dateIncoming")})
public class Tasks implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ts")
    private Integer iDts;
    @Column(name = "id_person")
    private Integer idPerson;
    @Column(name = "id_apart")
    private Integer idApart;
    @Lob
    @Column(name = "tasks")
    private String tasks;
    @Basic(optional = false)
    @Column(name = "date_incoming")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIncoming;

    public Tasks() {
    }

    public Tasks(Integer iDts) {
        this.iDts = iDts;
    }

    public Tasks(Integer iDts, Date dateIncoming) {
        this.iDts = iDts;
        this.dateIncoming = dateIncoming;
    }

    public Integer getIDts() {
        return iDts;
    }

    public void setIDts(Integer iDts) {
        Integer oldIDts = this.iDts;
        this.iDts = iDts;
        changeSupport.firePropertyChange("IDts", oldIDts, iDts);
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        Integer oldIdPerson = this.idPerson;
        this.idPerson = idPerson;
        changeSupport.firePropertyChange("idPerson", oldIdPerson, idPerson);
    }

    public Integer getIdApart() {
        return idApart;
    }

    public void setIdApart(Integer idApart) {
        Integer oldIdApart = this.idApart;
        this.idApart = idApart;
        changeSupport.firePropertyChange("idApart", oldIdApart, idApart);
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        String oldTasks = this.tasks;
        this.tasks = tasks;
        changeSupport.firePropertyChange("tasks", oldTasks, tasks);
    }

    public Date getDateIncoming() {
        return dateIncoming;
    }

    public void setDateIncoming(Date dateIncoming) {
        Date oldDateIncoming = this.dateIncoming;
        this.dateIncoming = dateIncoming;
        changeSupport.firePropertyChange("dateIncoming", oldDateIncoming, dateIncoming);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDts != null ? iDts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.iDts == null && other.iDts != null) || (this.iDts != null && !this.iDts.equals(other.iDts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hmdb.Tasks[ iDts=" + iDts + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
