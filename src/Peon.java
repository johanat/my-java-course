public class Peon implements Empleado{

    public void printName() {
        System.out.println("Yo soy un peón");
    }

    public void printText(String text) {
        System.out.println("El texto en peon es " + text);
    }

    public void pagar(int paga) {
        System.out.println("Soy el peon y me están pagando " + paga);
    }
}
