/*
 * Esta clase representa la entidad TipoPagoEntidad, que corresponde a los tipos de pagos disponibles en el sistema.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa los tipos de pagos disponibles en el sistema. Cada tipo
 * de pago tiene un nombre, un número de mensualidades asociado y un estado de
 * eliminación. Además, esta clase mapea la relación con los pagos realizados.
 *
 * @author Chris
 */
@Entity
@Table(name = "tiposPagos")
public class TipoPagoEntidad implements Serializable {

    @Id
    @Column(name = "idTipoPago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "numMensualidades", nullable = false)
    private int numMensualidades;

    @Column(name = "eliminado", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean eliminado;

    @OneToMany(mappedBy = "tipoPago", cascade = CascadeType.PERSIST)
    private List<PagoEntidad> pagos;

    /**
     * Constructor vacío de la clase TipoPagoEntidad.
     */
    public TipoPagoEntidad() {
    }

    /**
     * Constructor con parámetros para inicializar un TipoPagoEntidad.
     *
     * @param nombre El nombre del tipo de pago.
     * @param numMensualidades El número de mensualidades asociadas al tipo de
     * pago.
     * @param eliminado Indicador de si el tipo de pago está eliminado o no.
     * @param pagos La lista de pagos asociados a este tipo de pago.
     */
    public TipoPagoEntidad(String nombre, int numMensualidades, boolean eliminado, List<PagoEntidad> pagos) {
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.eliminado = eliminado;
        this.pagos = pagos;
    }

    /**
     * Método getter para obtener el ID del tipo de pago.
     *
     * @return El ID del tipo de pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el ID del tipo de pago.
     *
     * @param id El ID del tipo de pago a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el nombre del tipo de pago.
     *
     * @return El nombre del tipo de pago.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del tipo de pago.
     *
     * @param nombre El nombre del tipo de pago a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el número de mensualidades asociadas al tipo
     * de pago.
     *
     * @return El número de mensualidades asociadas al tipo de pago.
     */
    public int getNumMensualidades() {
        return numMensualidades;
    }

    /**
     * Método setter para establecer el número de mensualidades asociadas al
     * tipo de pago.
     *
     * @param numMensualidades El número de mensualidades a establecer.
     */
    public void setNumMensualidades(int numMensualidades) {
        this.numMensualidades = numMensualidades;
    }

    /**
     * Método getter para verificar si el tipo de pago está marcado como
     * eliminado.
     *
     * @return true si el tipo de pago está eliminado, false si no.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método setter para marcar el tipo de pago como eliminado o no eliminado.
     *
     * @param eliminado true para marcar como eliminado, false para marcar como
     * no eliminado.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método getter para obtener la lista de pagos asociados a este tipo de
     * pago.
     *
     * @return La lista de pagos asociados a este tipo de pago.
     */
    public List<PagoEntidad> getPagos() {
        return pagos;
    }

    /**
     * Método setter para establecer la lista de pagos asociados a este tipo de
     * pago.
     *
     * @param pagos La lista de pagos a establecer.
     */
    public void setPagos(List<PagoEntidad> pagos) {
        this.pagos = pagos;
    }

    /**
     * Constructor con parámetros para inicializar un TipoPagoEntidad,
     * incluyendo el ID.
     *
     * @param id El ID del tipo de pago.
     * @param nombre El nombre del tipo de pago.
     * @param numMensualidades El número de mensualidades asociadas al tipo de
     * pago.
     * @param eliminado Indicador de si el tipo de pago está eliminado o no.
     * @param pagos La lista de pagos asociados a este tipo de pago.
     */
    public TipoPagoEntidad(Long id, String nombre, int numMensualidades, boolean eliminado, List<PagoEntidad> pagos) {
        this.id = id;
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.eliminado = eliminado;
        this.pagos = pagos;
    }
}
