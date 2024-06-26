/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import InterfacesNegocio.IBeneficiarioNegocio;
import InterfacesNegocio.ICuentaBancariaNegocio;
import bo.BeneficiarioNegocio;
import bo.CuentaBancariaNegocio;
import excepciones.NegocioException;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author crazy
 */
public class DlgAnadirCuenta extends javax.swing.JDialog {

    private BeneficiarioDTO beneficiarioLogeado;
    private ICuentaBancariaNegocio cuentaneg;
    private IBeneficiarioNegocio beneneg;

    public DlgAnadirCuenta(java.awt.Frame parent, boolean modal, BeneficiarioDTO beneficiarioLogeado) {
        super(parent, modal);
        this.cuentaneg = new CuentaBancariaNegocio();
        this.beneneg = new BeneficiarioNegocio();
        this.beneficiarioLogeado = beneficiarioLogeado;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNumeroCuenta = new javax.swing.JLabel();
        txtNumeroCuenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblClabe = new javax.swing.JLabel();
        txtClabe = new javax.swing.JTextField();
        txtBanco = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumeroCuenta.setText("Numero de cuenta:");
        jPanel1.add(lblNumeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        txtNumeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 200, -1));

        jLabel1.setText("Banco:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 40, -1));

        lblClabe.setText("CLABE:");
        jPanel1.add(lblClabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txtClabe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClabeActionPerformed(evt);
            }
        });
        jPanel1.add(txtClabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 260, -1));
        jPanel1.add(txtBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 260, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

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

    private void txtNumeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCuentaActionPerformed

    private void txtClabeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClabeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClabeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        try {

            String banco = txtBanco.getText();
            long numeroCuenta = Long.parseLong(txtNumeroCuenta.getText());
            String clave = txtClabe.getText();

            BeneficiarioDTO beneficiario = beneneg.buscarBeneficiarioDTO(beneficiarioLogeado);

            CuentaBancariaDTO cuenta = new CuentaBancariaDTO();

            cuenta.setBanco(banco);
            cuenta.setNumeroCuenta(numeroCuenta);
            cuenta.setClave(clave);
            cuenta.setBeneficiario(beneficiario);
            cuenta.setEliminado(false);

            try {
                cuentaneg.guardarCuentaBancaria(cuenta);
                JOptionPane.showMessageDialog(this, "Cuenta bancaria registrado correctamente");

                this.dispose();
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

            this.dispose();
        } catch (NegocioException ex) {
            Logger.getLogger(DlgAnadirCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClabe;
    private javax.swing.JLabel lblNumeroCuenta;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtClabe;
    private javax.swing.JTextField txtNumeroCuenta;
    // End of variables declaration//GEN-END:variables
}
