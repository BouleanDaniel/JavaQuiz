import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class MainMenu implements ActionListener {
	// declaratiile pentru butoanele de categorii + numele fiecaruia
	 JButton categoryO = new JButton("Capitale");
	 JButton categoryT = new JButton("Munti");
	 JButton categoryTh = new JButton("Rauri");
	 JButton resetCat = new JButton("Reset");
	 JFrame menu = new JFrame("Meniu");
	 
  public MainMenu() {
	  // setarile pentru frame-ul meniului
    menu.getContentPane().setBackground(Color.GRAY);
    menu.setTitle("Meniu Principal");
    menu.setBackground(Color.WHITE);
    
    menu.setResizable(false);
    menu.setSize(500, 400);

    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.getContentPane().setLayout(null);
    // butonul pentru prima categorie
    categoryO.setFont(new Font("Arial", Font.BOLD, 12));
    categoryO.setBounds(131, 57, 212, 30);
    categoryO.addActionListener(this);
    // buton pentru resetarea categoriilor
    resetCat.setFont(new Font("Arial", Font.BOLD, 12));
    resetCat.setBounds(131, 180, 212, 30);
    resetCat.addActionListener(this);
    // butonul pentru a doua categorie
    categoryT.setFont(new Font("Arial", Font.BOLD, 12));
    categoryT.setBounds(131, 98, 212, 30);
    categoryT.addActionListener(this);
    
    // JLabel pentru text
    JLabel categ = new JLabel("Selectati categoria");
    categ.setFont(new Font("Arial", Font.BOLD, 29));
    categ.setBounds(106, 11, 274, 35);
    menu.getContentPane().add(categ);
    
    // butonul pentru a treia categorie
    categoryTh.setFont(new Font("Arial", Font.BOLD, 12));
    categoryTh.setBounds(131, 139, 212, 30);
    categoryTh.addActionListener(this);
    
    // adaugam butoanele in frame
    menu.getContentPane().add(categoryO);
    menu.getContentPane().add(categoryT);
    menu.getContentPane().add(categoryTh);
    menu.getContentPane().add(resetCat);
    
    menu.setVisible(true);
    
  }
  public void actionPerformed(ActionEvent ae) { // verificarea apasarii butoanelor pentru categorii ce deschide fereastra testului selectat
    
    if (ae.getSource() == categoryO) {
    	Test testFrame = new Test();
        testFrame.setVisible(true);
        categoryO.setEnabled(false);
    }
    if (ae.getSource() == categoryT) {
    	Test1 test1Frame = new Test1();
        test1Frame.setVisible(true);
        categoryT.setEnabled(false);
        
    }
    if (ae.getSource() == categoryTh) {
    	Test2 test2Frame = new Test2();
        test2Frame.setVisible(true);
        categoryTh.setEnabled(false);
        
    }
    if (ae.getSource() == resetCat) {
        categoryO.setEnabled(true);
        categoryT.setEnabled(true);
        categoryTh.setEnabled(true);
    }
    
  }

  public static void main(String args[]) {
    new MainMenu();
  }
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}
}