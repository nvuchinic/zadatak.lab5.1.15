import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuessTheNumber extends JPanel {
	static JButton buttonBigger = new JButton("Bigger");
	static JButton buttonSmaller = new JButton("Smaller");
	static JButton buttonBingo = new JButton("Bingo");
	static JTextField field = new JTextField(20);
	static int end = 10000;
	static int start = 0;
	static int mid = (start + end) / 2;
	static String midString;
	static int counter=0;
	// static int guess;

	public static void main(String[] args) {
		JFrame window = new JFrame("Guess the number");
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field.setEditable(false);
		mid = (start + end) / 2;
		midString = Integer.toString(mid);

		field.setText(midString);
		// GuessTheNumber content=new GuessTheNumber();
		// window.setContentPane(content);
		window.setLayout(new FlowLayout());
		window.add(buttonBigger);
		buttonBigger.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				start = mid + 1;
				mid = (start + end) / 2;
				midString = Integer.toString(mid);
				field.setText(midString);
			}
		});

		window.add(buttonSmaller);
		buttonSmaller.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				counter++;
				end = mid - 1;
				mid = (start + end) / 2;
				midString = Integer.toString(mid);
				field.setText(midString);
			}
		});
		
		window.add(buttonBingo);
		buttonBingo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane pane = new JOptionPane();
				pane.showMessageDialog(null,"Ja sam pametan racunar, pogodio sam broj iz "+counter+" puta");
				end = 10000;
				start = 0;
				mid = (start + end) / 2;
				String midString;
				midString = Integer.toString(mid);
				field.setText(midString);
				counter=0;
			
				return;
			}
		});
		window.add(field);
		window.setVisible(true);
	}
}
