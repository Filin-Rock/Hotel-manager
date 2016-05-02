
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
public class TasksList extends javax.swing.JFrame {

    Connection conn = MySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form TasksList
     */
    public TasksList() {
        
        initComponents();
        
        showTasksListInJTable();        
    }

    // Create array list and get data from table tasks
    public ArrayList<ForTascksList> getTascksList() 
    {  
        ArrayList<ForTascksList> createTascksList = new ArrayList<ForTascksList>();
    
        String query = "SELECT tasks.ID_ts AS Id, id_person AS worker, apartment.numberOfApart AS Apartment, tasks.tasks AS Task, tasks.date_incoming AS DateAndTime, department.persons AS WhoAdded, id_complit AS Compliting FROM tasks JOIN department ON tasks.id_who = department.ID_d JOIN apartment ON tasks.id_apart = apartment.ID_a";
    
        try{
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
    
        ForTascksList forTascksList;
        
        while(rs.next()){
            forTascksList = new ForTascksList(rs.getInt("Id"), rs.getString("worker"), 
                    rs.getString("Apartment"), rs.getString("Task"), 
                    rs.getString("DateAndTime"), rs.getString("WhoAdded"), rs.getInt("Compliting"));
            createTascksList.add(forTascksList);          
        }
        
    } catch (Exception e) {e.printStackTrace();}
    
        return createTascksList;
    }
    
    // Added and Show array list in table displayTasksForUser
    public void showTasksListInJTable()
    {
        ArrayList<ForTascksList> list = getTascksList();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        displayTasksForUser = new javax.swing.JTable();

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
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TasksList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TasksList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TasksList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TasksList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TasksList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable displayTasksForUser;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
