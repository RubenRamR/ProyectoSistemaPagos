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
public interface ICuentaBancariaDAO {

    public void guardarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException;

    public void modificarCuentaBancaria(Long id, CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException;

    public void guardarCuentaBancariaConRelaciones(CuentaBancariaEntidad cuentaBancaria, BeneficiarioEntidad beneficiario, List<PagoEntidad> pagos) throws PersistenciaException;

    public CuentaBancariaEntidad buscarCuentaBancaria(CuentaBancariaEntidad cuentaBancaria) throws PersistenciaException;

    public CuentaBancariaEntidad buscarCuentaBancariaPorId(Long idCuentaBancaria) throws PersistenciaException;

    public List<CuentaBancariaEntidad> buscarCuentasBancarias() throws PersistenciaException;
    
    void eliminarCuentaBancaria(Long id) throws PersistenciaException;
}
