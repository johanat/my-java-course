import java.util.ArrayList;

public class Inventario {
     ArrayList<Producto> productos = new ArrayList<>();

    void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    Producto buscarProducto(double id) {
        for (int i = 0; i < productos.size(); i++) {
            if (id == productos.get(i).getId()) {
                return productos.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return productos.toString();
    }
}
