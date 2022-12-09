package view.record;

import javax.swing.JFrame;


public class EditRecordDialog extends javax.swing.JDialog {
    private String[] clientIDs;
    private String[] serviceIDs;
    private String[] employeeIDs;
    
    public EditRecordDialog(java.awt.Frame parent, boolean modal, String[] clientIDs, String[] serviceIDs, String[] employeeIDs) {
        super(parent, modal);
        this.clientIDs = clientIDs;
        this.serviceIDs = serviceIDs;
        this.employeeIDs = employeeIDs;
        initComponents();
    }

    private EditRecordDialog(JFrame jFrame, boolean b) {
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ServiceIDCombo = new javax.swing.JComboBox<>();
        RecordDateField = new javax.swing.JTextField();
        RecordTimeField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        ClientIDCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EmployeeIDCombo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Данные о записи в парикмахерской");

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Услуга:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Дата записи:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Время записи:");

        ServiceIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        ServiceIDCombo.setModel(new javax.swing.DefaultComboBoxModel(serviceIDs));

        RecordDateField.setForeground(new java.awt.Color(0, 0, 153));

        RecordTimeField.setForeground(new java.awt.Color(0, 0, 153));

        OKButton.setForeground(new java.awt.Color(255, 0, 102));
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        ClientIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        ClientIDCombo.setModel(new javax.swing.DefaultComboBoxModel(clientIDs));

        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Клиент:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Мастер:");

        EmployeeIDCombo.setModel(new javax.swing.DefaultComboBoxModel(employeeIDs));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClientIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ServiceIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmployeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecordDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RecordTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ClientIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ServiceIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecordDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RecordTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

//    public String getRecordID() {
//        return (String) RecordIDField.getText();
//    }
//
//    public void setRecordID(String RecordID) {
//        this.RecordIDField.setText(RecordID);
//    }
    
    public String getClientSurname() {
        return (String) ClientIDCombo.getSelectedItem();
    }

    public void setClientSurname(String ClientSurname) {
        this.ClientIDCombo.setSelectedItem(ClientSurname);
    }
    
    public String getEmployeeSurname() {
        return (String) EmployeeIDCombo.getSelectedItem();
    }

    public void setEmployeeSurname(String EmployeeSurname) {
        this.EmployeeIDCombo.setSelectedItem(EmployeeSurname);
    }
    
    public String getServiceName() {
        return (String) ServiceIDCombo.getSelectedItem();
    }

    public void setServiceName(String ServiceName) {
        this.ServiceIDCombo.setSelectedItem(ServiceName);
    }
    
    public String getRecordDate() {
        return (String) RecordDateField.getText();
    }

    public void setRecordDate(String RecordDate) {
        this.RecordDateField.setText(RecordDate);
    }
    
        public String getRecordTime() {
        return (String) RecordTimeField.getText();
    }

    public void setRecordTime(String RecordTime) {
        this.RecordTimeField.setText(RecordTime);
    }
    
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
            java.util.logging.Logger.getLogger(EditRecordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRecordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRecordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRecordDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditRecordDialog dialog = new EditRecordDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClientIDCombo;
    private javax.swing.JComboBox<String> EmployeeIDCombo;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField RecordDateField;
    private javax.swing.JTextField RecordTimeField;
    private javax.swing.JComboBox<String> ServiceIDCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
