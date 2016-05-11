
package hmdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rock
 */
public class User extends javax.swing.JFrame {
    MySqlConnect mySqlConnect = new MySqlConnect();
    Connection conn = mySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String idDepartment = Authorization.loggedUserID;
    
    /**
     * Creates new form TasksList
     */
    public User() {
        initComponents();
        showTasksListInJTable();        
    }

    // Create array list and get data from table tasks
    public ArrayList<ForTasksList> getTascksList() 
    {  
        ArrayList<ForTasksList> createTasksList = new ArrayList<>();
    
        String query = "SELECT tasks.ID_ts AS Id, idPerson AS Worker, "
                + "apartment.numberOfApart AS Apartment, tasks.tasks AS Task, "
                + "tasks.date_incoming AS DateAndTime, users.persons AS WhoAdded, "
                + "idComplete AS Compliting FROM tasks "
                + "JOIN users ON tasks.idWho = users.ID_d "
                + "JOIN apartment ON tasks.idApart = apartment.ID_a "
                + "WHERE idPerson = '"+idDepartment+"'";
    
        try{
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
    
        ForTasksList forTascksList;
        
        while(rs.next()){
            forTascksList = new ForTasksList(rs.getInt("Id"), rs.getString("Worker"), 
                    rs.getString("Apartment"), rs.getString("Task"), 
                    rs.getString("DateAndTime"), rs.getString("WhoAdded"), rs.getInt("Compliting"));
            createTasksList.add(forTascksList);          
        }
        
    } catch (Exception e) {e.printStackTrace();}
    
        return createTasksList;
    }
    
    // Added and Show array list in table displayTasksForUser
    public void showTasksListInJTable()
    {
        ArrayList<ForTasksList> list = getTascksList();
        DefaultTableModel model = (DefaultTableModel) displayTasksForUser.getModel();
        
        Object [] row = new Object[6];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getIdTs();
            row[1] = list.get(i).getIdApart();
            row[2] = list.get(i).getTasks();
            row[3] = list.get(i).getDateIncoming();
            row[4] = list.get(i).getIdWho();
            row[5] = list.get(i).getIdComplit();
            
            model.addRow(row);
        }
    }
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTasksForUser = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        displayTasksForUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Apartment", "Task", "Date", "Who Added", "Complit"
            }
        ));
        jScrollPane1.setViewportView(displayTasksForUser);
        if (displayTasksForUser.getColumnModel().getColumnCount() > 0) {
            displayTasksForUser.getColumnModel().getColumn(0).setMinWidth(30);
            displayTasksForUser.getColumnModel().getColumn(0).setPreferredWidth(30);
            displayTasksForUser.getColumnModel().getColumn(0).setMaxWidth(30);
            displayTasksForUser.getColumnModel().getColumn(1).setMinWidth(10);
            displayTasksForUser.getColumnModel().getColumn(1).setPreferredWidth(50);
            displayTasksForUser.getColumnModel().getColumn(1).setMaxWidth(50);
            displayTasksForUser.getColumnModel().getColumn(2).setMinWidth(10);
            displayTasksForUser.getColumnModel().getColumn(2).setPreferredWidth(200);
            displayTasksForUser.getColumnModel().getColumn(2).setMaxWidth(200);
            displayTasksForUser.getColumnModel().getColumn(3).setMinWidth(10);
            displayTasksForUser.getColumnModel().getColumn(3).setPreferredWidth(150);
            displayTasksForUser.getColumnModel().getColumn(3).setMaxWidth(150);
            displayTasksForUser.getColumnModel().getColumn(4).setMinWidth(10);
            displayTasksForUser.getColumnModel().getColumn(4).setPreferredWidth(110);
            displayTasksForUser.getColumnModel().getColumn(4).setMaxWidth(110);
            displayTasksForUser.getColumnModel().getColumn(5).setMinWidth(10);
            displayTasksForUser.getColumnModel().getColumn(5).setPreferredWidth(60);
            displayTasksForUser.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            User user = new User();
            user.setLocationRelativeTo(null);
            user.setResizable(false);
            user.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable displayTasksForUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
