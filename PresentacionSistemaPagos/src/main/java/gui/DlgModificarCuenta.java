/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import DTOs.CuentaBancariaDTO;
import InterfacesNegocio.ICuentaBancariaNegocio;
import bo.CuentaBancariaNegocio;
import excepciones.NegocioException;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author crazy
 */
public class DlgModificarCuenta extends javax.swing.JDialog {

    private ICuentaBancariaNegocio cuentaBancariaNegocio;
    private CuentaBancariaDTO cuentaBancariaDTO;
    private long idCuentaBancaria;

    public DlgModificarCuenta(java.awt.Frame parent, boolean modal, long idCuentaBancaria) {
        super(parent, modal);
        initComponents();
        this.cuentaBancariaNegocio = new CuentaBancariaNegocio();
        this.idCuentaBancaria = idCuentaBancaria;

        consultarCuentaYLlenarTextFields();
    }

    private void consultarCuentaYLlenarTextFields() {
        try
        {
            this.cuentaBancariaDTO = cuentaBancariaNegocio.buscarCuentaBancariaPorId(idCuentaBancaria);
        } catch (NegocioException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }

        String numeroCuenta = String.valueOf(cuentaBancariaDTO.getNumeroCuenta());

        txtNumeroCuenta.setText(numeroCuenta);
        txtClabe.setText(cuentaBancariaDTO.getClave());
        txtBanco.setText(cuentaBancariaDTO.getBanco());

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
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

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

        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        btnEliminar.setText("Eliminar cuenta");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtNumeroCuenta.getText().trim().isEmpty()
                || txtClabe.getText().trim().isEmpty()
                || txtBanco.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CuentaBancariaDTO cuentaBancaria = new CuentaBancariaDTO();
        cuentaBancaria.setId(idCuentaBancaria);
        cuentaBancaria.setNumeroCuenta(Long.parseLong(txtNumeroCuenta.getText()));
        cuentaBancaria.setClave(txtClabe.getText());
        cuentaBancaria.setBanco(txtBanco.getText());
        cuentaBancaria.setEliminado(false);

        try
        {
            cuentaBancariaNegocio.modificarCuentaBancaria(idCuentaBancaria, cuentaBancaria);
            JOptionPane.showMessageDialog(this, "Cuenta Bancaria modificada correctamente");

            this.dispose();

        } catch (NegocioException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try
        {
            CuentaBancariaDTO cuentaBancaria = cuentaBancariaNegocio.buscarCuentaBancariaPorId(idCuentaBancaria);
            if (cuentaBancaria == null)
            {
                JOptionPane.showMessageDialog(this, "La cuenta bancaria con ID " + idCuentaBancaria + " no existe", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            cuentaBancaria.setEliminado(true);
            cuentaBancariaNegocio.modificarCuentaBancaria(idCuentaBancaria, cuentaBancaria);

            JOptionPane.showMessageDialog(this, "Cuenta Bancaria eliminada correctamente");

            this.dispose();

        } catch (NegocioException ex)
        {
            JOptionPane.showMessageDialog(this, "Error al eliminar la cuenta bancaria: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClabe;
    private javax.swing.JLabel lblNumeroCuenta;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtClabe;
    private javax.swing.JTextField txtNumeroCuenta;
    // End of variables declaration//GEN-END:variables
}
