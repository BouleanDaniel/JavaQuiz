import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Test2 implements ActionListener{
	
	String[] questions = 	{
								"De unde izvoraste raul Mures?",
								"De unde izvoraste raul Dambovita?",
								"De unde izvoraste raul Somesul Mare?",
								"De unde izvoraste raul Olt?",
								"De unde izvoraste raul Arges",
								"De unde izvoraste raul Bistrita?",
								"De unde izvoraste raul Ialomita?",
								"De unde izvoraste raul Târnava Mare?",
								"De unde izvoraste raul Trotus?",
								"De unde izvoraste raul Bega?"
							};
	String[][] options = 	{
								{"Obcina Feredeu","Munţii Hășmasu Mare","Muntii Rarau","Muntii Rodnei"},
								{"Muntii Bucegi","Muntii Piatra Craiului","Muntii Fagaraş","Masivul Ceahlu"},
								{"Muntii Rodnei"," Muntii Rarău","Muntii Apuseni","Muntii Bistritei"},
								{"Muntii Gurghiu","Muntii Bargau","Muntii Hasmasu Mare","Muntii Ciucas"},
								{"Muntii Iezer, Papusa","Muntii Fagaraş","Muntii Retezat","Muntii Ciucas"},
								{"Masivul Ceahlău","Munţii Rodnei","Muntii Bistriţeie","Muntii Baiului"},
								{"Muntii Baiului","Muntii Ciucas","Muntii Bucegi","Muntii Călimani"},
								{"Muntii Gurghiu","Muntii Giurgeu","Muntele Giumalau","Muntii Calimani"},
								{"Muntii Ciucului","Muntii Ciucas","Muntii Giurgeu","Muntii Apuseni"},
								{"Muntii Poiana Rusca","Muntii Apuseni","Muntii Semenic","Muntii Rarau"}
							};
	char[] answers = 		{
								'B',
								'C',
								'A',
								'C',
								'B',
								'B',
								'C',
								'A',
								'A',
								'A'
							};
	char guess;
	char answer;
	int index;
	int correct_guesses =0;
	int total_questions = questions.length;
	int result;
	int seconds=10;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	JProgressBar progressBar = new JProgressBar();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			progressBar.setValue(seconds);
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Test2() {
	
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700,650);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,682,50);
		textfield.setBackground(Color.WHITE);
		textfield.setForeground(new Color(0,0,0));
		textfield.setFont(new Font("Arial",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,682,68);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(Color.WHITE);
		textarea.setForeground(Color.BLACK);
		textarea.setFont(new Font("Arial",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(51,167,250,100);
		buttonA.setFont(new Font("Arial",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(389,167,250,100);
		buttonB.setFont(new Font("Arial",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(48,374,253,100);
		buttonC.setFont(new Font("Arial",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(389,374,250,100);
		buttonD.setFont(new Font("Arial",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(48,268,253,106);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("Arial", Font.PLAIN, 20));
		
		answer_labelB.setBounds(389,268,250,106);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("Arial", Font.PLAIN, 20));
		
		answer_labelC.setBounds(48,477,253,93);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("Arial", Font.PLAIN, 20));
		
		answer_labelD.setBounds(389,477,250,93);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("Arial", Font.PLAIN, 20));
		
		number_right.setBounds(247,213,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Arial",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(247,313,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Arial",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.getContentPane().add(answer_labelA);
		frame.getContentPane().add(answer_labelB);
		frame.getContentPane().add(answer_labelC);
		frame.getContentPane().add(answer_labelD);
		frame.getContentPane().add(buttonA);
		frame.getContentPane().add(buttonB);
		frame.getContentPane().add(buttonC);
		frame.getContentPane().add(buttonD);
		frame.getContentPane().add(textarea);
		frame.getContentPane().add(textfield);
		progressBar.setValue(10);
		progressBar.setMaximum(10);
		
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setFont(new Font("Arial", Font.PLAIN, 11));
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(10, 575, 662, 25);
		frame.getContentPane().add(progressBar);
		
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Intrebarea "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=10;
				progressBar.setValue(10);
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
		
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("REZULTAT:");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.getContentPane().add(number_right);
		frame.getContentPane().add(percentage);
		
	}
	
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}