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
public class FrmAdminPagarRechazar extends javax.swing.JFrame {
    
    public FrmAdminPagarRechazar() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        lblEstatus = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblAbonado = new javax.swing.JLabel();
        lblFechas = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        comboEstatus = new javax.swing.JComboBox<>();
        comboAbonado = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Monto", "FechaHora", "Estatus", "Tipo", "Beneficiario", "Cuenta", "Terminado", "Pagar", "Rechazar"
            }
        ));
        jScrollPane1.setViewportView(tblPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 590, 400));

        lblEstatus.setText("Estatus:");
        jPanel1.add(lblEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lblCliente.setText("Cliente:");
        jPanel1.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        lblAbonado.setText("Abonado");
        jPanel1.add(lblAbonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        lblFechas.setText("Entre fechas:");
        jPanel1.add(lblFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, -1));
        jPanel1.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, -1));
        jPanel1.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, -1));

        comboEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autorizado", "Pagado", "Cualquier estatus" }));
        jPanel1.add(comboEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, -1));

        comboAbonado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terminado", "Abonado", "Ambas opciones" }));
        jPanel1.add(comboAbonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        btnFiltrar.setText("Filtrar");
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jButton2.setText("jButton2");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> comboAbonado;
    private javax.swing.JComboBox<String> comboEstatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAbonado;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEstatus;
    private javax.swing.JLabel lblFechas;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
