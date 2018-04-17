package ch.hslu.ad.sw08.parking.cars;

import ch.hslu.ad.sw08.parking.CarPark;
import ch.hslu.ad.sw08.parking.CarParkPosition;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a car with the following behaviour:
 * Drive into the car park with the most free parking slots. If no car park has free slots, it leaves without parking.
 */
public class CarOnlyFreeParking extends Car {

    public CarOnlyFreeParking(List<CarPark> possibleCarParks) {
        super(possibleCarParks);
    }

    @Override
    public synchronized void run() {
        CarPark carParkWithMostFreeParkings = possibleCarParks.stream()
                .filter(carPark -> carPark.getNumberOfFreeSlots() > 0)
                .sorted(Comparator.comparingInt(CarPark::getNumberOfFreeSlots))
                .findFirst()
                .orElse(null);
        if (carParkWithMostFreeParkings != null) {
            carParkWithMostFreeParkings.driveIntoParking(this);
            this.parkRandomDuration(carParkWithMostFreeParkings);
        }
    }

}
