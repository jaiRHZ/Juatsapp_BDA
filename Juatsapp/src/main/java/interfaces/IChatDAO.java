
package interfaces;

import dominio.Chat;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IChatDAO {
    
    public Chat createChat(Chat chat);
    
    public Chat readChat(Chat chat);
    
    public Chat updateChat(Chat chat);
    
    public void deleteChat(Chat chat);
    
    public List<Chat> readAllChat();
}
