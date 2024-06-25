/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.PagoDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author rramirez
 */
public interface IPagoNegocio {

    void guardarPago(PagoDTO pago) throws NegocioException;

    PagoDTO buscarPagoPorId(Long idPago) throws NegocioException;

    void eliminarPago(Long id) throws NegocioException;

}
