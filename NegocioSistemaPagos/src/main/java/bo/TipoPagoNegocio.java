/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.TipoPagoDTO;
import entidades.TipoPagoEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITipoPagoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import InterfacesNegocio.ITipoPagoNegocio;
import conexion.ConexionBD;
import daos.TipoPagoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz ITipoPagoNegocio para gestionar los tipos de
 * pago.
 */
public class TipoPagoNegocio implements ITipoPagoNegocio {

    private final ITipoPagoDAO tipoPagoDAO;
    private static final Logger LOGGER = Logger.getLogger(TipoPagoNegocio.class.getName());
    IConexionBD conexion;

    /**
     * Constructor de la clase TipoPagoNegocio. Inicializa la conexión a la base
     * de datos y el DAO necesario para operaciones de tipo de pago.
     */
    public TipoPagoNegocio() {
        this.conexion = new ConexionBD();
        this.tipoPagoDAO = new TipoPagoDAO(conexion);
    }

    /**
     * Método para eliminar un tipo de pago por su ID. Cambia la columna
     * "eliminado" a true en la entidad correspondiente y guarda los cambios.
     *
     * @param id ID del tipo de pago a eliminar.
     */
    @Override
    public void eliminarTipoPago(Long id) {
        try
        {
            // Buscar el tipo de pago existente por su ID
            TipoPagoEntidad tipoPagoExistente = tipoPagoDAO.buscarTipoPagoPorId(id);
            if (tipoPagoExistente == null)
            {
                try
                {
                    throw new NegocioException("El tipo de pago con ID " + id + " no existe.");
                } catch (NegocioException ex)
                {
                    Logger.getLogger(TipoPagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // Cambiar la columna "eliminado" a true
            tipoPagoExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            tipoPagoDAO.guardarTipoPago(tipoPagoExistente);
        } catch (PersistenciaException ex)
        {
            try
            {
                LOGGER.log(Level.SEVERE, "Error al eliminar el tipo de pago.", ex);
                throw new NegocioException("Error al eliminar el tipo de pago.", ex);
            } catch (NegocioException ex1)
            {
                Logger.getLogger(TipoPagoNegocio.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Método para guardar un nuevo tipo de pago en la base de datos. Convierte
     * un objeto DTO en entidad y lo guarda utilizando el DAO correspondiente.
     *
     * @param tipoPagoDTO DTO con los datos del tipo de pago a guardar.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la operación.
     */
    @Override
    public void guardarTipoPago(TipoPagoDTO tipoPagoDTO) throws PersistenciaException {
        TipoPagoEntidad tipoPago = convertirADominio(tipoPagoDTO);
        tipoPagoDAO.guardarTipoPago(tipoPago);
    }

    /**
     * Método para modificar un tipo de pago existente en la base de datos.
     * Convierte un objeto DTO en entidad y realiza la modificación utilizando
     * el DAO correspondiente.
     *
     * @param id ID del tipo de pago a modificar.
     * @param tipoPagoDTO DTO con los nuevos datos del tipo de pago.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la operación.
     */
    @Override
    public void modificarTipoPago(Long id, TipoPagoDTO tipoPagoDTO) throws PersistenciaException {
        TipoPagoEntidad tipoPago = convertirADominio(tipoPagoDTO);
        tipoPagoDAO.modificarTipoPago(id, tipoPago);
    }

    /**
     * Método para buscar un tipo de pago por su ID en la base de datos.
     * Convierte la entidad encontrada en un objeto DTO y lo retorna.
     *
     * @param id ID del tipo de pago a buscar.
     * @return DTO con los datos del tipo de pago encontrado.
     * @throws PersistenciaException Si ocurre un error en la capa de
     * persistencia durante la operación.
     */
    @Override
    public TipoPagoDTO buscarTipoPagoPorId(Long id) throws PersistenciaException {
        TipoPagoEntidad tipoPago = tipoPagoDAO.buscarTipoPagoPorId(id);
        return convertirADTO(tipoPago);
    }

    /**
     * Método para insertar tipos de pago predeterminados en la base de datos.
     * Utiliza objetos DTO predefinidos para guardar tipos de pago comunes.
     *
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la operación.
     */
    public void insertaTiposDePagoPredeterminados() throws NegocioException {
        try
        {
            TipoPagoDTO tipoPagoDTO1 = new TipoPagoDTO("Reembolso", 1);
            TipoPagoDTO tipoPagoDTO2 = new TipoPagoDTO("Proveedor", 5);
            TipoPagoDTO tipoPagoDTO3 = new TipoPagoDTO("Viatico", 7);

            TipoPagoEntidad tipoPago1 = convertirADominio(tipoPagoDTO1);
            TipoPagoEntidad tipoPago2 = convertirADominio(tipoPagoDTO2);
            TipoPagoEntidad tipoPago3 = convertirADominio(tipoPagoDTO3);

            tipoPagoDAO.guardarTipoPago(tipoPago1);
            tipoPagoDAO.guardarTipoPago(tipoPago2);
            tipoPagoDAO.guardarTipoPago(tipoPago3);
        } catch (PersistenciaException ex)
        {
            Logger.getLogger(TipoPagoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para obtener una lista de todos los tipos de pago almacenados en
     * la base de datos. Convierte las entidades encontradas en objetos DTO y
     * los devuelve como una lista.
     *
     * @return Lista de DTOs con los datos de todos los tipos de pago.
     * @throws NegocioException Si ocurre un error en la lógica de negocio
     * durante la operación.
     */
    public List<TipoPagoDTO> muestraTiposPago() throws NegocioException {
        try
        {
            List<TipoPagoEntidad> tiposPagoEntidad = tipoPagoDAO.buscarTodosTiposPago();

            List<TipoPagoDTO> tiposPagoDTO = new ArrayList<>();
            for (TipoPagoEntidad tipoPagoEntidad : tiposPagoEntidad)
            {
                tiposPagoDTO.add(convertirADTO(tipoPagoEntidad));
            }

            return tiposPagoDTO;
        } catch (PersistenciaException e)
        {
            throw new NegocioException("Error al obtener la lista de tipos de pago", e);
        }
    }

    /**
     * Método privado para convertir un objeto DTO de tipo de pago en una
     * entidad.
     *
     * @param tipoPagoDTO DTO con los datos del tipo de pago.
     * @return Entidad de tipo de pago con los datos del DTO.
     */
    private TipoPagoEntidad convertirADominio(TipoPagoDTO tipoPagoDTO) {
        // Convert DTO to Entity
        TipoPagoEntidad tipoPago = new TipoPagoEntidad();
        tipoPago.setId(tipoPagoDTO.getId());
        tipoPago.setNombre(tipoPagoDTO.getNombre());
        // Set other fields
        return tipoPago;
    }

    /**
     * Método privado para convertir una entidad de tipo de pago en un objeto
     * DTO.
     *
     * @param tipoPago Entidad de tipo de pago con los datos.
     * @return DTO con los datos de la entidad de tipo de pago.
     */
    private TipoPagoDTO convertirADTO(TipoPagoEntidad tipoPago) {
        TipoPagoDTO tipoPagoDTO = new TipoPagoDTO();
        tipoPagoDTO.setId(tipoPago.getId());
        tipoPagoDTO.setNombre(tipoPago.getNombre());
        tipoPagoDTO.setNumMensualidades(tipoPago.getNumMensualidades());

        return tipoPagoDTO;
    }
}
