/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.PagoDTO;
import excepciones.NegocioException;

/**
 *
 * @author rramirez
 */
public interface IPagoNegocio {

    public void guardarPago(PagoDTO pago) throws NegocioException;

}
