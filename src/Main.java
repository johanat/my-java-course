
public class Main {
    public static void main(String[] args) {
    Circle myCircle= new Circle(3);
    Rectangle myRectangle = new Rectangle(2,4);
    Square mySquare= new Square(2);

    PrintCircle printCircle = new PrintCircle(myCircle);
    PrintRectangle printRectangle = new PrintRectangle(myRectangle);
    PrintSquare printSquare = new PrintSquare(mySquare);

    printCircle.printArea();
    printRectangle.printArea();
    printSquare.printArea();

    }
}



