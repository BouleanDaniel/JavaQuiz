import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Test implements ActionListener{
	// lista de intrebari
	String[] questions = 	{
								"Care este capitala Olandei?",
								"Care este capitala Germaniei?",
								"Care este capitala Turciei?",
								"Care este capitala Braziliei?",
								"Care este capitala Danemarcei?",
								"Care este capitala Elveției?",
								"Care este capitala Chinei?",
								"Care este capitala Serbiei?",
								"Care este capitala Australiei?",
								"Care este capitala Indiei?"
								
								
	// lista de raspunsuri							
							};
	String[][] options = 	{
								{"Amsterdam","Andorra la Vella","Nicosia","Roterdam"},
								{"Hamburg","Bonn","Berlin","Stockholm"},
								{"Istanbul","Ankara","Bodrum","Geneva"},
								{"Brasilia","Rio de Janeiro","Sao Paolo","Zurich"},
								{"Zurich","Geneva","Berna","Stockholm"},
								{"Stockholm","Copenhaga","Jakarta","Berna"},
								{"Rabat","Beijing","Hong Kong","Shanghai"},
								{"Sofia","Geneva","Bratislava","Belgrad"},
								{"Canberra","Cape Town","Bodrum","Sydney"},
								{"Delhi","New Delhi","Hamburg","Rabat"},
							};
	char[] answers = 		{
								'A',
								'C',
								'B',
								'A',
								'B',
								'D',
								'B',
								'D',
								'A',
								'B'
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
	// cronometrul pentru bara de progres
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
	
	public Test() {
        // setarile pentru frame-ul testului
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700,650);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		// textfield pentru afisarea numarului intrebarii
		textfield.setBounds(0,0,682,50);
		textfield.setBackground(Color.WHITE);
		textfield.setForeground(new Color(0,0,0));
		textfield.setFont(new Font("Arial",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		// text area pentru afisarea intrebarii
		textarea.setBounds(0,50,682,68);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(Color.WHITE);
		textarea.setForeground(Color.BLACK);
		textarea.setFont(new Font("Arial",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		// butonul pt varianta de raspuns A
		buttonA.setBounds(51,167,250,100);
		buttonA.setFont(new Font("Arial",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		// butonul pt varianta de raspuns B
		buttonB.setBounds(389,167,250,100);
		buttonB.setFont(new Font("Arial",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		// butonul pt varianta de raspuns C
		buttonC.setBounds(48,374,253,100);
		buttonC.setFont(new Font("Arial",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		// butonul pt varianta de raspuns D
		buttonD.setBounds(389,374,250,100);
		buttonD.setFont(new Font("Arial",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		// textul variantei de raspuns A
		answer_labelA.setBounds(48,268,253,106);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("Arial", Font.PLAIN, 20));
		// textul variantei de raspuns B
		answer_labelB.setBounds(389,268,250,106);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("Arial", Font.PLAIN, 20));
		// textul variantei de raspuns D
		answer_labelC.setBounds(48,477,253,93);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("Arial", Font.PLAIN, 20));
		// textul variantei de raspuns C
		answer_labelD.setBounds(389,477,250,93);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("Arial", Font.PLAIN, 20));
		// textfield pentru afisarea numarului de intrebari corecte din numarul de intrebari totale
		number_right.setBounds(247,213,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Arial",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		// textfield pentru cat % din intrebari au fost rezolvate corect
		percentage.setBounds(247,313,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Arial",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		// adaugam toate componentele
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
		// progressbar pentru cronometru
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
	public void nextQuestion() { // functia pentru selectarea intrebarii urmatoare
		
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
		// functia ce verifica apasarea unui buton de raspuns
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
		// funcia pentru afisarea raaspunsului corect prin schimbarea culorii raspunsurilor gresite in rosu
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
		
		Timer pause = new Timer(2000, new ActionListener() { // se pune pauza cronometrului atat timp cat se afisseaza raspunsul corect			
			@Override
			public void actionPerformed(ActionEvent e) {
				// resetarea culorii raspunsurilor si a cronometrului
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
		// afisarea la final a rezultatului testului (raspunsuri corecte / numar total de intrebari si cat % din intrebari au fost corecte)
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