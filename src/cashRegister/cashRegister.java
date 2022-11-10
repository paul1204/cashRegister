package cashRegister;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;

import items.Item;
import receipt.CustomerReceipt;
import receipt.MasterReceipt;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 


public class cashRegister {

	JFrame frame;
	
	private JTextField textField;
	private JTextField jtxtTax;
	private JTextField jtxtsub;
	private JTextField jtxttotal;
	private JTextField jtxtDisplay;
	private JTextField jtxtChange;
	private JTextField jtxtQty;

	    //table is for Current Sales
		//made public for other objects to use
		public JTable table;
		
		
		
		//table for sales report
		private JTable salesTable;
		private JList jSalesList;
		
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cashRegister window = new cashRegister();
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
	public cashRegister() {		
		initAws();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initAws() {
		
	}
	
	private void pushReceiptTOAWS(AmazonS3 s3, String bucket , String json, int transactionId ) throws IOException {	
		File parentReceipt = new File("/home/paul/Desktop/receipts/");
		FileWriter w = new FileWriter(parentReceipt);
		parentReceipt.createNewFile();
		
		String baseFile = "Receipt/";
		String storeNumber = "102/";
		String file = baseFile + storeNumber + Integer.toString(transactionId)+".json";
		
		
		w.write(json);
		w.close();
		s3.putObject(bucket, file  , parentReceipt );

	}
	
	private void initialize() {
		
		String bucket = "dailysalescollection";
		AWSCredentials credentials = new BasicAWSCredentials(
				  "AKIAVPZ34GDESFXLIJP5", 
				  "EfG4j1KTzVoAJE+lYRGoly7Z+R6jesUexlN44uKR"
				  
				);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		
		
		
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 303, 292);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		CloseShift shift = new CloseShift();
		CalcTotal tot = new CalcTotal();
		Till till = new Till(100.00);
		
		ArrayList<Item> toReceipt = new ArrayList<>();
		MasterReceipt receipt = new MasterReceipt();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		CustomerReceipt customerReceipt = new CustomerReceipt();
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn7.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn7.getText(); 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn7.setBounds(10, 11, 89, 50);
		panel.add(btn7);
		 
		JButton btn8 = new JButton("8");
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn8.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn8.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
				
				
			}
		});
		btn8.setBounds(109, 11, 89, 50);
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn9.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn9.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn9.setBounds(208, 11, 89, 50);
		panel.add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn4.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn4.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn4.setBounds(10, 72, 89, 50);
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn5.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn5.getText(); 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn5.setBounds(109, 72, 89, 50);
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn6.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn6.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn6.setBounds(208, 72, 89, 50);
		panel.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn1.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn1.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn1.setBounds(10, 133, 89, 34);
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn2.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn2.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
				
			}
		});
		btn2.setBounds(109, 133, 89, 34);
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn3.getText());
				}
				else {
					enterNum = jtxtDisplay.getText() + btn3.getText(); 
					jtxtDisplay.setText(enterNum);
				}
			}
		});
		btn3.setBounds(208, 133, 89, 34);
		panel.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn0.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn0.getText()  ; 
					jtxtDisplay.setText(enterNum);
				}
				
			}
		});
		btn0.setBounds(10, 239, 89, 23);
		panel.add(btn0);
		
		JButton btnDec = new JButton(".");
		btnDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!jtxtDisplay.getText().contains(".")) {
					jtxtDisplay.setText(jtxtDisplay.getText() + btnDec.getText());
					}
			}
		});
		btnDec.setBounds(109, 239, 89, 23);
		panel.add(btnDec);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtDisplay.setText(null);
				jtxtChange.setText(null);
			}
		});
		btnClear.setBounds(208, 239, 89, 23);
		panel.add(btnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(389, 11, 289, 292);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 328, 1401, 198);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 11, 443, 184);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTax.setBounds(10, 103, 158, 29);
		panel_3.add(lblTax);
		
		jtxtTax = new JTextField();
		jtxtTax.setBounds(204, 106, 210, 35);
		panel_3.add(jtxtTax);
		jtxtTax.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSubtotal.setBounds(10, 57, 158, 29);
		panel_3.add(lblSubtotal);
		
		jtxtsub = new JTextField();
		jtxtsub.setColumns(10);
		jtxtsub.setBounds(204, 60, 210, 35);
		panel_3.add(jtxtsub);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTotal.setBounds(10, 148, 158, 29);
		panel_3.add(lblTotal);
		
		jtxttotal = new JTextField();
		jtxttotal.setColumns(10);
		jtxttotal.setBounds(204, 142, 210, 35);
		panel_3.add(jtxttotal);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQty.setBounds(10, 17, 158, 29);
		panel_3.add(lblQty);
		
		jtxtQty = new JTextField();
		jtxtQty.setColumns(10);
		jtxtQty.setBounds(204, 14, 210, 35);
		panel_3.add(jtxtQty);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_1.setBounds(491, 11, 445, 155);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblDisplayCash = new JLabel("Display Cash");
		lblDisplayCash.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDisplayCash.setBounds(13, 62, 158, 29);
		panel_3_1.add(lblDisplayCash);
		
		
		
		jtxtDisplay = new JTextField();
	//	jtxtDisplay.setText(null);
		jtxtDisplay.setColumns(10);
		jtxtDisplay.setBounds(204, 57, 210, 35);
		panel_3_1.add(jtxtDisplay);
	
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChange.setBounds(10, 115, 158, 29);
		panel_3_1.add(lblChange);
		
		jtxtChange = new JTextField();
		jtxtChange.setColumns(10);
		jtxtChange.setBounds(204, 115, 210, 35);
		panel_3_1.add(jtxtChange);
		
		JLabel lblPayMethod = new JLabel("Pay Method");
		lblPayMethod.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPayMethod.setBounds(13, 11, 158, 29);
		panel_3_1.add(lblPayMethod);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Cash", "Credit Card", "EBT"}));
		comboBox.setBounds(204, 11, 210, 35);
		panel_3_1.add(comboBox);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_1_1.setBounds(946, 11, 379, 155);
		panel_2.add(panel_3_1_1);
		panel_3_1_1.setLayout(null);
		
	//	String d = jtxtDisplay.getText();
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String jsonString = "";

				
				if(comboBox.getSelectedItem().equals("Cash")) {
					
					CalcChange cashChange  = new CalcChange(tot, Double.parseDouble(jtxtDisplay.getText()));
					
					double change = cashChange.calcChange();
					
				    int transactionID = (int)Math.floor(Math.random()*(9999-0+1)+0);

				    receipt.pushTotalToReceipt(tot, transactionID);
				    
				    try {
						jsonString = mapper.writeValueAsString(receipt);
					} catch (JsonProcessingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				    
				    
					till.dispenseChange(change);					
					
					String s = String.format("%.2f", change) ;
					
					
					
					
					jtxtChange.setText(s);
					
					//cashChange.report(tot); ??
					
										
					shift.addSales(tot.getSubTotal());
					shift.addQty(tot.getQty());
					shift.addTax(tot.getTax());
					shift.addCogs(tot.getCogs());
					
					receipt.generateChildReceipt(customerReceipt);
					
					//Lets put this on another thread to execute
					try {
						pushReceiptTOAWS(s3client, bucket, jsonString, transactionID);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//Lets put this on another thread to execute
				}
				
				if(comboBox.getSelectedItem().equals("Credit Card")) {
					creditCardReader read = new creditCardReader();
					int pin = read.acceptPin();
					creditCardAuth auth = new creditCardAuth();
					if( (auth.auth(read.acceptCard(), pin, tot.getSubTotal()  ) == true) ) {
						
					     int transactionID = (int)Math.floor(Math.random()*(9999-0+1)+0);

						receipt.pushTotalToReceipt(tot, transactionID);
						
						jtxtChange.setText("Card Accepted!");

						
						shift.addSales(tot.getSubTotal());
						shift.addQty(tot.getQty());
						shift.addTax(tot.getTax());
						shift.addCogs(tot.getCogs());
					}
					else {
						jtxtChange.setText("Card Declined");
					}
				}
				}
				
		});
		
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPay.setBounds(26, 12, 89, 43);
		panel_3_1_1.add(btnPay);
		
		
		
		
		
		
		
		
		JButton btnNewButton_12_1 = new JButton("Print");
		btnNewButton_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageFormat header = new MessageFormat("Thank you for Shopping at The Store!");
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				
				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);
				}
				
				catch(java.awt.print.PrinterException ex) {
					System.err.format("No Printer Found", ex.getMessage());
				}
			
				
				
				
				
			}
		});
		btnNewButton_12_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12_1.setBounds(141, 12, 89, 43);
		panel_3_1_1.add(btnNewButton_12_1);
		
		JButton btnNewButton_12_2 = new JButton("Reset");
		btnNewButton_12_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tot.resetTotal();
				jtxtDisplay.setText(null);
				jtxtQty.setText(null);
				jtxtTax.setText(null);
				jtxtsub.setText(null);
				jtxttotal.setText(null);
				jtxtDisplay.setText(null);
				jtxtChange.setText(null);
				
				DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
				RecordTable.setRowCount(0);
			}
		});
		
		btnNewButton_12_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12_2.setBounds(243, 12, 105, 51);
		panel_3_1_1.add(btnNewButton_12_2);
		
		JButton btnNewButton_12_3 = new JButton("Exit");
		btnNewButton_12_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to Exit", "cashRegister", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					shift.reset();
					System.exit(0);
				}
			}
		});
		btnNewButton_12_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12_3.setBounds(141, 91, 148, 37);
		panel_3_1_1.add(btnNewButton_12_3);
		
		JButton btnNewButton_12_5 = new JButton("Report");
		btnNewButton_12_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File shiftReport = shift.close();
				
				LocalDateTime myDateObj = LocalDateTime.now();
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");

				String formattedDate = myDateObj.format(myFormatObj);
				String folder = "Sales/";
				//MM/DD/YY for date
				//String date = "010722";
				String ext = ".csv";
				String fileName = folder + formattedDate + ext;
				System.out.println(fileName + " this is going to the S3");
			
				s3client.putObject(bucket, fileName  , shiftReport );
				
			}
		});
		btnNewButton_12_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12_5.setBounds(26, 88, 105, 43);
		panel_3_1_1.add(btnNewButton_12_5);
		
//		JButton closeShift = new JButton("");
//		closeShift.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//MessageFormat header = new MessageFormat("Sales Report");
//				//MessageFormat footer = new MessageFormat("Page {0, number, integer}");
//				//DefaultTableModel model1 = (DefaultTableModel) salesTable.getModel();
//				//Double[] salesA = new Double[sales.size()];
//				
//				
//				
//			}
//		});
//		closeShift.setFont(new Font("Tahoma", Font.BOLD, 15));
//		closeShift.setBounds(142, 81, 105, 56);
//		panel_3_1_1.add(closeShift);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(984, 11, 427, 292);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton coffee = new JButton("");
		coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String name = "Coffee";
				double price = 2.59;
				String upcNumber = "1234";
				String size = "12oz";
				
				double cost = 1.00;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				Item coffee = new Item(name, price, upcNumber, size);
				
				//toReceipt.add(coffee);
				
				receipt.addItem(coffee);
				
				
				model.addRow(new Object[] {coffee.getName() , "1" , coffee.getPrice()});
		
				tot.generateTotal(price,cost, table);
				
				jtxtQty.setText(Integer.toString(tot.getQty()));
				jtxtsub.setText(String.format("%.2f",tot.getSubTotal()));
				jtxtTax.setText(String.format("%.2f",tot.getTax()));
				jtxttotal.setText(String.format("%.2f",tot.getTotal()));
			}
		});

		coffee.setIcon(new ImageIcon("../cashRegister/Icons/coffee.jpg"));
		coffee.setBounds(10, 18, 56, 58);
		panel_1_1.add(coffee);
		
		JButton btnNewButton_11_1 = new JButton("");
		btnNewButton_11_1.setBounds(10, 169, 73, 54);
		panel_1_1.add(btnNewButton_11_1);
		

		
		JButton coke = new JButton("");
		coke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = "Coke";
				double price = 2.59;
				String upcNumber = "2341";
				String size = "12oz";
				double cost = 1.00;
				Item coke = new Item(name, price, upcNumber, size);
				receipt.addItem(coke);
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {coke.getName() , "1" , coke.getPrice()});
		
				tot.generateTotal(price,cost, table);
				
				jtxtQty.setText(Integer.toString(tot.getQty()));
				jtxtsub.setText(String.format("%.2f",tot.getSubTotal()));
				jtxtTax.setText(String.format("%.2f",tot.getTax()));
				jtxttotal.setText(String.format("%.2f",tot.getTotal()));
				
			}
		});
		//coke.setIcon(new ImageIcon("C:\\Users\\pauls\\eclipse-workspace\\cashRegister\\Icons\\coke.jpg"));
		//coke.setIcon(new ImageIcon(""));
		coke.setIcon(new ImageIcon("../cashRegister/Icons/coke.jpg"));
		coke.setBounds(93, 18, 73, 54);
		panel_1_1.add(coke);
		
		JButton btnNewButton_11_1_2 = new JButton("");
		btnNewButton_11_1_2.setBounds(93, 87, 73, 54);
		panel_1_1.add(btnNewButton_11_1_2);
		
		JButton btnNewButton_11_1_1_1 = new JButton("");
		btnNewButton_11_1_1_1.setBounds(93, 169, 73, 54);
		panel_1_1.add(btnNewButton_11_1_1_1);
		
		JButton btnNewButton_11_3 = new JButton("");
		btnNewButton_11_3.setBounds(176, 18, 73, 54);
		panel_1_1.add(btnNewButton_11_3);
		
		JButton btnNewButton_11_1_3 = new JButton("");
		btnNewButton_11_1_3.setBounds(176, 87, 73, 54);
		panel_1_1.add(btnNewButton_11_1_3);
		
		JButton btnNewButton_11_1_1_2 = new JButton("");
		btnNewButton_11_1_1_2.setBounds(176, 169, 73, 54);
		panel_1_1.add(btnNewButton_11_1_1_2);
		
		JButton btnNewButton_11_2_1 = new JButton("");
		btnNewButton_11_2_1.setBounds(259, 19, 73, 54);
		panel_1_1.add(btnNewButton_11_2_1);
		
		JButton btnNewButton_11_1_2_1 = new JButton("");
		btnNewButton_11_1_2_1.setBounds(259, 87, 73, 54);
		panel_1_1.add(btnNewButton_11_1_2_1);
		
		JButton btnNewButton_11_1_1_1_1 = new JButton("");
		btnNewButton_11_1_1_1_1.setBounds(259, 169, 73, 54);
		panel_1_1.add(btnNewButton_11_1_1_1_1);
		
		JButton btnNewButton_11_2_1_1 = new JButton("");
		btnNewButton_11_2_1_1.setBounds(342, 19, 73, 54);
		panel_1_1.add(btnNewButton_11_2_1_1);
		
		JButton btnNewButton_11_1_2_1_1 = new JButton("");
		btnNewButton_11_1_2_1_1.setBounds(342, 87, 73, 54);
		panel_1_1.add(btnNewButton_11_1_2_1_1);
		
		JButton btnNewButton_11_1_1_1_1_1 = new JButton("");
		btnNewButton_11_1_1_1_1_1.setBounds(342, 169, 73, 54);
		panel_1_1.add(btnNewButton_11_1_1_1_1_1);
		
		JButton btnNewButton_11_1_1 = new JButton("");
		btnNewButton_11_1_1.setBounds(10, 88, 73, 54);
		panel_1_1.add(btnNewButton_11_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(773, 15, 187, 241);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel( new Object[][] {}, new String[] { "Items", "Qty", "Amount"}));
		
//		salesTable = new JTable();
//		salesTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Total Sales"} ));
//		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		
		scrollPane.setViewportView(table);
		//scrollPane.setViewportView(salesTable);
		
		textField = new JTextField();
		textField.setBounds(773, 267, 190, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
