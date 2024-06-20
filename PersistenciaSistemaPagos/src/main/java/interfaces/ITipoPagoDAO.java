/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.TipoPagoEntidad;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris
 */
public interface ITipoPagoDAO {

    public void guardarTipoPago(TipoPagoEntidad tipo) throws PersistenciaException;
    
    public void modificarBeneficiario(Long id, TipoPagoEntidad tipo) throws PersistenciaException;
}
