public class Player {
    // This board is the board set up by the other player, not the board set up by this player
    private Board theirBoard;

    public Player(Board other)
    {
        theirBoard = other;
    }


    //Seems like you could just put each players ships into a seperate arrayLists and when the a ship gets
    //eliminated you remove it, if one players list has 0 then you win or something.
    public boolean hasWon ()
    {
        if (theirBoard.getPlacedShips().size() <= 0)
        {
            return true;
        }
        else {
            return false;
        }
    }
//        //
//        for (int i = 0; i < theirBoard.getNumRows(); i++)
//        {
//           for (int j = 0; j < theirBoard.getNumCols(); j++)
//            {
//if (theirBoard.getGameBoard().get(theirBoard.findKey(i,j)) == null)
//{}
//                //{
//                   else if (!theirBoard.getGameBoard().get(theirBoard.findKey(i,j)).getIsHit() && theirBoard.getGameBoard().get(theirBoard.findKey(i,j)).getIsShip()) {
////
//                        return false;
//                    }
//               // }
//            }
//
//        }
//        return true;
//    }

}
