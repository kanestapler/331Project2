import java.util.*;

public class Board {
	private Square[][] grid;
	
	public Board(int row, int col) {
		grid = new Square[row][col];
        
        for (int i = 0; i < row; i++) {
		   for (int j = 0; j < col; j++) {
			   grid[i][j] = new Square(false);
		   }
	   }
	}
    
    public void setStart(int x, int y) {
        grid[x][y].setValue('A');
    }
    
    public void setEnd(int x, int y) {
        grid[x][y].setValue('B');
    }
    
    public void setBlocked(List<int[]> list) {
        int[] array;
        for(int i = 0; i < list.size(); i++) {
            array = list.get(i);
            grid[array[0]][array[1]].setBlocked(true);
        }
    }
    
    public String toString() {
        String s = "";
        for(int i = 0; i < grid.length; i++) {
           for(int j = 0; j < grid[i].length; j++) {
               s += grid[i][j].getValue() + " ";
           }
           s += "\n";
        }
        return s;
    }
}