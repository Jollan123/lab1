import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test extends Car {
    Saab95 Saab = new Saab95();

    @Test
    void setTurboOn() {
        Saab.setTurboOn();
        assertTrue(Saab.getTurbo());
    }

    @Test
    void setTurboOff() {
        Saab.setTurboOff();
        assertFalse(Saab.getTurbo());
    }

    @Test
    void incrementSpeed() {
        assertEqu
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }
}