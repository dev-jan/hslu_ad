package ch.hslu.sw08;

import ch.hslu.ad.sw08.parking.CarPark;
import ch.hslu.ad.sw08.parking.CarParkSimulator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarParkSimulatorTest {
    @Test
    public void test_runSimulation_fewCars() {
        // arrange
        int numberOfCars = 300;
        CarParkSimulator carParkSimulator = new CarParkSimulator();
        carParkSimulator.withDurationInSeconds(5)
                .withNumberOfCars(numberOfCars)
                .withCarPark(new CarPark(200, "Parking 1 (Autobahn)"))
                .withCarPark(new CarPark(100, "Parking 2 (Center)"))
                .withCarPark(new CarPark(100, "Parking 3 (Beach)"));

        // act
        carParkSimulator.runSimulation();

        // assert
        assertThat(carParkSimulator.getCarsInSimulation().size()).isEqualTo(numberOfCars);
    }

    @Test
    public void test_runSimulation_manyCars() {
        // arrange
        int numberOfCars = 2000;
        CarParkSimulator carParkSimulator = new CarParkSimulator();
        carParkSimulator.withDurationInSeconds(5)
                .withNumberOfCars(numberOfCars)
                .withCarPark(new CarPark(200, "Parking 1 (Autobahn)"))
                .withCarPark(new CarPark(100, "Parking 2 (Center)"))
                .withCarPark(new CarPark(100, "Parking 3 (Beach)"));

        // act
        carParkSimulator.runSimulation();

        // assert
        assertThat(carParkSimulator.getCarsInSimulation().size()).isEqualTo(numberOfCars);
    }

}
