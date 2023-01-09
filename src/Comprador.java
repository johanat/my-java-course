public class Comprador {
    private String nombre;
    private float dinero;

    Comprador(String nombre, float dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }
    void comprar(Inventario inventario, Producto producto) {

        if (dinero >= producto.getPrecio()) {
            float loQueMeQueda = dinero;
            loQueMeQueda = loQueMeQueda - producto.getPrecio();
            dinero = loQueMeQueda;
            inventario.eliminarProducto(producto);
        } else {
            System.out.println(" \n ****** No tienes suficiente dinero ******");
        }
    }

    @Override
    public String toString() {
        return " Nombre: " + nombre + " Dinero: " + dinero;
    }
}


