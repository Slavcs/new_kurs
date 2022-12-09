package view.service;

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

public class InsertServiceTable extends javax.swing.JFrame {
     private EditServiceDialog dlg;

    public InsertServiceTable() throws IOException {
        dlg = new EditServiceDialog(this, true);

        initComponents();

        TableRowSorter<ServiceTableModel> sorter = new TableRowSorter<>();
        sorter.setModel((ServiceTableModel) ServiceTable.getModel());
        ServiceTable.setRowSorter(sorter);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ServiceNameField = new javax.swing.JTextField();
        ServiceCostField = new javax.swing.JTextField();
        ServiceTypeCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArrayList<String[]> rs = getResultFromService();
        ServiceTable = new javax.swing.JTable();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Данные об услугах парикмахерской");

        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Название:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Стоимость:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Вид:");

        ServiceTypeCombo.setForeground(new java.awt.Color(0, 0, 153));
        ServiceTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Стрижка", "Выпрямление", "Окрашивание", "Завивка"}));

        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("бел.руб.");

        AddButton.setForeground(new java.awt.Color(255, 0, 102));
        AddButton.setText("Добавить услугу");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ServiceTable.setModel(new view.service.ServiceTableModel(rs));
        ServiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ServiceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ServiceTable);

        EditButton.setForeground(new java.awt.Color(255, 0, 102));
        EditButton.setText("Изменить запись");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(EditButton)
                                .addGap(52, 52, 52)
                                .addComponent(DeleteButton)
                                .addGap(47, 47, 47)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ServiceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ServiceCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(ServiceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServiceNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServiceCostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServiceTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
//        sendMessage("_send_button");
//        //String ServiceID = ServiceIDField.getText();
//        String ServiceName = ServiceNameField.getText();
//        String ServiceCost = ServiceCostField.getText();
//        String ServiceType = (String)ServiceTypeCombo.getSelectedItem();
//
//        stringmap = new LinkedHashMap<>();
//
//        //stringmap.put("ServiceID", ServiceID);
//        stringmap.put("ServiceName", ServiceName);
//        stringmap.put("ServiceType", ServiceType);
//        stringmap.put("ServiceCost", ServiceCost);
//
//        sendObject(stringmap);
sendMessage("_send_button");
ClientCP.stringmap = new LinkedHashMap<>();
        ClientCP.stringmap.put("ServiceName", this.ServiceNameField.getText());
        ClientCP.stringmap.put("ServiceCost", this.ServiceCostField.getText());
        ClientCP.stringmap.put("ServiceType", (String) this.ServiceTypeCombo.getSelectedItem());
        ClientCP.sendObject(ClientCP.stringmap);

        this.setVisible(false);  
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
         sendMessage("_edit_button");
        //dlg.setServiceID((String) ServiceTable.getValueAt(ServiceTable.getSelectedRow(), 0));
        dlg.setServiceName((String) ServiceTable.getValueAt(ServiceTable.getSelectedRow(), 1));
        dlg.setServiceCost((String) ServiceTable.getValueAt(ServiceTable.getSelectedRow(), 2));
        dlg.setServiceType((String) ServiceTable.getValueAt(ServiceTable.getSelectedRow(), 3));
        dlg.setVisible(true);

        stringmap = new LinkedHashMap<>();

        //stringmap.put("ServiceID", dlg.getServiceID());
        stringmap.put("ServiceID", (String) ServiceTable.getValueAt(ServiceTable.getSelectedRow(), 0));
        stringmap.put("ServiceName", dlg.getServiceName());
        stringmap.put("ServiceCost", dlg.getServiceCost());
        stringmap.put("ServiceType", dlg.getServiceType());

        sendObject(stringmap);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        sendMessage("_delete_button");
        String ServiceID = (String) ServiceTable.getValueAt(ServiceTable.getSelectedRow(), 0);
        stringmap = new LinkedHashMap<>();
        stringmap.put("ServiceID", ServiceID);

        sendObject(stringmap);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        sendMessage("_go_back");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ServiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServiceTableMouseClicked
        if (ServiceTable.getSelectedRowCount() > 0) {
            EditButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        } else {
            EditButton.setEnabled(false);
            DeleteButton.setEnabled(false);
        }
    }//GEN-LAST:event_ServiceTableMouseClicked

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
            java.util.logging.Logger.getLogger(InsertServiceTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertServiceTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertServiceTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertServiceTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new InsertServiceTable().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InsertServiceTable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void updateComponents() {
        getContentPane().removeAll();
        initComponents();
    }

    public ArrayList<String[]> getResultFromService() {
        ArrayList<String[]> rs = null;

        sendMessage("_get_result_from_service");
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
    private javax.swing.JTextField ServiceCostField;
    private javax.swing.JTextField ServiceNameField;
    private javax.swing.JTable ServiceTable;
    private javax.swing.JComboBox<String> ServiceTypeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
