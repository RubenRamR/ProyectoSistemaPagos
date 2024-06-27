/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import DTOs.BeneficiarioDTO;
import DTOs.CuentaBancariaDTO;
import DTOs.PagoDTO;
import InterfacesNegocio.IBeneficiarioNegocio;
import Utileria.Encriptacion;
import Utileria.Utilidades;
import conexion.ConexionBD;
import daos.BeneficiarioDAO;
import entidades.BeneficiarioEntidad;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IBeneficiarioDAO;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa la lógica de negocio relacionada con los beneficiarios.
 */
public class BeneficiarioNegocio implements IBeneficiarioNegocio {

    private IBeneficiarioDAO beneficiarioDAO;
    IConexionBD conexion;
    private static final Logger LOGGER = Logger.getLogger(BeneficiarioNegocio.class.getName());

    /**
     * Constructor de la clase BeneficiarioNegocio. Inicializa la conexión a la
     * base de datos y el DAO correspondiente.
     */
    public BeneficiarioNegocio() {
        this.conexion = new ConexionBD();
        this.beneficiarioDAO = new BeneficiarioDAO(conexion);
    }

    /**
     * Método para eliminar un beneficiario dado su ID.
     *
     * @param id ID del beneficiario a eliminar.
     * @throws NegocioException Si ocurre un error durante la eliminación del
     * beneficiario.
     */
    @Override
    public void eliminarBeneficiario(Long id) throws NegocioException {
        try {
            // Buscar el beneficiario existente por su ID
            BeneficiarioEntidad beneficiarioExistente = beneficiarioDAO.buscarBeneficiarioPorId(id);
            if (beneficiarioExistente == null) {
                throw new NegocioException("El beneficiario con ID " + id + " no existe.");
            }

            // Cambiar la columna "eliminado" a true
            beneficiarioExistente.setEliminado(true);

            // Guardar los cambios en la base de datos
            beneficiarioDAO.eliminarBeneficiario(id);
        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al eliminar el beneficiario.", ex);
        }

    }

    /**
     * Método para guardar un beneficiario en la base de datos.
     *
     * @param beneficiarioDTO DTO con los datos del beneficiario a guardar.
     * @throws NegocioException Si ocurre un error durante el proceso de guardar
     * el beneficiario.
     */
    @Override
    public void guardarBeneficiario(BeneficiarioDTO beneficiarioDTO) throws NegocioException {
        try {
            BeneficiarioEntidad beneficiario = new BeneficiarioEntidad(
                    beneficiarioDTO.getNombres(),
                    beneficiarioDTO.getApellidoPaterno(),
                    beneficiarioDTO.getApellidoMaterno(),
                    beneficiarioDTO.getUsuario(),
                    beneficiarioDTO.getContrasena(),
                    beneficiarioDTO.getClaveContrato(),
                    beneficiarioDTO.getSaldo()
            );
            beneficiario.setEliminado(beneficiarioDTO.isEliminado());
            String contraseñaEncriptada = Encriptacion.encriptarPassword(beneficiario.getContrasena());
            beneficiario.setContrasena(contraseñaEncriptada);
            beneficiarioDAO.guardarBeneficiario(beneficiario);
        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método para modificar los datos de un beneficiario existente.
     *
     * @param beneficiario DTO con los nuevos datos del beneficiario.
     * @throws NegocioException Si ocurre un error durante la modificación del
     * beneficiario.
     */
    @Override
    public void modificarBeneficiario(BeneficiarioDTO beneficiario) throws NegocioException {
        try {
            validarBeneficiario(beneficiario);
            BeneficiarioEntidad beneficiarioEntidad = convertirDTOAEntidad(beneficiario);
            beneficiarioDAO.modificarBeneficiario(beneficiarioEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al editar beneficiario", e);
        }
    }

    /**
     * Método para guardar un beneficiario junto con sus relaciones (cuentas
     * bancarias y pagos).
     *
     * @param beneficiario DTO con los datos del beneficiario.
     * @param cuentas Lista de DTOs con las cuentas bancarias asociadas.
     * @param pagos Lista de DTOs con los pagos asociados.
     * @throws NegocioException Si ocurre un error durante el proceso de guardar
     * el beneficiario con relaciones.
     */
    @Override
    public void guardarBeneficiarioConRelaciones(BeneficiarioDTO beneficiario, List<CuentaBancariaDTO> cuentas, List<PagoDTO> pagos) throws NegocioException {
        try {
            // Crear una instancia de BeneficiarioEntidad con los datos del DTO
            BeneficiarioEntidad beneficiarioEntidad = new BeneficiarioEntidad(
                    beneficiario.getNombres(),
                    beneficiario.getApellidoPaterno(),
                    beneficiario.getApellidoMaterno(),
                    beneficiario.getUsuario(),
                    beneficiario.getContrasena(),
                    beneficiario.getClaveContrato(),
                    beneficiario.getSaldo()
            );

            // Guardar el beneficiario en la base de datos
            beneficiarioDAO.guardarBeneficiario(beneficiarioEntidad);
        } catch (PersistenciaException ex) {
            Logger.getLogger(BeneficiarioNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al guardar el beneficiario con relaciones.", ex);
        }
    }

    /**
     * Método para buscar y devolver un BeneficiarioDTO dado otro
     * BeneficiarioDTO como parámetro de búsqueda.
     *
     * @param beneficiarioDTO DTO con los datos del beneficiario a buscar.
     * @return BeneficiarioDTO encontrado.
     * @throws NegocioException Si ocurre un error durante la búsqueda del
     * beneficiario.
     */
    public BeneficiarioDTO buscarBeneficiarioDTO(BeneficiarioDTO beneficiarioDTO) throws NegocioException {
        try {
            // Imprimir los datos del beneficiarioDTO
            System.out.println("Buscando BeneficiarioDTO con ID: " + beneficiarioDTO.getId());

            // Convertir BeneficiarioDTO a BeneficiarioEntidad
            BeneficiarioEntidad beneficiarioEntidad = convertirDTOAEntidad(beneficiarioDTO);

            // Buscar el beneficiario en la base de datos
            BeneficiarioEntidad beneficiarioEncontrado = beneficiarioDAO.buscarBeneficiario(beneficiarioEntidad);

            // Convertir la entidad encontrada a DTO y devolverla
            BeneficiarioDTO beneficiarioEncontradoDTO = convertirEntidadADTO(beneficiarioEncontrado);

            // Imprimir los datos del beneficiario encontrado
            System.out.println("Beneficiario encontrado: " + beneficiarioEncontradoDTO.getId());

            return beneficiarioEncontradoDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al buscar el beneficiario", e);
        }
    }

    /**
     * Método para buscar y devolver una lista de BeneficiarioDTOs.
     *
     * @param limit Cantidad máxima de resultados a devolver.
     * @param pagina Número de página de resultados.
     * @return Lista de BeneficiarioDTOs encontrados.
     * @throws NegocioException Si ocurre un error durante la búsqueda de
     * beneficiarios.
     */
    @Override
    public List<BeneficiarioDTO> buscarBeneficiarios(int limit, int pagina) throws NegocioException {
        try {
            this.esNumeroNegativo(limit);
            this.esNumeroNegativo(pagina);

            int offset = this.obtenerOFFSETMySQL(limit, pagina);

            List<BeneficiarioEntidad> listaBeneficiarios = this.beneficiarioDAO.buscarBeneficiarios(limit, offset);

            if (listaBeneficiarios == null || listaBeneficiarios.isEmpty()) {
                throw new NegocioException("No existen beneficiarios registrados");
            }
            return this.convertirBeneficiarioDTO(listaBeneficiarios);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
            throw new NegocioException(e.getMessage());
        }
    }

    /**
     * Método privado para convertir una lista de BeneficiarioEntidad a una
     * lista de BeneficiarioDTO.
     *
     * @param beneficiarios Lista de BeneficiarioEntidad a convertir.
     * @return Lista de BeneficiarioDTO generada.
     * @throws NegocioException Si la lista de beneficiarios es nula.
     */
    private List<BeneficiarioDTO> convertirBeneficiarioDTO(List<BeneficiarioEntidad> beneficiarios) throws NegocioException {
        if (beneficiarios == null) {
            throw new NegocioException("No se pudieron obtener la lista de beneficiarios");
        }
        List<BeneficiarioDTO> beneficiariosDTO = new ArrayList<>();
        for (BeneficiarioEntidad beneficiario : beneficiarios) {
            BeneficiarioDTO dto = new BeneficiarioDTO();
            dto.setId(beneficiario.getId());
            dto.setNombres(beneficiario.getNombres());
            dto.setApellidoPaterno(beneficiario.getApellidoPaterno());
            dto.setApellidoMaterno(beneficiario.getApellidoMaterno());
            dto.setUsuario(beneficiario.getUsuario());
            dto.setContrasena(beneficiario.getContrasena());
            dto.setClaveContrato(beneficiario.getClaveContrato());
            dto.setSaldo(beneficiario.getSaldo());
            beneficiariosDTO.add(dto);
        }
        return beneficiariosDTO;
    }

    private void esNumeroNegativo(int numero) throws NegocioException {
        if (numero < 0) {
            throw new NegocioException("El numero ingresado es negativo bro");
        }
    }

    private int obtenerOFFSETMySQL(int limite, int pagina) throws NegocioException {
        int offset = new Utilidades().RegresarOFFSETMySQL(limite, pagina);
        this.esNumeroNegativo(offset);
        return offset;
    }

    public BeneficiarioEntidad convertirDTOAEntidad(BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioEntidad beneficiarioEntidad = new BeneficiarioEntidad();
        beneficiarioEntidad.setId(beneficiarioDTO.getId());
        beneficiarioEntidad.setApellidoMaterno(beneficiarioDTO.getApellidoMaterno());
        beneficiarioEntidad.setApellidoPaterno(beneficiarioDTO.getApellidoPaterno());
        beneficiarioEntidad.setClaveContrato(beneficiarioDTO.getClaveContrato());
        beneficiarioEntidad.setContrasena(beneficiarioDTO.getContrasena());
        beneficiarioEntidad.setNombres(beneficiarioDTO.getNombres());
        beneficiarioEntidad.setUsuario(beneficiarioDTO.getUsuario());
        return beneficiarioEntidad;
    }

    public BeneficiarioDTO convertirEntidadADTO(BeneficiarioEntidad beneficiarioEntidad) {
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO();
        beneficiarioDTO.setId(beneficiarioEntidad.getId());
        beneficiarioDTO.setApellidoMaterno(beneficiarioEntidad.getApellidoMaterno());
        beneficiarioDTO.setApellidoPaterno(beneficiarioEntidad.getApellidoPaterno());
        beneficiarioDTO.setClaveContrato(beneficiarioEntidad.getClaveContrato());
        beneficiarioDTO.setContrasena(beneficiarioEntidad.getContrasena());
        beneficiarioDTO.setNombres(beneficiarioEntidad.getNombres());
        beneficiarioDTO.setUsuario(beneficiarioEntidad.getUsuario());

        return beneficiarioDTO;
    }

    /**
     * Método para buscar y devolver un BeneficiarioDTO dado su ID.
     *
     * @param idBeneficiario ID del beneficiario a buscar.
     * @return BeneficiarioDTO encontrado.
     * @throws NegocioException Si ocurre un error durante la búsqueda del
     * beneficiario por ID.
     */
    @Override
    public BeneficiarioDTO buscarBeneficiarioPorId(Long idBeneficiario) throws NegocioException {
        try {
            BeneficiarioEntidad beneficiarioEntidad = beneficiarioDAO.buscarBeneficiarioPorId(idBeneficiario);
            return convertirEntidadADTO(beneficiarioEntidad);
        } catch (PersistenciaException ex) {
            System.out.println("Error");
        }
        return null;
    }

    /**
     * Método para realizar el login de un beneficiario utilizando su usuario y
     * contraseña.
     *
     * @param usuario Nombre de usuario del beneficiario.
     * @param contrasena Contraseña del beneficiario.
     * @return BeneficiarioDTO correspondiente al beneficiario que realizó el
     * login.
     * @throws NegocioException Si ocurre un error durante el proceso de login.
     */
    @Override
    public BeneficiarioDTO loginBeneficiario(String usuario, String contrasena) throws NegocioException {

        BeneficiarioDTO benefi = buscarPorUsuario(usuario);
        if (benefi == null) {
            throw new NegocioException("Usuario no encontrado.");
        }
        boolean contraseñaValida = Encriptacion.verificarPasswordConHash(contrasena, benefi.getContrasena());
        if (!contraseñaValida) {
            throw new NegocioException("Credenciales no válidas.");
        }
        return benefi;

    }

    /**
     * Metodo para buscar beneficiario por su usuario.
     *
     * @param usuario El nombre de usuario del beneficiario.
     * @return El beneficairio encontrado.
     * @throws NegocioException
     */
    @Override
    public BeneficiarioDTO buscarPorUsuario(String usuario) throws NegocioException {
        try {
            BeneficiarioEntidad benefi = beneficiarioDAO.buscarPorUsuario(usuario);
            return convertirEntidadADTO(benefi);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar el beneificiario por usuario y contraseña: ");
        }
    }

    private void validarBeneficiario(BeneficiarioDTO beneficiario) throws NegocioException {
        if (beneficiario == null) {
            throw new NegocioException("Beneficiario no puede ser nulo");
        }

        if (beneficiario.getId() == null) {
            throw new NegocioException("Id de beneficiario no puede ser nulo");
        }

        if (beneficiario.getNombres() == null || beneficiario.getNombres().trim().isEmpty()) {
            throw new NegocioException("Nombre de beneficiario no puede ser nulo o vacío");
        }

        if (beneficiario.getApellidoPaterno() == null || beneficiario.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("Apellido de beneficiario no puede ser nulo o vacío");
        }

    }

}
