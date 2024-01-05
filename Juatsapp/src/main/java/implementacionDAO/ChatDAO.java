package implementacionDAO;

import conexionBD.IConexionBD;
import dominio.Chat;
import interfaces.IChatDAO;
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
public class ChatDAO implements IChatDAO {

    private IConexionBD conexionBD;

    public ChatDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Chat createChat(Chat chat) {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            bd.persist(chat);
            bd.getTransaction().commit();
            return chat;
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
    public Chat readChat(Chat chat) {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Chat chatBuscado = bd.find(Chat.class, chat.getIdChat());
            bd.getTransaction().commit();
            return chatBuscado;
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
    public Chat updateChat(Chat chat) {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Chat chatActualizado = bd.find(Chat.class, chat.getIdChat());
            chatActualizado.setMensajes(chat.getMensajes());
            chatActualizado.setMiniatura(chat.getMiniatura());
            chatActualizado.setNombre(chat.getNombre());
            chatActualizado.setUsuarios(chat.getUsuarios());
            bd.merge(chatActualizado);
            bd.getTransaction().commit();
            return chatActualizado;
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
    public void deleteChat(Chat chat) {
        EntityManagerFactory em = conexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                chat = bd.find(Chat.class, chat.getIdChat());
            } catch (EntityNotFoundException enfe) {
            }
            if (chat != null) {
                bd.remove(chat);
            }
            bd.getTransaction().commit();
        } finally {
            if (bd != null) {
                bd.close();
            }
        }
    }

    @Override
    public List<Chat> readAllChat() {
        EntityManagerFactory bdf = conexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Chat> criteria = builder.createQuery(Chat.class);
            Root<Chat> root = criteria.from(Chat.class);
            TypedQuery<Chat> query = bd.createQuery(criteria);
            List<Chat> chats = query.getResultList();
            bd.getTransaction().commit();
            return chats;

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
