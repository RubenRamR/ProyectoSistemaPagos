/*
 * Esta clase representa un objeto de transferencia de datos (DTO) para el manejo
 * de tipos de pago, incluyendo su identificador, nombre, número de mensualidades,
 * lista de pagos asociados y estado de eliminación.
 */
package DTOs;

import java.util.List;

/**
 * Clase que representa un tipo de pago en el sistema.
 */
public class TipoPagoDTO {

    private Long id;
    private String nombre;
    private int numMensualidades;
    private List<PagoDTO> pagos;
    private boolean eliminado;

    /**
     * Constructor vacío de la clase TipoPagoDTO.
     */
    public TipoPagoDTO() {
    }

    /**
     * Constructor de la clase TipoPagoDTO que inicializa el nombre y el número
     * de mensualidades.
     *
     * @param nombre El nombre del tipo de pago.
     * @param numMensualidades El número de mensualidades para este tipo de
     * pago.
     */
    public TipoPagoDTO(String nombre, int numMensualidades) {
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
    }

    /**
     * Constructor de la clase TipoPagoDTO que inicializa todos los atributos.
     *
     * @param id El identificador único del tipo de pago.
     * @param nombre El nombre del tipo de pago.
     * @param numMensualidades El número de mensualidades para este tipo de
     * pago.
     * @param pagos La lista de pagos asociados a este tipo de pago.
     */
    public TipoPagoDTO(Long id, String nombre, int numMensualidades, List<PagoDTO> pagos) {
        this.id = id;
        this.nombre = nombre;
        this.numMensualidades = numMensualidades;
        this.pagos = pagos;
    }

    /**
     * Método getter para obtener el identificador único del tipo de pago.
     *
     * @return El identificador único del tipo de pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el identificador único del tipo de pago.
     *
     * @param id El identificador único del tipo de pago.
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
     * @param nombre El nombre del tipo de pago.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener el número de mensualidades para este tipo de
     * pago.
     *
     * @return El número de mensualidades para este tipo de pago.
     */
    public int getNumMensualidades() {
        return numMensualidades;
    }

    /**
     * Método setter para establecer el número de mensualidades para este tipo
     * de pago.
     *
     * @param numMensualidades El número de mensualidades para este tipo de
     * pago.
     */
    public void setNumMensualidades(int numMensualidades) {
        this.numMensualidades = numMensualidades;
    }

    /**
     * Método getter para obtener la lista de pagos asociados a este tipo de
     * pago.
     *
     * @return La lista de pagos asociados a este tipo de pago.
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * Método setter para establecer la lista de pagos asociados a este tipo de
     * pago.
     *
     * @param pagos La lista de pagos asociados a este tipo de pago.
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * Método getter para obtener el estado de eliminación del tipo de pago.
     *
     * @return true si el tipo de pago ha sido marcado como eliminado, false en
     * caso contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método setter para establecer el estado de eliminación del tipo de pago.
     *
     * @param eliminado true si se desea marcar el tipo de pago como eliminado,
     * false en caso contrario.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método que devuelve una representación en forma de cadena del nombre del
     * tipo de pago.
     *
     * @return Representación en forma de cadena del nombre del tipo de pago.
     */
    @Override
    public String toString() {
        return "TipoPagoDTO{" + "id=" + id + ", nombre=" + nombre + ", numMensualidades=" + numMensualidades + ", pagos=" + pagos + ", eliminado=" + eliminado + '}';
    }

}
