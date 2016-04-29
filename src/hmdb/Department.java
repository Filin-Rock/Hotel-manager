/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmdb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author Rock
 */
@Entity
@Table(name = "department", catalog = "hotel_manager_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByIDd", query = "SELECT d FROM Department d WHERE d.iDd = :iDd"),
    @NamedQuery(name = "Department.findByDepName", query = "SELECT d FROM Department d WHERE d.depName = :depName"),
    @NamedQuery(name = "Department.findByPersons", query = "SELECT d FROM Department d WHERE d.persons = :persons"),
    @NamedQuery(name = "Department.findByUsername", query = "SELECT d FROM Department d WHERE d.username = :username"),
    @NamedQuery(name = "Department.findByPassword", query = "SELECT d FROM Department d WHERE d.password = :password"),
    @NamedQuery(name = "Department.findByIdRole", query = "SELECT d FROM Department d WHERE d.idRole = :idRole")})

public class Department implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_d")
    private Integer iDd;
    @Column(name = "dep_name")
    private String depName;
    @Column(name = "persons")
    private String persons;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "ID_ROLE")
    private Integer idRole;

    public Department() {
    }

    public Department(Integer iDd) {
        this.iDd = iDd;
    }

    public Department(Integer iDd, String username, String password) {
        this.iDd = iDd;
        this.username = username;
        this.password = password;
    }

    public Integer getIDd() {
        return iDd;
    }

    public void setIDd(Integer iDd) {
        Integer oldIDd = this.iDd;
        this.iDd = iDd;
        changeSupport.firePropertyChange("IDd", oldIDd, iDd);
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        String oldDepName = this.depName;
        this.depName = depName;
        changeSupport.firePropertyChange("depName", oldDepName, depName);
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        String oldPersons = this.persons;
        this.persons = persons;
        changeSupport.firePropertyChange("persons", oldPersons, persons);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        Integer oldIdRole = this.idRole;
        this.idRole = idRole;
        changeSupport.firePropertyChange("idRole", oldIdRole, idRole);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDd != null ? iDd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.iDd == null && other.iDd != null) || (this.iDd != null && !this.iDd.equals(other.iDd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hmdb.Department[ iDd=" + iDd + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
