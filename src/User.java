public class User {
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

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return  "<html> "+" Name: "+name+"<br/>"+" Surname: "+surname+ "<br/>"+ " DNI: "+DNI+ "<br/>"+"Direction: "+direction+"<br/>"+"____________________"+"<br/>";
    }
}
