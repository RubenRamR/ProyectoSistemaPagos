/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package InterfacesNegocio;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import entidades.BeneficiarioEntidad;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author rramirez
 */
public interface IBeneficiarioNegocio {

    public void guardarBeneficiario(BeneficiarioDTO beneficiario) throws NegocioException;

    public void modificarBeneficiario(Long id, BeneficiarioDTO beneficiario) throws NegocioException;
    
    public BeneficiarioDTO buscarBeneficiarioDTO(BeneficiarioDTO beneficiario) throws NegocioException;

    public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException;
    
    public List<BeneficiarioDTO> buscarBeneficiarios(int limit, int pagina) throws NegocioException;

    void eliminarBeneficiario(Long id) throws NegocioException;
    
    public BeneficiarioDTO buscarBeneficiarioPorId(Long idBo) throws NegocioException;
    
    public BeneficiarioDTO loginBeneficiario(String usuario, String contrasena) throws NegocioException;

    
}
