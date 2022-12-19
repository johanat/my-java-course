public class Empresa {
    int sueldoDeJefe = 100;
    int sueldoDeSecretaria = 80;
    int sueldoDePeon = 40;

    void pagarSueldoAEmpleado(Empleado empleado) {
        if (empleado instanceof Jefe) {
            empleado.pagar(sueldoDeJefe);
        } else if (empleado instanceof Peon) {
            empleado.pagar(sueldoDePeon);
        } else {
            empleado.pagar(sueldoDeSecretaria);
        }
    }
}
