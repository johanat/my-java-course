
public class Main {
    public static void main(String[] args) {
        Car cocheRent;
        Car cocheRent2;

        RentalCompany rentalCompany = new RentalCompany();

        cocheRent=rentalCompany.rent();
        cocheRent2=rentalCompany.rent();

        System.out.println("I have rented a car " + cocheRent.getModelCar() + " cars disponibles = "+rentalCompany.getTotalAvailableCar() );

        rentalCompany.returm(cocheRent);
        rentalCompany.returm(cocheRent2);
        System.out.println("I have "+ rentalCompany.getTotalAvailableCar()+ " disponible");

    }
}


