package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "generoUsuario", nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroUsuario genero;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idImagen", nullable = true)
    private Imagen perfil;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "contrasenya", nullable = false)
    private String contrasenya;

    //Relaciones
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Mensaje> mensajes;

    @ManyToMany(mappedBy = "usuarios")
    private List<Chat> chats;

    public Usuario() {
    }

    public Usuario(int id, String telefono, GeneroUsuario genero, Imagen perfil,
            Calendar fechaNacimiento, String contrasenya, Domicilio domicilio, List<Mensaje> mensajes, List<Chat> chats) {
        this.id = id;
        this.telefono = telefono;
        this.genero = genero;
        this.perfil = perfil;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenya = contrasenya;
        this.domicilio = domicilio;
        this.mensajes = mensajes;
        this.chats = chats;
    }

    public Usuario(String telefono, GeneroUsuario genero, Imagen perfil, Calendar fechaNacimiento, String contrasenya, Domicilio domicilio, List<Mensaje> mensajes, List<Chat> chats) {
        this.telefono = telefono;
        this.genero = genero;
        this.perfil = perfil;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenya = contrasenya;
        this.domicilio = domicilio;
        this.mensajes = mensajes;
        this.chats = chats;
    }

    public Usuario(String telefono, GeneroUsuario genero, Imagen perfil, Calendar fechaNacimiento, String contrasenya, Domicilio domicilio) {
        this.telefono = telefono;
        this.genero = genero;
        this.perfil = perfil;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenya = contrasenya;
        this.domicilio = domicilio;
    }

    //---Getter & Setter---
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public GeneroUsuario getGenero() {
        return genero;
    }

    public void setGenero(GeneroUsuario genero) {
        this.genero = genero;
    }

    public Imagen getPerfil() {
        return perfil;
    }

    public void setPerfil(Imagen perfil) {
        this.perfil = perfil;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", telefono=" + telefono + ", genero=" + genero + ", perfil=" + perfil + ", fechaNacimiento=" + fechaNacimiento + ", contrasenya=" + contrasenya + ", domicilio=" + domicilio + ", mensajes=" + mensajes + ", chats=" + chats + '}';
    }

}
