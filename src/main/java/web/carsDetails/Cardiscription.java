package web.carsDetails;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
public class Cardiscription {
        private List<Car> cars = new ArrayList<>();

        public List<Car> getAllCars() {
            cars.add(new Car("Lada", "White", 434));
            cars.add(new Car("Volkswagen", "Black", 343));
            cars.add(new Car("BMW", "Black", 345));
            cars.add(new Car("Porsch", "Red", 888));
            cars.add(new Car("Dodge", "Blye", 4574));
            return  cars;
        }
}
