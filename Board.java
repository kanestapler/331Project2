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
        grid[(int)start.getX()][(int)start.getY()].setValue("*");
        grid[x][y].setValue("A");
        start.setLocation(x, y);
    }
    
    public void setEnd(int x, int y) {
        grid[(int)end.getX()][(int)end.getY()].setValue("*");
        grid[x][y].setValue("B");
        end.setLocation(x, y);
    }
    
    public void setBlocked(int x, int y) {
        grid[x][y].setBlocked(true);
        grid[x][y].setValue("#");
    }
    
    public void setBlocked(List<Point> list) {
        Point point;
        for(int i = 0; i < list.size(); i++) {
            point = list.get(i);
            grid[(int)point.getX()][(int)point.getY()].setBlocked(true);
            grid[(int)point.getX()][(int)point.getY()].setValue("#");
        }
    }
    
    public void calculatePath() {
        calculateValue((int)start.getX(), (int)start.getY(), 0);
        grid[(int)start.getX()][(int)start.getX()].setValue("A");
    }
    
    private void calculateValue(int x, int y, int v) {
        if(isLegal(x, y)) {
            List<Point> list = new ArrayList<>();
            if(isLegal(x+1,y) && grid[x+1][y].getBlocked()) list.add(new Point(x+1, y));
            if(isLegal(x-1,y) && grid[x-1][y].getBlocked()) list.add(new Point(x-1, y));
            if(isLegal(x,y+1) && grid[x][y+1].getBlocked()) list.add(new Point(x, y+1));
            if(isLegal(x,y-1) && grid[x][y-1].getBlocked()) list.add(new Point(x, y-1));
            
            int lowest = v;
            
            for(int i = 0; i < list.size(); i++) {
                Point point = list.get(i);
                int compare = Integer.parseInt(grid[(int)point.getX()][(int)point.getY()].getValue());
                if(lowest > compare) lowest = compare;
            }
            
            grid[x][y].setValue("" + lowest);
            grid[x][y].setBlocked(true);
            
            for(int i = 0; i < list.size(); i++) {
                Point point = list.get(i);
                calculateValue((int)point.getX(), (int)point.getY(), v+1);
            }
        }
    }
    
    private boolean isLegal(int x, int y) {
        if((x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length)) {
            return true;
        }
        else return false;
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