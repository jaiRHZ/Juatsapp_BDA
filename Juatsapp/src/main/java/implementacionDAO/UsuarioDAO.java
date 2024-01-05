package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Usuario;
import interfaces.IUsuarioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class UsuarioDAO implements IUsuarioDAO {

    IConexionBD iConexionBD;

    public UsuarioDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();

        try {
            bd.getTransaction().begin();
            bd.persist(usuario);
            bd.getTransaction().commit();
            return usuario;
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Este numero ya ha sido registrado");
            
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
    public Usuario readUsuario(Usuario usuario) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Usuario usuarioEncontrado = bd.find(Usuario.class, usuario.getId());
            bd.getTransaction().commit();
            return usuarioEncontrado;
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
    public Usuario updateUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> readAllUsuario() {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            Root<Usuario> root = criteria.from(Usuario.class);
            TypedQuery<Usuario> query = bd.createQuery(criteria);
            List<Usuario> pagos = query.getResultList();
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
