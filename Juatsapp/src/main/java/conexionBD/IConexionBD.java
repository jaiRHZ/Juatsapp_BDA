
package conexionBD;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IConexionBD {
    
    EntityManagerFactory useConnectionMySQL();
    
}
