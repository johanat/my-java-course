public class Secretaria implements Empleado{

    public void printName() {
        System.out.println("Soy una secretaria");
    }

    public void printText(String text) {
        System.out.println("El text en secretaria es " + text);
    }

    public void pagar(int paga) {
        System.out.println("Soy la secretaria y me están pagando " + paga);
    }
}
