import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilLastBilTest {
    BilLastBil Lastbil = new BilLastBil();
    Saab95 saab = new Saab95();


    @Test
    void raiseRamp(){
        Lastbil.raiseRamp();
        assertTrue(Lastbil.isRampUp);
    }

    @Test
    void lowerRamp() {
        Lastbil.lowerRamp();
        assertFalse(Lastbil.isRampUp);
    }

    @Test
    void loadCar() {
        Lastbil.loadCar(saab);
        assertEquals(saab,Lastbil.loadedCars.get(0));
    }

    @Test
    void removeCar() {
        Lastbil.loadCar(saab);
        Lastbil.removeCar();

        assertTrue(Lastbil.getLoadedCars().isEmpty());

    }

    @Test
    void gas() {
        double[] amounts = {1, -1, 10, 0.5};
        double orgSpeed = Lastbil.getCurrentSpeed();
        for (double i : amounts) {
            Lastbil.gas(i);
            assertTrue((Lastbil.getCurrentSpeed() > orgSpeed));
            assertTrue((Lastbil.getCurrentSpeed() < Lastbil.getEnginePower() || Lastbil.getCurrentSpeed() > 0));
        }

    }

    @Test
    void brake() {
        double[] amounts = {1, -1, 10, 0.5};
        double orgSpeed = Lastbil.getCurrentSpeed();
        for (double i : amounts) {
            Lastbil.brake(i);
            assertFalse((Lastbil.getCurrentSpeed() > orgSpeed));
            assertTrue((Lastbil.getCurrentSpeed() < Lastbil.getEnginePower() || Lastbil.getCurrentSpeed() > 0));
        }
    }

}