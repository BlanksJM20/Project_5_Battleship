import java.util.ArrayList;

/**
 * This class has the ships name and size, and an arraylist of an objects that has
 * specified info for each cell.
 */
public class Ship {
    private String name;

    private ArrayList<ShipIdx> cells;

    public Ship (String name, int size, int row, int col)
    {

        this.name = name;

        for (int i = 0; i < size; i++)
        {
            ShipIdx e = new ShipIdx(false);
            cells.add(e);
        }

    }
    public ShipIdx getIdx (int Index)
    {
        return cells.get(Index);
    }


    public String getName() {
        return name;
    }
    public int getCellsSize ()
    {
        return cells.size();
    }

    public void isHit (int index)
    {
        if (cells.get(index).getIsHit() != true)
        {
            cells.get(index).setHit(true);

        }
        else
        {
            System.out.println("ERROR. ALREADY REGISTERED THE HIT. SHIPS.IsHIT ");
        }
    }


    public boolean isSunk()
    {
        int count = 0;
        for (int i = 0; i < cells.size(); i++)
        {
            if (!cells.get(i).getIsHit() )
            {
                return false;
            }

        }
        return true;
    }
}
