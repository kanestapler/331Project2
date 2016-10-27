import java.util.*;

public class Main {
	
   public static void main(String[] args) {
       int xSize = 10;
	   int ySize = 10;
	   
	   Board board = new Board(xSize, ySize);
	   board.setStart(3, 3);
       board.setEnd(6, 6);
       
       String s = board.toString();
       System.out.println(s);
   }
}