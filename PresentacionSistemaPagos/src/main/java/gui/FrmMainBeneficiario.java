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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author crazy
 */
public class FrmMainBeneficiario extends javax.swing.JFrame {


    public FrmMainBeneficiario() {
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
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getMonto();
                fila[2] = row.getTipo();
                fila[3] = row.getFechaHora();
                fila[4] = row.getParcialidades();
                fila[5] = row.getEstatus();
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
        this.cargarConfiguracionInicialTablaPelicula();
        this.cargarPagosEnTabla();

    }

    private void cargarConfiguracionInicialTablaPelicula() {
        ActionListener onModificarPagoClickListener = (ActionEvent e) ->
        {
            modificarPago();
        };

        int indiceColumnaModificar = 6;
        TableColumnModel modeloColumnas = this.tblPagos.getColumnModel();
        
        modeloColumnas.getColumn(indiceColumnaModificar).setCellRenderer(new JButtonRenderer("Modificar"));
        modeloColumnas.getColumn(indiceColumnaModificar).setCellEditor(new JButtonCellEditor("Modificar", onModificarPagoClickListener));
    }

    public void modificarPago() {
        DlgModificarPago frame = new DlgModificarPago(this, false);
        frame.setVisible(true);
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuCuenta = new javax.swing.JMenu();
        itemMisCuentas = new javax.swing.JMenuItem();
        itemCerrarSesion = new javax.swing.JMenuItem();
        menuPagos = new javax.swing.JMenu();
        itemNuevoPago = new javax.swing.JMenuItem();
        menuAbonos = new javax.swing.JMenu();
        menuVerMisAbonos = new javax.swing.JMenuItem();
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
                "ID", "Monto", "Tipo", "FechaHora", "Parcialidades", "Estatus", "Modificar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 710, 410));

        jLabel1.setText("Su lista de pagos:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, -1));

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

        menuAbonos.setText("Abonos");

        menuVerMisAbonos.setText("Ver mis abonos");
        menuVerMisAbonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerMisAbonosActionPerformed(evt);
            }
        });
        menuAbonos.add(menuVerMisAbonos);

        jMenuBar2.add(menuAbonos);

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

    private void menuVerMisAbonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerMisAbonosActionPerformed
        // TODO add your handling code here:
        FrmVerAbonos frame = new FrmVerAbonos();
        frame.setVisible(true);
    }//GEN-LAST:event_menuVerMisAbonosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemMisCuentas;
    private javax.swing.JMenuItem itemNuevoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAbonos;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenu menuPagos;
    private javax.swing.JMenuItem menuVerMisAbonos;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
