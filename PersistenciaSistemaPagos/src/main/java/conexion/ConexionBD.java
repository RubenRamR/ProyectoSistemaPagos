package conexion;

import interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionBD implements IConexionBD {

    /**
     * Crea una conexión con el gestor de persistencia.
     *
     * @return Un objeto EntityManager para interactuar con la base de datos.
     */
    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConexionBD");

        EntityManager entityManager = emFactory.createEntityManager();

        return entityManager;
    }

}
