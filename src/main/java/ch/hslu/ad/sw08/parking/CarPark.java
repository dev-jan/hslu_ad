package ch.hslu.ad.sw08.parking;

import ch.hslu.ad.sw08.parking.cars.Car;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Represents a car park, @{@link Car} can park in it.
 */
public class CarPark {
    private String name = "";
    private int capacity = 0;
    private List<Car> parkingSlots;
    private LinkedBlockingQueue<Car> waitingCars = new LinkedBlockingQueue<>();

    /**
     * Create a new car park with a given capacity and name
     * @param capacity the capacity of the car park
     * @param name the name of the car park
     */
    public CarPark(int capacity, String name) {
        this.capacity = capacity;
        this.parkingSlots = Collections.synchronizedList(new ArrayList<>(capacity));
        this.name = name;
    }

    /**
     * Return the number of free parking slots in the car park
     * @return the number of free slots, 0 if there are no free slots
     */
    public int getNumberOfFreeSlots() {
        return capacity - parkingSlots.size();
    }

    /**
     * Drive the given car into the parking. If there are no free parking slots, the car stay in a waiting queue.
     * @param car the car that enters the car park
     * @return the position of the car.
     */
    public synchronized CarParkPosition driveIntoParking(Car car) {
        int freeSlots = getNumberOfFreeSlots();
        if (freeSlots > 0) {
            this.parkingSlots.add(car);
            return CarParkPosition.PARKED;
        }
        else {
            this.waitingCars.add(car);
            return CarParkPosition.WAITING;
        }
    }

    /**
     * The given car will stop waiting for a parking slot and will be removed from the waiting queue.
     * @param car the car that will be removed from the waiting queue
     */
    public synchronized void stopWaitingForParkingSlot(Car car) {
        this.waitingCars.remove(car);
    }

    /**
     * The given car will drive out of the parking. The parking slot will be free after it drives out.
     * @param car the car that drive out
     */
    public synchronized void driveOutOfParking(Car car) {
        boolean carRemoved = this.parkingSlots.remove(car);
        if (capacity <= 0 && waitingCars.size() > 0 && carRemoved) {
            Car waitingCar = waitingCars.poll();
            this.parkingSlots.add(waitingCar);
            waitingCar.notifyAll();
        }
    }

    /**
     * Check if the given car is in the car park, in the waiting queue or not in the car park
     * @param car the car to check
     * @return the position of the given car
     */
    public CarParkPosition getPositionOfCar(Car car) {
        if (this.parkingSlots.contains(car)) {
            return CarParkPosition.PARKED;
        }
        if (this.waitingCars.contains(car)) {
            return CarParkPosition.WAITING;
        }
        return CarParkPosition.NOT_PARKED;
    }

    public String getParkingName() {
        return this.name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("capacity", capacity)
                .append("parkingSlots", parkingSlots)
                .append("waitingCars", waitingCars)
                .toString();
    }
}
