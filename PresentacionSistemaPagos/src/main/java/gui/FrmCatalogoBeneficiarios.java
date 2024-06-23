/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import DTOs.BeneficiarioDTO;
import entidadestemporales.Beneficiario;
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

import InterfacesNegocio.IBeneficiarioNegocio;
import bo.BeneficiarioNegocio;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import entidades.BeneficiarioEntidad;
import excepciones.NegocioException;


/**
 *
 * @author crazy
 */
public class FrmCatalogoBeneficiarios extends javax.swing.JFrame {
    private IBeneficiarioNegocio beneficiarioNegocio;
    private int pagina;
    private int limite;
    private int offset;
    

    public FrmCatalogoBeneficiarios() {
        beneficiarioNegocio = new BeneficiarioNegocio();
        pagina = 1;
        limite = 5;
        
        initComponents();
        cargarMetodosIniciales();
    }

    private void llenarTablaBeneficiarios(List<BeneficiarioDTO> listaBeneficiarios) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblBeneficiarios.getModel();
        if (modeloTabla.getRowCount() > 0)
        {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--)
            {
                modeloTabla.removeRow(i);
            }
        }
        if (listaBeneficiarios != null)
        {
            listaBeneficiarios.forEach(row ->
            {
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getClaveContrato();
                fila[2] = row.getNombres();
                fila[3] = row.getApellidoPaterno();
                fila[4] = row.getApellidoMaterno();
                fila[5] = row.getUsuario();
                modeloTabla.addRow(fila);
            });
        }
    }

    public void cargarBeneficiariosEnTabla() {
        try
        {
            List<BeneficiarioDTO> beneficiarios = new ArrayList<>();
            beneficiarios = beneficiarioNegocio.buscarBeneficiarios(limite, pagina);
            
            this.llenarTablaBeneficiarios(beneficiarios);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaBeneficiarios();
        this.cargarBeneficiariosEnTabla();

    }

    private void cargarConfiguracionInicialTablaBeneficiarios() {
        ActionListener onModificarPagoClickListener = (ActionEvent e) ->
        {
            modificarBeneficiario();
        };

        int indiceColumnaModificar = 6;
        TableColumnModel modeloColumnas = this.tblBeneficiarios.getColumnModel();
        
        modeloColumnas.getColumn(indiceColumnaModificar).setCellRenderer(new JButtonRenderer("Modificar"));
        modeloColumnas.getColumn(indiceColumnaModificar).setCellEditor(new JButtonCellEditor("Modificar", onModificarPagoClickListener));
    }

    public void modificarBeneficiario() {
        long idBeneficiario = (long) tblBeneficiarios.getValueAt(tblBeneficiarios.getSelectedRow(), 0);
        DlgModificarBeneficiario frame = new DlgModificarBeneficiario(idBeneficiario);
        frame.setModal(true);
        frame.setVisible(true);
        cargarMetodosIniciales();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBeneficiarios = new javax.swing.JTable();
        btnRegistrarBeneficiario = new javax.swing.JButton();
        btnAdelante = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBeneficiarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Clave", "Nombres", "Apellido P", "Apellido M", "Usuario", "Modificar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBeneficiarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 77, 750, 320));

        btnRegistrarBeneficiario.setText("Registrar un beneficiario");
        btnRegistrarBeneficiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarBeneficiarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnAdelante.setText("Adelante >>");
        btnAdelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdelanteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdelante, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, -1, -1));

        btnAtras.setText("<< Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        lblPagina.setText(String.valueOf(pagina));
        jPanel1.add(lblPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, -1, -1));

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

    private void btnRegistrarBeneficiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarBeneficiarioActionPerformed
        // TODO add your handling code here:
        DlgRegistrarBeneficiario frame = new DlgRegistrarBeneficiario();
        frame.setModal(true);
        frame.setVisible(true);
        cargarMetodosIniciales();
    }//GEN-LAST:event_btnRegistrarBeneficiarioActionPerformed

    private void btnAdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdelanteActionPerformed
        // TODO add your handling code here:
        pagina++;
        lblPagina.setText(String.valueOf(pagina));
        cargarBeneficiariosEnTabla();
    }//GEN-LAST:event_btnAdelanteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        if (pagina == 1){
            JOptionPane.showMessageDialog(this, "Ya estás en la primera pagina");
        } else {
            pagina--;
            lblPagina.setText(String.valueOf(pagina));
            cargarBeneficiariosEnTabla();
        }

    }//GEN-LAST:event_btnAtrasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdelante;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRegistrarBeneficiario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JTable tblBeneficiarios;
    // End of variables declaration//GEN-END:variables
}
