public class Square {
	
	public int xVal;
	public int yVal;
	private String value;
    private boolean blocked;
	
	public Square(boolean b) {
        blocked = b;
        value = "*";
	}
	
	public Square(int x, int y) {
		blocked = false;
		xVal = x;
		yVal = y;
		value = "*";
	}
    
    public void setBlocked(boolean b) {
        blocked = b;
    }
	
	public void setValue(String x) {
		value = x;
	}
	
	public void setValue(int x) {
		value = Integer.toString(x);
	}
    
    public boolean getBlocked() {
        return blocked;
    }
	
	public String getValue() {
		return value;
	}
	
	public void setLocation(int x, int y) {
		xVal = x;
		yVal = y;
	}
	
}