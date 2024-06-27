/*
 * Esta interfaz define el contrato para la creación de conexiones a la base de datos utilizando EntityManager.
 */
package interfaces;

import javax.persistence.EntityManager;

/**
 * Interfaz que define el contrato para la creación de conexiones a la base de
 * datos utilizando EntityManager.
 *
 * Proporciona un método para crear y obtener una instancia de EntityManager.
 *
 * Este contrato permite la implementación de diferentes estrategias para la
 * gestión de conexiones a la base de datos.
 *
 * @author Chris
 */
public interface IConexionBD {

    /**
     * Crea y devuelve una instancia de EntityManager para la conexión a la base
     * de datos.
     *
     * @return EntityManager para la conexión a la base de datos.
     */
    public EntityManager crearConexion();

}
