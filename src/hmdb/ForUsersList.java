package hmdb;

/**
 * @author Rock
 */

public class ForUsersList  {
    
    private final int idD;
    private final String department, person;
    
    public ForUsersList(int idD, String department, String person)
    {
        this.idD = idD;
        this.department = department;
        this.person = person;
    }

    public int getIdD(){
        return idD;
    }
    
    public String getDepartment(){
        return department;
    }
    
    public String getPerson (){
        return person;
    }
        
}
