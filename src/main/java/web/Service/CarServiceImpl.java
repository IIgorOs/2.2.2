package web.service;


import org.springframework.stereotype.Component;
import web.model.Car;
import web.Service.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    public List<Car> cars;

    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "Red"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Opel", "Red"));
        cars.add(new Car("Mercedes","Silver"));
        cars.add(new Car("Lada","Yellow"));
        if (count >= 5) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}