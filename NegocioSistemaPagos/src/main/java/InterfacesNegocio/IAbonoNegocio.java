/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.AbonoDTO;
import DTOs.PagoDTO;
import excepciones.NegocioException;

/**
 *
 * @author rramirez
 */
public interface IAbonoNegocio {

    public void guardarAbono(AbonoDTO abono) throws NegocioException;

    public void modificarAbono(Long id, AbonoDTO abono) throws NegocioException;

    public void guardarAbonoConRelacion(AbonoDTO abono, PagoDTO pago) throws NegocioException;
    
    void eliminarAbono(Long id) throws NegocioException;
}
