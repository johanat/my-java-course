

public class Producto {
    private int id;
    private String nombre;
    private float precio;

    Producto(int id, String nombre, float precio) {
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;

    }

    public double getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "\nId: "+id+" Nombre: "+nombre+" Precio "+precio;
    }
}
