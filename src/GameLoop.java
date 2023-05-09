import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class GameLoop {
    //Sets up the gameBoard
    private Board p1b = new Board();
    private Board p2b = new Board();
    private Player p1 = new Player(p1b);
    private Player p2 = new Player(p2b);
    //ArrayList<Ship> ships = new ArrayList<>();


    /**
     * runGame: Runs the game class
     */
    public void runGame() throws Exception{

        System.out.println("Player one starts. Hand the computer to player one");
        System.out.println(p1b.shipLocationBoardToString());
        Scanner scn = new Scanner(System.in);

        //Ship carrier = new Ship("Carrier", 5,);

        HashMap<String, Integer> shipNames = new HashMap<>();
        shipNames.put("Carrier", 5);
        shipNames.put("Battleship",4);
        shipNames.put("Submarine",3);
        shipNames.put("Cruiser",3);
        shipNames.put("Destroyer",2);

        ArrayList<String> shipName = new ArrayList<>();
        shipName.add("Carrier");
        shipName.add("Battleship");
        shipName.add("Submarine");
        shipName.add("Cruiser");
        shipName.add("Destroyer");


        System.out.println("Ship set up for Player 1:");

        for(int i = 0; i < shipNames.size(); i++){
            System.out.println("Enter the row# then column# for your upper left point of the " + shipName.get(i) + " size of " + shipNames.get(shipName.get(i)));
            int row = scn.nextInt();
            int column = scn.nextInt();
            System.out.println("Type true if you want ship horizontal");
            boolean isHorizontal = scn.nextBoolean();
            Ship newShip = new Ship(shipName.get(i), shipNames.get(shipName.get(i)), isHorizontal);
            p1b.addShip(newShip, row, column);
            System.out.println(p1b.shipLocationBoardToString());
        }

        System.out.println("Push any key to clear the window then hand computer to player 2");
        scn.next();
        for(int i = 0; i <21; i++){
            System.out.println("DONT SCROLL UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!/////////////////////////////////////");
        }


        System.out.println(p2b.shipLocationBoardToString());

        System.out.println("Ship set up for Player 2:");
        for(int i = 0; i < shipNames.size(); i++){
            System.out.println("Enter the row# then column# for your upper left point of the " + shipName.get(i) + " size of " + shipNames.get(shipName.get(i)));
            int row = scn.nextInt();
            int column = scn.nextInt();
            System.out.println("Type true if you want ship horizontal");
            boolean isHorizontal = scn.nextBoolean();
            Ship newShip = new Ship(shipName.get(i), shipNames.get(shipName.get(i)), isHorizontal);
            p2b.addShip(newShip, row, column);
            System.out.println(p2b.shipLocationBoardToString());
        }

        System.out.println("Push any key to clear the window then hand computer to player 1");
        scn.next();
        for(int i = 0; i <21; i++){
            System.out.println("DONT SCROLL UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!/////////////////////////////////////");
        }


        int currentPlayer = 1;
        while(!p1.hasWon() && !p2.hasWon()){
            if(currentPlayer == 1){
                System.out.println("PLAYER ONE:");
                System.out.println(p1b.shipLocationBoardToString());
                System.out.println(p2b.hitLocationToString());
                System.out.println("Choose as Cell to shoot, row # then col # (X mark is a hit, O mark is a miss");
                int row = scn.nextInt();
                int column = scn.nextInt();
                p2b.markHit(row, column);
                //if(p2b.isSunk()){
                //  do something
                //}
                System.out.println(p2b.hitLocationToString());
                currentPlayer = 2;
                System.out.println("Push any key to change turns and clear screen");
                scn.next();
                for(int i = 0; i <21; i++){
                    System.out.println("DONT SCROLL UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!/////////////////////////////////////");
                }

            }
            if(currentPlayer == 2){
                System.out.println("PLAYER ONE:");
                System.out.println(p2b.shipLocationBoardToString());
                System.out.println(p1b.hitLocationToString());
                System.out.println("Choose as Cell to shoot, row # then col # (X mark is a hit, O mark is a miss");
                int row = scn.nextInt();
                int column = scn.nextInt();
                p1b.markHit(row, column);
                //if(p1b.isSunk()){
                //  do something
                //}
                System.out.println(p1b.hitLocationToString());
                currentPlayer = 1;
                System.out.println("Push any key to change turns and clear screen");
                scn.next();
                for(int i = 0; i <21; i++){
                    System.out.println("DONT SCROLL UP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!/////////////////////////////////////");
                }

            }
        }
        if(p1.hasWon()){
            System.out.println("Player ONE is VICTORIOUS");
        }
        if(p2.hasWon()){
            System.out.println("Player TWO is VICTORIOUS");
        }





    }
}
