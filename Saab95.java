import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        turningForce = 1;
        stopEngine();
    }


    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    public boolean getTurbo() { return turboOn; }
    
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1) return;

        incrementSpeed(amount);

        if (getCurrentSpeed() > enginePower) {
            currentSpeed = enginePower;
        }
    }

    public void brake(double amount){
        if (amount < 0 || amount > 1) return;

        decrementSpeed(amount);

        if (currentSpeed < 0) currentSpeed = 0;
    }
}
