package ch.hslu.ad.sw08.parking.cars;

import ch.hslu.ad.sw08.parking.CarPark;
import ch.hslu.ad.sw08.parking.CarParkPosition;

import java.util.List;

/**
 * Represents a car with the following behaviour:
 * Drives into every car park. If the parking has no free parking slots, it tries the next car park.
 */
public class CarTryEveryParking extends Car {

    public CarTryEveryParking(List<CarPark> possibleCarParks) {
        super(possibleCarParks);
    }

    @Override
    public synchronized void run() {
        for (CarPark carPark : possibleCarParks) {
            if (carPark.getNumberOfFreeSlots() > 0) {
                CarParkPosition position = carPark.driveIntoParking(this);
                if (position == CarParkPosition.WAITING) {
                    carPark.stopWaitingForParkingSlot(this);
                }
                if (position == CarParkPosition.PARKED) {
                    this.parkRandomDuration(carPark);
                    break;
                }
            }
        }
    }

}
