/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import InterfacesNegocio.ICuentaBancariaNegocio;
import bo.CuentaBancariaNegocio;
import excepciones.NegocioException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;
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

    private BeneficiarioDTO beneficiarioLogeado;
    private ICuentaBancariaNegocio cuentasNegocio;

    public FrmMisCuentas(BeneficiarioDTO beneficiarioLogeado) {
        this.beneficiarioLogeado = beneficiarioLogeado;
        this.cuentasNegocio = new CuentaBancariaNegocio();
        initComponents();
        cargarMetodosIniciales();
        actualizarTabla();
    }

    private void llenarTablaCuentas(List<CuentaBancariaDTO> listaCuentas) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCuentas.getModel();
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        if (listaCuentas != null) {
            listaCuentas.forEach(row
                    -> {
                Object[] fila = new Object[6];
                fila[0] = row.getId();
                fila[1] = row.getNumeroCuenta();
                fila[2] = row.getClave();
                fila[3] = row.getBanco();
                modeloTabla.addRow(fila);
            });
        }
    }

    public void actualizarTabla() {
        try {
            List<CuentaBancariaDTO> cuentas = cuentasNegocio.listaCuentasPorIdBeneficiario(beneficiarioLogeado.getId());

            cuentas = cuentas.stream()
                    .filter(cuenta -> !cuenta.isEliminado())
                    .collect(Collectors.toList());

            DefaultTableModel model = (DefaultTableModel) this.tblCuentas.getModel();
            model.setRowCount(0);

            for (CuentaBancariaDTO cuenta : cuentas) {
                Object[] fila
                        = {
                            cuenta.getId(),
                            cuenta.getNumeroCuenta(),
                            cuenta.getClave(),
                            cuenta.getBanco()
                        };
                model.addRow(fila);
            }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarCuentasEnTabla() {
        try {
            List<CuentaBancariaDTO> cuentas = cuentasNegocio.listaCuentasPorIdBeneficiario(beneficiarioLogeado.getId());

            this.llenarTablaCuentas(cuentas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void cargarMetodosIniciales() {
        this.cargarConfiguracionInicialTablaCuentas();
        this.cargarCuentasEnTabla();

    }

    private void cargarConfiguracionInicialTablaCuentas() {
        ActionListener onModificarPagoClickListener = (ActionEvent e)
                -> {
            int fila = tblCuentas.getSelectedRow();
            if (fila != -1) {
                long idCuentaBancaria = (long) tblCuentas.getValueAt(fila, 0);
                DlgModificarCuenta frame = new DlgModificarCuenta(this, false, idCuentaBancaria, beneficiarioLogeado);
                frame.setVisible(true);

                actualizarTabla();
            }
        };

        int indiceColumnaMasOpciones = 4;
        TableColumnModel modeloColumnas = this.tblCuentas.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaMasOpciones).setCellRenderer(new JButtonRenderer("Más opciones"));
        modeloColumnas.getColumn(indiceColumnaMasOpciones).setCellEditor(new JButtonCellEditor("Más opciones", onModificarPagoClickListener));
    }

    public void masOpciones() {
        long idCuentaBancaria = (long) tblCuentas.getValueAt(tblCuentas.getSelectedRow(), 0);
        DlgModificarCuenta frame = new DlgModificarCuenta(this, false, idCuentaBancaria, beneficiarioLogeado);
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
        DlgAnadirCuenta dac = new DlgAnadirCuenta(this, false, beneficiarioLogeado);
        dac.setVisible(true);
        cargarMetodosIniciales();
        actualizarTabla();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuentas;
    // End of variables declaration//GEN-END:variables
}
