
package hmdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Rock
 */
public class UsersList extends javax.swing.JFrame {
    MySqlConnect mySqlConnect = new MySqlConnect();
    Connection conn = mySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form UserList1
     */
    public UsersList() {
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
        Object [] row = new Object[7];
        for(int i = 0; i < list.size(); i++)
        {
            row[0] = list.get(i).getIdD();
            row[1] = list.get(i).getDepartment();
            row[2] = list.get(i).getPerson();
            row[3] = list.get(i).getUsername();
            row[4] = list.get(i).getPassword();
            row[5] = list.get(i).getRole();
            row[6] = list.get(i).getAvatarPath();
            

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
                
            JOptionPane.showMessageDialog(null, "Данные удачно " + message);
            
            } else {
                JOptionPane.showMessageDialog(null, "Данные " + message);
            }
        } catch (Exception ex) {ex.printStackTrace();}
    } 

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisplayUsers = new javax.swing.JTable();
        idDisplay = new javax.swing.JTextField();
        departDisplay = new javax.swing.JTextField();
        personDisplay = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        usernameDisplay = new javax.swing.JTextField();
        passwDisplay = new javax.swing.JTextField();
        roleDisplay = new javax.swing.JTextField();
        avatarPathDisplay = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        reloadData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Пользователи");

        jTableDisplayUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ИН", "Отдел", "Ф.И.О.", "Логин", "Пароль", "Роль", "Фото"
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
            jTableDisplayUsers.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTableDisplayUsers.getColumnModel().getColumn(3).setMaxWidth(130);
            jTableDisplayUsers.getColumnModel().getColumn(4).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(4).setPreferredWidth(110);
            jTableDisplayUsers.getColumnModel().getColumn(4).setMaxWidth(110);
            jTableDisplayUsers.getColumnModel().getColumn(5).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(5).setPreferredWidth(125);
            jTableDisplayUsers.getColumnModel().getColumn(5).setMaxWidth(125);
            jTableDisplayUsers.getColumnModel().getColumn(6).setMinWidth(10);
            jTableDisplayUsers.getColumnModel().getColumn(6).setPreferredWidth(205);
            jTableDisplayUsers.getColumnModel().getColumn(6).setMaxWidth(205);
        }

        updateButton.setText("Изменить");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Удалить");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(personDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roleDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avatarPathDisplay))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(deleteButton)))))

                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(departDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(personDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(roleDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(avatarPathDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addContainerGap())
        );

        pack();
    }

        
    // Delete data
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    
        try {      
            String query = "DELETE FROM users WHERE ID_d = '"+idDisplay.getText()+"'";
            updateAndDeleteQuery(query, "удалены!");
        
        } catch (Exception exc) {exc.printStackTrace();}
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    
    private void jTableDisplayUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisplayUsersMouseClicked
        
        int i = jTableDisplayUsers.getSelectedRow();
        TableModel model = jTableDisplayUsers.getModel();

        idDisplay.setText(model.getValueAt(i,0).toString());
        departDisplay.setText(model.getValueAt(i,1).toString());
        personDisplay.setText(model.getValueAt(i,2).toString());
        usernameDisplay.setText(model.getValueAt(i,3).toString());
        passwDisplay.setText(model.getValueAt(i,4).toString());
        roleDisplay.setText(model.getValueAt(i,5).toString());
        avatarPathDisplay.setText(model.getValueAt(i,6).toString());
    }//GEN-LAST:event_jTableDisplayUsersMouseClicked

     // Update data
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
        String a = "Администратор", m = "Менеджер", u ="Пользователь", idRoleForSet = null;
        
        try {
            if (roleDisplay.getText().equals(a)) {
                idRoleForSet = "1";
            } else if (roleDisplay.getText().equals(m)) {
                idRoleForSet = "2";
            } else {
                idRoleForSet = "3";
            }
                
          String query = "UPDATE users SET depName = '"+departDisplay.getText()+"', "
                  + "persons = '"+personDisplay.getText()+"', username = '"+usernameDisplay.getText()+"', "
                  + "password = '"+passwDisplay.getText()+"', idRole = '"+idRoleForSet+"', "
                  + "avatarPath = '"+avatarPathDisplay.getText()+"' WHERE ID_d = '"+idDisplay.getText()+"'";   
          
            updateAndDeleteQuery(query, "изменены!");

        } catch (Exception exce) {exce.printStackTrace();}
    }//GEN-LAST:event_updateButtonActionPerformed

    // Add users
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddUser au = new AddUser();
        au.setLocationRelativeTo(null);
        au.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsersList usersList = new UsersList();
                usersList.setLocationRelativeTo(null);
                usersList.setVisible(true);
            }
        });
    }
    private javax.swing.JButton reloadData;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField avatarPathDisplay;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departDisplay;
    private javax.swing.JTextField idDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDisplayUsers;
    private javax.swing.JTextField passwDisplay;
    private javax.swing.JTextField personDisplay;
    private javax.swing.JTextField roleDisplay;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameDisplay;
    // End of variables declaration//GEN-END:variables
}
