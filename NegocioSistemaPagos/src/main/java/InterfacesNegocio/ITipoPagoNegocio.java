/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.TipoPagoDTO;
import excepciones.NegocioException;

/**
 *
 * @author rramirez
 */
public interface ITipoPagoNegocio {

    public void guardarTipoPago(TipoPagoDTO tipo) throws NegocioException;

    public void modificarBeneficiario(Long id, TipoPagoDTO tipo) throws NegocioException;
}
