
package hmdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Rock
 */
public class Manager extends javax.swing.JFrame {
    MySqlConnect mySqlConnect = new MySqlConnect();
    Connection conn = mySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String idDepartment = Authorization.loggedUserID;
 
    /**
     * Creates new form Administrator
     */
    public Manager( ) {
        initComponents();
        
        //Add numberOfApart to choose appartment(ch_apartment) button
        String queryChangeApartment = "SELECT numberOfApart FROM apartment";
        ch_apartment.removeAllItems();
        rs = addItems(conn, queryChangeApartment);
        try {
            while (rs.next()) {
                ch_apartment.addItem(rs.getString("numberOfApart"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {
        
        jMenu2 = new javax.swing.JMenu();
        ch_department = new javax.swing.JComboBox<>();
        ch_name = new javax.swing.JComboBox<>();
        ad_submit = new javax.swing.JButton();
        ch_apartment = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasks_list = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        view = new javax.swing.JMenu();
        usersList = new javax.swing.JMenuItem();
        tasksList = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mенеджер");

        ch_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Консьерж", "Мастер", "Ресторан", "Такси", "Уборка"}));
        ch_department.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ch_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_departmentActionPerformed(evt);
            }
        });

        ch_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Ф.И.О>" }));

        ad_submit.setText("Опубликовать");
        ad_submit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ad_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_submitActionPerformed(evt);
            }
        });

        ch_apartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {""}));


        jScrollPane1.setViewportView(tasks_list);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Отдел");
        jLabel1.setToolTipText("");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ф.И.О.");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Апартаменты");

        jMenu1.setText("Файл");

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Выход");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        view.setText("Просмотр");

        usersList.setText("Персонал");
        usersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersListActionPerformed(evt);
            }
        });
        view.add(usersList);

        tasksList.setText("Задания");
        tasksList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tasksListActionPerformed(evt);
            }
        });
        view.add(tasksList);

        jMenuBar1.add(view);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ch_name, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ch_department, 0, 131, Short.MAX_VALUE)
                    .addComponent(ad_submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ch_apartment, javax.swing.GroupLayout.Alignment.TRAILING, 0, 131, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ch_department, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ch_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ch_apartment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(ad_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        ch_department.getAccessibleContext().setAccessibleName("");

        pack();
    }

    //Choice department
    private void ch_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_departmentActionPerformed
       
        String currentDepartment = (String) ch_department.getSelectedItem();
        String queryChangeDepartment = String.format("SELECT * FROM users WHERE depName='%s'", currentDepartment);
        ch_name.removeAllItems();
        rs = addItems(conn, queryChangeDepartment);
        try {
            while (rs.next()) {
                ch_name.addItem(rs.getString("persons"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ch_departmentActionPerformed

    // Exit command
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    // Submit action
    private void ad_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_submitActionPerformed
      
        // Get department title
        String currentName = (String) ch_name.getSelectedItem();
        
        // Get person ID
        String queryToGetID = String.format("SELECT ID_d from users WHERE persons='%s'", currentName);
        try {
            pst = conn.prepareStatement(queryToGetID);
            rs = pst.executeQuery(queryToGetID);
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        int currentPersonID = 0;
        try {
            if (rs.next()) {
                currentPersonID = rs.getInt("ID_d");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Get number of apartment
        String currentApartment = (String) ch_apartment.getSelectedItem();
        String queryToGetApartName = String.format("SELECT ID_a from apartment WHERE numberOfApart='%s'", currentApartment);
        try {
            pst = conn.prepareStatement(queryToGetApartName);
            rs = pst.executeQuery(queryToGetApartName);
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String currentApartID = "";
        try {
            if (rs.next()) {
                currentApartID = rs.getString("ID_a");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Insert data (currentPersonID, currentApartID, currentTask) to the "tasks" table
        String currentTask = tasks_list.getText();
        int idComplete = 1;
        String submitQuery = String.format("INSERT INTO tasks (idPerson, idApart, tasks, idWho, idComplete) "
                + "VALUES('%d', '%s', '%s', '%s', '%d')", currentPersonID, currentApartID, currentTask, idDepartment, idComplete);
        try {
            pst = conn.prepareStatement(submitQuery);
            pst.executeUpdate(submitQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Задание добавленно");
    }//GEN-LAST:event_ad_submitActionPerformed

    // View table users
    private void usersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersListActionPerformed
        UsersListForManager ulfm = new UsersListForManager();
        ulfm.setLocationRelativeTo(null);
        ulfm.setVisible(true);
    }//GEN-LAST:event_usersListActionPerformed

    // View tasks List
    private void tasksListActionPerformed(java.awt.event.ActionEvent evt) {                                          
        TasksList tl = new TasksList();
        tl.setLocationRelativeTo(null);
        tl.setVisible(true);
    }                                          

    public static void main(String [] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Manager administrator = new Manager();
                administrator.setResizable(false);
                administrator.setLocationRelativeTo(null);
                administrator.setVisible(true);
            }
        });
    }
    
    public static ResultSet addItems(Connection conn, String query) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    private javax.swing.JButton ad_submit;
    private javax.swing.JComboBox<String> ch_apartment;
    private javax.swing.JComboBox<String> ch_department;
    private javax.swing.JComboBox<String> ch_name;
    private javax.swing.JMenuItem exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem tasksList;
    private javax.swing.JTextPane tasks_list;
    private javax.swing.JMenuItem usersList;
    private javax.swing.JMenu view;

}
