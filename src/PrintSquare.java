public class PrintSquare {
     private Square cuadrado;
    PrintSquare(Square cuadrado){
        this.cuadrado=cuadrado;
    }
    void printArea(){

        System.out.println("The area of square is "+ cuadrado.getArea() );
    }

}
