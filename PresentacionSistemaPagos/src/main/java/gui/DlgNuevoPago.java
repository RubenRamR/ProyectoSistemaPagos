/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.EstatusDTO;
import DTOs.Estatus_pagoDTO;
import DTOs.PagoDTO;
import DTOs.TipoPagoDTO;
import InterfacesNegocio.IBeneficiarioNegocio;
import InterfacesNegocio.ICuentaBancariaNegocio;
import InterfacesNegocio.IPagoNegocio;
import bo.BeneficiarioNegocio;
import bo.CuentaBancariaNegocio;
import bo.PagoNegocio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author crazy
 */
public class DlgNuevoPago extends javax.swing.JDialog {

    private BeneficiarioDTO beneficiarioLogeado;
    private IPagoNegocio pagoneg;
    private ICuentaBancariaNegocio cuentaneg;
    private IBeneficiarioNegocio beneneg;

    public DlgNuevoPago(BeneficiarioDTO beneficiarioLogeado) {

        super();
        this.cuentaneg = new CuentaBancariaNegocio();
        this.beneneg = new BeneficiarioNegocio();
        this.pagoneg = new PagoNegocio();
        this.beneficiarioLogeado = beneficiarioLogeado;
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
        comboTipoDePago = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

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

        comboTipoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoDePagoActionPerformed(evt);
            }
        });
        jPanel1.add(comboTipoDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 190, -1));

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

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            TipoPagoDTO tipoPago = new TipoPagoDTO();
            tipoPago.setId(6l);
            tipoPago.setEliminado(false);
            tipoPago.setNombre("Mensualidad");
            tipoPago.setNumMensualidades(12);

            // Recopilando datos del formulario
            float monto = Float.parseFloat(txtMonto.getText());
            String comprobante = txtMensaje.getText();
            String banco = txtBanco.getText();
            long numeroCuenta = Long.parseLong(txtCuenta.getText());
            String clave = txtClabe.getText();
//            String tipoPagoSeleccionado = comboTipoDePago.getSelectedItem().toString();

            BeneficiarioDTO beneficiario = beneneg.buscarBeneficiarioDTO(beneficiarioLogeado);

            CuentaBancariaDTO cuentaBancaria = new CuentaBancariaDTO();
            cuentaBancaria.setBanco(banco);
            cuentaBancaria.setNumeroCuenta(numeroCuenta);
            cuentaBancaria.setClave(clave);
            cuentaBancaria.setBeneficiario(beneficiario);

            cuentaneg.guardarCuentaBancaria(cuentaBancaria);

            CuentaBancariaDTO cuentaBancaria1 = cuentaneg.buscarCuentaBancariaDTO(cuentaBancaria);
            PagoDTO nuevoPago = new PagoDTO();
            nuevoPago.setMonto(monto);
            nuevoPago.setComprobante(comprobante);
            nuevoPago.setFechaHora(Calendar.getInstance());
            nuevoPago.setBeneficiario(beneficiario);
            nuevoPago.setCuentaBancaria(cuentaBancaria1);
            nuevoPago.setTipoPago(tipoPago);
            nuevoPago.setEliminado(false);

            pagoneg.guardarPago(nuevoPago);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un monto válido");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el pago: " + ex.getMessage());
        }

        // Cerrar la ventana actual
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void comboTipoDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoDePagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoDePagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
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
