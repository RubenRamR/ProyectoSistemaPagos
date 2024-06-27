/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase entidad que representa un abono realizado en el sistema.
 *
 * <p>
 * Esta entidad es mapeada a la tabla "abonos" en la base de datos.</p>
 */
@Entity
@Table(name = "abonos")
public class AbonoEntidad implements Serializable {

    @Id
    @Column(name = "idAbono")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @Column(name = "monto")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "idPago", nullable = false)
    private PagoEntidad pago;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    /**
     * Constructor vacío de la clase AbonoEntidad.
     */
    public AbonoEntidad() {
    }

    /**
     * Constructor con todos los atributos de la clase AbonoEntidad.
     *
     * @param id ID del abono.
     * @param fechaHora Fecha y hora del abono.
     * @param monto Monto del abono.
     * @param pago Pago asociado al abono.
     */
    public AbonoEntidad(Long id, Calendar fechaHora, float monto, PagoEntidad pago) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    /**
     * Constructor sin el ID del abono.
     *
     * @param fechaHora Fecha y hora del abono.
     * @param monto Monto del abono.
     * @param pago Pago asociado al abono.
     */
    public AbonoEntidad(Calendar fechaHora, float monto, PagoEntidad pago) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.pago = pago;
    }

    /**
     * Obtiene el ID del abono.
     *
     * @return El ID del abono.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del abono.
     *
     * @param id El ID del abono.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora del abono.
     *
     * @return La fecha y hora del abono.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del abono.
     *
     * @param fechaHora La fecha y hora del abono.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el monto del abono.
     *
     * @return El monto del abono.
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto del abono.
     *
     * @param monto El monto del abono.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el pago asociado al abono.
     *
     * @return El pago asociado al abono.
     */
    public PagoEntidad getPago() {
        return pago;
    }

    /**
     * Establece el pago asociado al abono.
     *
     * @param pago El pago asociado al abono.
     */
    public void setPago(PagoEntidad pago) {
        this.pago = pago;
    }

    /**
     * Verifica si el abono está marcado como eliminado.
     *
     * @return true si el abono está marcado como eliminado, false en caso
     * contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Establece el estado de eliminación del abono.
     *
     * @param eliminado true si se marca como eliminado, false si no.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método toString que retorna una representación en cadena de la entidad
     * AbonoEntidad.
     *
     * @return Representación en cadena de la entidad AbonoEntidad.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AbonoEntidad{");
        sb.append("id=").append(id);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", monto=").append(monto);
        sb.append(", pago=").append(pago);
        sb.append(", eliminado=").append(eliminado);
        sb.append('}');
        return sb.toString();
    }
}
