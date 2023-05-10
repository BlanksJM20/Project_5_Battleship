import java.util.Random;
import java.util.Scanner;

public class SinglePlayerGameLoop {
    Board b = new Board();
    Random r = new Random();
    Ship x;
    boolean boardFull = false;
    boolean reLoop = true;
    Scanner scn = new Scanner(System.in);



    /**
     * finds if you have killed all the ships
     * @return
     */
    public boolean hasWon ()
{

    for (int i = 0; i < b.getNumCols(); i++)
    {
        for (int j = 0; j < b.getNumCols(); j++)
        {
            if (b.getGameBoard().get(b.findKey(i,j)) == null)
            {

            }
          else if (b.getGameBoard().get(b.findKey(i,j)).getIsShip() && !(b.getGameBoard().get(b.findKey(i,j)).getIsHit()))

            {
                return false;
            }
        }
    }
    return true;
}

    /**
     * Algorithm for determining where to hide the next cells.
     * Adds two new ships to the board
     */
    public void add2 ()
{

    Ship y = new Ship("y", 1, true);
    Ship z = new Ship("z", 1, true);
boolean hasWorked = false;
int laps = 0;
  while (!hasWorked)
  {

      try {
          int row = r.nextInt(9);
          int col = r.nextInt(9);
          if (row >0 && col > 0 )
          {
              for (int i = row -1; i < row + 1; i ++)
              {
                  for (int j = col - 1; i < col + 1; j ++)
                  {
                      if (b.getGameBoard().get(b.findKey(i,j)).getIsShip())
                      {
                          throw new Exception("too close");
                      }
                  }
              }
             b.addShip(y,row,col);
          }
          row = r.nextInt(9);
           col = r.nextInt(9);
          if (row >0 && col > 0 )
          {
              for (int i = row -1; i < row + 1; i ++)
              {
                  for (int j = col - 1; i < col + 1; j ++)
                  {
                      if (b.getGameBoard().get(b.findKey(i,j)).getIsShip())
                      {
                          throw new Exception("too close");
                      }
                  }
              }
              b.addShip(z,row,col);
              hasWorked = true;
          }
          else{
              b.addShip(y, r.nextInt(9), r.nextInt(9));
              b.addShip(z, r.nextInt(9), r.nextInt(9));
              hasWorked = true;
          }
          if (laps > 100 && laps < 100000)
          {
              b.addShip(y, r.nextInt(9), r.nextInt(9));
              b.addShip(z, r.nextInt(9), r.nextInt(9));
              hasWorked = true;
          }
          else if (laps > 100000) {
              boardFull = true;
              break;
          }

      }catch (Exception e)
      {
          laps++;
      }
  }
}
    public void gameLoop ()
    {
        try {
            x = new Ship("x", 1, true);
            b.addShip(x, r.nextInt(9), r.nextInt(9));
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("The rules are simple: \n every time you miss, two new enemy cells appear in the board. \n" +
                "Kill them all before the board fills up.");
        while (!hasWon() && !boardFull)
        {
            System.out.println(b.hitLocationToString());
            System.out.println(b.shipLocationBoardToString());
            while (reLoop) {
                try {
                    System.out.println("Enter the row of the cell you want to shoot (X mark is a hit, O mark is a miss");
                    int row = scn.nextInt();
                    System.out.println("Enter the Column of the cell you want to shoot");
                    int column = scn.nextInt();
                    b.markHit(row, column);
                    break;
                }catch (Exception e)
                {
                    System.out.println("Invalid Input. Please try again");
                    scn.next();
                }
                if (hasWon() || boardFull)
                {
                    break;
                }
               else
                {
                    add2();
                }
            }
            if (hasWon())
            {
                System.out.println("YAYAYAYAAYAYAYAYAYAY: YOU WON!!!!");
            }
            else{
                System.out.println("too bad. You lose");
            }








        }
    }
}
