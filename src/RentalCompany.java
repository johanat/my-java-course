import java.util.ArrayList;


public class RentalCompany {
    private ArrayList<Car> cars = new ArrayList<>();

    RentalCompany() {

        cars.add(new Car("Opel", "Insignia", 2011, true));
        cars.add(new Car("Nissan", "QASHQAI", 2020, true));
        cars.add(new Car("Seat", "Ibiza", 2022, true));
        cars.add(new Car("Audi", "AudiA4", 2019, true));
        cars.add(new Car("Toyota", "Corolla ", 2021, true));
    }

    Car rent() {
        for (Car car : cars) {
            if (car.isAvailable() == true) {
                car.setAvailable(false);
                return car;
            }
        }
        return null;
    }

    void returm(Car car) {
        car.setAvailable(true);
    }


    int getTotalAvailableCar() {
        int counter = 0;

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).isAvailable() == true) {
                counter++;
            }
        }
        return counter;

    }
}


