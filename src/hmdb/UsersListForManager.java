
package hmdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rock
 */
public class UsersListForManager extends javax.swing.JFrame {
    MySqlConnect mySqlConnect = new MySqlConnect();
    Connection conn = mySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form UserList1
     */
    public UsersListForManager() {
        initComponents();
        showUsersListInJTable();
    }

    // Create array list and get data from table users
    public ArrayList<ForUsersList> getUsersList() 
    {  
        ArrayList<ForUsersList> createUsersList = new ArrayList<ForUsersList>();
    
        String query = "SELECT ID_d, depName, persons, username, password, "
                + "role.Name AS Role, avatarPath FROM users "
                + "JOIN role ON users.idRole = role.id_role ORDER BY ID_d";
    
        try{
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
    
        ForUsersList forUsersList;
        
        while(rs.next()){
            forUsersList = new ForUsersList(rs.getInt("ID_d"), rs.getString("depName"), 
                    rs.getString("persons"), rs.getString("username"), rs.getString("password"),
                    rs.getString("Role"), rs.getString("avatarPath"));
            createUsersList.add(forUsersList);          
        }
        
    } catch (Exception e) {e.printStackTrace();}
        return createUsersList;
    }
    
    // Show result array list in table jTableDisplayUsers
    public void showUsersListInJTable()
    {
        ArrayList<ForUsersList> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel) jTableDisplayUsers.getModel();
        Object [] row = new Object[5];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getIdD();
            row[1] = list.get(i).getDepartment();
            row[2] = list.get(i).getPerson();
            row[3] = list.get(i).getRole();
            row[4] = list.get(i).getAvatarPath();
            
            model.addRow(row);
        }
    }
     
    // Complit query for update and delete method
    public void updateAndDeleteQuery (String query, String message) {     

        try {
            pst = conn.prepareStatement(query);
            
            if ((pst.executeUpdate(query)) == 1)
            {
               DefaultTableModel model = (DefaultTableModel) jTableDisplayUsers.getModel();
               model.setRowCount(0);
               showUsersListInJTable();
                
            JOptionPane.showMessageDialog(null, "Data " + message+ " Succefully");
            
            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {ex.printStackTrace();}
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisplayUsers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Пользователи");

        jTableDisplayUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ИН", "Отдел", "Ф.И.О.", "Роль", "Фото"
            }
        ));
        jTableDisplayUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisplayUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDisplayUsers);
        if (jTableDisplayUsers.getColumnModel().getColumnCount() > 0) {
            jTableDisplayUsers.getColumnModel().getColumn(0).setMinWidth(30);
            jTableDisplayUsers.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableDisplayUsers.getColumnModel().getColumn(0).setMaxWidth(30);
            jTableDisplayUsers.getColumnModel().getColumn(1).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(1).setPreferredWidth(140);
            jTableDisplayUsers.getColumnModel().getColumn(1).setMaxWidth(140);
            jTableDisplayUsers.getColumnModel().getColumn(2).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(2).setPreferredWidth(145);
            jTableDisplayUsers.getColumnModel().getColumn(2).setMaxWidth(145);
            jTableDisplayUsers.getColumnModel().getColumn(3).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(3).setPreferredWidth(125);
            jTableDisplayUsers.getColumnModel().getColumn(3).setMaxWidth(125);
            jTableDisplayUsers.getColumnModel().getColumn(4).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(4).setPreferredWidth(205);
            jTableDisplayUsers.getColumnModel().getColumn(4).setMaxWidth(205);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTableDisplayUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisplayUsersMouseClicked
           
    }//GEN-LAST:event_jTableDisplayUsersMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersListForManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsersListForManager usersList = new UsersListForManager();
                usersList.setLocationRelativeTo(null);
                usersList.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayUsers;
    // End of variables declaration//GEN-END:variables
}
