package ch.hslu.ad.sw08.parking.cars;

import ch.hslu.ad.sw06.RandomHelper;
import ch.hslu.ad.sw08.parking.CarPark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Represents a car that can drive into a @{@link CarPark}. A car must be instantiated by one of the subclasses of
 * {@link Car}.
 */
public abstract class Car {
    protected static final Logger LOG = LogManager.getLogger(Car.class);
    private static final int NUMBER_OF_SUBCLASSES = 4;
    private static final int MIN_PARKING_DURATION = 10;
    private static final int MAX_PARKING_DURATION = 100;
    protected List<CarPark> possibleCarParks;
    private boolean parkingSuccessful = false;

    /**
     * Create a random car with the type of any subclass of car. The type of the car is random.
     * @param possibleCarParks The carParks that the car can drive into
     * @return a random car
     */
    public static Car createRandomCar(List<CarPark> possibleCarParks) {
        int random = RandomHelper.nextRandom(1, NUMBER_OF_SUBCLASSES);
        switch(random) {
            case 1: return new CarFirstParking(possibleCarParks);
            case 2: return new CarTryEveryParking(possibleCarParks);
            case 3: return new CarOnlyFreeParking(possibleCarParks);
            case 4: return new CarTryEveryParkingAndWait(possibleCarParks);
            default: return new CarFirstParking(possibleCarParks);
        }
    }

    /**
     * Create a new car with given possible car parks
     * @param possibleCarParks car parks that the car can drive into
     */
    public Car(List<CarPark> possibleCarParks) {
        this.possibleCarParks = possibleCarParks;
    }

    /**
     * Do whatever the car wants to do :)
     */
    public abstract void run();


    private int getRandomParkingDuration() {
        return RandomHelper.nextRandom(MIN_PARKING_DURATION, MAX_PARKING_DURATION);
    }

    /**
     * Wait a random time in the parking slot and drive away after.
     * @param carPark the car park the car is parked
     */
    protected void parkRandomDuration(CarPark carPark) {
        LOG.info(this.toString() + ": Parked in " + carPark.getParkingName());
        try {
            int duration = this.getRandomParkingDuration();
            Thread.sleep(duration);
            this.setParkingSuccessful(true);
            LOG.info(Thread.currentThread().getName() + ": Leaved parking with duration " + duration + " minutes");
            carPark.driveOutOfParking(this);
        } catch (InterruptedException e) {
            LOG.warn("Parking interrupted!");
        }
    }

    protected void setParkingSuccessful(boolean success) {
        this.parkingSuccessful = success;
    }

    public boolean wasParkingSuccessful() {
        return this.parkingSuccessful;
    }

}
