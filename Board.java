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
			   grid[i][j] = new Square(i,j);
		   }
	   }
	}
    
    public void setStart(int x, int y) {
        grid[x][y].setValue("0");
        start.setLocation(x, y);
    }
    
    public void setEnd(int x, int y) {
        grid[x][y].setValue("X");
        end.setLocation(x, y);
    }
    
    public void setBlocked(int x, int y) {
        grid[x][y].setBlocked(true);
        grid[x][y].setValue("#");
    }
    
    public void setBlocked(List<Point> list) {
        for (Point point : list) {
        	grid[(int)point.getX()][(int)point.getY()].setBlocked(true);
        	grid[(int)point.getX()][(int)point.getY()].setValue("#");
        }
    }
    
    public void Run() {
    	boolean haveIhitTheEnd = false;
    	Queue<Square> searchingQueue = new LinkedList<Square>();
    	searchingQueue.add(grid[start.x][start.y]);
    	while(!haveIhitTheEnd) {
    		Square currentSpot = searchingQueue.poll();
    		Square top = new Square(false);
    		Square bottom = new Square(false);
    		Square left = new Square(false);
    		Square right = new Square(false);
    		
    		if (IsThisInBounds(currentSpot.xVal, currentSpot.yVal-1)) {
        		top = grid[currentSpot.xVal][currentSpot.yVal-1];
        		if (DidIFindTheEnd(top)) {
        			haveIhitTheEnd = true;
        			break;
        		} else if (IsThisEmpty(top)) {
        			top.setValue(Integer.parseInt(currentSpot.getValue()) + 1);
        			searchingQueue.add(top);
        		}
    		}
    		if (IsThisInBounds(currentSpot.xVal, currentSpot.yVal+1)) {
    			bottom = grid[currentSpot.xVal][currentSpot.yVal+1];
        		if (DidIFindTheEnd(bottom)) {
        			haveIhitTheEnd = true;
        			break;
        		} else if (IsThisEmpty(bottom)) {
        			bottom.setValue(Integer.parseInt(currentSpot.getValue()) + 1);
        			searchingQueue.add(bottom);
        		}
    		}
    		if (IsThisInBounds(currentSpot.xVal-1, currentSpot.yVal)) {
    			left = grid[currentSpot.xVal-1][currentSpot.yVal];
        		if (DidIFindTheEnd(left)) {
        			haveIhitTheEnd = true;
        			break;
        		} else if (IsThisEmpty(left)) {
        			left.setValue(Integer.parseInt(currentSpot.getValue()) + 1);
        			searchingQueue.add(left);
        		}
    		}
    		if (IsThisInBounds(currentSpot.xVal+1, currentSpot.yVal)) {
    			right = grid[currentSpot.xVal+1][currentSpot.yVal];
        		if (DidIFindTheEnd(right)) {
        			haveIhitTheEnd = true;
        			break;
        		} else if (IsThisEmpty(right)) {
        			right.setValue(Integer.parseInt(currentSpot.getValue()) + 1);
        			searchingQueue.add(right);
        		}
    		}
    		
    	}
    	Backtrack();
    }


    private boolean IsThisEmpty(Square here) {
		return (here.getValue() == "*");
	}

	private boolean IsThisInBounds(int x, int y) {
        if((x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length)) {
            return true;
        }
        else return false;
    }

	private boolean DidIFindTheEnd(Square here) {
    	return (here.getValue() == "X");
    		
    }
	
	private void Backtrack() {
		boolean haveIhitTheStart = false;
		Stack<Square> searchingStack = new Stack<>();
		searchingStack.add(grid[end.x][end.y]);
    	while(!haveIhitTheStart) {
    		Square currentSpot = searchingStack.pop();
    		//currentSpot.setValue("Z");
    		
    		Square lowestSquare = new Square(false);
    		
    		Square top = new Square(false);
    		Square bottom = new Square(false);
    		Square left = new Square(false);
    		Square right = new Square(false);
    		
    		if (IsThisInBounds(currentSpot.xVal, currentSpot.yVal-1)) {
        		top = grid[currentSpot.xVal][currentSpot.yVal-1];
    		}
    		if (IsThisInBounds(currentSpot.xVal, currentSpot.yVal+1)) {
    			bottom = grid[currentSpot.xVal][currentSpot.yVal+1];
    		}
    		if (IsThisInBounds(currentSpot.xVal-1, currentSpot.yVal)) {
    			left = grid[currentSpot.xVal-1][currentSpot.yVal];
    		}
    		if (IsThisInBounds(currentSpot.xVal+1, currentSpot.yVal)) {
    			right = grid[currentSpot.xVal+1][currentSpot.yVal];
    		}
    		
    		lowestSquare = GetLowestValue(top, bottom, left, right);
    		
    		if (lowestSquare.getValue().equals("0")) {
    			haveIhitTheStart = true;
    		}
    		searchingStack.push(lowestSquare);
    		
    	}
		
	}
    
    
    
    
    
    
    
	private Square GetLowestValue(Square top, Square bottom, Square left, Square right) {
	
		int topInt = Integer.MAX_VALUE;
		int bottomInt = Integer.MAX_VALUE;
		int leftInt = Integer.MAX_VALUE;
		int rightInt = Integer.MAX_VALUE;
		
		if (top.getValue().matches("^-?\\d+$")) {
			topInt = Integer.parseInt(top.getValue());
		}
		if (bottom.getValue().matches("^-?\\d+$")) {
			bottomInt = Integer.parseInt(bottom.getValue());
		}
		if (left.getValue().matches("^-?\\d+$")) {
			leftInt = Integer.parseInt(left.getValue());
		}
		if (right.getValue().matches("^-?\\d+$")) {
			rightInt = Integer.parseInt(right.getValue());
		}
		
		if (topInt <= bottomInt && topInt <= leftInt && topInt <= rightInt) {
			if (topInt != 0) {
				top.setValue("-");
			}
			return top;
		} else if (bottomInt <= topInt && bottomInt <= leftInt && bottomInt <= rightInt) {
			if (bottomInt != 0) {
				bottom.setValue("-");
			}
			return bottom;
		} else if (leftInt <= topInt && leftInt <= bottomInt && leftInt <= rightInt) {
			if (leftInt != 0) {
				left.setValue("|");
			}
			return left;
		} else if (rightInt <= topInt && rightInt <= bottomInt && rightInt <= leftInt) {
			if (rightInt != 0) {
				right.setValue("|");
			}
			return right;
		}
		
		return null;
		
	}

//    public void calculatePath() {
//        List<Point> list = new ArrayList<>();
//        list.add(start);
//        calculateValue(list, 0);
//    }
//    
//    private void calculateValue(List<Point> list, int v) {
//        List<Point> newList = new ArrayList<>();
//        for(int i = 0; i < list.size(); i++) {
//            if(isLegal((int)list.get(i).getX(), (int)list.get(i).getY())) {
//                int x = (int)list.get(i).getX();
//                int y = (int)list.get(i).getY();
//                grid[x][y].setValue("" + v);
//                grid[x][y].setBlocked(true);
//                
//                if(isLegal(x+1,y) && !grid[x+1][y].getBlocked()) {
//                    Point point = new Point(x+1, y);
//                    if(!newList.contains(point)) newList.add(point);
//                }
//                if(isLegal(x-1,y) && !grid[x-1][y].getBlocked()) {
//                    Point point = new Point(x-1, y);
//                    if(!newList.contains(point)) newList.add(point);
//                }
//                if(isLegal(x,y+1) && !grid[x][y+1].getBlocked()) {
//                    Point point = new Point(x, y+1);
//                    if(!newList.contains(point)) newList.add(point);
//                }
//                if(isLegal(x,y-1) && !grid[x][y-1].getBlocked()) {
//                    Point point = new Point(x, y-1);
//                    if(!newList.contains(point)) newList.add(point);
//                }
//            }
//        }
//        if(newList.size() > 0) { calculateValue(newList, v+1); }
//    }
    
    
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
    
    public String getValue(int x, int y) {
    	return grid[x][y].getValue();
    }
}