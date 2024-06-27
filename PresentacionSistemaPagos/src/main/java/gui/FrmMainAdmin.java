package gui;

import InterfacesNegocio.ITipoPagoNegocio;
import bo.TipoPagoNegocio;
import entidadestemporales.Pago;
import excepciones.NegocioException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author crazy
 */
public class FrmMainAdmin extends javax.swing.JFrame {

    private ITipoPagoNegocio tipoPago;

    public FrmMainAdmin() {
        this.tipoPago = new TipoPagoNegocio();
        initComponents();
        cargarPagosEnTabla();
    }

    private void llenarTablaPagos(List<Pago> listaPagos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPagos.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        if (listaPagos != null) {
            listaPagos.forEach(row
                    -> {
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
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaPagos", "root", "root");

            String sql = "SELECT p.idPago, p.monto, p.fechaHora, p.comprobante, tp.nombre as tipoPago, "
                    + "b.nombres, b.apellidoPaterno, cb.numeroCuenta, "
                    + "(SELECT ep.idEstatus FROM estatusPagos ep WHERE ep.idPago = p.idPago ORDER BY ep.fechaHora DESC LIMIT 1) as ultimoEstatus "
                    + "FROM pagos p "
                    + "JOIN tiposPagos tp ON p.idTipoPago = tp.idTipoPago "
                    + "JOIN beneficiarios b ON p.idBeneficiario = b.idBeneficiario "
                    + "JOIN cuentasBancarias cb ON p.idCuenta = cb.idCuenta "
                    + "WHERE p.eliminado = false";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Pago> pagos = new ArrayList<>();

            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getString("idPago"),
                        rs.getString("monto"),
                        rs.getString("fechaHora"),
                        getEstatusNombre(rs.getInt("ultimoEstatus")),
                        rs.getString("tipoPago"),
                        rs.getString("nombres") + " " + rs.getString("apellidoPaterno"),
                        rs.getString("numeroCuenta"),
                        getTerminado(rs.getInt("ultimoEstatus")),
                        rs.getString("idPago")
                );
                pagos.add(pago);
            }

            this.llenarTablaPagos(pagos);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getEstatusNombre(int idEstatus) {
        // Aquí deberías implementar una lógica para convertir el ID del estatus a su nombre
        // Por ejemplo, podrías usar un switch o un map
        switch (idEstatus) {
            case 1:
                return "Autorizado";
            case 2:
                return "Pagado";
            case 3:
                return "Rechazado";
            default:
                return "Desconocido";
        }
    }

    private String getTerminado(int idEstatus) {
        // Similar al método anterior, pero para determinar si está terminado
        switch (idEstatus) {
            case 2:
                return "Terminado";
            default:
                return "Pendiente";
        }
    }

    protected void cargarMetodosIniciales() throws SQLException {
        this.cargarConfiguracionInicialTablaPagos();
        this.cargarPagosEnTabla();

    }

    private void cargarConfiguracionInicialTablaPagos() {
        ActionListener onAutorizarPagoClickListener = (ActionEvent e)
                -> {
            autorizarPago();
        };
        ActionListener onRechazarPagoClickListener = (ActionEvent e)
                -> {
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

    public void rechazarPago() {
        JOptionPane.showMessageDialog(this, "se rechazó el pago");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 760, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Autorización de pagos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jButton1.setText("Insertar tipo pago");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

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

    private void itemReportePagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReportePagosActionPerformed
        // TODO add your handling code here:
        FrmReportePagos frame = new FrmReportePagos();
        frame.setVisible(true);
    }//GEN-LAST:event_itemReportePagosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            tipoPago.insertaTiposDePagoPredeterminados();
        } catch (NegocioException ex) {
            Logger.getLogger(FrmMainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemCatalogoBeneficiarios;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemPagarlos;
    private javax.swing.JMenuItem itemReportePagos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuCatalogoBeneficiarios;
    private javax.swing.JMenu menuCerrarSesion;
    private javax.swing.JMenu menuPagos;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
