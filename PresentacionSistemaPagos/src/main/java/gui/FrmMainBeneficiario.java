/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.image.BufferedImage;

/**
 *
 * @author crazy
 */
public class FrmMainBeneficiario extends javax.swing.JFrame {


    public FrmMainBeneficiario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuCuenta = new javax.swing.JMenu();
        itemMisCuentas = new javax.swing.JMenuItem();
        itemCerrarSesion = new javax.swing.JMenuItem();
        menuPagos = new javax.swing.JMenu();
        itemNuevoPago = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenu();
        itemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Monto", "Estatus", "Tipo", "Parcialidades", "FechaHora", "Ver abonos", "Modificar"
            }
        ));
        jScrollPane1.setViewportView(tblPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 710, 410));

        jLabel1.setText("Su lista de pagos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, -1));

        jButton1.setText("ver abonos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 90, 20));

        jButton2.setText("modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        menuCuenta.setText("Cuenta");

        itemMisCuentas.setText("Mis cuentas");
        itemMisCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMisCuentasActionPerformed(evt);
            }
        });
        menuCuenta.add(itemMisCuentas);

        itemCerrarSesion.setText("Cerrar sesión");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        menuCuenta.add(itemCerrarSesion);

        jMenuBar2.add(menuCuenta);

        menuPagos.setText("Pagos");

        itemNuevoPago.setText("Nuevo pago");
        itemNuevoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoPagoActionPerformed(evt);
            }
        });
        menuPagos.add(itemNuevoPago);

        jMenuBar2.add(menuPagos);

        menuAcercaDe.setText("Acerca de");

        itemAcercaDe.setText("Acerca de");
        itemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaDeActionPerformed(evt);
            }
        });
        menuAcercaDe.add(itemAcercaDe);

        jMenuBar2.add(menuAcercaDe);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemMisCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMisCuentasActionPerformed
        // TODO add your handling code here:}
        FrmMisCuentas fmc = new FrmMisCuentas();
        fmc.setVisible(true);
    }//GEN-LAST:event_itemMisCuentasActionPerformed

    private void itemNuevoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoPagoActionPerformed
        // TODO add your handling code here:
        DlgNuevoPago fnp = new DlgNuevoPago(this, false);
        fnp.setVisible(true);
    }//GEN-LAST:event_itemNuevoPagoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FrmVerAbonos dva = new FrmVerAbonos();
        dva.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DlgModificarPago dmp = new DlgModificarPago(this, false);
        dmp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaDeActionPerformed
        // TODO add your handling code here:
        DlgAcercaDe dad = new DlgAcercaDe(this, false);
        dad.setVisible(true);
    }//GEN-LAST:event_itemAcercaDeActionPerformed

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        // TODO add your handling code here:
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemCerrarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemMisCuentas;
    private javax.swing.JMenuItem itemNuevoPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenu menuPagos;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
