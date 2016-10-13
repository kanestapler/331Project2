import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
   public static void main(String[] args) {
	   
	   int xSize = 10;
	   int ySize = 10;
	   
	   Square[][] mainGrid = new Square[xSize][ySize];
	   
	   for (int i=0; i < xSize; i++) {
		   for (int j=0; j < ySize; j++) {
			   mainGrid[i][j] = new Square(i, j);
		   }
	   }
	   
	   mainGrid[3][3].SetValue('A');
	   mainGrid[6][6].SetValue('B');
	   
	   Queue<Square> mainQueue = new LinkedList<Square>();
	   mainQueue.add(mainGrid[3][3]);
	   
	   
	  
   }
}