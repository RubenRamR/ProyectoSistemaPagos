/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.AbonoDTO;
import DTOs.PagoDTO;
import excepciones.NegocioException;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los abonos.
 */
public interface IAbonoNegocio {

    /**
     * Método para guardar un abono en el sistema.
     *
     * @param abono El abono a guardar.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public void guardarAbono(AbonoDTO abono) throws NegocioException;

    /**
     * Método para modificar un abono existente en el sistema.
     *
     * @param id ID del abono a modificar.
     * @param abono Los datos actualizados del abono.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public void modificarAbono(Long id, AbonoDTO abono) throws NegocioException;

    /**
     * Método para guardar un abono relacionado con un pago específico.
     *
     * @param abono El abono a guardar.
     * @param pago El pago al cual se relacionará el abono.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    public void guardarAbonoConRelacion(AbonoDTO abono, PagoDTO pago) throws NegocioException;

    /**
     * Método para eliminar un abono del sistema.
     *
     * @param id ID del abono a eliminar.
     * @throws NegocioException Si ocurre un error durante la operación de negocio.
     */
    void eliminarAbono(Long id) throws NegocioException;
}
