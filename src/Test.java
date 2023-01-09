import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Producto(111, "blusas", 18.30f));
        inventario.agregarProducto(new Producto(222, "vestidos", 25));
        inventario.agregarProducto(new Producto(333, "baqueros", 35));

        Comprador comprador = new Comprador("Johana", 30);

        System.out.println("Inventario de los productos ");
        System.out.println(inventario);//......................

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIntroduce el id del producto a comprar ");
        int id = scanner.nextInt();
        Producto producto = inventario.buscarProducto(id);

        if (producto != null) {
            System.out.print("\n"+comprador);
            comprador.comprar(inventario, producto);

            System.out.println(producto);
            System.out.println(comprador);

        } else {
            System.out.println("No se ha encontrado el producto en el inventario");
        }
        System.out.println("\nInventario actualizado\n ");
        System.out.println(inventario);
    }
}
