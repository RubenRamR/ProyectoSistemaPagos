/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import java.awt.image.BufferedImage;

/**
 *
 * @author crazy
 */
public class DlgModificarPago extends javax.swing.JDialog {
    
    
    public DlgModificarPago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMonto = new javax.swing.JLabel();
        lblBanco = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        lblClabe = new javax.swing.JLabel();
        lblTipoPago = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtCuenta = new javax.swing.JTextField();
        txtClabe = new javax.swing.JTextField();
        txtMensaje = new javax.swing.JTextField();
        comboTipoDePago = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));

        jPanel1.setPreferredSize(new java.awt.Dimension(720, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMonto.setText("Monto a pagar:");
        jPanel1.add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 90, -1));

        lblBanco.setText("Banco:");
        jPanel1.add(lblBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lblCuenta.setText("Numero de la cuenta:");
        jPanel1.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 120, -1));

        lblClabe.setText("CLABE:");
        jPanel1.add(lblClabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        lblTipoPago.setText("Tipo de pago a hacer:");
        jPanel1.add(lblTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        lblMensaje.setText("Mensaje:");
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        txtBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBancoActionPerformed(evt);
            }
        });
        jPanel1.add(txtBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, -1));
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 140, -1));
        jPanel1.add(txtCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 180, -1));
        jPanel1.add(txtClabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 180, -1));

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 190, -1));

        comboTipoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Viatico", "Proveedor", "Reembolso" }));
        jPanel1.add(comboTipoDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        btnEliminar.setText("Eliminar pago");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBancoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajeActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboTipoDePago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblClabe;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblTipoPago;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtClabe;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtMensaje;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
