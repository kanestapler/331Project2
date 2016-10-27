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
        List<Point> list = new ArrayList<>();
        list.add(start);
        calculateValue(list, 0);
        grid[(int)start.getX()][(int)start.getY()].setValue("A");
        grid[(int)end.getX()][(int)end.getY()].setValue("B");
    }
    
    private void calculateValue(List<Point> list, int v) {
        List<Point> newList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(isLegal((int)list.get(i).getX(), (int)list.get(i).getY())) {
                int x = (int)list.get(i).getX();
                int y = (int)list.get(i).getY();
                grid[x][y].setValue("" + v);
                grid[x][y].setBlocked(true);
                
                if(isLegal(x+1,y) && !grid[x+1][y].getBlocked()) {
                    Point point = new Point(x+1, y);
                    if(!newList.contains(point)) newList.add(point);
                }
                if(isLegal(x-1,y) && !grid[x-1][y].getBlocked()) {
                    Point point = new Point(x-1, y);
                    if(!newList.contains(point)) newList.add(point);
                }
                if(isLegal(x,y+1) && !grid[x][y+1].getBlocked()) {
                    Point point = new Point(x, y+1);
                    if(!newList.contains(point)) newList.add(point);
                }
                if(isLegal(x,y-1) && !grid[x][y-1].getBlocked()) {
                    Point point = new Point(x, y-1);
                    if(!newList.contains(point)) newList.add(point);
                }
            }
        }
        if(newList.size() > 0) { calculateValue(newList, v+1); }
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