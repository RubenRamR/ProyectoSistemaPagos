/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entidadestemporales.Pago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author crazy
 */
public class FrmMainAdmin extends javax.swing.JFrame {
    
    public FrmMainAdmin() {
        initComponents();
        cargarMetodosIniciales();
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

            
            this.llenarTablaPagos(pagos);
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaPagos();
        this.cargarPagosEnTabla();

    }

    private void cargarConfiguracionInicialTablaPagos() {
        ActionListener onAutorizarPagoClickListener = (ActionEvent e) ->
        {
            autorizarPago();
        };
        ActionListener onRechazarPagoClickListener = (ActionEvent e) ->
        {
            rechazarPago();
        };
        
        int indiceColumnaAutorizar = 7;
        int indiceColumnaRechazar = 8;
        TableColumnModel modeloColumnas = this.tblPagos.getColumnModel();
        
        modeloColumnas.getColumn(indiceColumnaAutorizar).setCellRenderer(new JButtonRenderer("Autorizar"));
        modeloColumnas.getColumn(indiceColumnaAutorizar).setCellEditor(new JButtonCellEditor("Autorizar", onAutorizarPagoClickListener));
        
        modeloColumnas.getColumn(indiceColumnaRechazar).setCellRenderer(new JButtonRenderer("Rechazar"));
        modeloColumnas.getColumn(indiceColumnaRechazar).setCellEditor(new JButtonCellEditor("Rechazar", onRechazarPagoClickListener));
        
    }

    public void autorizarPago() {
        JOptionPane.showMessageDialog(this, "se autorizó el pago");
    }
    
    public void rechazarPago(){
        JOptionPane.showMessageDialog(this, "se rechazó el pago");
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        lblCliente = new javax.swing.JLabel();
        lblFechas = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCatalogoBeneficiarios = new javax.swing.JMenu();
        itemCatalogoBeneficiarios = new javax.swing.JMenuItem();
        menuPagos = new javax.swing.JMenu();
        itemPagarlos = new javax.swing.JMenuItem();
        itemReportePagos = new javax.swing.JMenuItem();
        menuCerrarSesion = new javax.swing.JMenu();
        itemCerrarSesion = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenu();
        itemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                "ID", "Tipo", "Monto", "FechaHora", "Beneficiario", "Cuenta", "Terminado", "Autorizar", "Rechazar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 590, 400));

        lblCliente.setText("Cliente:");
        jPanel1.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lblFechas.setText("Entre fechas:");
        jPanel1.add(lblFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, -1));
        jPanel1.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 110, -1));
        jPanel1.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, -1));

        btnFiltrar.setText("Filtrar");
        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Autorización de pagos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        menuCatalogoBeneficiarios.setText("Catalogo beneficiarios");

        itemCatalogoBeneficiarios.setText("Ver catáogo de beneficiarios");
        itemCatalogoBeneficiarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCatalogoBeneficiariosActionPerformed(evt);
            }
        });
        menuCatalogoBeneficiarios.add(itemCatalogoBeneficiarios);

        jMenuBar1.add(menuCatalogoBeneficiarios);

        menuPagos.setText("Pagos");

        itemPagarlos.setText("Pagarlos");
        itemPagarlos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPagarlosActionPerformed(evt);
            }
        });
        menuPagos.add(itemPagarlos);

        itemReportePagos.setText("Reporte de pagos");
        itemReportePagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReportePagosActionPerformed(evt);
            }
        });
        menuPagos.add(itemReportePagos);

        jMenuBar1.add(menuPagos);

        menuCerrarSesion.setText("Cerrar sesion");

        itemCerrarSesion.setText("Cerra la sesion");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        menuCerrarSesion.add(itemCerrarSesion);

        jMenuBar1.add(menuCerrarSesion);

        menuAcercaDe.setText("Acerca de");

        itemAcercaDe.setText("Acerca de");
        itemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaDeActionPerformed(evt);
            }
        });
        menuAcercaDe.add(itemAcercaDe);

        jMenuBar1.add(menuAcercaDe);

        setJMenuBar(jMenuBar1);

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

    private void itemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaDeActionPerformed
        // TODO add your handling code here:
        DlgAcercaDe fad = new DlgAcercaDe(this, false);
        fad.setVisible(true);
    }//GEN-LAST:event_itemAcercaDeActionPerformed

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        // TODO add your handling code here:
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void itemCatalogoBeneficiariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCatalogoBeneficiariosActionPerformed
        // TODO add your handling code here:
        FrmCatalogoBeneficiarios frame = new FrmCatalogoBeneficiarios();
        frame.setVisible(true);
    }//GEN-LAST:event_itemCatalogoBeneficiariosActionPerformed

    private void itemPagarlosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPagarlosActionPerformed
        // TODO add your handling code here:
        FrmAdminPagarRechazar fapr = new FrmAdminPagarRechazar();
        fapr.setVisible(true);
    }//GEN-LAST:event_itemPagarlosActionPerformed

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void itemReportePagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReportePagosActionPerformed
        // TODO add your handling code here:
        FrmReportePagos frame = new FrmReportePagos();
        frame.setVisible(true);
    }//GEN-LAST:event_itemReportePagosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemCatalogoBeneficiarios;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemPagarlos;
    private javax.swing.JMenuItem itemReportePagos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFechas;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuCatalogoBeneficiarios;
    private javax.swing.JMenu menuCerrarSesion;
    private javax.swing.JMenu menuPagos;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
