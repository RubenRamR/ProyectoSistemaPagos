/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.PagoDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los pagos.
 */
public interface IPagoNegocio {

    /**
     * Método para guardar un pago en el sistema.
     *
     * @param pago El pago a guardar.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    void guardarPago(PagoDTO pago) throws NegocioException;

    /**
     * Método para buscar un pago por su ID en el sistema.
     *
     * @param idPago ID del pago a buscar.
     * @return El pago encontrado.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    PagoDTO buscarPagoPorId(Long idPago) throws NegocioException;

    /**
     * Método para eliminar un pago del sistema.
     *
     * @param id ID del pago a eliminar.
     * @throws NegocioException Si ocurre un error durante la operación de
     * negocio.
     */
    void eliminarPago(Long id) throws NegocioException;

}
