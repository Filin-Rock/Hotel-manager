
package hmdb;

/**
 *
 * @author Rock
 */
public class ForTasksList {
    
    private final int idTs, idComplit;
    private final String idPerson, idApart, tasks, dateIncoming, idWho;
    
    public ForTasksList(int idTs, String idPerson, String idApart, String tasks,
            String dateIncoming, String idWho, int idComplit)
    {
        this.idTs = idTs;
        this.idPerson = idPerson;
        this.idApart = idApart;
        this.tasks = tasks;
        this.dateIncoming = dateIncoming;
        this.idWho = idWho;
        this.idComplit = idComplit;
    }

    public int getIdTs() {
        return idTs;
    }
 
    public String getIdPerson() {
        return idPerson;
    }   

    public String getIdApart() {
        return idApart;
    }
    
    public String getTasks () {
        return tasks;
    }   
    
    public String getDateIncoming () {
        return dateIncoming;
    }
        
    public String getIdWho () {
        return idWho;
    }
    
    public int getIdComplit () {
        return idComplit;
    }
}
