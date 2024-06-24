/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entidadestemporales.Cuenta;
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
public class FrmMisCuentas extends javax.swing.JFrame {
    
    public FrmMisCuentas() {
        initComponents();
        cargarMetodosIniciales();
    }
    
        private void llenarTablaCuentas(List<Cuenta> listaCuentas) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCuentas.getModel();
        if (modeloTabla.getRowCount() > 0)
        {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--)
            {
                modeloTabla.removeRow(i);
            }
        }
        if (listaCuentas != null)
        {
            listaCuentas.forEach(row ->
            {
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getNumeroCuenta();
                fila[2] = row.getClave();
                fila[3] = row.getBanco();
                modeloTabla.addRow(fila);
            });
        }
    }

    public void cargarCuentasEnTabla() {
        try
        {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(new Cuenta("1", "001122334455", "clave1", "Banco A"));
            cuentas.add(new Cuenta("2", "001122334466", "clave2", "Banco B"));
            cuentas.add(new Cuenta("3", "001122334477", "clave3", "Banco C"));
            cuentas.add(new Cuenta("4", "001122334488", "clave4", "Banco D"));
            cuentas.add(new Cuenta("5", "001122334499", "clave5", "Banco E"));
            cuentas.add(new Cuenta("6", "001122334500", "clave6", "Banco F"));
            cuentas.add(new Cuenta("7", "001122334511", "clave7", "Banco G"));
            cuentas.add(new Cuenta("8", "001122334522", "clave8", "Banco H"));
            cuentas.add(new Cuenta("9", "001122334533", "clave9", "Banco I"));
            cuentas.add( new Cuenta("10", "001122334544", "clave10", "Banco J"));
            
            
            this.llenarTablaCuentas(cuentas);
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaPelicula();
        this.cargarCuentasEnTabla();

    }

    private void cargarConfiguracionInicialTablaPelicula() {
        ActionListener onModificarPagoClickListener = (ActionEvent e) ->
        {
            masOpciones();
        };

        int indiceColumnaMasOpciones = 4;
        TableColumnModel modeloColumnas = this.tblCuentas.getColumnModel();
        
        modeloColumnas.getColumn(indiceColumnaMasOpciones).setCellRenderer(new JButtonRenderer("Mas opciones"));
        modeloColumnas.getColumn(indiceColumnaMasOpciones).setCellEditor(new JButtonCellEditor("Mas opciones", onModificarPagoClickListener));
    }

    public void masOpciones() {
        DlgModificarCuenta frame = new DlgModificarCuenta(this, false);
        frame.setVisible(true);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();
        btnCrearCuenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
        setResizable(false);

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Numero de cuenta", "Clave", "Banco", "Más opciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCuentas);

        btnCrearCuenta.setText("Añadir otra cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Sus cuentas bancarias registradas en el sistema:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearCuenta)
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCrearCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

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

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        // TODO add your handling code here:
        DlgAnadirCuenta dac = new DlgAnadirCuenta(this, false);
        dac.setVisible(true);
    }//GEN-LAST:event_btnCrearCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuentas;
    // End of variables declaration//GEN-END:variables
}
