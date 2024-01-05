/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package mx.itson.juatsapp;

import dominio.Domicilio;
import dominio.GeneroUsuario;
import dominio.Imagen;
import dominio.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class Juatsapp {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistencia");

        EntityManager bd = factory.createEntityManager();

        bd.getTransaction().begin();

        GeneroUsuario generoUsuario = GeneroUsuario.MASCULINO;  // Ejemplo, debes asignar el valor correspondiente
        Imagen imagenPerfil = null;
        Domicilio domicilio = new Domicilio("calle", "1234", "asd", "123456");  // Debes proporcionar los parámetros correctos

// Obtén la fecha de nacimiento utilizando el Calendar
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(Calendar.YEAR, 1990);  // Ajusta el año según sea necesario
        fechaNacimiento.set(Calendar.MONTH, Calendar.JANUARY);  // Ajusta el mes según sea necesario
        fechaNacimiento.set(Calendar.DAY_OF_MONTH, 1);  // Ajusta el día según sea necesario

// Supongamos que ya tienes el teléfono y la contraseña
        String telefono = "123456789";
        String contrasenya = "miContrasenyaSegura";

// Crea el objeto Usuario utilizando el constructor
        Usuario usuario = new Usuario(telefono, generoUsuario, imagenPerfil, fechaNacimiento, contrasenya, domicilio);
        bd.persist(usuario);
        bd.getTransaction().commit();
    }
}
