public class Circle {

    private int radio;

    Circle(int radio) {
        this.radio = radio;
    }

    float getArea() {
        float area = (float) Math.PI * (float) Math.pow(radio, 2);
        return area;

    }

}
