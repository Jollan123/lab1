import java.awt.*;

public abstract class Car implements Movable{

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

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }
}
