public class Player {
    // This board is the board set up by the other player, not the board set up by this player
    private Board theirBoard;

    /**
     * Player set up, assigned their own board
     * @param other
     */
    public Player(Board other)
    {
        theirBoard = other;
    }


    //Seems like you could just put each players ships into a seperate arrayLists and when the a ship gets
    //eliminated you remove it, if one players list has 0 then you win or something.

    /**
     *
     * @return true if a player has won
     */
    public boolean hasWon ()
    {
//        System.out.println("Number of ships: " + theirBoard.getPlacedShips().size());
        if (theirBoard.getPlacedShips().size() <= 0)
        {


            return true;
        }
        else {


            return false;
        }
    }


}
