import java.util.HashMap;

/**
 * This class contains detailed information on each cell
 */
public class ShipIdx {

    private boolean isHit;
    private int col;
    private int row;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public ShipIdx (boolean isHit)
    {
        this.isHit = isHit;
    }

    public boolean getIsHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
