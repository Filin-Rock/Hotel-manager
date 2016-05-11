package hmdb;

/**
 * @author Rock
 */

public class ForUsersList  {
    
    private final int idD;
    private final String department, person, username, password, role, avatarPath;
    
    public ForUsersList(int idD, String department, String person, String username, String password, String role, String avatarPath)
    {
        this.idD = idD;
        this.department = department;
        this.person = person;
        this.username = username;
        this.password = password;
        this.role = role;
        this.avatarPath = avatarPath;
    }

    public int getIdD() {
        return idD;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getPerson () {
        return person;
    }
         
    public String getUsername () {
        return username;
    }       
    
    public String getPassword () {
        return password;
    }
        
    public String getRole () {
        return role;
    }
        
    public String getAvatarPath () {
        return avatarPath;
    }
}
