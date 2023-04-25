public class Board {

    //We are not sure if we need two players but if we do here they are
    public int playerOne;
    public int playerTwo;

    //IN CASE: we want to change the length and widths of the board.
    private int boardLength;
    private int boardWidth;

    //Array that represents the board
    private char[][] battleshipBoard = new char[boardLength][boardWidth];


    /**
     *Board Constructor: Creates an empty battleship board
     */
    public Board(){};

    /**
     * getRow: Gets the row number
     * @param location: user puts the location/box number
     * @return: returns the row number
     */
    public int getRow(int location){
        return 0;
    }

    /**
     * getColumn: Gets the column number
     * @param location: user puts the location/box number
     * @return: returns the column number
     */
    public int getColumn(int location){
        return 0;
    }

    /**
     * setShips: will set the ships of that player
     * @param currentPlayer: user puts in whose turn it is
     */
    public void setShips(int currentPlayer){};

    /**
     * turn: shoots a canon at location on the board
     * @param currentPlayer: user puts in whose turn it is
     */
    public void turn(int currentPlayer){}

    /**
     * isHit: lets the user know if it is hit
     * @param currentPlayer: user inputs the current player
     * @return: returns if it is a hit
     */
    public boolean isHit(int currentPlayer){
        return false;
    }

    /**
     * spaceOccupied: Lets the user know if there has been a shot there before
     * @param row
     * @param column
     * @return: true or false based on if the space has been shot at or not
     */
    public boolean spaceOccupied(int row, int column){
        return false;
    }

    /**
     * hasWon: tests to see if one players ships have all been sunk
     * @param currentPlayer
     * @return: Returns true if a player has won
     */
    public boolean hasWon(int currentPlayer){
        return false;
    }

}
