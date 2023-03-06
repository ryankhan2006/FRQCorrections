import java.util.ArrayList;

public class TileGame {
    private ArrayList<NumberTile> board;

    public TileGame()
    {
        board = new ArrayList<NumberTile>();
    }

    //Added this so we can have a new examples to check our work
    public TileGame(ArrayList<NumberTile> tileList)
    {
        board = tileList;
    }

    private int getIndexForFit(NumberTile tile)
    {
       if (board.size() == 0 || tile.getRight() == board.get(0).getLeft()) {
         return 0;
       }


    if (tile.getLeft() == board.get(board.size() - 1).getRight()) {
      return board.size();
    }
    for(int i = 1; i < board.size(); i++){
      if(board.get(i - 1).getRight() == tile.getLeft() &&
           board.get(i).getLeft() == tile.getRight()) {
        return i;
    }
    }
    return -1;
    }

    public boolean insertTile(NumberTile tile)
    {
        for (int i = 1; i <= 4; i++)
    {
      int index = getIndexForFit(tile);
      if (index != -1)
      {
        board.add(index, tile);
        return true;
      }
      tile.rotate();
    }

    return false;
    }
    public String toString()
    {
        String retStr = "";
        for (int i = 0; i < board.size(); i++)
        {
            retStr += " "+board.get(i).getTop()+"  ";
        }
        retStr += "\n";
        for (int i = 0; i < board.size(); i++)
        {
            retStr += board.get(i).getLeft()+" "+board.get(i).getRight()+" ";
        }
        retStr += "\n";
        for (int i = 0; i < board.size(); i++)
        {
            retStr += " "+board.get(i).getBottom()+"  ";
        }
        retStr += "\n";
        return retStr;
    }
}