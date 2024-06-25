/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entidadestemporales.Pago;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crazy
 */
public class FrmReportePagos extends javax.swing.JFrame {
    private final List<Pago> pagosOriginales = new ArrayList<>();
    public FrmReportePagos() {
        initComponents();
        cargarMetodosIniciales();
        
        cmbTipo.addActionListener(e -> aplicarFiltros());
    cmbEstatus.addActionListener(e -> aplicarFiltros());
    cmbAbonos.addActionListener(e -> aplicarFiltros());
    btnRestablecer.addActionListener(e -> restablecerFiltros());
    }
    
    private void restablecerFiltros() {
    // Restablecer los ComboBox a su estado inicial
    cmbTipo.setSelectedItem("<None>");
    cmbEstatus.setSelectedItem("<None>");
    cmbAbonos.setSelectedItem("<None>");

    // Limpiar los campos de texto de fechas si los tienes
    jTextField1.setText("Desde");
    jTextField2.setText("Hasta");

    // Volver a cargar todos los pagos originales en la tabla
    llenarTablaPagos(pagosOriginales);
}
    
    private void aplicarFiltros() {
    String tipo = cmbTipo.getSelectedItem().toString();
    String estatus = cmbEstatus.getSelectedItem().toString();
    String abonos = cmbAbonos.getSelectedItem().toString();
    
    List<Pago> pagosFiltrados = new ArrayList<>(pagosOriginales);
    
    // Filtrar por tipo
    if (!tipo.equals("<None>")) {
        pagosFiltrados = pagosFiltrados.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
    
    // Filtrar por estatus
    if (!estatus.equals("<None>")) {
        pagosFiltrados = pagosFiltrados.stream()
                .filter(p -> p.getEstatus().equalsIgnoreCase(estatus))
                .collect(Collectors.toList());
    }
    
    // Filtrar por abonos
    if (!abonos.equals("<None>")) {
        if (abonos.equals("Si")) {
            pagosFiltrados = pagosFiltrados.stream()
                    .filter(p -> p.getTerminado().equalsIgnoreCase("Abonado"))
                    .collect(Collectors.toList());
        } else if (abonos.equals("No")) {
            pagosFiltrados = pagosFiltrados.stream()
                    .filter(p -> !p.getTerminado().equalsIgnoreCase("Abonado"))
                    .collect(Collectors.toList());
        }
    }
    
    llenarTablaPagos(pagosFiltrados);
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
                Object[] fila = new Object[8];
                fila[0] = row.getId();
                fila[1] = row.getTipo();
                fila[2] = row.getMonto();
                fila[3] = row.getFechaHora();
                fila[4] = row.getBeneficiario();
                fila[5] = row.getCuenta();
                fila[6] = row.getTerminado();
                fila[7] = row.getEstatus();
                modeloTabla.addRow(fila);
            });
        }
    }

    public void cargarPagosEnTabla() {
    try {
        pagosOriginales.clear();
        pagosOriginales.add(new Pago("1", "1000.00", "2024-06-01 10:00", "Autorizado", "Reembolso", "Juan Perez", "123456789", "Abonado", "1"));
        pagosOriginales.add(new Pago("2", "1500.50", "2024-06-02 11:00", "Pagado", "Viatico", "Maria Gomez", "987654321", "Terminado", "5"));
        pagosOriginales.add(new Pago("3", "200.00", "2024-06-03 12:00", "Rechazado", "Viatico", "Carlos Lopez", "123987456", "Abonado", "5"));
        pagosOriginales.add(new Pago("4", "3000.00", "2024-06-04 13:00", "Autorizado", "Reembolso", "Ana Martinez", "456123789", "Abonado", "1"));
        pagosOriginales.add(new Pago("5", "500.75", "2024-06-05 14:00", "Pagado", "Proveedor", "Luis Fernandez", "789456123", "Terminado", "7"));
        pagosOriginales.add(new Pago("6", "750.25", "2024-06-06 15:00", "Rechazado", "Viatico", "Laura Sanchez", "321654987", "Pendiente", "5"));
        pagosOriginales.add(new Pago("7", "900.00", "2024-06-07 16:00", "Autorizado", "Reembolso", "Pedro Ramirez", "654987321", "Pendiente", "1"));
        pagosOriginales.add(new Pago("8", "1100.30", "2024-06-08 17:00", "Rechazado", "Proveedor", "Sofia Torres", "789123456", "Abonado", "7"));
        pagosOriginales.add(new Pago("9", "2500.00", "2024-06-09 18:00", "Rechazado", "Proveedor", "Marta Ruiz", "987321654", "Pendiente", "7"));
        pagosOriginales.add(new Pago("10", "1750.45", "2024-06-10 19:00", "Pagado", "Reembolso", "Alberto Mendoza", "321987654", "Terminado", "1"));
        
        llenarTablaPagos(pagosOriginales);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
    }
}

    protected void cargarMetodosIniciales() {
        this.cargarPagosEnTabla();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGenerarPDF = new javax.swing.JButton();
        cmbEstatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbAbonos = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnRestablecer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Monto", "FechaHora", "Tipo", "Beneficiario", "Cuenta", "Terminado", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPagos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 770, 240));

        jLabel2.setText("Tipo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Lista de todos los pagos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        btnGenerarPDF.setText("Generar reporte PDF");
        jPanel1.add(btnGenerarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Creado", "Modificado", "Autorizado", "Rechazado", "Pagado", "Completado", " " }));
        jPanel1.add(cmbEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

        jLabel4.setText("Abonos:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        jLabel5.setText("Rango de fechas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Viatico", "Proveedor", "Reembolso", " " }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 90, -1));

        jLabel6.setText("Filtrar por...");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel7.setText("Estatus");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        cmbAbonos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Ambos", "Si", "No" }));
        jPanel1.add(cmbAbonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 100, -1));

        jTextField1.setText("Desde");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 90, -1));

        jTextField2.setText("Hasta");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 90, -1));

        btnRestablecer.setText("Restablecer Filtros");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

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

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        // Restablecer los ComboBox a su estado inicial
    cmbTipo.setSelectedItem("<None>");
    cmbEstatus.setSelectedItem("<None>");
    cmbAbonos.setSelectedItem("<None>");

    // Limpiar los campos de texto de fechas si los tienes
    jTextField1.setText("Desde");
    jTextField2.setText("Hasta");

    // Volver a cargar todos los pagos originales en la tabla
    llenarTablaPagos(pagosOriginales);

    // Opcional: Mostrar un mensaje de confirmación
    JOptionPane.showMessageDialog(this, "Filtros restablecidos. Mostrando todos los pagos.", "Información", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnRestablecerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JComboBox<String> cmbAbonos;
    private javax.swing.JComboBox<String> cmbEstatus;
    private javax.swing.JComboBox<String> cmbTipo;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
