import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage<Car> garage = new Garage<>(2, 2);
    Saab95 saab = new Saab95();


    @Test
    void storeCar() {
        // IMPORTANT: place the car close enough
        saab.x = 8;
        saab.y = 8;

        garage.openGarage();
        garage.storeCar(saab);

        assertEquals(1, garage.getStoredCars().size());
        assertSame(saab, garage.getStoredCars().get(0));
    }

    @Test
    void removeCar() {
        garage.openGarage();

        garage.storeCar(saab);
        garage.removeCar();

        assertTrue(garage.getStoredCars().isEmpty());
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