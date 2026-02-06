import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage<Car> garage = new Garage<>(10, 10);
    Saab95 saab = new Saab95();

    @Test
    void storeCar() {
        garage.openGarage();
        garage.storeCar(saab);
        assertEquals(saab, garage.storedCars.getFirst());

    }

    @Test
    void removeCar() {
        garage.openGarage();
        garage.storeCar(saab);
        garage.removeCar();
        assertNotEquals(saab, garage.storedCars.getFirst());
    }

    @Test
    void openGarage() {
        garage.openGarage();
        assertTrue(garage.isOpen);
    }

    @Test
    void closeGarage() {
        garage.closeGarage();
        assertFalse(garage.isOpen);
    }
}