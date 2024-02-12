package battleship;

/** Class for Cell */
public class Cell {

    /** Attributes */
    private Ship ship;
    private boolean shot;
    
    /** Constructor for Cell
     */
    public Cell(){
        this.ship = null;
        this.shot = false;
    }

    /**
     * Check if the cell got a ship or not
     * @return true if no ship / false if ship
     */
    public boolean isEmpty(){
        return this.ship == null;
    }

    /** get the current ship on the cell
     * @return the current ship
     */
    public Ship getShip(){
        if (this.ship == null){
            return null;
        }
        return this.ship;
    }

    /** return the current shot value for the current cell 
     * @return true if shot is true / false either
    */
    public boolean getShot(){
        return this.shot;
    }

    /** set a ship at the current cell
     * @param ship a ship
     */
    public void setShip(Ship ship){
        this.ship = ship;
    }

    /** valid a shot for the current cell */
    public void setShot(){
        this.shot = true;
    }

    /** check if the Ship has been shot
     * @return true if been shot / false either
     */
    public boolean hasBeenShot() {
        return this.shot == true;
    }

    /** Shot a ship 
     * @return HIT if hit / MISS if miss
    */
    public Answer Shot() {
        if (this.ship != null && this.hasBeenShot() == false){
            this.shot = true;
            this.ship.beenHitting();
            if(this.ship.hasBeenSunk() == true){
                return Answer.SINK;
            }
            return Answer.HIT;
        }
        this.shot = true;
        return Answer.MISS;
    }

    /** return a specific character, depends on the side
     * @param defender true if defender / false if attaquant
     * @return a character
     */
    public char toCharacter(boolean defender){
        if (defender == true){
            if (this.ship == null){return ("∼".charAt(0));}
            else if (this.ship != null && this.hasBeenShot() == true) {return "*".charAt(0);}
            else if (this.ship != null) {return "B".charAt(0);}
        }
        if (this.hasBeenShot() == false){return (".".charAt(0));}
        else if (this.ship != null && this.hasBeenShot() == true) {return "*".charAt(0);}
        return "∼".charAt(0);
    }
}