/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import DTOs.BeneficiarioDTO;
import InterfacesNegocio.IBeneficiarioNegocio;
import bo.BeneficiarioNegocio;
import excepciones.NegocioException;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author crazy
 */
public class DlgRegistrarBeneficiario extends javax.swing.JDialog {

    private IBeneficiarioNegocio beneficiarioNegocio;

    public DlgRegistrarBeneficiario() {
        super();
        this.beneficiarioNegocio = new BeneficiarioNegocio();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoP = new javax.swing.JLabel();
        lblApellidoM = new javax.swing.JLabel();
        lblClaveContrato = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtClaveDeContrato = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblContrasena1 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        txtContrasenaRep = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(720, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar un beneficiario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 210, 30));

        lblContrasena.setText("Contraseña del usuario:");
        jPanel1.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        lblUsuario.setText("Nombre de usuario:");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, 20));

        lblNombre.setText("Nombre(s):");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        lblApellidoP.setText("Apellido paterno:");
        jPanel1.add(lblApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        lblApellidoM.setText("Apellido materno:");
        jPanel1.add(lblApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        lblClaveContrato.setText("Clave de contrato:");
        jPanel1.add(lblClaveContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 190, -1));
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 190, -1));
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 190, -1));
        jPanel1.add(txtClaveDeContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 270, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, -1, -1));

        lblContrasena1.setText("Repite la contraseña:");
        jPanel1.add(lblContrasena1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 230, -1));
        jPanel1.add(txtContrasenaRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 230, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (txtNombres.getText().trim().isEmpty()
                || txtApellidoPaterno.getText().trim().isEmpty()
                || txtApellidoMaterno.getText().trim().isEmpty()
                || txtUsuario.getText().trim().isEmpty()
                || txtContrasena.getText().trim().isEmpty()
                || txtContrasenaRep.getText().trim().isEmpty()
                || txtClaveDeContrato.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String contraseña = new String(txtContrasena.getPassword()).trim();
        String confirmarContraseña = new String(txtContrasenaRep.getPassword()).trim();

        if (!contraseña.equals(confirmarContraseña)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error de contraseña", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BeneficiarioDTO beneficiario = new BeneficiarioDTO();
        beneficiario.setNombres(txtNombres.getText());
        beneficiario.setApellidoPaterno(txtApellidoPaterno.getText());
        beneficiario.setApellidoMaterno(txtApellidoMaterno.getText());
        beneficiario.setUsuario(txtUsuario.getText());
        beneficiario.setContrasena(contraseña);
        beneficiario.setClaveContrato(txtClaveDeContrato.getText());
        beneficiario.setSaldo(1000);
        beneficiario.setEliminado(false);

        try {
            beneficiarioNegocio.guardarBeneficiario(beneficiario);
            JOptionPane.showMessageDialog(this, "Beneficiario registrado correctamente");
            this.dispose();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblClaveContrato;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblContrasena1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtClaveDeContrato;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JPasswordField txtContrasenaRep;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
