package battleship;


import static org.junit.Assert.assertEquals;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import battleship.util.Position;

public class GameTest {
    @Test
    public void WellAddedShipVertically() throws IllegalStateException{
        Sea sea = new Sea(5, 10);
        Ship ship = new Ship(3);
        Position pos = new Position(1, 6);
        Game game = new Game(sea);
        game.addShipVertically(ship, pos);
    }

    @Test(expected = IllegalStateException.class)
    public void BadAddedShipVertically() throws IllegalStateException{
        Sea sea = new Sea(5, 10);
        Ship ship = new Ship(3);
        Position pos = new Position(4, 7);
        Game game = new Game(sea);
        game.addShipVertically(ship, pos);
    }

    @Test
    public void WellAddedShipHorizontally() throws IllegalStateException{
        Sea sea = new Sea(5, 10);
        Ship ship = new Ship(3);
        Position pos = new Position(1, 5);
        Game game = new Game(sea);
        game.addShipHorizontally(ship, pos);
    }

    @Test(expected = IllegalStateException.class)
    public void BadAddedShipHorizontally() throws IllegalStateException{
        Sea sea = new Sea(5, 10);
        Ship ship = new Ship(3);
        Position pos = new Position(4, 8);
        Game game = new Game(sea);
        game.addShipHorizontally(ship, pos);
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(battleship.GameTest.class);
    }
}
