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
	   
	   mainGrid[1][1].SetValue('A');
	   System.out.println(mainGrid[1][1].GetValue());
	  
   }
}