package dominio;

import dominio.Chat;
import dominio.Domicilio;
import dominio.GeneroUsuario;
import dominio.Imagen;
import dominio.Mensaje;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-01-05T03:53:18")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Domicilio> domicilio;
    public static volatile SingularAttribute<Usuario, Calendar> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, GeneroUsuario> genero;
    public static volatile ListAttribute<Usuario, Mensaje> mensajes;
    public static volatile ListAttribute<Usuario, Chat> chats;
    public static volatile SingularAttribute<Usuario, String> contrasenya;
    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, Imagen> perfil;

}