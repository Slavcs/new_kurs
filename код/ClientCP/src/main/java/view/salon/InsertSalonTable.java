package view.salon;

import clientcp.ClientCP;
import static clientcp.ClientCP.receiveResultSet;
import static clientcp.ClientCP.sendMessage;
import static clientcp.ClientCP.sendObject;
import static clientcp.ClientCP.stringmap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableRowSorter;

public class InsertSalonTable extends javax.swing.JFrame {
    private EditSalonDialog dlg;

    public InsertSalonTable() throws IOException {
        dlg = new EditSalonDialog(this, true);
        initComponents();
        TableRowSorter<SalonTableModel> sorter = new TableRowSorter<>();
        sorter.setModel((SalonTableModel) SalonTable.getModel());
        SalonTable.setRowSorter(sorter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SalonNameField = new javax.swing.JTextField();
        SalonCityField = new javax.swing.JTextField();
        SalonAddressField = new javax.swing.JTextField();
        WebField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArrayList<String[]> rs = getResultFromSalon();
        SalonTable = new javax.swing.JTable();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Данные о парикмахерской");

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Название:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Город:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Адрес:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Web-сайт:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Номер телефона:");

        SalonCityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalonCityFieldActionPerformed(evt);
            }
        });

        AddButton.setForeground(new java.awt.Color(255, 0, 102));
        AddButton.setText("Добавить парикмахерскую");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        SalonTable.setModel(new view.salon.SalonTableModel(rs));
        SalonTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalonTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SalonTable);

        EditButton.setForeground(new java.awt.Color(255, 0, 102));
        EditButton.setText("Редактировать запись");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setForeground(new java.awt.Color(255, 0, 102));
        DeleteButton.setText("Удалить запись");
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
                .addGap(46, 46, 46)
                .addComponent(EditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(WebField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SalonAddressField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SalonCityField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SalonNameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalonNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SalonCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalonAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WebField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BackButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(511, 654));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SalonCityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalonCityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalonCityFieldActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        sendMessage("_send_button");
ClientCP.stringmap = new LinkedHashMap<>();
        ClientCP.stringmap.put("SalonName", this.SalonNameField.getText());
        ClientCP.stringmap.put("SalonCity", this.SalonCityField.getText());
        ClientCP.stringmap.put("SalonLocation", this.SalonAddressField.getText());
        ClientCP.stringmap.put("SalonWebSite", this.WebField.getText());
        ClientCP.stringmap.put("SalonPhoneNumber", this.PhoneField.getText());
        ClientCP.sendObject(ClientCP.stringmap);

        this.setVisible(false);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        sendMessage("_edit_button");
        dlg.setSalonName((String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 1));
        dlg.setSalonCity((String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 2));
        dlg.setSalonLocation((String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 3));
        dlg.setSalonWebSite((String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 4));
        dlg.setSalonPhoneNumber((String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 5));
        dlg.setVisible(true);

        stringmap = new LinkedHashMap<>();

        stringmap.put("SalonID", (String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 0));
        stringmap.put("SalonName", dlg.getSalonName());
        stringmap.put("SalonCity", dlg.getSalonCity());
        stringmap.put("SalonLocation", dlg.getSalonLocation());
        stringmap.put("SalonWebSite", dlg.getSalonWebSite());
        stringmap.put("SalonPhoneNumber", dlg.getSalonPhoneNumber());

        sendObject(stringmap);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        sendMessage("_delete_button");
        String SalonID = (String) SalonTable.getValueAt(SalonTable.getSelectedRow(), 0);
        stringmap = new LinkedHashMap<>();
        stringmap.put("SalonID", SalonID);

        sendObject(stringmap);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        sendMessage("_go_back");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SalonTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalonTableMouseClicked
        if (SalonTable.getSelectedRowCount() > 0) {
            EditButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        } else {
            EditButton.setEnabled(false);
            DeleteButton.setEnabled(false);
        }
    }//GEN-LAST:event_SalonTableMouseClicked



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
            java.util.logging.Logger.getLogger(InsertSalonTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertSalonTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertSalonTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertSalonTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new InsertSalonTable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InsertSalonTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void updateComponents() {
        getContentPane().removeAll();
        initComponents();
    }

    public ArrayList<String[]> getResultFromSalon() {
        ArrayList<String[]> rs = null;

        sendMessage("_get_result_from_salon");
        rs = receiveResultSet();
        return rs;
    }
    
    public String quotate(String content) {
        return " '" + content + "' ";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JTextField SalonAddressField;
    private javax.swing.JTextField SalonCityField;
    private javax.swing.JTextField SalonNameField;
    private javax.swing.JTable SalonTable;
    private javax.swing.JTextField WebField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
