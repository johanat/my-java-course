public class PrintRectangle {
    private Rectangle rectangulo;

    PrintRectangle(Rectangle rectangulo){
        this.rectangulo=rectangulo;
    }
    void printArea(){
        System.out.println("The area of rectangle is "+ rectangulo.getArea() );
    }
}
