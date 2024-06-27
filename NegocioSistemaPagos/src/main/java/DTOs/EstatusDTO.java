/*
 * Esta clase representa un objeto de transferencia de datos (DTO) para el
 * manejo de estados, incluyendo su identificador, nombre, lista de pagos
 * asociados y estado de eliminación.
 */
package DTOs;

import java.util.List;

public class EstatusDTO {

    private Long id;
    private String nombre;
    private List<Estatus_pagoDTO> estatusPagos;
    private boolean eliminado;

    /**
     * Constructor vacío de la clase EstatusDTO.
     */
    public EstatusDTO() {
    }

    /**
     * Constructor de la clase EstatusDTO que inicializa el nombre y la lista de
     * pagos asociados.
     *
     * @param nombre El nombre del estado.
     * @param estatusPagos La lista de pagos asociados a este estado.
     */
    public EstatusDTO(String nombre, List<Estatus_pagoDTO> estatusPagos) {
        this.nombre = nombre;
        this.estatusPagos = estatusPagos;
    }

    /**
     * Constructor de la clase EstatusDTO que inicializa todos los atributos.
     *
     * @param id El identificador único del estado.
     * @param nombre El nombre del estado.
     * @param estatusPagos La lista de pagos asociados a este estado.
     */
    public EstatusDTO(Long id, String nombre, List<Estatus_pagoDTO> estatusPagos) {
        this.id = id;
        this.nombre = nombre;
        this.estatusPagos = estatusPagos;
    }

    /**
     * Método getter para obtener el identificador único del estado.
     *
     * @return El identificador único del estado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el identificador único del estado.
     *
     * @param id El identificador único del estado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el nombre del estado.
     *
     * @return El nombre del estado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setter para establecer el nombre del estado.
     *
     * @param nombre El nombre del estado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getter para obtener la lista de pagos asociados a este estado.
     *
     * @return La lista de pagos asociados a este estado.
     */
    public List<Estatus_pagoDTO> getEstatusPagos() {
        return estatusPagos;
    }

    /**
     * Método setter para establecer la lista de pagos asociados a este estado.
     *
     * @param estatusPagos La lista de pagos asociados a este estado.
     */
    public void setEstatusPagos(List<Estatus_pagoDTO> estatusPagos) {
        this.estatusPagos = estatusPagos;
    }

    /**
     * Método getter para obtener el estado de eliminación del estado.
     *
     * @return true si el estado ha sido marcado como eliminado, false en caso
     * contrario.
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * Método setter para establecer el estado de eliminación del estado.
     *
     * @param eliminado true si se desea marcar el estado como eliminado, false
     * en caso contrario.
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * Método que devuelve una representación en forma de cadena del objeto
     * EstatusDTO.
     *
     * @return Representación en forma de cadena del objeto EstatusDTO.
     */
    @Override
    public String toString() {
        return "EstatusDTO{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", estatusPagos=" + estatusPagos
                + ", eliminado=" + eliminado
                + '}';
    }
}
