import java.util.HashMap;

/**
 * Each ship is broken down into it's specific index info
 * That is then stored in a map with a key unique to each index.
 * When constructing the board now, all info can be had by simply calling the map
 * with the key for each index
 */
public class Board {
//      0  1  2  3  4  5  6  7  8  9
//     +–––––––––––––––––––––––––––––+
//    0|__|__|__|__|__|__|__|__|__|__|
//    1|__|__|__|__|__|__|__|__|__|__|
//    2|__|__|__|__|__|__|__|__|__|__|
//    3|__|__|__|__|__|__|__|__|__|__|
//    4|__|__|__|__|__|__|__|__|__|__|
//    5|__|__|__|__|__|__|__|__|__|__|
//    6|__|__|__|__|__|__|__|__|__|__|
//    7|__|__|__|__|__|__|__|__|__|__|
//    8|__|__|__|__|__|__|__|__|__|__|
//    9|__|__|__|__|__|__|__|__|__|__|

    private HashMap<Integer, Cell> gameBoard;
    private int NumRows = 10;
    private int NumCols = 10;

    /**
     * Initializes a game board and sets each cell key, and the value to null.
     */
    public Board()
    {
        gameBoard = new HashMap();
        for (int i = 0; i < NumRows; i++)
        {
            for (int j = 0; j < NumCols; j++)
            {
                gameBoard.put(findKey(i,j),null);
            }
        }
    }
    public static int findKey(int row, int col)
    {
        int counter = 0;
        counter = (row * 50) + (col * 2);
        return counter;
    }

    /**
     *
     * @param s Ship you want to place
     * @param row upper left most y value you want to place the ship
     * @param col upper left most x value you want to place the ship
     * @return a boolean dictating if there is another ship already placed in its proposed path.
     */
    public boolean noOverlap (Ship s, int row, int col)
    {
        if (s.getIsHorizontal())
        {
            for (int i = row; i < row +s.getCellsSize()-1; i++)
            {
                if (gameBoard.get(findKey(i,col)) != null)
                {
                    return  false;
                }
            }
        }
        if (!s.getIsHorizontal())
        {
            for (int i = col; i < col +s.getCellsSize(); i++)//removed -1
            {
                if (gameBoard.get(findKey(row,i)) != null)
                {
                    return  false;
                }
            }
        }
        return true;

    }

    /**
     * Marks a cell as being hit from a guess
     * @param row y coord
     * @param col x coord
     */
    public void markHit (int row, int col)
    {
        if (gameBoard.get(findKey(row,col)) == null)
        {
            Cell c = new Cell(true,false);
            gameBoard.put(findKey(row,col),c) ;
        }
        else {
            gameBoard.get(findKey(row,col)).setHit(true);
        }
    }

    /**
     * Places a ship on the board, by putting ship idx's in the appropriate map buckets
     * @param s the ship you want to place
     * @param row upper left most y coord of ship location
     * @param col upper left most x coord of ship location on grid board
     */
    public void addShip (Ship s, int row, int col) throws Exception
    {

        if(!s.getIsHorizontal() && (row + s.getCellsSize()-1) <NumRows && row >-1 && noOverlap(s,row,col) )
        {
            int index = 0;
            for (int i = row; i < row +s.getCellsSize(); i++)// removed -1
            {
                gameBoard.put(findKey(i,col),s.getIdx(index));
                index++;

            }

        }
        if(s.getIsHorizontal() && (col + s.getCellsSize()-1) <NumCols && col >-1 && noOverlap(s,row,col) )
        {
            int index = 0;
            for (int i = col; i < col +s.getCellsSize(); i++)// removed -1
            {
                gameBoard.put(findKey(row,i),s.getIdx(index));
                index++;

            }

        }
        else{ throw new Exception ("Invalid position. Try again");
        }
    }




    public String shipLocationBoardToString ()
    {
        //      0   1   2   3   4   5   6   7   8   9
        //     +–––––––--------––––––––––––––––––––––+
        //    0|__|__|__|__|__|__|__|__|__|__|
        //    1|__|__|__|__|__|__|__|__|__|__|
        //    2|__|__|__|__|__|__|__|__|__|__|
        //    3|__|__|__|__|__|__|__|__|__|__|
        //    4|__|__|__|__|__|__|__|__|__|__|
        //    5|__|__|__|__|__|__|__|__|__|__|
        //    6|__|__|__|__|__|__|__|__|__|__|
        //    7|__|__|__|__|__|__|__|__|__|__|
        //    8|__|__|__|__|__|__|__|__|__|__|
        //    9|__|__|__|__|__|__|__|__|__|__|
        String gb = "   0   1   2   3   4   5   6   7   8   9\n";
        for (int i = 0; i < NumRows; i++)
        {
            gb = gb +i;
            for (int j = 0; j < NumCols; j++)
            {
                gb = gb +"|_";
                if (gameBoard.get(findKey(i,j)) == null)
                {
                    gb = gb + " _";
                }
                else
                {
                    gb = gb + "S_";
                }
            }
            gb = gb + "|\n";

        }


        return gb;
    }
    public String hitLocationToString () {
        //      0   1   2   3   4   5   6   7   8   9
        //     +–––––––--------––––––––––––––––––––––+
        //    0|__|__|__|__|__|__|__|__|__|__|
        //    1|__|__|__|__|__|__|__|__|__|__|
        //    2|__|__|__|__|__|__|__|__|__|__|
        //    3|__|__|__|__|__|__|__|__|__|__|
        //    4|__|__|__|__|__|__|__|__|__|__|
        //    5|__|__|__|__|__|__|__|__|__|__|
        //    6|__|__|__|__|__|__|__|__|__|__|
        //    7|__|__|__|__|__|__|__|__|__|__|
        //    8|__|__|__|__|__|__|__|__|__|__|
        //    9|__|__|__|__|__|__|__|__|__|__|
        String gb = "   0   1   2   3   4   5   6   7   8   9\n";
        for (int i = 0; i < NumRows; i++) {
            gb = gb + i;
            for (int j = 0; j < NumCols; j++) {
                gb = gb + "|_";
                if (gameBoard.get(findKey(i, j)) == null||!gameBoard.get(findKey(i, j)).getIsHit() ){//||gameBoard.get(findKey(i,j)).getIsHit()== null) {
                    gb = gb + " _";
                } else if (!gameBoard.get(findKey(i, j)).getIsShip()){
                    gb = gb + "0_";
                }
                else {
                    gb = gb + "X_";
                }
            }
            gb = gb + "|\n";

        }
        return gb;
    }


//To string method tests.
        public static void main (String[]args) throws Exception {
            Board b = new Board();
            System.out.println(b.shipLocationBoardToString());
            Ship s = new Ship("BattleShip", 5, true);
            b.addShip(s, 3, 5);
            System.out.println(b.shipLocationBoardToString());
            b.markHit(3,5);
            b.markHit(3,4);
            System.out.println(b.hitLocationToString());


        }
}



