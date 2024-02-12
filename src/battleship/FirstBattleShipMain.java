package battleship;

import battleship.util.Position;

public class FirstBattleShipMain {
    public static void main(String[] args) {
        Sea sea1 = new Sea(10, 10);
        Ship ship1 = new Ship(1);
        Ship ship2 = new Ship(1);
        Position pos1 = new Position(2, 5);
        Position pos2 = new Position(5, 2);
        sea1.addShip(ship1, pos1);
        sea1.addShip(ship2, pos2);
        System.out.println("-- Plateau Defenseur --");
        sea1.display(true);
        System.out.println("-- Plateau Attaquant --");
        sea1.display(false);
        sea1.Shoot(pos2);
        System.out.println("-- Plateau Defenseur --");
        sea1.display(true);
        System.out.println("-- Plateau Attaquant --");
        sea1.display(false);
    }
}
