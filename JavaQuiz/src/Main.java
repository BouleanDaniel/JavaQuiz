import javax.swing.JFrame;

public class Main { // functia main ce face vizibila fereastra de login
	
    public static void main(String[] args) {

    	LoginFrame frame = new LoginFrame();
        frame.setTitle("Formular Logare");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
   
        }
  
 
}