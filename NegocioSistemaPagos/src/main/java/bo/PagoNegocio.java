/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.PagoDTO;
import entidades.PagoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IPagoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import InterfacesNegocio.IPagoNegocio;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import daos.CuentaBancariaDAO;
import daos.PagoDAO;
import daos.TipoPagoDAO;
import entidades.BeneficiarioEntidad;
import entidades.CuentaBancariaEntidad;
import entidades.TipoPagoEntidad;

/**
 * Clase que implementa la interfaz IPagoNegocio para gestionar los pagos.
 */
public class PagoNegocio implements IPagoNegocio {

    private final IPagoDAO pagoDAO;
    private static final Logger LOGGER = Logger.getLogger(PagoNegocio.class.getName());
    IConexionBD conexion;

    /**
     * Constructor de la clase PagoNegocio. Inicializa la conexión a la base de
     * datos y el DAO necesario para operaciones de pago.
     */
    public PagoNegocio() {
        this.conexion = new ConexionBD();
        this.pagoDAO = new PagoDAO(conexion);
    }

    /**
     * Método para eliminar un pago por su ID. Cambia la columna "eliminado" a
     * true en la entidad correspondiente y guarda los cambios.
     *
     * @param id ID del pago a eliminar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la eliminación.
     */
    @Override
    public void eliminarPago(Long id) throws NegocioException {
        try
        {
            PagoEntidad pagoExistente = pagoDAO.buscarPagoPorId(id);
            if (pagoExistente == null)
            {
                try
                {
                    throw new NegocioException("El pago con ID " + id + " no existe.");
                } catch (NegocioException ex)
                {
                    Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Cambiar la columna "eliminado" a true
            pagoExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            pagoDAO.guardarPago(pagoExistente);
        } catch (PersistenciaException ex)
        {
            LOGGER.log(Level.SEVERE, "Error al eliminar el pago.", ex);
            try
            {
                throw new NegocioException("Error al eliminar el pago.", ex);
            } catch (NegocioException ex1)
            {
                Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Método para guardar un nuevo pago en la base de datos. Convierte un
     * objeto DTO en entidad y lo guarda utilizando el DAO correspondiente.
     *
     * @param pagoDTO DTO con los datos del pago a guardar.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la operación.
     */
    @Override
    public void guardarPago(PagoDTO pagoDTO) throws NegocioException {
        PagoEntidad pago = convertirADominio(pagoDTO);
        try
        {
            pagoDAO.guardarPago(pago);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para buscar un pago por su ID en la base de datos. Convierte la
     * entidad encontrada en un objeto DTO y lo retorna.
     *
     * @param id ID del pago a buscar.
     * @return DTO con los datos del pago encontrado.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la búsqueda.
     */
    @Override
    public PagoDTO buscarPagoPorId(Long id) throws NegocioException {
        PagoEntidad pago = null;
        try
        {
            pago = pagoDAO.buscarPagoPorId(id);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertirADTO(pago);
    }

    /**
     * Método privado para convertir un objeto DTO en una entidad de pago.
     * Realiza la búsqueda de otros objetos relacionados (beneficiario, tipo de
     * pago, cuenta bancaria) necesarios para la entidad.
     *
     * @param pagoDTO DTO con los datos del pago.
     * @return Entidad de pago con los datos del DTO.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la conversión.
     */
    private PagoEntidad convertirADominio(PagoDTO pagoDTO) throws NegocioException {
        // Convert DTO to Entity
        BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO(conexion);
        BeneficiarioEntidad beneficiario = null;

        TipoPagoDAO tipo = new TipoPagoDAO(conexion);
        TipoPagoEntidad tipoPago = null;

        CuentaBancariaDAO cuenta = new CuentaBancariaDAO(conexion);
        CuentaBancariaEntidad cuentaNueva = null;

        try
        {
            beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(pagoDTO.getBeneficiario().getId());
            tipoPago = tipo.buscarTipoPagoPorId(pagoDTO.getTipoPago().getId());
            cuentaNueva = cuenta.buscarCuentaBancariaPorId(pagoDTO.getCuentaBancaria().getId());
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(PagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        PagoEntidad pago = new PagoEntidad(pagoDTO.getId(), pagoDTO.getMonto(), pagoDTO.getComprobante(), pagoDTO.getFechaHora(), beneficiario, cuentaNueva, tipoPago, false);

        return pago;
    }

    /**
     * Método privado para convertir una entidad de pago en un objeto DTO.
     *
     * @param pago Entidad de pago con los datos.
     * @return DTO con los datos de la entidad de pago.
     */
    private PagoDTO convertirADTO(PagoEntidad pago) {
        // Convert Entity to DTO
        PagoDTO pagoDTO = new PagoDTO();
        pagoDTO.setId(pago.getId());
        pagoDTO.setMonto(pago.getMonto());
        // Set other fields
        return pagoDTO;
    }
}
