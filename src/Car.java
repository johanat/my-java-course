public class Car {
    private String make;
    private String modelCar;
    private int yearCar;
    private boolean available;


    Car(String make, String modelCar,int yearCar,boolean available){
            this.make=make;
            this.modelCar=modelCar;
            this.yearCar=yearCar;
            this.available=available;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }
    public String getModelCar() {
        return modelCar;
    }

    public void setYearCar(int yearCar) {
        this.yearCar = yearCar;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public boolean isAvailable() {
        return available;
    }

    void rent(){
       available=false;


    }
    void returm (){
        available=true;

    }

}
