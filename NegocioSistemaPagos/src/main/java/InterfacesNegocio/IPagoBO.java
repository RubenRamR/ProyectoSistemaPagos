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
public interface IPagoBO {
    void guardarPago(PagoDTO pago) throws PersistenciaException;
    PagoDTO buscarPagoPorId(Long idPago) throws PersistenciaException;
    void eliminarPago(Long id) throws PersistenciaException;
    
}