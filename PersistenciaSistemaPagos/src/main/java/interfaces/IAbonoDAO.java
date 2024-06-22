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

    public void guardarAbono(AbonoEntidad abono) throws PersistenciaException;

    public void modificarAbono(Long id, AbonoEntidad abono) throws PersistenciaException;

    public void guardarAbonoConRelacion(AbonoEntidad abono, PagoEntidad pago) throws PersistenciaException;

    public AbonoEntidad buscarAbono(AbonoEntidad abono) throws PersistenciaException;
    
    public AbonoEntidad buscarAbonoPorId(Long idAbono) throws PersistenciaException;

    public List<AbonoEntidad> buscarAbonos() throws PersistenciaException;

}
