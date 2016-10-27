public class Square {
	
	public int xPos;
	public int yPos;
	private String value;
    private boolean blocked;
	
	public Square(boolean b) {
        blocked = b;
        value = "*";
	}
    
    public void setBlocked(boolean b) {
        blocked = b;
    }
	
	public void setValue(String x) {
		value = x;
	}
    
    public boolean getBlocked() {
        return blocked;
    }
	
	public String getValue() {
		return value;
	}
	
}