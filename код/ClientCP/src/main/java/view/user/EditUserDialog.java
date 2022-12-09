package view.user;

import clientcp.ClientCP;

import javax.swing.JFrame;
import java.util.LinkedHashMap;

import static clientcp.ClientCP.sendMessage;

public class EditUserDialog extends javax.swing.JDialog {
private String[] salonIDs;
    
    public EditUserDialog(java.awt.Frame parent, boolean modal, String[] salonIDs) {
        super(parent, modal);
        this.salonIDs = salonIDs;
        initComponents();
    }

    private EditUserDialog(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SalonIDCombo = new javax.swing.JComboBox<>();
        EmployeeSurnameField = new javax.swing.JTextField();
        EmployeeNameField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Данные о мастере парикмахерской");

        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("ID мастера:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Парикмахерская:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Фамилия:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Имя:");

        SalonIDCombo.setForeground(new java.awt.Color(0, 0, 153));
        SalonIDCombo.setModel(new javax.swing.DefaultComboBoxModel(salonIDs));

        OKButton.setForeground(new java.awt.Color(255, 0, 102));
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(SalonIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EmployeeSurnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(EmployeeNameField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OKButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SalonIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(EmployeeSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(EmployeeNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        sendMessage("_edit_button");
        ClientCP.stringmap = new LinkedHashMap<>();
        ClientCP.stringmap.put("SalonID", (String) this.SalonIDCombo.getSelectedItem());
        ClientCP.stringmap.put("EmployeeID", this.jLabel2.getText().split(":")[1]);
        ClientCP.stringmap.put("EmployeeSurname", this.EmployeeSurnameField.getText());
        ClientCP.stringmap.put("EmployeeName", this.EmployeeNameField.getText());
        ClientCP.sendObject(ClientCP.stringmap);
        this.jLabel2.setText(this.jLabel2.getText().split(":")[0]);

        this.setVisible(false);

    }//GEN-LAST:event_OKButtonActionPerformed

    public String getSalonID() {
        return (String) SalonIDCombo.getSelectedItem();
    }

    public void setSalonID(String SalonID) {
        this.SalonIDCombo.setSelectedItem(SalonID);
    }
    
    public String getEmployeeID() {
        System.out.println(this.jLabel2.getText().split(":")[1]);
        return this.jLabel2.getText().split(":")[1];
//        return (String) EmployeeIDField.getText();
    }

    public void setEmployeeID(String EmployeeID) {
        this.jLabel2.setText(this.jLabel2.getText()+EmployeeID);
//        this.EmployeeIDField.setText(EmployeeID);
    }
    
        public String getEmployeeSurname() {
        return (String) EmployeeSurnameField.getText();
    }

    public void setEmployeeSurname(String EmployeeSurname) {
        this.EmployeeSurnameField.setText(EmployeeSurname);
    }
    
        public String getEmployeeName() {
        return (String) EmployeeNameField.getText();
    }

    public void setEmployeeName(String RecordTime) {
        this.EmployeeNameField.setText(RecordTime);
    }
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
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditUserDialog dialog = new EditUserDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField EmployeeNameField;
    private javax.swing.JTextField EmployeeSurnameField;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox<String> SalonIDCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
