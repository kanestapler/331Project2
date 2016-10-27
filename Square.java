public class Square {
	
	public int xPos;
	public int yPos;
	private char value;
    private boolean blocked;
	
	public Square(boolean b) {
        blocked = b;
        value = '0';
	}
    
    public void setBlocked(boolean b) {
        blocked = b;
    }
	
	public void setValue(char x) {
		value = x;
	}
    
    public boolean getBlocked() {
        return blocked;
    }
	
	public char getValue() {
		if(blocked) return '#';
        else return value;
	}
	
}