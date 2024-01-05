
package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Mensaje;
import interfaces.IMensajeDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class MensajeDAO implements IMensajeDAO{

    IConexionBD iConexionBD;

    public MensajeDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }
    
    @Override
    public Mensaje createMensaje(Mensaje mensaje) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(mensaje);
            bd.getTransaction().commit();
            return mensaje;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    
    
    }

    @Override
    public Mensaje readMensaje(Mensaje mensaje) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Mensaje mensajeEncontrado = bd.find(Mensaje.class, mensaje.getId());
            bd.getTransaction().commit();
            return mensajeEncontrado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public Mensaje updateMensaje(Mensaje mensaje) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            Mensaje mensajeActualizado = bd.find(Mensaje.class, mensaje.getId());
            mensajeActualizado.setTexto(mensaje.getTexto());
            mensajeActualizado.setFechaHoraRegistro(mensaje.getFechaHoraRegistro());
            mensajeActualizado.setUsuario(mensaje.getUsuario());
            mensajeActualizado.setImagen(mensaje.getImagen());
            
            bd.merge(mensajeActualizado);
            bd.getTransaction().commit();
            return mensajeActualizado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public void deleteMensaje(Mensaje mensaje) {
        EntityManagerFactory em = iConexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                mensaje = bd.find(Mensaje.class, mensaje.getId());
            } catch (EntityNotFoundException enfe) {
            }
            if (mensaje != null) {
                bd.remove(mensaje);
            }
            //comentario = em.merge(comentario);
            bd.getTransaction().commit();
        } finally {
            if (bd != null) {
                bd.close();
            }
        }
    
    }

    @Override
    public List<Mensaje> readAllMensaje() {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Mensaje> criteria = builder.createQuery(Mensaje.class);
            Root<Mensaje> root = criteria.from(Mensaje.class);
            TypedQuery<Mensaje> query = bd.createQuery(criteria);
            List<Mensaje> pagos = query.getResultList();
            bd.getTransaction().commit();
            return pagos;

        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    
    }
    
}
