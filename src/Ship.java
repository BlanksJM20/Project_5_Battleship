import java.util.ArrayList;

/**
 * This class has the ships name and size, and an arraylist of an objects that has
 * specified info for each cell.
 */
public class Ship {
    private String name;
    private boolean isHorizontal;

    private ArrayList<Cell> cells;
    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Ship (String name, int size, boolean isHorizontal )
    {
        this.cells = new ArrayList<>();
        this.name = name;
        this.isHorizontal = isHorizontal;

        for (int i = 0; i < size; i++)
        {
            Cell e = new Cell(false,true);
            cells.add(e);
        }

    }
    public Cell getIdx (int Index)
    {
        return cells.get(Index);
    }
    public boolean getIsHorizontal()
    {
        return  isHorizontal;
    }


    public String getName() {
        return name;
    }
    public int getCellsSize ()
    {
        return cells.size();
    }


}
