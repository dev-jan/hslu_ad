package ch.hslu.ad.sw08.parking;

import ch.hslu.ad.sw08.parking.cars.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Represents a simulation of multiple car parks.
 */
public class CarParkSimulator {
    private static final Logger LOG = LogManager.getLogger(CarParkSimulator.class);
    private int durationInSeconds = 0;
    private int numberOfCars = 0;
    private List<CarPark> carParks = Collections.synchronizedList(new ArrayList<>());
    private List<Car> carsInSimulation = Collections.synchronizedList(new ArrayList<>());

    /**
     * Run the simulation. The Simulator object must be first initialized with valid parameters of the simulations,
     * otherwise the default values are taken.
     */
    public void runSimulation() {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCars);

        for(int i = 0; i < numberOfCars;i++) {
            executorService.execute(() -> {
                Car car = Car.createRandomCar(carParks);
                carsInSimulation.add(car);
                car.run();
            });
        }


        try {
            Thread.sleep(durationInSeconds * 1000);
            executorService.shutdownNow();

            executorService.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOG.error("Simulation interrupted!");
        }

        LOG.info("===== Statistics =====");
        LOG.info("Total cars: " + carsInSimulation.size());
        LOG.info("Successful cars: " + carsInSimulation.stream().filter(c -> c.wasParkingSuccessful()).count());
    }

    /**
     * Set the duration of the simulation to a given value.
     * @param duration the duration of the simulation in seconds
     * @return the simulator
     */
    public CarParkSimulator withDurationInSeconds(int duration) {
        this.durationInSeconds = duration;
        return this;
    }

    /**
     * Set the number of cars, that are driving in the simulation.
     * @param numberOfCars the number of cars in the simulation
     * @return the simulator
     */
    public CarParkSimulator withNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
        return this;
    }

    /**
     * Add a given car park to the simulation.
     * @param carPark the car park to add
     * @return
     */
    public CarParkSimulator withCarPark(CarPark carPark) {
        this.carParks.add(carPark);
        return this;
    }

    /**
     * Returns all car objects that where active in the simulation.
     * @return
     */
    public List<Car> getCarsInSimulation() {
        return this.carsInSimulation;
    }
}
