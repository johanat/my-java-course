public class Jefe implements Empleado{

    public void printName() {
        System.out.println("Soy un empleado");
    }

    public void printText(String text) {
        System.out.println("El texto que me pasan es " + text);
    }

    public void pagar(int paga) {
        System.out.println("Soy el jefe y me están pagando " + paga);
    }
}
