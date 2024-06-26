/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entidadestemporales.Pago;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
    modeloTabla.setRowCount(0);  // Limpiar la tabla
    listaPagos.forEach(row -> {
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

    
    
   public void cargarPagosEnTabla() {
    try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaPagos", "root", "root");
        String jpql = "SELECT p.idPago, tp.nombre AS tipo, p.monto, p.fechaHora, " +
                "CONCAT(b.nombres, ' ', b.apellidoPaterno, ' ', b.apellidoMaterno) AS beneficiario, " +
                "cb.numeroCuenta, " +
                "CASE WHEN a.monto IS NOT NULL THEN 'Abonado' ELSE 'Pendiente' END AS terminado, " +
                "e.nombre AS estatus " +
                "FROM pagos p " +
                "JOIN tiposPagos tp ON p.idTipoPago = tp.idTipoPago " +
                "JOIN beneficiarios b ON p.idBeneficiario = b.idBeneficiario " +
                "JOIN cuentasBancarias cb ON p.idCuenta = cb.idCuenta " +
                "LEFT JOIN abonos a ON p.idPago = a.idPago " +
                "LEFT JOIN estatusPagos ep ON p.idPago = ep.idPago " +
                "LEFT JOIN estatus e ON ep.idEstatus = e.idEstatus " +
                "ORDER BY p.fechaHora DESC";
        
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                Statement stmt = conn.createStatement();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ResultSet rs = stmt.executeQuery(jpql);
        
        pagosOriginales.clear();
        
        while (rs.next()) {
            Pago pago = new Pago(
                rs.getString("idPago"),
                rs.getString("monto"),
                rs.getString("fechaHora"),
                rs.getString("estatus"),
                rs.getString("tipo"),
                rs.getString("beneficiario"),
                rs.getString("numeroCuenta"),
                rs.getString("terminado"),
                rs.getString("idPago")
            );
            pagosOriginales.add(pago);
        }
        
        rs.close();
        stmt.close();
        conn.close();
        
        llenarTablaPagos(pagosOriginales);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al cargar los pagos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    protected void cargarMetodosIniciales() {
        this.cargarPagosEnTabla();

    }
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
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbAbonos = new javax.swing.JComboBox<>();
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
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarPDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));

        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Creado", "Modificado", "Autorizado", "Rechazado", "Pagado", "Completado", " " }));
        jPanel1.add(cmbEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        jLabel4.setText("Abonos:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, -1));

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
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        cmbAbonos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Ambos", "Si", "No" }));
        jPanel1.add(cmbAbonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 100, -1));

        btnRestablecer.setText("Restablecer Filtros");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, -1, -1));

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

    // Volver a cargar todos los pagos originales en la tabla
    llenarTablaPagos(pagosOriginales);

    // Opcional: Mostrar un mensaje de confirmación
    JOptionPane.showMessageDialog(this, "Filtros restablecidos. Mostrando todos los pagos.", "Información", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
       Document document = new Document(PageSize.A4); // Cambiamos a A4 para más espacio
    try {
        PdfWriter.getInstance(document, new FileOutputStream("ReportePagos.pdf"));
        document.open();
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font fontSubTitulo = new Font(Font.FontFamily.HELVETICA, 12, Font.ITALIC);
        Font fontContenido = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

        // Título del reporte
        Paragraph titulo = new Paragraph("Reporte de Pagos", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);

        document.add(new Paragraph(" ")); // Espacio en blanco

        // Filtros aplicados
        Paragraph filtros = new Paragraph("Filtros aplicados:", fontSubTitulo);
        document.add(filtros);

        PdfPTable tableFiltros = new PdfPTable(2);
        tableFiltros.setWidthPercentage(100);
        tableFiltros.addCell(new Phrase("Tipo:", fontContenido));
        tableFiltros.addCell(new Phrase(cmbTipo.getSelectedItem().toString(), fontContenido));
        tableFiltros.addCell(new Phrase("Estatus:", fontContenido));
        tableFiltros.addCell(new Phrase(cmbEstatus.getSelectedItem().toString(), fontContenido));
        tableFiltros.addCell(new Phrase("Abonos:", fontContenido));
        tableFiltros.addCell(new Phrase(cmbAbonos.getSelectedItem().toString(), fontContenido));
        document.add(tableFiltros);

        document.add(new Paragraph(" ")); // Espacio en blanco

        // Tabla de pagos
        Paragraph tablaTitulo = new Paragraph("Pagos:", fontSubTitulo);
        document.add(tablaTitulo);

        PdfPTable table = new PdfPTable(8); // 8 columnas para los datos de Pago
        table.setWidthPercentage(100);

        // Encabezados de la tabla
        String[] headers = {"ID", "Tipo", "Monto", "Fecha/Hora", "Beneficiario", "Cuenta", "Terminado", "Estatus"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, fontContenido));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        }

        // Datos de la tabla
        DefaultTableModel model = (DefaultTableModel) tblPagos.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                table.addCell(new Phrase(model.getValueAt(i, j).toString(), fontContenido));
            }
        }

        document.add(table);

    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        document.close();
        JOptionPane.showMessageDialog(null, "Se creó el archivo 'ReportePagos.pdf' en la carpeta del proyecto");
    }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed


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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
