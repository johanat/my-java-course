public class Rectangle {

    private int  lado1, lado2;

    Rectangle(int lado1, int lado2){
        this.lado1=lado1;
        this.lado2= lado2;
    }
    float getArea(){
        float area= lado1*lado2;
        return area;
    }



}
