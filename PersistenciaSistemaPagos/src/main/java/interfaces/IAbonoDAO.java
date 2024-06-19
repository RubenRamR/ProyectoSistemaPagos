/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.AbonoEntidad;
import entidades.PagoEntidad;

/**
 *
 * @author caarl
 */
public interface IAbonoDAO {
    void guardarAbono(AbonoEntidad abono);
    void modificarAbono(Long id, AbonoEntidad abono);
    void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago);

}
