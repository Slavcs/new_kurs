package view.user;

import clientcp.ClientCP;
import static clientcp.ClientCP.receiveResultSet;
import static clientcp.ClientCP.sendMessage;
import static clientcp.ClientCP.sendObject;
import static clientcp.ClientCP.stringmap;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class InsertUserTable extends javax.swing.JFrame {
    private ArrayList<String[]> rsmr;
     private EditUserDialog dlg;
    
    
    public InsertUserTable() {
        dlg = new EditUserDialog(this, true, getIDsFromSalon());

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArrayList<String[]> rs = getResultFromSalon();
        SalonTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SalonIDCombo = new javax.swing.JComboBox<>();
        EmployeeSurnameField = new javax.swing.JTextField();
        EmployeeNameField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rsmr = getResultFromEmployee();
        UserTable = new javax.swing.JTable();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Данные о сотрудниках");


        SalonTable.setModel(new view.user.SalonTableModel(rs));
        jScrollPane1.setViewportView(SalonTable);

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Парикмахерская:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Фамилия мастера:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Имя мастера:");

        SalonIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        SalonIDCombo.setModel(new javax.swing.DefaultComboBoxModel(getIDsFromSalon()));

        AddButton.setForeground(new java.awt.Color(255, 0, 102));
        AddButton.setText("Добавить мастера");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        UserTable.setModel(new view.user.UserTableModel(rsmr));
        UserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(UserTable);

        EditButton.setForeground(new java.awt.Color(255, 0, 102));
        EditButton.setText("Редактировать");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        EditButton.setVisible(false);

        DeleteButton.setForeground(new java.awt.Color(255, 0, 102));
        DeleteButton.setText("Удалить");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        BackButton.setForeground(new java.awt.Color(255, 0, 102));
        BackButton.setText("Назад");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(EditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SalonIDCombo, 0, 207, Short.MAX_VALUE)
                            .addComponent(EmployeeSurnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(EmployeeNameField)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalonIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmployeeSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(EmployeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
//        sendMessage("_send_button");
//        String EmployeeID = EmployeeIDField.getText();
//        String SalonID = (String)SalonIDCombo.getSelectedItem();
//        String EmployeeSurname = EmployeeSurnameField.getText();
//        String EmployeeName = EmployeeNameField.getText();
//        
//
//        stringmap = new LinkedHashMap<>();
//
//        stringmap.put("EmployeeID", EmployeeID);
//        stringmap.put("SalonID", SalonID);
//        stringmap.put("EmployeeSurname", EmployeeSurname);
//        stringmap.put("EmployeeName", EmployeeName);
//
//        sendObject(stringmap);
        boolean isOk = true;
        for(String[] obj: rsmr){
            if(obj[2].equals(this.EmployeeSurnameField.getText()))
                isOk = false;
        }
        if(isOk) {
            sendMessage("_send_button");
            ClientCP.stringmap = new LinkedHashMap<>();
            ClientCP.stringmap.put("SalonID", (String) this.SalonIDCombo.getSelectedItem());
            ClientCP.stringmap.put("EmployeeSurname", this.EmployeeSurnameField.getText());
            ClientCP.stringmap.put("EmployeeName", this.EmployeeNameField.getText());
            ClientCP.sendObject(ClientCP.stringmap);
            jLabel4.setForeground(new java.awt.Color(0, 0, 153));
            this.setVisible(false);
        }else {
            jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        }

    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        sendMessage("_edit_button");
        dlg.setEmployeeID((String) UserTable.getValueAt(UserTable.getSelectedRow(), 0));
        dlg.setSalonID((String) UserTable.getValueAt(UserTable.getSelectedRow(), 1));
        dlg.setEmployeeSurname((String) UserTable.getValueAt(UserTable.getSelectedRow(), 2));
        dlg.setEmployeeName((String) UserTable.getValueAt(UserTable.getSelectedRow(), 3));
        dlg.setVisible(true);

        stringmap = new LinkedHashMap<>();

//        stringmap.put("EmployeeID", dlg.getEmployeeID());
        stringmap.put("EmployeeID", (String) UserTable.getValueAt(UserTable.getSelectedRow(), 0));
        stringmap.put("SalonID", dlg.getSalonID());
        stringmap.put("EmployeeSurname", dlg.getEmployeeSurname());
        stringmap.put("EmployeeName", dlg.getEmployeeName());

        sendObject(stringmap);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        sendMessage("_delete_button");
        String EmployeeID = (String) UserTable.getValueAt(UserTable.getSelectedRow(), 0);
        stringmap = new LinkedHashMap<>();
        stringmap.put("EmployeeID", EmployeeID);

        sendObject(stringmap);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        sendMessage("_go_back");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void UserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserTableMouseClicked
        if (UserTable.getSelectedRowCount() > 0) {
            EditButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        } else {
            EditButton.setEnabled(false);
            DeleteButton.setEnabled(false);
        }
    }//GEN-LAST:event_UserTableMouseClicked

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
            java.util.logging.Logger.getLogger(InsertUserTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertUserTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertUserTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertUserTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InsertUserTable().setVisible(true);
            }
        });
    }
    
    public ArrayList<String[]> getResultFromEmployee() {
        ArrayList<String[]> rsmr = null;

        sendMessage("_get_result_from_employee");
        rsmr = receiveResultSet();
        return rsmr;
    }

    public ArrayList<String[]> getResultFromSalon() {
        ArrayList<String[]> rs = null;

        sendMessage("_get_result_from_salon");
        rs = receiveResultSet();
        return rs;
    }

    public String[] getIDsFromSalon() {
        ArrayList<String> arrList = new ArrayList<>();
        ArrayList<String[]> rs = null;

        sendMessage("_get_ids_from_salon");
        rs = receiveResultSet();
        for (int i = 0; i < rs.size(); i++) {
            arrList.add(rs.get(i)[0]);
        }
        return arrList.toArray(new String[arrList.size()]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField EmployeeNameField;
    private javax.swing.JTextField EmployeeSurnameField;
    private javax.swing.JComboBox<String> SalonIDCombo;
    private javax.swing.JTable SalonTable;
    private javax.swing.JTable UserTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
