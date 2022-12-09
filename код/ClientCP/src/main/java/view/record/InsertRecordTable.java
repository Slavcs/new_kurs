package view.record;

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


public class InsertRecordTable extends javax.swing.JFrame {
    private EditClientDialog dlgClient;
    private EditRecordDialog dlgRecord;

    
    public InsertRecordTable() throws IOException {
        dlgClient = new EditClientDialog(this, true);
        dlgRecord = new EditRecordDialog(this, true,getIDsFromClient(), getIDsFromService(), getIDsFromEmployee());

        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ClientSurnameField = new javax.swing.JTextField();
        ClientNameField = new javax.swing.JTextField();
        ClientPhoneNumberField = new javax.swing.JTextField();
        AddClientButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArrayList<String[]> rs = getResultFromClient();
        ClientTable = new javax.swing.JTable();
        EditClientButton = new javax.swing.JButton();
        DeleteClientButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ServiceIDCombo = new javax.swing.JComboBox<>();
        RecordDateField = new javax.swing.JTextField();
        RecordTimeField = new javax.swing.JTextField();
        AddRecordButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ArrayList<String[]> rsmr = getResultFromRecord();
        RecordTable = new javax.swing.JTable();
        EditRecordButton = new javax.swing.JButton();
        DeleteRecordButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ClientIDCombo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        EmployeeIDCombo = new javax.swing.JComboBox<>();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Данные о записи клиента");

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Фамилия клиента:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Имя клиента:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Номер телефона:");

        ClientSurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientSurnameFieldActionPerformed(evt);
            }
        });

        AddClientButton.setForeground(new java.awt.Color(255, 0, 102));
        AddClientButton.setText("Добавить клиента");
        AddClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientButtonActionPerformed(evt);
            }
        });

        ClientTable.setModel(new view.record.ClientTableModel(rs));
        ClientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ClientTable);

        EditClientButton.setForeground(new java.awt.Color(255, 0, 102));
        EditClientButton.setText("Редактировать запись");
        EditClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditClientButtonActionPerformed(evt);
            }
        });

        DeleteClientButton.setForeground(new java.awt.Color(255, 0, 102));
        DeleteClientButton.setText("Удалить запись");
        DeleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteClientButtonActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Услуга:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Дата записи:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Время записи:");

        ServiceIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        ServiceIDCombo.setModel(new javax.swing.DefaultComboBoxModel(getIDsFromService()));

        RecordTimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordTimeFieldActionPerformed(evt);
            }
        });

        AddRecordButton.setForeground(new java.awt.Color(255, 0, 102));
        AddRecordButton.setText("Добавить запись");
        AddRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordButtonActionPerformed(evt);
            }
        });

        RecordTable.setModel(new view.record.RecordTableModel(rsmr));
        RecordTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecordTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(RecordTable);

        EditRecordButton.setForeground(new java.awt.Color(255, 0, 102));
        EditRecordButton.setText("Редактировать запись");
        EditRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRecordButtonActionPerformed(evt);
            }
        });

        DeleteRecordButton.setForeground(new java.awt.Color(255, 0, 102));
        DeleteRecordButton.setText("Удалить запись");
        DeleteRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRecordButtonActionPerformed(evt);
            }
        });

        BackButton.setForeground(new java.awt.Color(255, 0, 102));
        BackButton.setText("Назад");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 102));
        jLabel11.setText("Данные о записи в парикмахерскую");

        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("Клиент:");

        ClientIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        ClientIDCombo.setModel(new javax.swing.DefaultComboBoxModel(getIDsFromClient()));

        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Мастер:");

        EmployeeIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        EmployeeIDCombo.setModel(new javax.swing.DefaultComboBoxModel(getIDsFromEmployee()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EditClientButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DeleteClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ClientIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ServiceIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(EmployeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(81, 81, 81)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(RecordDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                            .addComponent(RecordTimeField))
                                        .addGap(80, 80, 80)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(76, 76, 76))))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(EditRecordButton)
                .addGap(67, 67, 67)
                .addComponent(DeleteRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ClientPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addComponent(jLabel4))
                                            .addComponent(ClientSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ClientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AddClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AddRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(ClientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientPhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddClientButton)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditClientButton)
                    .addComponent(DeleteClientButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ServiceIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecordDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecordTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddRecordButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditRecordButton)
                    .addComponent(DeleteRecordButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        setSize(new java.awt.Dimension(544, 691));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ClientSurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientSurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientSurnameFieldActionPerformed

    private void RecordTimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordTimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecordTimeFieldActionPerformed

    private void DeleteRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRecordButtonActionPerformed
        sendMessage("_delete_button_record");
        String RecordID = (String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 0);
        stringmap = new LinkedHashMap<>();
        stringmap.put("RecordID", RecordID);

        sendObject(stringmap);
    }//GEN-LAST:event_DeleteRecordButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        sendMessage("_go_back");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AddClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientButtonActionPerformed
sendMessage("_send_button");
ClientCP.stringmap = new LinkedHashMap<>();
        ClientCP.stringmap.put("ClientSurname", this.ClientSurnameField.getText());
        ClientCP.stringmap.put("ClientName", this.ClientNameField.getText());
        ClientCP.stringmap.put("ClientPhoneNumber", (String) this.ClientPhoneNumberField.getText());
        ClientCP.sendObject(ClientCP.stringmap);

        this.setVisible(false);
    }//GEN-LAST:event_AddClientButtonActionPerformed

    private void EditClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditClientButtonActionPerformed
         sendMessage("_edit_button");

        dlgClient.setClientSurname((String) ClientTable.getValueAt(ClientTable.getSelectedRow(), 1));
        dlgClient.setClientName((String) ClientTable.getValueAt(ClientTable.getSelectedRow(), 2));
        dlgClient.setClientPhoneNumber((String) ClientTable.getValueAt(ClientTable.getSelectedRow(), 3));
        dlgClient.setVisible(true);

        stringmap = new LinkedHashMap<>();

        stringmap.put("ClientID", (String) ClientTable.getValueAt(ClientTable.getSelectedRow(), 0));
        stringmap.put("ClientSurname", dlgClient.getClientSurname());
        stringmap.put("ClientName", dlgClient.getClientName());
        stringmap.put("ClientPhoneNumber", dlgClient.getClientPhoneNumber());
        sendObject(stringmap);
    }//GEN-LAST:event_EditClientButtonActionPerformed

    private void DeleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteClientButtonActionPerformed
        sendMessage("_delete_button");
        String ClientID = (String) ClientTable.getValueAt(ClientTable.getSelectedRow(), 0);
        stringmap = new LinkedHashMap<>();
        stringmap.put("ClientID", ClientID);

        sendObject(stringmap);
    }//GEN-LAST:event_DeleteClientButtonActionPerformed

    private void AddRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordButtonActionPerformed
sendMessage("_send_button_record");
ClientCP.stringmap = new LinkedHashMap<>();
        ClientCP.stringmap.put("ClientSurname", (String) this.ClientIDCombo.getSelectedItem());
        ClientCP.stringmap.put("ServiceName", (String) this.ServiceIDCombo.getSelectedItem());
        ClientCP.stringmap.put("EmployeeSurname", (String) this.EmployeeIDCombo.getSelectedItem());
        ClientCP.stringmap.put("RecordDate", this.RecordDateField.getText());
        ClientCP.stringmap.put("RecordTime", this.RecordTimeField.getText());
        ClientCP.sendObject(ClientCP.stringmap);

        this.setVisible(false);  
    }//GEN-LAST:event_AddRecordButtonActionPerformed

    private void EditRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRecordButtonActionPerformed
        sendMessage("_edit_button_record");

        dlgRecord.setClientSurname((String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 1));
        dlgRecord.setServiceName((String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 2));
        dlgRecord.setEmployeeSurname((String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 3));
        dlgRecord.setRecordDate((String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 4));
        dlgRecord.setRecordTime((String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 5));
        dlgRecord.setVisible(true);

        stringmap = new LinkedHashMap<>();

        stringmap.put("RecordID", (String) RecordTable.getValueAt(RecordTable.getSelectedRow(), 0));
        stringmap.put("ClientSurname", dlgRecord.getClientSurname());
        stringmap.put("ServiceName", dlgRecord.getServiceName());
        stringmap.put("EmployeeSurname", dlgRecord.getEmployeeSurname());
        stringmap.put("RecordDate", dlgRecord.getRecordDate());
        stringmap.put("RecordTime", dlgRecord.getRecordTime());

        sendObject(stringmap);
    }//GEN-LAST:event_EditRecordButtonActionPerformed

    private void ClientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientTableMouseClicked
        if (ClientTable.getSelectedRowCount() > 0) {
            EditClientButton.setEnabled(true);
            DeleteClientButton.setEnabled(true);
            AddRecordButton.setEnabled(true);
        } else {
            EditClientButton.setEnabled(false);
            DeleteClientButton.setEnabled(false);
            AddRecordButton.setEnabled(false);
        }
    }//GEN-LAST:event_ClientTableMouseClicked

    private void RecordTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecordTableMouseClicked
        if (RecordTable.getSelectedRowCount() > 0) {
            EditRecordButton.setEnabled(true);
            DeleteRecordButton.setEnabled(true);
        } else {
            EditRecordButton.setEnabled(false);
            DeleteRecordButton.setEnabled(false);
        }
    }//GEN-LAST:event_RecordTableMouseClicked

   
    
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
            java.util.logging.Logger.getLogger(InsertRecordTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertRecordTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertRecordTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertRecordTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new InsertRecordTable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InsertRecordTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
     public void updateComponents() {
        getContentPane().removeAll();
        initComponents();
    }

    public ArrayList<String[]> getResultFromRecord() {
        ArrayList<String[]> rs = null;

        sendMessage("_get_result_from_record");
        rs = receiveResultSet();
        return rs;
    }

    public ArrayList<String[]> getResultFromClient() {
        ArrayList<String[]> rs = null;

        sendMessage("_get_result_from_client");
        rs = receiveResultSet();
        return rs;
    }

    public String[] getIDsFromService() {
        ArrayList<String> arrList = new ArrayList<>();
        ArrayList<String[]> rs = null;

        sendMessage("_get_ids_from_service");
        rs = receiveResultSet();
        for (int i = 0; i < rs.size(); i++) {
            arrList.add(rs.get(i)[0]);
        }
        return arrList.toArray(new String[arrList.size()]);
    }
    
    public String[] getIDsFromClient() {
        ArrayList<String> arrList = new ArrayList<>();
        ArrayList<String[]> rs = null;

        sendMessage("_get_ids_from_client");
        rs = receiveResultSet();
        for (int i = 0; i < rs.size(); i++) {
            arrList.add(rs.get(i)[0]);
        }
        return arrList.toArray(new String[arrList.size()]);
    }
    
    public String[] getIDsFromEmployee() {
        ArrayList<String> arrList = new ArrayList<>();
        ArrayList<String[]> rs = null;

        sendMessage("_get_ids_from_employee");
        rs = receiveResultSet();
        for (int i = 0; i < rs.size(); i++) {
            arrList.add(rs.get(i)[0]);
        }
        return arrList.toArray(new String[arrList.size()]);
    }
    
    public String quotate(String content) {
        return " '" + content + "' ";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClientButton;
    private javax.swing.JButton AddRecordButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> ClientIDCombo;
    private javax.swing.JTextField ClientNameField;
    private javax.swing.JTextField ClientPhoneNumberField;
    private javax.swing.JTextField ClientSurnameField;
    private javax.swing.JTable ClientTable;
    private javax.swing.JButton DeleteClientButton;
    private javax.swing.JButton DeleteRecordButton;
    private javax.swing.JButton EditClientButton;
    private javax.swing.JButton EditRecordButton;
    private javax.swing.JComboBox<String> EmployeeIDCombo;
    private javax.swing.JTextField RecordDateField;
    private javax.swing.JTable RecordTable;
    private javax.swing.JTextField RecordTimeField;
    private javax.swing.JComboBox<String> ServiceIDCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
