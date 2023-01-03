import java.util.ArrayList;

public class Usuario {
    String nombreUsuario;
    String contrasena;
    String nombreCompleto;
    int edad;
    String genero;
    String correoElectronico;


    ArrayList<Usuario> listaDeAmigos = new ArrayList<>();


    Usuario(String nombreUsuario, String contrasena, String nombreCompleto, int edad, String genero, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.genero = genero;
        this.correoElectronico = correoElectronico;

    };

    void agregarAmigo(Usuario usuario) {

        listaDeAmigos.add(usuario);


    }

    void eliminarAmigo(Usuario usuario) {
        listaDeAmigos.remove(usuario);


    }

    void enviarMensaje(Usuario usuario, String mensaje) {
        System.out.println("mensaje.....");
        System.out.println(nombreUsuario + " ha enviado un mensaje:" + " a " + usuario + " 2:30pm" + "\n" + mensaje);
    }

    void imprimirAmigos() {
        System.out.println(listaDeAmigos);

    }

    @Override
    public String toString() {
        return nombreUsuario;
    }
}


