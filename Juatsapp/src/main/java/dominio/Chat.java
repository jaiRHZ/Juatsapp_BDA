package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "chat")
public class Chat {
    
    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    
    
    private Imagen miniatura;

    //Relaciones
    @ManyToMany()
    @JoinTable(name = "usuario_chat",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_chat"))
    private List<Usuario> usuarios;
    
    @OneToMany(mappedBy = "chat")
    private List<Mensaje> mensajes;

    
    //--Constructores--
    public Chat() {
    }

    public Chat(Long idChat, String nombre, Imagen miniatura, List<Usuario> usuarios, List<Mensaje> mensajes) {
        this.idChat = idChat;
        this.nombre = nombre;
        this.miniatura = miniatura;
        this.usuarios = usuarios;
        this.mensajes = mensajes;
    }

    public Chat(String nombre, Imagen miniatura, List<Usuario> usuarios, List<Mensaje> mensajes) {
        this.nombre = nombre;
        this.miniatura = miniatura;
        this.usuarios = usuarios;
        this.mensajes = mensajes;
    }

    public Chat(String nombre, Imagen miniatura) {
        this.nombre = nombre;
        this.miniatura = miniatura;
    }

    //Getter & setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Imagen getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(Imagen miniatura) {
        this.miniatura = miniatura;
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idChat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chat other = (Chat) obj;
        return Objects.equals(this.idChat, other.idChat);
    }

    @Override
    public String toString() {
        return "Chat{" + "idChat=" + idChat + ", nombre=" + nombre + ", miniatura=" + miniatura + ", usuarios=" + usuarios + ", mensajes=" + mensajes + '}';
    }

    
    
}
