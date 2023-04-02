import javax.swing.*;

public class Launcher extends JFrame {

	private static Launcher instance = new Launcher();
	
	private void makeInterface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(final String[] args) {
		instance.makeInterface();
	}
	
}
