package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {
    @Test
    public void initiliizationIsOk(){
        Cell cell = new Cell();
        assertEquals(null, cell.getShip());
        assertEquals(false, cell.hasBeenShot());
    }

    @Test
    public void CorrectlyGettingTheShip(){
        Ship ship = new Ship(3);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertEquals(ship, cell.getShip());
    }

    @Test
    public void SettersWorking(){
        Ship ship2 = new Ship(5);
        Cell cell = new Cell();
        cell.setShip(ship2);
        assertEquals(ship2, cell.getShip());
    }

    @Test
    public void GetCorrectlyShot(){
        Ship ship = new Ship(3);
        Cell cell = new Cell();
        cell.setShip(ship);
        assertEquals(Answer.HIT,cell.Shot());
        assertEquals(2, ship.getLifePoints());
        assertEquals(true, cell.hasBeenShot());
        assertEquals(Answer.MISS,cell.Shot());
        assertEquals(2, ship.getLifePoints());

        Cell cell2 = new Cell();
        assertEquals(Answer.MISS,cell2.Shot());
        assertEquals(true, cell2.hasBeenShot());

        Ship ship3 = new Ship(1);
        Cell cell3 = new Cell();
        cell3.setShip(ship3);
        assertEquals(Answer.SINK,cell3.Shot());
        assertEquals(true, cell3.hasBeenShot());

    }

    @Test
    public void toCharacterAllThePossibilities(){
        // version defenseur
        Cell cell = new Cell();
        assertEquals("∼".charAt(0), cell.toCharacter(true));
        Ship ship2 = new Ship(3);
        Cell cell2 = new Cell();
        cell2.setShip(ship2);
        assertEquals("B".charAt(0), cell2.toCharacter(true));
        Ship ship3 = new Ship(3);
        Cell cell3 = new Cell();
        cell3.setShip(ship3);
        cell3.Shot();
        assertEquals("*".charAt(0), cell3.toCharacter(true));

        // version attaquant
        Cell cell4 = new Cell();
        assertEquals(".".charAt(0), cell4.toCharacter(false));
        Cell cell5 = new Cell();
        cell5.Shot();
        assertEquals("∼".charAt(0), cell5.toCharacter(false));
        Ship ship6 = new Ship(3);
        Cell cell6 = new Cell();
        cell6.setShip(ship6);
        cell6.Shot();
        assertEquals("*".charAt(0), cell6.toCharacter(false));
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(battleship.CellTest.class);
    }

}