/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.PagoEntidad;
import excepciones.PersistenciaException;

/**
 *
 * @author Chris
 */
public interface IPagoDAO {

    public void guardarPago(PagoEntidad pago) throws PersistenciaException;
}
