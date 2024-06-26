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
 *
 * @author rramirez
 */
public interface ITipoPagoNegocio {

    void guardarTipoPago(TipoPagoDTO tipoPago) throws PersistenciaException;

    void modificarTipoPago(Long id, TipoPagoDTO tipoPago) throws PersistenciaException;

    TipoPagoDTO buscarTipoPagoPorId(Long idTipoPago) throws PersistenciaException;

    void eliminarTipoPago(Long id) throws PersistenciaException;

    public List<TipoPagoDTO> muestraTiposPago() throws NegocioException;
}
