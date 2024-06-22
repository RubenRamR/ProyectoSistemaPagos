/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

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

/**
 *
 * @author crazy
 */
public class FrmCatalogoBeneficiarios extends javax.swing.JFrame {


    public FrmCatalogoBeneficiarios() {
        initComponents();
        cargarMetodosIniciales();
    }

    private void llenarTablaBeneficiarios(List<Beneficiario> listaBeneficiarios) {
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
                fila[1] = row.getClave();
                fila[2] = row.getNombres();
                fila[3] = row.getApellidoP();
                fila[4] = row.getApellidoM();
                fila[5] = row.getUsuario();
                modeloTabla.addRow(fila);
            });
        }
    }

    public void cargarBeneficiariosEnTabla() {
        try
        {
            List<Beneficiario> beneficiarios = new ArrayList<>();
            beneficiarios.add(new Beneficiario("1", "001", "Juan", "Perez", "Garcia", "jperez", "password1"));
            beneficiarios.add(new Beneficiario("2", "002", "Maria", "Gomez", "Lopez", "mgomez", "password2"));
            beneficiarios.add(new Beneficiario("3", "003", "Carlos", "Lopez", "Martinez", "clopez", "password3"));
            beneficiarios.add(new Beneficiario("4", "004", "Ana", "Martinez", "Rodriguez", "amartinez", "password4"));
            beneficiarios.add(new Beneficiario("5", "005", "Luis", "Fernandez", "Hernandez", "lfernandez", "password5"));
            beneficiarios.add(new Beneficiario("6", "006", "Laura", "Sanchez", "Morales", "lsanchez", "password6"));
            beneficiarios.add(new Beneficiario("7", "007", "Pedro", "Ramirez", "Torres", "pramirez", "password7"));
            beneficiarios.add(new Beneficiario("8", "008", "Sofia", "Torres", "Gonzalez", "storres", "password8"));
            beneficiarios.add(new Beneficiario("9", "009", "Marta", "Ruiz", "Diaz", "mruiz", "password9"));
            beneficiarios.add(new Beneficiario("10", "010", "Alberto", "Mendoza", "Santos", "amendoza", "password10"));

      
            this.llenarTablaBeneficiarios(beneficiarios);
        } catch (Exception ex)
        {
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
        DlgModificarBeneficiario frame = new DlgModificarBeneficiario(this, false);
        frame.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBeneficiarios = new javax.swing.JTable();
        btnRegistrarBeneficiario = new javax.swing.JButton();

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
        ));
        jScrollPane1.setViewportView(tblBeneficiarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 77, 750, 400));

        btnRegistrarBeneficiario.setText("Registrar un beneficiario");
        btnRegistrarBeneficiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarBeneficiarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

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
        DlgRegistrarBeneficiario drb = new DlgRegistrarBeneficiario(this, false);
        drb.setVisible(true);
    }//GEN-LAST:event_btnRegistrarBeneficiarioActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarBeneficiario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBeneficiarios;
    // End of variables declaration//GEN-END:variables
}