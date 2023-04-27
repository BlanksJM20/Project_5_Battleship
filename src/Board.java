import java.util.HashMap;

/**
 * Each ship is broken down into it's specific index info
 * That is then stored in a map with a key unique to each index.
 * When constructing the board now, all info can be had by simply calling the map
 * with the key for each index
 */
public abstract class Board {
    //  0  1  2  3  4  5  6  7  8  9
    // +–––––––––––––––––––––––––––––+
    //A|__|__|__|__|__|__|__|__|__|__|
    //B|__|__|__|__|__|__|__|__|__|__|
    //C|__|__|__|__|__|__|__|__|__|__|
    //D|__|__|__|__|__|__|__|__|__|__|
    //E|__|__|__|__|__|__|__|__|__|__|
    //F|__|__|__|__|__|__|__|__|__|__|
    //G|__|__|__|__|__|__|__|__|__|__|
    //H|__|__|__|__|__|__|__|__|__|__|
    //I|__|__|__|__|__|__|__|__|__|__|
    //J|__|__|__|__|__|__|__|__|__|__|

    private HashMap<Integer,ShipIdx> gameBoard;
    private int NumRows = 10;
    private int NumCols = 10;

    public Board()
    {
        gameBoard = new HashMap();
    }
    public static int findKey(int row, int col)
    {
        int counter = 0;
        counter = (row * 50) + (col * 2);
        return counter;
    }
    public void addShip (Ship s)
    {
        for (int i = 0; i < s.getCellsSize(); i++)
            gameBoard.put(findKey(s.getIdx(i).getRow(),s.getIdx(i).getCol()), s.getIdx(i));
//TODO: make ship know require a direction to face, and then given the starting coords, have it find the values for each idx and set them
    }

//    public static void main(String[] args) {//indexes and their corresponding keys.
//        for (int i = 0; i < 10; i++)
//        {
//            for (int j = 0; j < 10; j++)
//            {
//                int l = findKey(i,j);
//                System.out.println(l + " At index " + i + "," + j);
//            }
//        }
//
//    }
//


}
