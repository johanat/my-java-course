public class PrintCircle {
   private Circle circulo; // 1 la variable se crea para utilizar globalmente

    PrintCircle(Circle circulo){
        this.circulo=circulo; // 2 al instanciar una clas el primer metodo que se llama es el contructor y lo que me pasan debo guadar en la variable que he creado para hacer uso de lla en otros metodos

    }

    void printArea(){

        System.out.println("The area of Cicle is "+ circulo.getArea() );
    }


}
