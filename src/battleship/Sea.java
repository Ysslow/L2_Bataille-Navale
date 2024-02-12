package battleship;

import battleship.util.Position;

/** Sea class */
public class Sea {
    
    /** Attributes */
    private Cell[][] tab;

    /** Constructor of Sea
     * @param x x-pos
     * @param y y-pos
     */
    public Sea(int x, int y){
        this.tab = new Cell[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                this.tab[i][j] = new Cell();
            }
        }
    }

    /** get the tab in the sea
     * @return tab
     */
    public Cell[][] getTab(){
        return this.tab;
    }

    /**
     * Add a specific ship to a cell
     * @param s ship
     * @param p position
     */
    public void addShip(Ship s, Position p) throws ArrayIndexOutOfBoundsException{
        if(p.getX() > this.tab.length || p.getY() > this.tab[0].length){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tab[p.getX()][p.getY()].setShip(s);
    }

    /** Shoot a specific cell on the sea
     * @param p position
     * @return HIT / MISS / SINK
     * @throws ArrayIndexOutOfBoundsException index out
     */
    public Answer Shoot(Position p) throws ArrayIndexOutOfBoundsException{
        if(p.getX() > this.tab.length || p.getY() > this.tab[0].length){
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.tab[p.getX()][p.getY()].Shot();
    }

    /** Get all the remaining LifePoints
     * @return number of life
     */
    public int getRemainingLifePoints(){
        int result = 0;
        for (int i = 0; i < this.tab.length; i++){
            for (int j = 0; j < this.tab[0].length; j++){
                if (this.tab[i][j].getShip() != null){
                    result += this.tab[i][j].getShip().getLifePoints();
                }
            }
        }
        return result;
    }

    /** display the game board line by line and cell by cell, on standard output,
    *    the display is different for the defender or the attacker, according to parameter
    * @param defender true if display is for defender, false if for opponent
    */
    public void display(boolean defender) {
        for (int i = 0; i < this.tab.length; i++){
            for (int j = 0; j < this.tab[0].length; j++){
                System.out.print(this.tab[i][j].toCharacter(defender) + " ");
            }
            System.out.println("\n");
        }
    }
}