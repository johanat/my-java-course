public class Fragrance {
    private String name;
    private String mark;
    private double price;
    private int cant;

    Fragrance(String name, String mark, double price, int cant) {
        this.name = name;
        this.mark = mark;
        this.price = price;
        this.cant = cant;
    };

    void addStock(int cantidad) {
        cant = cantidad + cant;
    }

    void sell(int cantidad) {
        cant = cant - cantidad;
    }

    void changePrice(double valor) {
        price = valor;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Mark: "+ mark +" Price: "+ price+ " Cant: "+cant;
    }
}


