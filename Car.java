import java.awt.*;

public abstract class Car implements Movable{
    //Abstract - går ej att göra objekt av car

    //Hjälper till för att se att vi verkligen override:ar
    @Override
    public void move() {
        y += Math.sin(getDirection()) * currentSpeed;
        x += Math.cos(getDirection()) * currentSpeed;
    }

    @Override
    public void turn_left() { direction -= (currentSpeed % 1) * turningForce; }

    @Override
    public void turn_right() {
        direction += (currentSpeed % 1) * turningForce;
    }

    private double direction = 0;
    protected double getDirection() {
        direction %= Math.PI * 2;
        if (direction < 0) direction += Math.PI * 2;
        return direction;
    }
    //Utomstående ska inte kunna ändra positionen men alla nya bilar som skapas behöver använda och uppdatera positionen
    protected double x, y;

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double turningForce;

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
}