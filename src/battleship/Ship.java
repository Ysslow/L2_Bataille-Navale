package battleship;

/** Class for Ship */
public class Ship {

    /** Attributes */
    private int lifePoints;
    
    /** Constructor for Ship
     * @param lifePoints lifepoints
     */
    public Ship(int lifePoints){
        this.lifePoints = lifePoints;
    }

    /** Look if the ship is sunk
     * @return true if sunk / false if not
     */
    public boolean hasBeenSunk(){
        return this.lifePoints == 0;
    }

    /** Look if the ship get hit */
    public void beenHitting(){
        this.lifePoints -= 1;
    }

    /** get the lifePoints of the Ship
     * @return the lifepoints
     */
    public int getLifePoints() {
        return this.lifePoints;
    }

    /** a little description of the Ship
     * @return a simple phrase to describe the object
     */
    public String toString() {
        return "Ship [lifePoints=" + lifePoints + "]";
    }
}