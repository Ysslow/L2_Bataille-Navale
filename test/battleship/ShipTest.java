package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipTest {
    @Test
    public void initiliizationIsOk() {
        Ship ship = new Ship(3);
        assertEquals(3, ship.getLifePoints());
    }

    @Test
    public void isItReallySunk() {
        Ship ship = new Ship(3);
        ship.beenHitting();
        ship.beenHitting();
        ship.beenHitting();
        assertEquals(true, ship.hasBeenSunk());
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(battleship.ShipTest.class);
    }
}