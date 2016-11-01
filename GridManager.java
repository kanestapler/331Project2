import javax.swing.*;
import java.awt.*;

public class GridManager extends JFrame {
	
	Container contents;
	
	
	public GridManager(int x, int y, Board board) {
		super("Wire Routing");
		contents = getContentPane();
		contents.setLayout(new GridLayout(x,y));
		JTextField[][] squaresText = new JTextField[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				squaresText[i][j] = new JTextField();
				squaresText[i][j].setText(board.getValue(i,j));
				squaresText[i][j].setHorizontalAlignment(JTextField.CENTER);
				contents.add(squaresText[i][j]);
			}
		}
		
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	
}
