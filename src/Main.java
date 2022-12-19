
public class Main {

    public static void main(String[] args) {

    Peon peon = new Peon();
    Jefe jefe = new Jefe();
    Secretaria secretaria = new Secretaria();

    peon.printName();
    peon.printText("peoncito");

    jefe.printName();
    jefe.printText("jefecito");

    Empresa empresa = new Empresa();

    empresa.pagarSueldoAEmpleado(jefe);
    empresa.pagarSueldoAEmpleado(peon);
    empresa.pagarSueldoAEmpleado(secretaria);

    }
}



