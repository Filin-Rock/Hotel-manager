/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Administrator extends javax.swing.JFrame {
    Connection conn = MySqlConnect.ConnectDB();
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form Administrator
     */
    public Administrator() {
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
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("hotel_manager_db?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        departmentQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT d FROM Department d");
        departmentList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : departmentQuery.getResultList();
        jMenu2 = new javax.swing.JMenu();
        ch_department = new javax.swing.JComboBox<>();
        ch_name = new javax.swing.JComboBox<>();
        ad_submit = new javax.swing.JButton();
        ch_apartment = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasks_list = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        add_user = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        view = new javax.swing.JMenu();
        usersList = new javax.swing.JMenuItem();
        tasksList = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ch_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Отдел>", "Консьерж", "Мастер", "Ресторан", "Такси", "Уборка" }));
        ch_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_departmentActionPerformed(evt);
            }
        });

        ch_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Ф.И.О>" }));
        ch_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_nameActionPerformed(evt);
            }
        });

        ad_submit.setText("Submit");
        ad_submit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ad_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad_submitActionPerformed(evt);
            }
        });

        ch_apartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Апартаменты>", "1", "2", "3" }));
        ch_apartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_apartmentActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tasks_list);

        jMenu1.setText("File");

        add_user.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        add_user.setText("Добавить поль.-ля");
        jMenu1.add(add_user);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        view.setText("View");

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
                    .addComponent(ch_department, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ch_apartment, 0, 131, Short.MAX_VALUE)
                    .addComponent(ad_submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(ch_department, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ch_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ch_apartment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(ad_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        ch_department.getAccessibleContext().setAccessibleName("Department");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Choice department
    private void ch_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_departmentActionPerformed
       
        String currentDepartment = (String) ch_department.getSelectedItem();
        String queryChangeDepartment = String.format("SELECT * FROM department WHERE dep_name='%s'", currentDepartment);
        ch_name.removeAllItems();
        rs = addItems(conn, queryChangeDepartment);
        try {
            while (rs.next()) {
                ch_name.addItem(rs.getString("persons"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ch_departmentActionPerformed

    //Exit command
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    //Submit action
    private void ad_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad_submitActionPerformed
      
        // Get department title
        String currentName = (String) ch_name.getSelectedItem();
        
        // Get person ID
        // todo: rename "department" table to "users" (info about users)
        String queryToGetID = String.format("SELECT ID_d from department WHERE persons='%s'", currentName);
        try {
            pst = conn.prepareStatement(queryToGetID);
            rs = pst.executeQuery(queryToGetID);
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        int currentPersonID = 0;
        try {
            if (rs.next()) {
                currentPersonID = rs.getInt("ID_d");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Get number of apartment
        String currentApartment = (String) ch_apartment.getSelectedItem();
        String queryToGetApartName = String.format("SELECT ID_a from apartment WHERE numberOfApart='%s'", currentApartment);
        try {
            pst = conn.prepareStatement(queryToGetApartName);
            rs = pst.executeQuery(queryToGetApartName);
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        String currentApartID = "";
        try {
            if (rs.next()) {
                currentApartID = rs.getString("ID_a");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // todo: check input data
        // todo: add current date & time

        // Insert data (currentPersonID, currentApartID, currentTask) to the "tasks" table
        String currentTask = tasks_list.getText();      
        String submitQuery = String.format("INSERT INTO "
                        + "tasks (id_person, id_apart, tasks) "
                        + "VALUES('%d', '%s', '%s')",
                currentPersonID, currentApartID, currentTask
        );
        try {
            pst = conn.prepareStatement(submitQuery);
            pst.executeUpdate(submitQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Add complete");
    }//GEN-LAST:event_ad_submitActionPerformed

    // View table department
    private void usersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersListActionPerformed
        UsersList vw = new UsersList();
        vw.setVisible(true);
    }//GEN-LAST:event_usersListActionPerformed

    private void ch_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_nameActionPerformed
        
    }//GEN-LAST:event_ch_nameActionPerformed

   
    private void ch_apartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_apartmentActionPerformed
    }//GEN-LAST:event_ch_apartmentActionPerformed

    private void tasksListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tasksListActionPerformed
        TasksList tasksList = new TasksList();
        //tasksList.setResizable(false);
        tasksList.setLocationRelativeTo(null);
        tasksList.setVisible(true);
    }//GEN-LAST:event_tasksListActionPerformed
    
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
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Administrator administrator = new Administrator();
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
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ad_submit;
    private javax.swing.JMenuItem add_user;
    private javax.swing.JComboBox<String> ch_apartment;
    private javax.swing.JComboBox<String> ch_department;
    private javax.swing.JComboBox<String> ch_name;
    private java.util.List<hmdb.Department> departmentList;
    private javax.persistence.Query departmentQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem tasksList;
    private javax.swing.JTextPane tasks_list;
    private javax.swing.JMenuItem usersList;
    private javax.swing.JMenu view;
    // End of variables declaration//GEN-END:variables
}