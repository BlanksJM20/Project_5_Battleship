public class Ship {
    public class Ship {
        // private boolean horizontal;
        private String name;
        private int size;
        private boolean[] cells;
        private int numHits;
        private int boardRow;
        private int boardCol;

        public Ship (boolean hor, String name, int size)
        {
            cells = new boolean[size];
            this.size = size;
            this.name = name;
            // horizontal = hor;
            for (int i = 0; i < cells.length; i++)
            {
                cells[i]  = false;
            }

        }

        public int getBoardCol() {
            return boardCol;
        }

        public String getName() {
            return name;
        }

        public int getBoardRow() {
            return boardRow;
        }

        public void setShip (int row, int col)
        {
            boardCol = col;
            boardRow = row;
        }

        public void isHit (int index)
        {
            if (cells[index] != true)
            {
                cells[index]= true;
                numHits++;
            }
            else
            {
                System.out.println("ERROR. ALREADY REGISTERED THE HIT. SHIPS.IsHIT ");
            }
        }


        public boolean isSunk()
        {
            int count = 0;
            for (int i = 0; i < cells.length; i++)
            {
                if (!cells[i] )
                {
                    return false;
                }

            }
            return true;
        }
    }

}
