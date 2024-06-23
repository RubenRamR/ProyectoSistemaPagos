/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entidadestemporales.Abono;
import entidadestemporales.Pago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author crazy
 */
public class FrmVerAbonos extends javax.swing.JFrame {
    
    
    public FrmVerAbonos() {
        initComponents();
        cargarMetodosIniciales();
    }
    
    private void llenarTablaAbonos(List<Abono> listaPagos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblAbonos.getModel();
        if (modeloTabla.getRowCount() > 0)
        {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--)
            {
                modeloTabla.removeRow(i);
            }
        }
        if (listaPagos != null)
        {
            listaPagos.forEach(row ->
            {
                Object[] fila = new Object[5];
                fila[0] = row.getId();
                fila[1] = 1;
                fila[2] = row.getMonto();
                fila[3] = row.getFechaHora();
                
                modeloTabla.addRow(fila);
            });
        }
    }

    public void cargarAbonosEnTabla() {
        try
        {
            List<Abono> abonos = new ArrayList<>();
            abonos.add(new Abono("1", "2023-06-20T10:00:00", "100.00"));
            abonos.add(new Abono("2", "2023-06-21T11:00:00", "150.00"));
            abonos.add(new Abono("3", "2023-06-22T12:00:00", "200.00"));
            abonos.add(new Abono("4", "2023-06-23T13:00:00", "250.00"));
            abonos.add(new Abono("5", "2023-06-24T14:00:00", "300.00"));
            abonos.add(new Abono("6", "2023-06-25T15:00:00", "350.00"));
            abonos.add(new Abono("7", "2023-06-26T16:00:00", "400.00"));
            abonos.add(new Abono("8", "2023-06-27T17:00:00", "450.00"));
            abonos.add(new Abono("9", "2023-06-28T18:00:00", "500.00"));
            abonos.add(new Abono("10", "2023-06-29T19:00:00", "550.00"));

            
            this.llenarTablaAbonos(abonos);
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaAbonos();
        this.cargarAbonosEnTabla();

    }

    private void cargarConfiguracionInicialTablaAbonos() {
        ActionListener onModificarPagoClickListener = (ActionEvent e) ->
        {
            eliminarAbonos();
        };

        int indiceColumnaEliminar = 4;
        TableColumnModel modeloColumnas = this.tblAbonos.getColumnModel();
        
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar).setCellEditor(new JButtonCellEditor("Eliminar", onModificarPagoClickListener));
    }

    public void eliminarAbonos() {
        JOptionPane.showMessageDialog(this, "se eliminó el abono");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAbonos = new javax.swing.JTable();
        btnAbonar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboPago = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAbonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Numero", "Monto", "Fecha", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tblAbonos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 740, 370));

        btnAbonar.setText("Abonar");
        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 110, 30));

        jLabel1.setText("Cuenta: 234234234");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 20));

        jLabel2.setText("A usted le faltan 5 abonos para el pago:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        comboPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago 1", "Pago 2", "Pago 3" }));
        comboPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPagoActionPerformed(evt);
            }
        });
        jPanel1.add(comboPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mis abonos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

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

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
        // TODO add your handling code here:
        DlgAbonar da = new DlgAbonar(this, false);
        da.setVisible(true);
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void comboPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JComboBox<String> comboPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAbonos;
    // End of variables declaration//GEN-END:variables
}
