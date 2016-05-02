
package hmdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Rock
 */
public class UsersList extends javax.swing.JFrame {

    Connection conn = MySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    /**
     * Creates new form UserList1
     */
    public UsersList() {
        
        initComponents();
        
        showUsersListInJTable();
        
    }

    // Create array list and get data from table department
    public ArrayList<ForUsersList> getUsersList() 
    {  
        ArrayList<ForUsersList> createUsersList = new ArrayList<ForUsersList>();
    
        String query = "SELECT * FROM department";
    
        try{
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
    
        ForUsersList forUsersList;
        
        while(rs.next()){
            forUsersList = new ForUsersList(rs.getInt("ID_d"), rs.getString("dep_name"), rs.getString("persons"));
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
        Object [] row = new Object[3];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getIdD();
            row[1] = list.get(i).getDepartment();
            row[2] = list.get(i).getPerson();

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
        idDisplay = new javax.swing.JTextField();
        departDisplay = new javax.swing.JTextField();
        personDisplay = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableDisplayUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Depart", "Person"
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
        }

        departDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departDisplayActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addGap(38, 38, 38)
                                .addComponent(deleteButton))
                            .addComponent(personDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    
        try {      
            String query = "DELETE FROM department WHERE ID_d = '"+idDisplay.getText()+"'";
            updateAndDeleteQuery(query, "Deleted");
        
        } catch (Exception exc) {exc.printStackTrace();}
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void departDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departDisplayActionPerformed
               
    }//GEN-LAST:event_departDisplayActionPerformed

    
    private void jTableDisplayUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisplayUsersMouseClicked
        
        int i = jTableDisplayUsers.getSelectedRow();
        TableModel model = jTableDisplayUsers.getModel();

        idDisplay.setText(model.getValueAt(i,0).toString());
        departDisplay.setText(model.getValueAt(i,1).toString());
        personDisplay.setText(model.getValueAt(i,2).toString());

    }//GEN-LAST:event_jTableDisplayUsersMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        try {
            String query = "UPDATE department SET dep_name = '"+departDisplay.getText()+"', "
                    + "persons = '"+personDisplay.getText()+"' WHERE ID_d = '"+idDisplay.getText()+"'";
            updateAndDeleteQuery(query, "Updated");

            } catch (Exception exce) {exce.printStackTrace();}
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UsersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departDisplay;
    private javax.swing.JTextField idDisplay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayUsers;
    private javax.swing.JTextField personDisplay;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
