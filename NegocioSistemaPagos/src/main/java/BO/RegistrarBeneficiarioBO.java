/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import IBO.IRegistrarBeneficiariosBO;
import daos.BeneficiarioDAO;
import daos.CuentaBancariaDAO;
import daos.PagoDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.PagoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rramirez
 */
public class RegistrarBeneficiarioBO implements IRegistrarBeneficiariosBO {

    private static BeneficiarioDAO beneficiarioDAO;
    private static CuentaBancariaDAO cuentaBancariaDAO;
    private static PagoDAO pagoDAO;

    public RegistrarBeneficiarioBO(IConexionBD conexion) {
        beneficiarioDAO = new BeneficiarioDAO(conexion);
        cuentaBancariaDAO = new CuentaBancariaDAO(conexion);
        pagoDAO = new PagoDAO(conexion);
    }

    @Override
    public void guardarBeneficiario(BeneficiarioDTO beneficiario) throws NegocioException {
        try
        {
            BeneficiarioEntidad entidad = convertirBeneficiarioAEntidad(beneficiario);
            beneficiarioDAO.guardarBeneficiario(entidad);
        } catch (PersistenciaException ex)
        {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public void modificarBeneficiario(Long id, BeneficiarioDTO beneficiario) throws NegocioException {
        try
        {
            BeneficiarioEntidad entidad = convertirBeneficiarioAEntidad(beneficiario);
            beneficiarioDAO.modificarBeneficiario(id, entidad);
        } catch (PersistenciaException ex)
        {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException {
        try
        {
            BeneficiarioEntidad beneficiarioEntidad = convertirBeneficiarioAEntidad(beneficiario);
            beneficiarioDAO.guardarBeneficiario(beneficiarioEntidad);

            for (CuentaBancariaDTO cuentaDTO : cuentas)
            {
                CuentaBancariaEntidad cuentaEntidad = convertirCuentaAEntidad(cuentaDTO);
                cuentaEntidad.setBeneficiario(beneficiarioEntidad);
                cuentaBancariaDAO.guardarCuentaBancaria(cuentaEntidad);
            }

            // Convertir y guardar cada PagoDTO
            for (PagoDTO pagoDTO : pagos)
            {
                PagoEntidad pagoEntidad = convertirPagoADominio(pagoDTO);
                pagoEntidad.setBeneficiario(beneficiarioEntidad);
                pagoDAO.guardarPago(pagoEntidad);
            }
        } catch (PersistenciaException ex)
        {
            throw new NegocioException(ex.getMessage(), ex);
        }
    }

    private BeneficiarioEntidad convertirBeneficiarioAEntidad(BeneficiarioDTO dto) {
        return new BeneficiarioEntidad(
                dto.getId(),
                dto.getNombres(),
                dto.getApellidoPaterno(),
                dto.getApellidoMaterno(),
                dto.getUsuario(),
                dto.getContrasena(),
                dto.getClaveContrato(),
                dto.getSaldo()
        );
    }

    private PagoDTO convertirPagoADTO(PagoEntidad entidad) {
        return new PagoDTO(
                entidad.getId(),
                entidad.getMonto(),
                entidad.getComprobante(),
                entidad.getFechaHora(),
//                convertirADTO(entidad.getBeneficiario()),
//                convertirCuentaADTO(entidad.getCuentasBancaria()),
//                convertirTipoPagoADTO(entidad.getTipoPago()),
//                convertirAbonosADTO(entidad.getAbono()),
//                convertirEstatusPagosADTO(entidad.getEstatus_pago())
        );
    }

    private List<PagoDTO> convertirPagosADTO(List<PagoEntidad> entidades) {
        return entidades.stream().map(this::convertirPagoADTO).collect(Collectors.toList());
    }

    private CuentaBancariaEntidad convertirCuentaAEntidad(CuentaBancariaDTO dto) {
        BeneficiarioEntidad beneficiario = convertirBeneficiarioAEntidad(dto.getBeneficiario());
        return new CuentaBancariaEntidad(
                dto.getId(),
                dto.getNumeroCuenta(),
                dto.getClave(),
                dto.getBanco(),
                dto.isEliminado(),
                beneficiario,
                dto.getPagos()
        );
    }
}
