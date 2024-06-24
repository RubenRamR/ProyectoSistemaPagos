/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.TipoPagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Chris
 */




public interface ITipoPagoDAO {
    void guardarTipoPago(TipoPagoEntidad tipo) throws PersistenciaException;
    
    void modificarTipoPago(Long id, TipoPagoEntidad tipo) throws PersistenciaException;
    
    TipoPagoEntidad buscarTipoPagoPorId(Long id) throws PersistenciaException;
    
    List<TipoPagoEntidad> buscarTodosTiposPago() throws PersistenciaException;
    
    void eliminarTipoPago(Long id) throws PersistenciaException;
    
    List<TipoPagoEntidad> buscarTiposPagoPorNombre(String nombre) throws PersistenciaException;
}
