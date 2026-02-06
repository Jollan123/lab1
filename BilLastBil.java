import java.awt.*;
import java.util.ArrayList;

public class BilLastBil extends Truck{

    private ArrayList<PassengerCar> loadedCars = new ArrayList<>(8);
    private boolean isRampUp;


    public BilLastBil() {
            nrDoors = 2;
            color = Color.blue;
            enginePower = 250;
            modelName = "BMW";
            turningForce = 1;
            stopEngine();
            isRampUp = false;
        }

    public void raiseRamp() {
    if (!isRampUp) isRampUp = true;
    }

    public void lowerRamp() {
    if (isRampUp) isRampUp = false;
    }

    public void loadCar(PassengerCar Car){
        if (getDistance(Car.x, Car.y) < 5) {
            loadedCars.add(Car);
            Car.x = x;
            Car.y = y;
        }
    }

    public void removeCar(){
        int unloadedCarIndex = loadedCars.size() - 1;
        loadedCars.get(unloadedCarIndex).y = y + 5;
        loadedCars.removeLast();
    }

    @Override
    public void brake(double amount) {
        super.brake(amount);
        if (currentSpeed == 0) lowerRamp();
    }

    @Override
    public void gas(double amount) {
        super.gas(amount);
        raiseRamp();
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
}


