
package hmdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rock
 */
public class TasksList extends javax.swing.JFrame {
    MySqlConnect mySqlConnect = new MySqlConnect();
    Connection conn = mySqlConnect.ConnectDB();
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
    public ArrayList<ForTasksList> getTascksList() 
    {  
        ArrayList<ForTasksList> createTasksList = new ArrayList<>();
    
        String query = "SELECT tasks.ID_ts AS Id, idPerson AS Worker, "
                + "apartment.numberOfApart AS Apartment, tasks.tasks AS Task, "
                + "tasks.date_incoming AS DateAndTime, users.persons AS WhoAdded, "
                + "idComplete AS Compliting FROM tasks "
                + "JOIN users ON tasks.idWho = users.ID_d "
                + "JOIN apartment ON tasks.idApart = apartment.ID_a";
    
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
        chComplete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Print = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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
        setTitle("Просмотр заданий");

        displayTasksForUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ИН", "Апартаменты", "Задание", "Дата", "Кто задал", "Выполнено"
            }
        ));
        jScrollPane1.setViewportView(displayTasksForUser);
        if (displayTasksForUser.getColumnModel().getColumnCount() > 0) {
            displayTasksForUser.getColumnModel().getColumn(0).setMinWidth(30);
            displayTasksForUser.getColumnModel().getColumn(0).setPreferredWidth(30);
            displayTasksForUser.getColumnModel().getColumn(0).setMaxWidth(30);
            displayTasksForUser.getColumnModel().getColumn(1).setMinWidth(10);
            displayTasksForUser.getColumnModel().getColumn(1).setPreferredWidth(100);
            displayTasksForUser.getColumnModel().getColumn(1).setMaxWidth(100);
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
            displayTasksForUser.getColumnModel().getColumn(5).setPreferredWidth(80);
            displayTasksForUser.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        chComplete.setText("Выполнено");
        chComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chCompleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Задание:");

        Print.setText("Печатать");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        jLabel2.setText("Печатать выделенное:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Print)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chComplete)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chComplete)
                    .addComponent(jLabel1)
                    .addComponent(Print)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chCompleteActionPerformed
        JOptionPane.showMessageDialog(null, "Скоро эта кнопка заработает.");
    }//GEN-LAST:event_chCompleteActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        JOptionPane.showMessageDialog(null, "Скоро эта кнопка заработает.");
    }//GEN-LAST:event_PrintActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TasksList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TasksList tasksList = new TasksList();
                tasksList.setLocationRelativeTo(null);
                tasksList.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Print;
    private javax.swing.JButton chComplete;
    private javax.swing.JTable displayTasksForUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
