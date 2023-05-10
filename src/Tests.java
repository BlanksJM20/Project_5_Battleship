public class Tests {

    /**
     * Tests for various parts of board
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Board b = new Board();
        //
        Ship s = new Ship("Scout", 2,true);
        Ship c = new Ship ("Carrier", 5,false);
        System.out.println(b.shipLocationBoardToString());
     //   b.addShip(s,3,3);
        b.addShip(c,4,3);
        b.addShip(s,0,0);
        b.addShip(s,0,8);
        b.addShip(c,1,6);
        b.addShip(s,9,0);
        System.out.println(b.shipLocationBoardToString());
        b.markHit(0,0);
        b.markHit(0,1);
        b.markHit(0,2);
        System.out.println(b.hitLocationToString());
        System.out.println("^^^^^Will show in multiple places b/c same ship is placed multiple times");
        System.out.println(" I was just too lazy to make multiple ships");
        Board b1 = new Board();
   Player p = new Player(b1);
   Ship l = new Ship("test",2,true);
   b1.addShip(l,0,0);
        System.out.println(b1.shipLocationBoardToString());
   b1.markHit(0,0);
        System.out.println(b1.hitLocationToString());
        System.out.println(p.hasWon() + " < should say false");
        //     System.out.println(b1.isSunk() + " < Should not say sunk");
        b1.markHit(0,1);
        System.out.println(b1.hitLocationToString());
        System.out.println(p.hasWon() + " < should say true");
    //    System.out.println(b1.isSunk() + " < Should say sunk");
    }
}
