/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import InterfacesNegocio.IPagoNegocio;
import entidadestemporales.Pago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilerias.CheckComboBox;
import utilerias.ComboItems;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author crazy
 */
public class FrmReportePagos extends javax.swing.JFrame {

    private JCheckBox checkCreado, checkModificado, checkAutorizado, checkRechazado, checkPagado;

    
    private IPagoNegocio pagosNegocio;
    
    public FrmReportePagos() {
        initComponents();
        cargarMetodosIniciales();
        cargarComboCheck();
    }

    private void cargarComboCheck() {
        checkCreado = new JCheckBox();
        checkCreado.setText("Creado");
        checkCreado.setBounds(20, 30, 120, 40);

        checkModificado = new JCheckBox();
        checkModificado.setText("Modificado");
        checkModificado.setBounds(20, 40, 120, 40);

        checkAutorizado = new JCheckBox();
        checkAutorizado.setText("Autorizado");
        checkAutorizado.setBounds(20, 50, 120, 40);

        checkRechazado = new JCheckBox();
        checkRechazado.setText("Rechazado");
        checkRechazado.setBounds(20, 60, 120, 40);

        checkPagado = new JCheckBox();
        checkPagado.setText("Pagado");
        checkPagado.setBounds(20, 70, 120, 40);

        add(checkCreado);
        add(checkModificado);
        add(checkAutorizado);
        add(checkRechazado);
        add(checkPagado);
    }

    private void llenarTablaPagos(List<Pago> listaPagos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPagos.getModel();
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
                Object[] fila = new Object[7];
                fila[0] = row.getId();
                fila[1] = row.getTipo();
                fila[2] = row.getMonto();
                fila[3] = row.getFechaHora();
                fila[4] = row.getBeneficiario();
                fila[5] = row.getCuenta();
                fila[6] = row.getTerminado();
                modeloTabla.addRow(fila);
            });
        }
    }

    public void cargarPagosEnTabla() {
        try
        {
            List<Pago> pagos = new ArrayList<>();
            pagos.add(new Pago("1", "1000.00", "2024-06-01 10:00", "Autorizado", "Reembolso", "Juan Perez", "123456789", "Abonado", "1"));
            pagos.add(new Pago("2", "1500.50", "2024-06-02 11:00", "Pagado", "Viatico", "Maria Gomez", "987654321", "Terminado", "5"));
            pagos.add(new Pago("3", "200.00", "2024-06-03 12:00", "Rechazado", "Viatico", "Carlos Lopez", "123987456", "Abonado", "5"));
            pagos.add(new Pago("4", "3000.00", "2024-06-04 13:00", "Autorizado", "Reembolso", "Ana Martinez", "456123789", "Abonado", "1"));
            pagos.add(new Pago("5", "500.75", "2024-06-05 14:00", "Pagado", "Proveedor", "Luis Fernandez", "789456123", "Terminado", "7"));
            pagos.add(new Pago("6", "750.25", "2024-06-06 15:00", "Rechazado", "Viatico", "Laura Sanchez", "321654987", "Pendiente", "5"));
            pagos.add(new Pago("7", "900.00", "2024-06-07 16:00", "Autorizado", "Reembolso", "Pedro Ramirez", "654987321", "Pendiente", "1"));
            pagos.add(new Pago("8", "1100.30", "2024-06-08 17:00", "Rechazado", "Proveedor", "Sofia Torres", "789123456", "Abonado", "7"));
            pagos.add(new Pago("9", "2500.00", "2024-06-09 18:00", "Rechazado", "Proveedor", "Marta Ruiz", "987321654", "Pendiente", "7"));
            pagos.add(new Pago("10", "1750.45", "2024-06-10 19:00", "Pagado", "Reembolso", "Alberto Mendoza", "321987654", "Terminado", "1"));

//            List<PagosDTO> pagosDTO = this.pagosNegocio.buscarPagoPorId(1);
            
//            this.llenarTablaPagos(pagosDTO);
            this.llenarTablaPagos(pagos);
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cargarMetodosIniciales() {
        this.cargarPagosEnTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnGenerarPDF = new javax.swing.JButton();
        jComboBoxCheckEstatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Monto", "FechaHora", "Tipo", "Beneficiario", "Cuenta", "Terminado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 600, 370));

        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, -1));

        jLabel2.setText("Entre fechas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, -1));

        txtFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, -1));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Lista de todos los pagos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        btnGenerarPDF.setText("Generar reporte PDF");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creado", "Modificado", "Autorizado", "Rechazado", "Pagado", "Completado", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        jComboBoxCheckEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creado", "Modificado", "Autorizado", "Rechazado", "Pagado", "Completado", " " }));
        jComboBoxCheckEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCheckEstatusActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCheckEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel4.setText("Estatus");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPDFActionPerformed
    private void jComboBoxCheckEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCheckEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCheckEstatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JComboBox<String> jComboBoxCheckEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
