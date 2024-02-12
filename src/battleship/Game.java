package battleship;
import battleship.util.*;
import java.util.Scanner; 

/** Game Class */
public class Game {
    
    /** Attributes */
    private Sea sea;

    /** Game constructor
     * @param sea sea
     */
    public Game(Sea sea){
        this.sea = sea;
    }

    /** Get the current sea for the game 
     * @return a sea
    */
    public Sea getSea() {
        return this.sea;
    }

    /** Ask for a position to the player
     * @return the choosen position
     */
    private Position inputPosition(){
        Scanner saisieUtilisateur = new Scanner(System.in);
        String Alphabet = "ABCDEFGHIJ";
        String Chiffre = "0123456789";
        int test1 = 0;
        int test2 = 0;
        while(test1 == 0 && test2  == 0){
            System.out.println("Veuillez saisir une lettre et un chiffre [A0 à J9] OU des coordonnées [(0,0)à(9,9)] :");
            String str = saisieUtilisateur.next();
            if (str.length() == 2){
                if (Alphabet.contains(str.substring(0,1)) == true){
                    test1 = str.charAt(0) - 65;
                    test2 = str.charAt(1) - 48;
                }
                else{
                    System.out.println("saisir une valeur correcte");
                }
            }
            else if (str.length() == 5){
                if(Chiffre.contains(str.substring(3,4))){
                    test1 = str.charAt(1) - 48;
                    test2 = str.charAt(3) - 48;
                }
                else{
                    System.out.println("saisir une valeur correcte");
                }
            }
            else{
                System.out.println("saisir une valeur correcte");
            }
        }
        Position pos = new Position(test1, test2);
        return pos;
    }

    /** Play the game */
    public void play(){
        while (sea.getRemainingLifePoints() != 0){
            sea.display(false);
            System.out.println(sea.Shoot(inputPosition()));
        }
        sea.display(false);
        System.out.println("Vous avez gagné, il n'y a plus de bateau restant sur le plateau !");
    }

    /** Test if u can place the ship vertically
     * @param shipToPlace ship
     * @param position position
     * @throws IllegalStateException if the ship b can not be placed on the sea
     */
    private void testIfShipCanBePlacedVertically(Ship shipToPlace, Position position) throws IllegalStateException{
        if (shipToPlace.getLifePoints()-1 + position.getX() > this.sea.getTab().length-1){
            throw new IllegalStateException();
        }
        for (int i = 0; i < shipToPlace.getLifePoints()-1; i++){
            if (this.sea.getTab()[position.getX()+i][position.getY()].isEmpty() == false){
                throw new IllegalStateException();
            }
        }
    }

    /** add the ship b to this game’s sea.  Ship is added vertically down from position p.
     *    The number of cells is determined by the ship life points.
     * @param shipToPlace the ship to add
     * @param position the position of the first (top) cell occupied by the ship
     * @throws IllegalStateException if the ship b can not be placed on the sea
     *    (ship goes outside of the sea or some cell is not empty)
     */
    public void addShipVertically(Ship shipToPlace, Position position) throws IllegalStateException{
        testIfShipCanBePlacedVertically(shipToPlace, position);
        for (int i = 0; i < shipToPlace.getLifePoints(); i++){
            this.sea.getTab()[position.getX()+i][position.getY()].setShip(shipToPlace);
        }
    }

    /** Test if u can place the ship horizontally
     * @param shipToPlace ship
     * @param position position
     * @throws IllegalStateException if the ship b can not be placed on the sea
     */
    private void testIfShipCanBePlacedHorizontally(Ship shipToPlace, Position position) throws IllegalStateException{
        if (shipToPlace.getLifePoints()-1 + position.getY() > this.sea.getTab()[0].length-1){
            throw new IllegalStateException();
        }
        for (int i = 0; i < shipToPlace.getLifePoints(); i++){
            if (this.sea.getTab()[position.getX()][position.getY()+i].isEmpty() == false){
                throw new IllegalStateException();
            }
        }
    }

    /** add the ship b to this game’s sea.  Ship is added horizontally right from position p.
     *    The number of cells is determined by the ship life points.
     * @param shipToPlace the ship to add
     * @param position the position of the first (top) cell occupied by the ship
     * @throws IllegalStateException if the ship b can not be placed on the sea
     *    (ship goes outside of the sea or some cell is not empty)
     */
    public void addShipHorizontally(Ship shipToPlace, Position position) throws IllegalStateException{
        testIfShipCanBePlacedHorizontally(shipToPlace, position);
        for (int i = 0; i < shipToPlace.getLifePoints(); i++){
            this.sea.getTab()[position.getX()][position.getY()+i].setShip(shipToPlace);
        }
    }

    /** add the ship to the game, added horizontally or vertically depends on dx, dy
     * @param shipToPlace ship 
     * @param position position
     * @param dx x-variation
     * @param dy y-variation
     * @throws IllegalStateException if the ship b can not be placed on the sea
     */
    public void addShip(Ship shipToPlace, Position position, int dx, int dy) throws IllegalStateException{
        if (dx != 0 && dy != 0){
            throw new IllegalStateException();
        }
        else if (dx != 0 && dy == 0){
            testIfShipCanBePlacedVertically(shipToPlace, position);
            for (int i = 0; i < dx; i++){
                this.sea.getTab()[position.getX()+i][position.getY()].setShip(shipToPlace);
            }
        }
        else if (dx == 0 && dy != 0){
            testIfShipCanBePlacedHorizontally(shipToPlace, position);
            for (int i = 0; i < dy; i++){
                this.sea.getTab()[position.getX()][position.getY()+i].setShip(shipToPlace);
            }
        }
    }
}