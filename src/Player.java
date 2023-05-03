public class Player {
    // This board is the board set up by the other player, not the board set up by this player
    private Board theirBoard;

    public Player(Board other)
    {
        theirBoard = other;
    }


    public boolean hasWon ()
    {
        for (int i = 0; i < theirBoard.getNumRows(); i++)
        {
           for (int j = 0; j < theirBoard.getNumCols(); j++)
            {
               if (theirBoard.getGameBoard().get(theirBoard.findKey(i,j)).getIsShip() && !theirBoard.getGameBoard().get(theirBoard.findKey(i,j)).getIsHit());
                {
                    return false;
                }
            }

        }
        return true;
    }

}
