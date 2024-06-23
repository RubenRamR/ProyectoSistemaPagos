/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.AbonoEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author caarl
 */
public interface IAbonoDAO {


    void guardarAbono(AbonoEntidad abono) throws PersistenciaException;

    void modificarAbono(Long id, AbonoEntidad abono) throws PersistenciaException;

    void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago) throws PersistenciaException;

    AbonoEntidad buscarAbono(AbonoEntidad abono) throws PersistenciaException;

    AbonoEntidad buscarAbonoPorId(Long idAbono) throws PersistenciaException;

    void eliminarAbono(Long id) throws PersistenciaException;

    List<AbonoEntidad> buscarAbonos() throws PersistenciaException;
}



