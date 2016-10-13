public class Square {
	
	public int xPos;
	public int yPos;
	private char value;
	
	public Square(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void SetValue(char x) {
		this.value = x;
	}
	
	public char GetValue() {
		return this.value;
	}
	
}