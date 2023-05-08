/**
 * This class contains detailed information on each cell
 */
public class Cell {
    //

    private boolean isHit;
    private boolean isShip;


    public Cell(boolean isHit, boolean isShip)
    {
        this.isHit = isHit;
        this.isShip = isShip;
    }

    public boolean getIsShip() {
        return isShip;
    }

    public boolean getIsHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
