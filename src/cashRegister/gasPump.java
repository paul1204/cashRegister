package cashRegister;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class gasPump {

	private JFrame frame;
	private JTextField totalPrice;
	private JTextField txtWelcomeToJava;
	private JTextField regularPrice;
	private JTextField midGradePrice;
	private JTextField premiumPrice;
	private JTextField pumpNumber;
	private JTextField pumpNumberhere;
	
	private gasPumps pump0;
	private gasPumps pump1;
	private gasPumps pump2;
	private gasPumps pump3;
	DecimalFormat d = new DecimalFormat("###.##");
	
	
	String space = "           ";
	private JTextField gallons;
	private JTextField total;
	private JTextField gallonAmount;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gasPump window = new gasPump();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gasPump() {
		initializePumps();
		initialize();
		
	}

	private void initializePumps() {
		pump0 = new gasPumps(1);
		pump1 = new gasPumps(2);
		pump2 = new gasPumps(3);
		pump3 = new gasPumps(4);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int n = -1;
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		totalPrice = new JTextField();
		totalPrice.setText(pump0.getPrice());
		totalPrice.setBounds(159, 58, 41, 30);
		frame.getContentPane().add(totalPrice);
		totalPrice.setColumns(10);
	
		txtWelcomeToJava = new JTextField();
		txtWelcomeToJava.setText("                           Live TV Is Currently Down! ");
		txtWelcomeToJava.setBounds(119, 102, 266, 159);
		frame.getContentPane().add(txtWelcomeToJava);
		txtWelcomeToJava.setColumns(10);
		
		
		
		
		JButton regularbutton = new JButton("87");
		regularbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pump0.selectGrade(0);
				totalPrice.setText(pump0.getPrice());
			}
		});
		regularbutton.setBounds(20, 317, 94, 64);
		frame.getContentPane().add(regularbutton);
		
		JButton midGradeButton = new JButton("89");
		midGradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pump0.selectGrade(1);
				totalPrice.setText(pump0.getPrice());
			}
		});
		midGradeButton.setBounds(192, 317, 94, 64);
		frame.getContentPane().add(midGradeButton);
		
		JButton premiumButton = new JButton("91");
		premiumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pump0.selectGrade(2);
				totalPrice.setText(pump0.getPrice());
			}
		});
		premiumButton.setBounds(381, 317, 94, 64);
		frame.getContentPane().add(premiumButton);
		
		JButton creditCardInsert = new JButton("Swipe Card");
		creditCardInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		creditCardInsert.setBounds(406, 102, 94, 53);
		frame.getContentPane().add(creditCardInsert);
		
		regularPrice = new JTextField();
		regularPrice.setBounds(34, 273, 41, 20);
		frame.getContentPane().add(regularPrice);
		regularPrice.setColumns(10);
		regularPrice.setText("           "+pump0.getRegular());
		
		midGradePrice = new JTextField();
		midGradePrice.setColumns(10);
		midGradePrice.setBounds(221, 272, 41, 20);
		frame.getContentPane().add(midGradePrice);
		midGradePrice.setText("           "+pump0.getMidGrade());
		
		premiumPrice = new JTextField();
		premiumPrice.setColumns(10);
		premiumPrice.setBounds(405, 273, 41, 20);
		frame.getContentPane().add(premiumPrice);
		premiumPrice.setText("           "+pump0.getPremium());
		
		pumpNumber = new JTextField();
		pumpNumber.setText("Pump Number");
		pumpNumber.setBounds(20, 11, 86, 40);
		frame.getContentPane().add(pumpNumber);
		pumpNumber.setColumns(10);
		
		pumpNumberhere = new JTextField();
		pumpNumberhere.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pumpNumberhere.setColumns(10);
		pumpNumberhere.setBounds(20, 66, 74, 30);
		frame.getContentPane().add(pumpNumberhere);
		pumpNumberhere.setText("           "+pump0.getPumpNumber());
		
		gallons = new JTextField();
		gallons.setColumns(10);
		gallons.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		gallons.setBounds(261, 60, 41, 30);
		frame.getContentPane().add(gallons);
		gallons.setText("           "+pump0.getGallons());
		
		total = new JTextField();
		total.setText("Total");
		total.setColumns(10);
		total.setBounds(136, 13, 86, 40);
		frame.getContentPane().add(total);
		
		gallonAmount = new JTextField();
		gallonAmount.setText("Gallons");
		gallonAmount.setColumns(10);
		gallonAmount.setBounds(248, 13, 86, 40);
		frame.getContentPane().add(gallonAmount);
	}
}
