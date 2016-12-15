import javax.swing.JFrame;

//main function creates frame from class triangleUI
public class triangleFrame {
	public static void main(String[] args){
		JFrame frame = new JFrame("Triangles");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.getContentPane().add(new triangleUI());
		   frame.pack();
		   frame.setVisible(true);
	}
}
