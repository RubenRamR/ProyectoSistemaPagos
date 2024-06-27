/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.ICuentaBancariaNegocio;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import daos.CuentaBancariaDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import interfaces.ICuentaBancariaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la lógica de negocio relacionada con las cuentas
 * bancarias.
 */
public class CuentaBancariaNegocio implements ICuentaBancariaNegocio {

    private ICuentaBancariaDAO cuentaBancariaDAO;
    private IBeneficiarioDAO beneficiarioDAO;
    private static final Logger LOGGER = Logger.getLogger(CuentaBancariaNegocio.class.getName());
    IConexionBD conexion;

    public CuentaBancariaNegocio() {
        this.conexion = new ConexionBD();
        this.cuentaBancariaDAO = new CuentaBancariaDAO(conexion);

    }

    /**
     * Elimina una cuenta bancaria dado su ID.
     *
     * @param id ID de la cuenta bancaria a eliminar.
     * @throws NegocioException Si ocurre un error al eliminar la cuenta
     * bancaria.
     */
    @Override
    public void eliminarCuentaBancaria(Long id) throws NegocioException {
        try
        {
            // Buscar la cuenta bancaria existente por su ID
            CuentaBancariaEntidad cuentaExistente = cuentaBancariaDAO.buscarCuentaBancariaPorId(id);
            if (cuentaExistente == null)
            {
                throw new NegocioException("La cuenta bancaria con ID " + id + " no existe.");
            }

            // Cambiar la columna "eliminado" a true
            cuentaExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            cuentaBancariaDAO.guardarCuentaBancaria(cuentaExistente);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al eliminar la cuenta bancaria.", ex);
        }
    }

    /**
     * Guarda una nueva cuenta bancaria en la base de datos.
     *
     * @param cuentaBancariaDTO Datos de la cuenta bancaria a guardar.
     * @throws NegocioException Si ocurre un error al guardar la cuenta
     * bancaria.
     */
    @Override
    public void guardarCuentaBancaria(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {
        try
        {
            beneficiarioDAO = new BeneficiarioDAO(conexion);
            BeneficiarioEntidad beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(cuentaBancariaDTO.getBeneficiario().getId());
            if (beneficiario == null)
            {
                throw new NegocioException("Beneficiario no encontrado con id: " + cuentaBancariaDTO.getBeneficiario().getId());
            }

            CuentaBancariaEntidad cuentaBancaria = new CuentaBancariaEntidad(
                    cuentaBancariaDTO.getNumeroCuenta(),
                    cuentaBancariaDTO.getClave(),
                    cuentaBancariaDTO.getBanco(),
                    cuentaBancariaDTO.isEliminado(),
                    beneficiario
            );

            cuentaBancariaDAO.guardarCuentaBancaria(cuentaBancaria);
        } catch (PersistenciaException ex)
        {
            throw new NegocioException("Error al guardar la cuenta bancaria", ex);
        }
    }

    /**
     * Modifica los datos de una cuenta bancaria existente.
     *
     * @param id ID de la cuenta bancaria a modificar.
     * @param cuentaBancariaDTO Nuevos datos de la cuenta bancaria.
     * @throws NegocioException Si ocurre un error al modificar la cuenta
     * bancaria.
     */
    @Override
    public void modificarCuentaBancaria(Long id, CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {
        try
        {
            // Buscar la cuenta bancaria existente por su ID
            CuentaBancariaEntidad cuentaExistente = cuentaBancariaDAO.buscarCuentaBancariaPorId(id);
            if (cuentaExistente == null)
            {
                throw new NegocioException("La cuenta bancaria con ID " + id + " no existe.");
            }

            // Actualizar los valores de la cuenta bancaria con los proporcionados en el DTO
            cuentaExistente.setNumeroCuenta(cuentaBancariaDTO.getNumeroCuenta());
            cuentaExistente.setClave(cuentaBancariaDTO.getClave());
            cuentaExistente.setBanco(cuentaBancariaDTO.getBanco());
            cuentaExistente.setEliminado(cuentaBancariaDTO.isEliminado());

            // Guardar los cambios en la base de datos
            cuentaBancariaDAO.modificarCuentaBancaria(id, cuentaExistente);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al modificar la cuenta bancaria.", ex);
        }
    }

    /**
     * Guarda una nueva cuenta bancaria en la base de datos junto con
     * relaciones.
     *
     * @param cuentaBancaria Datos de la cuenta bancaria a guardar.
     * @param beneficiario Datos del beneficiario relacionado.
     * @param pagos Lista de pagos relacionados (a implementar si es necesario).
     * @throws NegocioException Si ocurre un error al guardar la cuenta bancaria
     * con relaciones.
     */
    @Override
    public void guardarCuentaBancariaConRelaciones(CuentaBancariaDTO cuentaBancaria, BeneficiarioDTO beneficiario, List<PagoDTO> pagos) throws NegocioException {
        try
        {
            // Crear una instancia de CuentaBancariaEntidad con los datos del DTO
            BeneficiarioEntidad beneficiarioEntidad = beneficiarioDAO.buscarBeneficiarioPorId(beneficiario.getId());
            if (beneficiarioEntidad == null)
            {
                throw new NegocioException("Beneficiario no encontrado con ID " + beneficiario.getId());
            }

            CuentaBancariaEntidad cuentaBancariaEntidad = new CuentaBancariaEntidad(
                    cuentaBancaria.getNumeroCuenta(),
                    cuentaBancaria.getClave(),
                    cuentaBancaria.getBanco(),
                    cuentaBancaria.isEliminado(),
                    beneficiarioEntidad);

            // Guardar la cuenta bancaria en la base de datos
            cuentaBancariaDAO.guardarCuentaBancaria(cuentaBancariaEntidad);

        } catch (PersistenciaException ex)
        {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al guardar la cuenta bancaria con relaciones.", ex);
        }
    }

    /**
     * Convierte un objeto BeneficiarioDTO a BeneficiarioEntidad.
     *
     * @param beneficiarioDTO BeneficiarioDTO a convertir.
     * @return BeneficiarioEntidad convertido.
     */
    public BeneficiarioEntidad convertirBeneficiarioDTOaEntidad(BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioEntidad beneficiarioEntidad = new BeneficiarioEntidad();
        beneficiarioEntidad.setApellidoMaterno(beneficiarioDTO.getApellidoMaterno());
        beneficiarioEntidad.setApellidoPaterno(beneficiarioDTO.getApellidoPaterno());
        beneficiarioEntidad.setClaveContrato(beneficiarioDTO.getClaveContrato());
        beneficiarioEntidad.setContrasena(beneficiarioDTO.getContrasena());
        beneficiarioEntidad.setNombres(beneficiarioDTO.getNombres());
        beneficiarioEntidad.setUsuario(beneficiarioDTO.getUsuario());
        return beneficiarioEntidad;
    }

    /**
     * Obtiene una lista de cuentas bancarias asociadas a un beneficiario por su
     * ID.
     *
     * @param id ID del beneficiario.
     * @return Lista de cuentas bancarias asociadas al beneficiario.
     * @throws NegocioException Si ocurre un error al consultar la lista de
     * cuentas bancarias.
     */
    @Override
    public List<CuentaBancariaDTO> listaCuentasPorIdBeneficiario(Long id) throws NegocioException {
        try
        {

            List<CuentaBancariaEntidad> listaCuentasBancariasEntidad = cuentaBancariaDAO.listaCuentasPorIdBeneficiario(id);
            List<CuentaBancariaDTO> listaCuentasBancariasDTO = new ArrayList<>();

            for (CuentaBancariaEntidad cuentaBancariaEntidad : listaCuentasBancariasEntidad)
            {
                listaCuentasBancariasDTO.add(convertirEntidadADTO(cuentaBancariaEntidad));
            }
            return listaCuentasBancariasDTO;
        } catch (PersistenciaException e)
        {
            throw new NegocioException("Error al consultar lista de cuentas bancarias", e);
        }
    }

    /**
     * Busca una cuenta bancaria a partir de un objeto DTO.
     *
     * @param cuentaBancariaDTO DTO con los datos de la cuenta bancaria a
     * buscar.
     * @return Cuenta bancaria encontrada.
     * @throws NegocioException Si ocurre un error al buscar la cuenta bancaria.
     */
    public CuentaBancariaDTO buscarCuentaBancariaDTO(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {

        try
        {
            CuentaBancariaEntidad cuentaBancariaEntidad = convertirDTOAEntidad(cuentaBancariaDTO);
            CuentaBancariaEntidad cuentaBancariaEncontrada = cuentaBancariaDAO.buscarCuentaBancaria(cuentaBancariaEntidad);

            return convertirEntidadADTO(cuentaBancariaEncontrada);
        } catch (PersistenciaException e)
        {
            throw new NegocioException("Error al buscar la cuenta bancaria", e);
        }
    }

    /**
     * Busca una cuenta bancaria por su ID.
     *
     * @param id ID de la cuenta bancaria a buscar.
     * @return Cuenta bancaria encontrada.
     * @throws NegocioException Si ocurre un error al buscar la cuenta bancaria.
     */
    public CuentaBancariaDTO buscarCuentaBancariaPorId(Long id) throws NegocioException {
        try
        {
            // Buscar la cuenta bancaria en la base de datos usando el ID
            CuentaBancariaEntidad cuentaBancariaEncontrada = cuentaBancariaDAO.buscarCuentaBancariaPorId(id);

            // Convertir la entidad encontrada a DTO y devolverla
            return convertirEntidadADTO(cuentaBancariaEncontrada);
        } catch (PersistenciaException e)
        {
            throw new NegocioException("Error al buscar la cuenta bancaria", e);
        }
    }

    /**
     * Convierte un objeto DTO de cuenta bancaria a su correspondiente entidad.
     *
     * @param cuentaBancariaDTO DTO de cuenta bancaria a convertir.
     * @return Entidad de cuenta bancaria convertida.
     * @throws NegocioException Si ocurre un error al convertir el DTO a
     * entidad.
     */
    private CuentaBancariaEntidad convertirDTOAEntidad(CuentaBancariaDTO cuentaBancariaDTO) throws NegocioException {

        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO(conexion);
        BeneficiarioEntidad beneficiario = new BeneficiarioEntidad();

        try
        {
            beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(cuentaBancariaDTO.getBeneficiario().getId());
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(CuentaBancariaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        CuentaBancariaEntidad cuentaBancariaEntidad = new CuentaBancariaEntidad();
        cuentaBancariaEntidad.setId(cuentaBancariaDTO.getId());
        cuentaBancariaEntidad.setBanco(cuentaBancariaDTO.getBanco());
        cuentaBancariaEntidad.setNumeroCuenta(cuentaBancariaDTO.getNumeroCuenta());
        cuentaBancariaEntidad.setClave(cuentaBancariaDTO.getClave());
        cuentaBancariaEntidad.setEliminado(cuentaBancariaDTO.isEliminado());
        cuentaBancariaEntidad.setBeneficiario(beneficiario);

        return cuentaBancariaEntidad;
    }

    /**
     * Convierte una entidad de cuenta bancaria a su correspondiente DTO.
     *
     * @param cuentaBancariaEntidad Entidad de cuenta bancaria a convertir.
     * @return DTO de cuenta bancaria convertido.
     * @throws NegocioException Si ocurre un error al convertir la entidad a
     * DTO.
     */
    private CuentaBancariaDTO convertirEntidadADTO(CuentaBancariaEntidad cuentaBancariaEntidad) throws NegocioException {

        BeneficiarioNegocio b = new BeneficiarioNegocio();

        CuentaBancariaDTO cuentaDTO = new CuentaBancariaDTO(
                cuentaBancariaEntidad.getId(),
                cuentaBancariaEntidad.getNumeroCuenta(),
                cuentaBancariaEntidad.getClave(),
                cuentaBancariaEntidad.getBanco(),
                cuentaBancariaEntidad.isEliminado(),
                b.convertirEntidadADTO(cuentaBancariaEntidad.getBeneficiario())
        );

        return cuentaDTO;
    }

    @Override
    public List<CuentaBancariaDTO> buscarCuentasBancarias(BeneficiarioDTO beneficiario) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
