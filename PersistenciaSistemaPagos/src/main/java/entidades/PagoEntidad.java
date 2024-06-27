/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad que representa un pago realizado en el sistema.
 *
 * La entidad PagoEntidad guarda información sobre el monto del pago, el
 * comprobante asociado, la fecha y hora del pago, el beneficiario del pago, la
 * cuenta bancaria utilizada para el pago, el tipo de pago realizado, y los
 * abonos y estados asociados a este pago.
 */
@Entity
@Table(name = "pagos")
public class PagoEntidad implements Serializable {

    @Id
    @Column(name = "idPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", nullable = false)
    private float monto;

    @Column(name = "comprobante", nullable = false)
    private String comprobante;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @ManyToOne
    @JoinColumn(name = "idBeneficiario", nullable = false)
    private BeneficiarioEntidad beneficiario;

    @ManyToOne
    @JoinColumn(name = "idCuenta", nullable = false)
    private CuentaBancariaEntidad cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "idTipoPago", nullable = false)
    private TipoPagoEntidad tipoPago;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private List<AbonoEntidad> abono;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private List<Estatus_pagoEntidad> estatusPagos;

    /**
     * Constructor vacío de la clase PagoEntidad.
     */
    public PagoEntidad() {
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Constructor con parámetros de la clase PagoEntidad.
     *
     * @param monto Monto del pago.
     * @param comprobante Comprobante asociado al pago.
     * @param fechaHora Fecha y hora del pago.
     */
    public PagoEntidad(float monto, String comprobante, Calendar fechaHora) {
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();

        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
    }

    /**
     * Constructor con parámetros de la clase PagoEntidad.
     *
     * @param id Identificador único del pago.
     * @param monto Monto del pago.
     * @param comprobante Comprobante asociado al pago.
     * @param fechaHora Fecha y hora del pago.
     * @param beneficiario Beneficiario del pago.
     * @param cuentaBancaria Cuenta bancaria utilizada para el pago.
     * @param tipoPago Tipo de pago realizado.
     * @param eliminado Estado de eliminación del pago.
     */
    public PagoEntidad(Long id, float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentaBancaria, TipoPagoEntidad tipoPago, boolean eliminado) {
        this.id = id;
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoPago = tipoPago;
        this.eliminado = eliminado;
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Constructor con parámetros de la clase PagoEntidad.
     *
     * @param monto Monto del pago.
     * @param comprobante Comprobante asociado al pago.
     * @param fechaHora Fecha y hora del pago.
     * @param beneficiario Beneficiario del pago.
     * @param cuentaBancaria Cuenta bancaria utilizada para el pago.
     * @param tipoPago Tipo de pago realizado.
     * @param eliminado Estado de eliminación del pago.
     */
    public PagoEntidad(float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentaBancaria, TipoPagoEntidad tipoPago, boolean eliminado) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.eliminado = eliminado;
        this.tipoPago = tipoPago;
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Constructor con parámetros de la clase PagoEntidad.
     *
     * @param monto Monto del pago.
     * @param comprobante Comprobante asociado al pago.
     * @param fechaHora Fecha y hora del pago.
     * @param beneficiario Beneficiario del pago.
     * @param cuentaBancaria Cuenta bancaria utilizada para el pago.
     * @param eliminado Estado de eliminación del pago.
     */
    public PagoEntidad(float monto, String comprobante, Calendar fechaHora, BeneficiarioEntidad beneficiario, CuentaBancariaEntidad cuentaBancaria, boolean eliminado) {
        this.monto = monto;
        this.comprobante = comprobante;
        this.fechaHora = fechaHora;
        this.beneficiario = beneficiario;
        this.cuentaBancaria = cuentaBancaria;
        this.eliminado = eliminado;
        this.abono = new ArrayList<>();
        this.estatusPagos = new ArrayList<>();
    }

    /**
     * Método getter para obtener el estado de eliminación del pago.
     *
     * @return true si el pago está marcado como eliminado, false de lo
     * contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método setter para establecer el estado de eliminación del pago.
     *
     * @param eliminado El estado de eliminación del pago a establecer.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método getter para obtener el id del pago.
     *
     * @return El id del pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el id del pago.
     *
     * @param id El id del pago a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el monto del pago.
     *
     * @return El monto del pago.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Método setter para establecer el monto del pago.
     *
     * @param monto El monto del pago a establecer.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Método getter para obtener el comprobante asociado al pago.
     *
     * @return El comprobante asociado al pago.
     */
    public String getComprobante() {
        return comprobante;
    }

    /**
     * Método setter para establecer el comprobante asociado al pago.
     *
     * @param comprobante El comprobante a establecer.
     */
    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    /**
     * Método getter para obtener la fecha y hora del pago.
     *
     * @return La fecha y hora del pago.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Método setter para establecer la fecha y hora del pago.
     *
     * @param fechaHora La fecha y hora a establecer.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método getter para obtener el beneficiario del pago.
     *
     * @return El beneficiario del pago.
     */
    public BeneficiarioEntidad getBeneficiario() {
        return beneficiario;
    }

    /**
     * Método setter para establecer el beneficiario del pago.
     *
     * @param beneficiario El beneficiario a establecer.
     */
    public void setBeneficiario(BeneficiarioEntidad beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método getter para obtener la cuenta bancaria utilizada para el pago.
     *
     * @return La cuenta bancaria utilizada para el pago.
     */
    public CuentaBancariaEntidad getCuentasBancaria() {
        return cuentaBancaria;
    }

    /**
     * Método setter para establecer la cuenta bancaria utilizada para el pago.
     *
     * @param cuentasBancaria La cuenta bancaria a establecer.
     */
    public void setCuentasBancaria(CuentaBancariaEntidad cuentasBancaria) {
        this.cuentaBancaria = cuentasBancaria;
    }

    /**
     * Método getter para obtener el tipo de pago realizado.
     *
     * @return El tipo de pago realizado.
     */
    public TipoPagoEntidad getTipoPago() {
        return tipoPago;
    }

    /**
     * Método setter para establecer el tipo de pago realizado.
     *
     * @param tipoPago El tipo de pago a establecer.
     */
    public void setTipoPago(TipoPagoEntidad tipoPago) {
        this.tipoPago = tipoPago;
    }

    /**
     * Método getter para obtener los abonos asociados a este pago.
     *
     * @return La lista de abonos asociados al pago.
     */
    public List<AbonoEntidad> getAbono() {
        return abono;
    }

    /**
     * Método setter para establecer los abonos asociados a este pago.
     *
     * @param abono La lista de abonos a establecer.
     */
    public void setAbono(List<AbonoEntidad> abono) {
        this.abono = abono;
    }

    /**
     * Método getter para obtener los estados de pago asociados a este pago.
     *
     * @return La lista de estados de pago asociados al pago.
     */
    public List<Estatus_pagoEntidad> getEstatus_pago() {
        return estatusPagos;
    }

    /**
     * Método setter para establecer los estados de pago asociados a este pago.
     *
     * @param Estatus_pago La lista de estados de pago a establecer.
     */
    public void setEstatus_pago(List<Estatus_pagoEntidad> Estatus_pago) {
        this.estatusPagos = Estatus_pago;
    }

    @Override
    public String toString() {
        return "PagoEntidad{"
                + "id=" + id
                + ", monto=" + monto
                + ", comprobante='" + comprobante + '\''
                + ", fechaHora=" + fechaHora
                + ", beneficiario=" + beneficiario
                + ", cuentaBancaria=" + cuentaBancaria
                + ", tipoPago=" + tipoPago
                + ", abono=" + abono
                + ", estatusPagos=" + estatusPagos
                + '}';
    }

}
