/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.AbonoDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.IAbonoNegocio;
import conexion.ConexionBD;
import daos.AbonoDAO;
import entidades.AbonoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAbonoDAO;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import interfaces.ICuentaBancariaDAO;
import interfaces.ITipoPagoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la lógica de negocio relacionada con los abonos. Utiliza
 * DAOs para interactuar con la capa de persistencia.
 */
public class AbonoNegocio implements IAbonoNegocio {

    private final IAbonoDAO abonoDAO;
    private IBeneficiarioDAO beneficiarioDAO;
    private ICuentaBancariaDAO cuentaBancariaDAO;
    private ITipoPagoDAO tipoDAO;
    private static final Logger LOGGER = Logger.getLogger(AbonoNegocio.class.getName());
    IConexionBD conexion;

    /**
     * Constructor de la clase AbonoNegocio. Inicializa los DAOs necesarios para
     * interactuar con la base de datos.
     */
    public AbonoNegocio() {
        this.conexion = new ConexionBD();
        this.abonoDAO = new AbonoDAO(conexion);
    }

    /**
     * Método para eliminar un abono dado su ID.
     *
     * @param id ID del abono a eliminar.
     * @throws NegocioException Si ocurre un error durante la eliminación del
     * abono.
     */
    @Override
    public void eliminarAbono(Long id) throws NegocioException {
        try
        {
            // Buscar el abono existente por su ID
            AbonoEntidad abonoExistente = abonoDAO.buscarAbonoPorId(id);
            if (abonoExistente == null)
            {
                throw new NegocioException("El abono con ID " + id + " no existe.");
            }

            // Cambiar la columna "eliminado" a true
            abonoExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            abonoDAO.guardarAbono(abonoExistente);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(AbonoNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al eliminar el abono.", ex);
        }
    }

    @Override
    public void guardarAbono(AbonoDTO abonoDTO) throws NegocioException {
    }

    /**
     * Método para modificar los datos de un abono existente.
     *
     * @param id ID del abono a modificar.
     * @param abono DTO con los nuevos datos del abono.
     * @throws NegocioException Si ocurre un error durante la modificación del
     * abono.
     */
    @Override
    public void modificarAbono(Long id, AbonoDTO abono) throws NegocioException {
        try
        {
            // Buscar el abono existente por su ID
            AbonoEntidad abonoExistente = abonoDAO.buscarAbonoPorId(id);
            if (abonoExistente == null)
            {
                throw new NegocioException("El abono con ID " + id + " no existe.");
            }

            // Actualizar los valores del abono con los proporcionados en el DTO
            abonoExistente.setFechaHora(abono.getFechaHora());
            abonoExistente.setMonto(abono.getMonto());

            // Guardar los cambios en la base de datos
            abonoDAO.guardarAbono(abonoExistente);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(AbonoNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al modificar el abono.", ex);
        }
    }

    @Override
    public void guardarAbonoConRelacion(AbonoDTO abonoDTO, PagoDTO pagoDTO) throws NegocioException {
//        try {
//            beneficiarioDAO = new BeneficiarioDAO(conexion);
//            cuentaBancariaDAO = new CuentaBancariaDAO(conexion);
//            tipoDAO = new TipoPagoDAO(conexion);
//
//            BeneficiarioEntidad beneficiario = beneficiarioDAO.buscarBeneficiarioPorId(pagoDTO.getBeneficiario().getId());
//
//            CuentaBancariaEntidad cuentaBancaria = cuentaBancariaDAO.buscarCuentaBancariaPorId(pagoDTO.getCuentaBancaria().getId());
//
//            TipoPagoEntidad tipo = tipoDAO.buscarTipoPagoPorId(pagoDTO.getTipoPago().getId());
//
//            PagoEntidad pago = new PagoEntidad(
//                    pagoDTO.getMonto(),
//                    pagoDTO.getComprobante(),
//                    pagoDTO.getFechaHora());
//
//            PagoDAO pagodao = new PagoDAO(conexion);
//            if (pagoDTO.getId() == null) {
//                pagodao.guardarPago(pago);
//            } else {
//                pago = pagodao.buscarPagoPorId(pagoDTO.getId());
//            }
//
//            AbonoEntidad abonoE = new AbonoEntidad(
//                    abonoDTO.getFechaHora(),
//                    abonoDTO.getMonto(),
//                    pago);
//
//            abonoDAO.guardarAbono(abonoE);
//
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(AbonoNegocio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
