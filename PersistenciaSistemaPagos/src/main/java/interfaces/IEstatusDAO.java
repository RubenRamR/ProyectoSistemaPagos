/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.EstatusEntidad;

/**
 *
 * @author caarl
 */
public interface IEstatusDAO {
void guardarEstatus(EstatusEntidad estatus);
    void modificarEstatus(Long id, EstatusEntidad estatus);
}
