package pl.edu.wszib;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.edu.wszib.configuration.AppConfiguration;
import pl.edu.wszib.model.Car;
import pl.edu.wszib.services.ICarService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        ICarService carService = context.getBean(ICarService.class);

        Car car = new Car(20, "Audi", "A6", 1999);

        carService.saveCar(car);

        //Car car = new Car(20, "Audi", "A4", 1999);


        //CarServiceImpl.saveCar(car);
        //CarRepository.persistCar(car);

        /*Car car2 = CarRepository.getCarById(1);
        car2.setModel("6");
        CarRepository.persistCar(car2);
        Car updatedCarFromDb = CarRepository.getCarById(1);
        System.out.println(updatedCarFromDb);*/
        /*System.out.println(car2);

        List<Car> bmwCars = CarRepository.getAllBMWCars();
        System.out.println("LISTA:");
        for(Car tempCar : bmwCars) {
            System.out.println(tempCar);
        }*/
    }
}
