public class User {
    int id;
    String name;
    String surname;
    String DNI;
    String direction;

    User(String name, String surname, String DNI, String direction) {
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public String toString() {
        return name + "  (Dni) " + DNI;
    }

    public String toString2() {
        return "<html> " + " Name: " + name + "<br/>" + " Surname: " + surname + "<br/>" + " DNI: " + DNI + "<br/>" + "Direction: " + direction + "<br/>" + "____________________" + "<br/>";
    }

}
