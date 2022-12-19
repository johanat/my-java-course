
public class Main {

    static String msg = "Operación terminada";

    public static void main(String[] args) {

        System.out.println("Iniciando subida...");

        Uploader uploader = new Uploader();
        uploader.upload(new Listener() {
            @Override
            public void yaEsta() {
                System.out.println("Desde Main: " + msg);
            }
        });
    }
}






