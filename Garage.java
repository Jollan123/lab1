import java.util.ArrayList;

public class Garage<CarType extends Car> {
    private ArrayList<CarType> storedCars = new ArrayList<>(5);
    private boolean isOpen;
    private final double x,y;

    public Garage(double x, double y){
        boolean isOpen = false;
        this.x = x;
        this.y = y;
    }

    public void storeCar(CarType Car) {
        if (Car.getDistance(x, y) < 5 && isOpen) {
            storedCars.add(Car);
            Car.x = x;
            Car.y = y;
        }
    }

    public void removeCar(){
        if (isOpen) {
            int unloadedCarIndex = storedCars.size() - 1;
            storedCars.get(unloadedCarIndex).y = y + 5;
            storedCars.removeLast();
        }
    }

    public void openGarage(){ isOpen = true; }
    public void closeGarage(){ isOpen = false; }
}
