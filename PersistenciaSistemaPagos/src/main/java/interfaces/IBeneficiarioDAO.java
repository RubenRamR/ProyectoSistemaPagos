/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author caarl
 */
public interface IBeneficiarioDAO {

    public void guardarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException;

    public void modificarBeneficiario(Long id, BeneficiarioEntidad beneficiario) throws PersistenciaException;

    public void guardarBeneficiarioConRelaciones(BeneficiarioEntidad beneficiario, List<CuentaBancariaEntidad> cuentas, List<PagoEntidad> pagos) throws PersistenciaException;

    public BeneficiarioEntidad buscarBeneficiario(BeneficiarioEntidad beneficiario) throws PersistenciaException;

    public BeneficiarioEntidad buscarBeneficiarioPorId(Long idBeneficiario) throws PersistenciaException;

    public List<BeneficiarioEntidad> buscarBeneficiarios() throws PersistenciaException;
    
    void eliminarBeneficiario(Long id) throws PersistenciaException;
}
