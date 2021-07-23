package cashRegister;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class cashRegister {

	private JFrame frame;
	
	private JTextField textField;
	private JTextField jtxtTax;
	private JTextField jtxtsub;
	private JTextField jtxttotal;
	private JTextField jtxtDisplay;
	private JTextField jtxtChange;
	private JTextField jtxtQty;

	    //table is for Current Sales
		private JTable table;
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	//================Functions=============================
	public void ItemCost(){
		double sum = 0;
		int qty = 0;
		double taxRate = 0.062;
		
		for(int i = 0; i < table.getRowCount(); i++) {
			sum += Double.parseDouble(table.getValueAt(i, 2).toString());
			qty += Double.parseDouble(table.getValueAt(i, 1).toString());
		}
		
		String StrQty = Integer.toString(qty);
		jtxtQty.setText(StrQty);
		
		String strSubtotal = String.format("$ %.2f", sum);
		jtxtsub.setText(strSubtotal);
		
		double csubTotal = sum;
		
		double cTax = csubTotal * taxRate;
		String strTax = String.format("$ %.2f", cTax);
		jtxtTax.setText(strTax);
		
		double total = csubTotal + cTax;
		String strTotal = String.format("$ %.2f", total);
		jtxttotal.setText(strTotal);  
		
		//Bar Code
		//String BarCode = String.format("Total is %.2f", total);
		//jtxtBarCode.setText(BarCode);
		//return 
	}
	
	


	
	//================Functions=============================
	public void Change(CloseShift shift) {
		double sum = 0; 
		double tax = 0.062;
		double cash = Double.parseDouble(jtxtDisplay.getText());
		
		
		for(int i = 0; i < table.getRowCount(); i++) {
			sum +=  Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		
		double cTax = (tax * sum);
		double absTotal = (sum + cTax);
		double cChange = (absTotal - cash);
		String change = String.format("$ %.2f", Math.abs(cChange));
		jtxtChange.setText(change);
		//shiftReport(shift);
		
		shift.addSales(sum);
		shift.addQty(table.getRowCount());
		shift.addTax(cTax);
		
		//shift.addCogs();
	}
	
	
	//================Functions=============================
	
	private void shiftReport(CloseShift shift) {
		
	}
	
	
	//================Functions=============================
	
	
	
	//================Functions=============================
	private void initialize() {
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
		
		//Data Structure to store sales information
		ArrayList<Double> sales = new ArrayList<Double>();
		ArrayList<Double> sales1 = new ArrayList<Double>();
		//Cost of Item
		ArrayList<Double> itemCost = new ArrayList<Double>();
		
		//To Store Quantity of Items
		ArrayList<Double> qtyArr = new ArrayList<Double>();
		
		//Taxes...
		ArrayList<Double> taxes = new ArrayList<Double>();
		
		
		
		
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enterNum = jtxtDisplay.getText();

				if(enterNum == "") {
					jtxtDisplay.setText(btn7.getText());
				}
				
				else {
					enterNum = jtxtDisplay.getText() + btn7.getText()  ; 
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
					enterNum = jtxtDisplay.getText() + btn5.getText()  ; 
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
					enterNum = jtxtDisplay.getText() + btn3.getText()  ; 
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
		
		JComboBox<?> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cash", "Credit Card", "EBT"}));
		comboBox.setBounds(204, 11, 210, 35);
		panel_3_1.add(comboBox);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_1_1.setBounds(974, 11, 417, 155);
		panel_2.add(panel_3_1_1);
		panel_3_1_1.setLayout(null);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().equals("Cash")) {
					Change(shift);
				}
				
				
				
				else {
					jtxtChange.setText("");
					jtxtDisplay.setText("");
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
		btnNewButton_12_1.setBounds(176, 11, 89, 43);
		panel_3_1_1.add(btnNewButton_12_1);
		
		JButton btnNewButton_12_2 = new JButton("Reset");
		btnNewButton_12_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnNewButton_12_2.setBounds(318, 11, 89, 43);
		panel_3_1_1.add(btnNewButton_12_2);
		
		JButton btnNewButton_12_3 = new JButton("Exit");
		btnNewButton_12_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to Exit", "cashRegisterTutorial", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_12_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12_3.setBounds(346, 107, 61, 37);
		panel_3_1_1.add(btnNewButton_12_3);
		
		JButton btnNewButton_12_5 = new JButton("Void Item");
		btnNewButton_12_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int RemoveItem = table.getSelectedRow();
				
				if(RemoveItem >= 0) {
					model.removeRow(RemoveItem);
				
				}
				
				//Re Calculates 
				ItemCost();
			}
		});
		btnNewButton_12_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12_5.setBounds(26, 88, 89, 43);
		panel_3_1_1.add(btnNewButton_12_5);
		
		JButton closeShift = new JButton("Close Shift");
		closeShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MessageFormat header = new MessageFormat("Sales Report");
				//MessageFormat footer = new MessageFormat("Page {0, number, integer}");
				//DefaultTableModel model1 = (DefaultTableModel) salesTable.getModel();
				//Double[] salesA = new Double[sales.size()];
				
				shift.close();
				
			}
		});
		closeShift.setFont(new Font("Tahoma", Font.BOLD, 15));
		closeShift.setBounds(176, 88, 136, 43);
		panel_3_1_1.add(closeShift);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(984, 11, 427, 292);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton jbtnScreenshot = new JButton("");
		jbtnScreenshot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				double price = 2.59;
				double cost = 1.00;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Coffee" , "1" , price});
				sales1.add(price);
				itemCost.add(cost);
				//subTotal(price, 1);
				ItemCost();
				
			
			}
		});
		jbtnScreenshot.setIcon(new ImageIcon("C:\\Users\\pauls\\Pictures\\Screenshots\\Screenshot (2).png"));
		jbtnScreenshot.setBounds(10, 18, 73, 54);
		panel_1_1.add(jbtnScreenshot);
		
		JButton btnNewButton_11_1 = new JButton("");
		btnNewButton_11_1.setBounds(10, 87, 73, 54);
		panel_1_1.add(btnNewButton_11_1);
		
		JButton btnNewButton_11_1_1 = new JButton("");
		btnNewButton_11_1_1.setBounds(10, 169, 73, 54);
		panel_1_1.add(btnNewButton_11_1_1);
		
		JButton btnNewButton_11_2 = new JButton("");
		btnNewButton_11_2.setBounds(93, 18, 73, 54);
		panel_1_1.add(btnNewButton_11_2);
		
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
