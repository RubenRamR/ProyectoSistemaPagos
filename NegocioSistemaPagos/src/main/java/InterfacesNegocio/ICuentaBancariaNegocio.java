/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author rramirez
 */
public interface ICuentaBancariaNegocio {

    public void guardarCuentaBancaria(CuentaBancariaDTO cuentaBancaria) throws NegocioException;

    public void modificarCuentaBancaria(Long id, CuentaBancariaDTO cuentaBancaria) throws NegocioException;

    public void guardarCuentaBancariaConRelaciones(CuentaBancariaDTO cuentaBancaria, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) throws NegocioException;
    
    public CuentaBancariaDTO buscarCuentaBancariaDTO(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException;
    
    public CuentaBancariaDTO buscarCuentaBancariaPorId(Long id) throws NegocioException;

    void eliminarCuentaBancaria(Long id) throws NegocioException;
    
    public List<CuentaBancariaDTO> buscarCuentasBancarias(BeneficiarioDTO beneficiario) throws NegocioException;

}
