import java.util.*;
import java.awt.Point;

public class Board {
	private Square[][] grid;
    private Point start;
    private Point end;
	
	public Board(int row, int col) {
		grid = new Square[row][col];
        
        start = new Point();
        end = new Point();
        
        for (int i = 0; i < row; i++) {
		   for (int j = 0; j < col; j++) {
			   grid[i][j] = new Square(false);
		   }
	   }
	}
    
    public void setStart(int x, int y) {
        grid[(int)start.getX()][(int)start.getY()].setValue('*');
        grid[x][y].setValue('A');
        start.setLocation(x, y);
    }
    
    public void setEnd(int x, int y) {
        grid[(int)end.getX()][(int)end.getY()].setValue('*');
        grid[x][y].setValue('B');
        end.setLocation(x, y);
    }
    
    public void setBlocked(int x, int y) {
        grid[x][y].setBlocked(true);
    }
    
    public void setBlocked(List<Point> list) {
        Point point;
        for(int i = 0; i < list.size(); i++) {
            point = list.get(i);
            grid[(int)point.getX()][(int)point.getY()].setBlocked(true);
        }
    }
    
    public void calculatePath() {
        
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