/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
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
 * Entidad que representa el estado de un pago en el sistema.
 *
 * La entidad Estatus_pagoEntidad guarda información sobre el mensaje asociado
 * al estado del pago, la fecha y hora del estado, el pago al que pertenece y el
 * estatus asociado a este estado.
 */
@Entity
@Table(name = "estatusPagos")
public class Estatus_pagoEntidad implements Serializable {

    @Id
    @Column(name = "idEstatusPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensaje")
    private String mensaje;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @ManyToOne(cascade
            =
            {
                CascadeType.PERSIST
            })
    @JoinColumn(name = "idPago", nullable = false)
    private PagoEntidad pago;

    @ManyToOne(cascade
            =
            {
                CascadeType.PERSIST
            })
    @JoinColumn(name = "idEstatus", nullable = false)
    private EstatusEntidad estatus;

    /**
     * Constructor vacío de la clase Estatus_pagoEntidad.
     */
    public Estatus_pagoEntidad() {
    }

    /**
     * Constructor con parámetros de la clase Estatus_pagoEntidad.
     *
     * @param id Identificador único del estado del pago.
     * @param mensaje Mensaje asociado al estado del pago.
     * @param fechaHora Fecha y hora en que se registró el estado del pago.
     * @param pago Pago al que pertenece este estado.
     * @param estatus Estatus asociado a este estado del pago.
     */
    public Estatus_pagoEntidad(Long id, String mensaje, Calendar fechaHora, PagoEntidad pago, EstatusEntidad estatus) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    /**
     * Constructor con parámetros de la clase Estatus_pagoEntidad.
     *
     * @param mensaje Mensaje asociado al estado del pago.
     * @param fechaHora Fecha y hora en que se registró el estado del pago.
     * @param pago Pago al que pertenece este estado.
     * @param estatus Estatus asociado a este estado del pago.
     */
    public Estatus_pagoEntidad(String mensaje, Calendar fechaHora, PagoEntidad pago, EstatusEntidad estatus) {
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.pago = pago;
        this.estatus = estatus;
    }

    /**
     * Método getter para obtener el id del estado del pago.
     *
     * @return El id del estado del pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el id del estado del pago.
     *
     * @param id El id del estado del pago a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el mensaje asociado al estado del pago.
     *
     * @return El mensaje asociado al estado del pago.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método setter para establecer el mensaje asociado al estado del pago.
     *
     * @param mensaje El mensaje a establecer.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Método getter para obtener la fecha y hora en que se registró el estado
     * del pago.
     *
     * @return La fecha y hora del estado del pago.
     */
    public Calendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Método setter para establecer la fecha y hora en que se registró el
     * estado del pago.
     *
     * @param fechaHora La fecha y hora a establecer.
     */
    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método getter para obtener el pago asociado al estado del pago.
     *
     * @return El pago asociado al estado del pago.
     */
    public PagoEntidad getPago() {
        return pago;
    }

    /**
     * Método setter para establecer el pago asociado al estado del pago.
     *
     * @param pago El pago a establecer.
     */
    public void setPago(PagoEntidad pago) {
        this.pago = pago;
    }

    /**
     * Método getter para obtener el estatus asociado al estado del pago.
     *
     * @return El estatus asociado al estado del pago.
     */
    public EstatusEntidad getEstatus() {
        return estatus;
    }

    /**
     * Método setter para establecer el estatus asociado al estado del pago.
     *
     * @param estatus El estatus a establecer.
     */
    public void setEstatus(EstatusEntidad estatus) {
        this.estatus = estatus;
    }

    /**
     * Override del método toString para imprimir los detalles del estado del
     * pago.
     *
     * @return Una representación en forma de cadena del estado del pago.
     */
    @Override
    public String toString() {
        return "Estatus_pagoEntidad{"
                + "id=" + id
                + ", mensaje='" + mensaje + '\''
                + ", fechaHora=" + fechaHora
                + ", pago=" + pago
                + ", estatus=" + estatus
                + '}';
    }

}
