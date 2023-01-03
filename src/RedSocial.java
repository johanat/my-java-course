import java.util.ArrayList;

public class RedSocial {
    public static void main(String[] args) {

        Usuario johana = new Usuario("Johana", "1234jft.", "Johana Tonguino", 28, "femenino", "johanatonguino@gmail.com");
        Usuario darwin = new Usuario("Darwin", "tubaby..", "Darwin Lucero", 33, "Masculino", "darwinmeco98@gmail.com");
        Usuario fabricio = new Usuario("Fabricio", "bombon34", "Fabricio Cordova", 38, "Masculino", "cordovafaabri@gmail.com");
        Usuario maria = new Usuario("Maria", "6543ltulokita.", "Maria Aucapina", 65, "femenino", "cristtina@hotmail.com");
        Usuario teresa = new Usuario("Teresa", "señoraDivina23", "Teresa Ramos", 18, "femenino", "teresaaca@gmail.com");
        
       // ArrayList<Usuario> listaDeAmigos=new ArrayList<>();

        johana.agregarAmigo(darwin);
        johana.agregarAmigo(teresa);
        johana.agregarAmigo(fabricio);
        johana.agregarAmigo(maria);

        johana.imprimirAmigos();

        johana.eliminarAmigo(fabricio);
        johana.imprimirAmigos();

        teresa.enviarMensaje(johana, "Hola hija mia como estas, no se nada de ti");
    }
}
