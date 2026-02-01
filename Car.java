import java.awt.*;
//import java.lang.Math.*;

//Gör volvo tester och fixa gas and brake

public abstract class Car implements Movable{

    @Override
    public void move() {
        y += Math.sin(getDirection()) * currentSpeed;
        x += Math.cos(getDirection()) * currentSpeed;
    }

    @Override
    public void turn_left() { direction -= 0.15; }

    @Override
    public void turn_right() { direction += 0.15; }

    private double direction = 0;
    protected double getDirection() {
        direction %= Math.PI * 2;
        if (direction < 0) direction += Math.PI * 2;
        return direction;
    }

    private double x, y;

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

    protected abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount){
        if(amount < 0 || amount > 1) return;
        incrementSpeed(amount);
    }

    public void brake(double amount){
        if(amount < 0 || amount > 1) return;
        decrementSpeed(amount);
    }

}
