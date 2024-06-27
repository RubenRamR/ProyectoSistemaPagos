/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.TipoPagoDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los tipos de
 * pago.
 */
public interface ITipoPagoNegocio {

    /**
     * Guarda un tipo de pago en el sistema.
     *
     * @param tipoPago El tipo de pago a guardar.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    void guardarTipoPago(TipoPagoDTO tipoPago) throws PersistenciaException;

    /**
     * Modifica un tipo de pago existente en el sistema.
     *
     * @param id ID del tipo de pago a modificar.
     * @param tipoPago El tipo de pago modificado.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    void modificarTipoPago(Long id, TipoPagoDTO tipoPago) throws PersistenciaException;

    /**
     * Busca un tipo de pago por su ID en el sistema.
     *
     * @param idTipoPago ID del tipo de pago a buscar.
     * @return El tipo de pago encontrado.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    TipoPagoDTO buscarTipoPagoPorId(Long idTipoPago) throws PersistenciaException;

    /**
     * Elimina un tipo de pago del sistema.
     *
     * @param id ID del tipo de pago a eliminar.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia.
     */
    void eliminarTipoPago(Long id) throws PersistenciaException;

    /**
     * Obtiene una lista de todos los tipos de pago en el sistema.
     *
     * @return Lista de tipos de pago.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    List<TipoPagoDTO> muestraTiposPago() throws NegocioException;

    /**
     * Inserta tipos de pago predeterminados en el sistema.
     *
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    public void insertaTiposDePagoPredeterminados() throws NegocioException;
}
