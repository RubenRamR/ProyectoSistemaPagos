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
public class DlgModificarBeneficiario extends javax.swing.JDialog {

    private IBeneficiarioNegocio beneficiarioNegocio;
    private BeneficiarioDTO beneficiarioDTO;
    private long idBeneficiario;

    public DlgModificarBeneficiario(long idBeneficiario) {
        super();

        this.beneficiarioNegocio = new BeneficiarioNegocio();
        this.idBeneficiario = idBeneficiario;

        initComponents();

        consultarBeneficiarioYLlenarTextFields();
    }

    private void consultarBeneficiarioYLlenarTextFields() {
        try
        {
            this.beneficiarioDTO = beneficiarioNegocio.buscarBeneficiarioPorId(idBeneficiario);
        } catch (NegocioException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }

        txtNombres.setText(beneficiarioDTO.getNombres());
        txtUsuario.setText(beneficiarioDTO.getUsuario());
        txtClaveDeContrato.setText(beneficiarioDTO.getClaveContrato());
        txtApellidoPaterno.setText(beneficiarioDTO.getApellidoPaterno());
        txtApellidoMaterno.setText(beneficiarioDTO.getApellidoMaterno());
        txtContrasena.setText(beneficiarioDTO.getContrasena());

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
        txtContrasena = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtClaveDeContrato = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(720, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Modificar o eliminar beneficiario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 310, 30));

        lblContrasena.setText("Contraseña del usuario:");
        jPanel1.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        lblUsuario.setText("Nombre de usuario:");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, 20));

        lblNombre.setText("Nombre(s):");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        lblApellidoP.setText("Apellido paterno:");
        jPanel1.add(lblApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        lblApellidoM.setText("Apellido materno:");
        jPanel1.add(lblApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        lblClaveContrato.setText("Clave de contrato:");
        jPanel1.add(lblClaveContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 230, -1));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 230, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 190, -1));
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 190, -1));
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 190, -1));
        jPanel1.add(txtClaveDeContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 270, -1));

        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        btnEliminar.setText("Eliminar beneficiario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

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

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here: 
        if (txtNombres.getText().trim().isEmpty()
                || txtApellidoPaterno.getText().trim().isEmpty()
                || txtUsuario.getText().trim().isEmpty()
                || txtContrasena.getText().trim().isEmpty()
                || txtClaveDeContrato.getText().trim().isEmpty())
        {

            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BeneficiarioDTO beneficiario = new BeneficiarioDTO();
        beneficiario.setId(idBeneficiario);
        beneficiario.setNombres(txtNombres.getText());
        beneficiario.setApellidoPaterno(txtApellidoPaterno.getText());
        beneficiario.setApellidoMaterno(txtApellidoMaterno.getText());
        beneficiario.setUsuario(txtUsuario.getText());
        beneficiario.setContrasena(txtContrasena.getText());
        beneficiario.setClaveContrato(txtClaveDeContrato.getText());
        beneficiario.setSaldo(1000);
        beneficiario.setEliminado(false);

        try
        {
            beneficiarioNegocio.modificarBeneficiario(beneficiario);
            JOptionPane.showMessageDialog(this, "Beneficiario modificado correctamente");
            this.dispose();
        } catch (NegocioException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try
        {
            // TODO add your handling code here:
            beneficiarioNegocio.eliminarBeneficiario(idBeneficiario);
        } catch (NegocioException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }

        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblClaveContrato;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtClaveDeContrato;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
