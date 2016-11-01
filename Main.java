import java.util.*;
import java.awt.Point;

public class Main {
	
   public static void main(String[] args) {
       int xSize = 7;
	   int ySize = 7;
	   
	   Board board = new Board(xSize, ySize);
	   board.setStart(2, 1);
       board.setEnd(3, 5);
       
       List<Point> list = new ArrayList<>();
       list.add(new Point(0, 2));
       list.add(new Point(1, 2));
       list.add(new Point(1, 3));
       
       list.add(new Point(2, 4));
       list.add(new Point(3, 3));
       list.add(new Point(3, 4));
       list.add(new Point(4, 4));
       
       list.add(new Point(4, 0));
       list.add(new Point(5, 0));
       list.add(new Point(5, 1));
       list.add(new Point(5, 2));
       list.add(new Point(6, 0));
       list.add(new Point(6, 1));
       list.add(new Point(6, 2));
       
       board.setBlocked(list);
       
       board.Run();
       
       System.out.println(board.toString());
   }
}