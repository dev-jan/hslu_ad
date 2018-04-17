package ch.hslu.ad.sw08.parking.cars;

import ch.hslu.ad.sw08.parking.CarPark;
import ch.hslu.ad.sw08.parking.CarParkPosition;

import java.util.List;

/**
 * Represents a car with the following behaviour:
 * Drive into the first car park and wait until a parking slot gets free.
 */
public class CarFirstParking extends Car {

    public CarFirstParking(List<CarPark> possibleCarParks) {
        super(possibleCarParks);
    }

    @Override
    public synchronized void run() {
        CarPark carPark = possibleCarParks.get(0);
        CarParkPosition position = carPark.driveIntoParking(this);
        if (position == CarParkPosition.PARKED) {
            this.parkRandomDuration(carPark);
        }
        if (position == CarParkPosition.WAITING) {
            while (carPark.getPositionOfCar(this) != CarParkPosition.WAITING) {
                try {
                    LOG.warn(Thread.currentThread().getName() + " is waiting for parking slot...");
                    this.wait();
                } catch (InterruptedException e) {
                    LOG.info("Waiting for parking slot interrupted");
                }
            }
            this.parkRandomDuration(carPark);
        }
    }

}
