package currencyMVC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CurrencyView extends JFrame
{
	private JPanel panel;
	private JTextField quantity;
	private JComboBox originCurrency;
	private JLabel toLabel;
	private JComboBox destinyCurrency;
	private JLabel result;
	private JButton calculateBtn;
	private JScrollPane solutionText;
	private JTextArea txtAreaReceive;
	public CurrencyView()
	{
		super("This is the best currency machine");
		
		//Instantiate the global variables
		panel= new JPanel();
		quantity= new JTextField("1",10);
		originCurrency= new JComboBox();
		toLabel= new JLabel("  to  ");
		destinyCurrency= new JComboBox();
		calculateBtn=new JButton("calculate");
		solutionText= new JScrollPane();
		result= new JLabel("SOLUTION");
		txtAreaReceive= new JTextArea();
		 
		//set default quantity to 1
		quantity.setToolTipText("1");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//add elements to the combo box
		originCurrency.addItem("Dollar");
		originCurrency.addItem("Pound");
		originCurrency.addItem("Zloty");
		originCurrency.addItem("Euro");
		
		destinyCurrency.addItem("Dollar");
		destinyCurrency.addItem("Pound");
		destinyCurrency.addItem("Zloty");
		destinyCurrency.addItem("Euro");
		
		
		
		//add elements to the panel
		
		panel.add(quantity);
		panel.add(originCurrency);
		panel.add(toLabel);
		panel.add(destinyCurrency);
		panel.add(calculateBtn);
		panel.add(result);
		panel.add(solutionText);
		
		this.add(panel);
		
		
		//addListener to Btn
		
		//this.calculateBtn.addActionListener(CalculationListener cal);
		
		//setFont
				Font fontAmount = new Font("Comic",Font.BOLD + Font.ITALIC,14);
				quantity.setFont(fontAmount);
				quantity.setForeground(Color.GREEN);
				result.setForeground(Color.BLUE);
				Font fontResult = new Font("Comic",Font.BOLD + Font.ITALIC,14);
				result.setFont(fontResult);
		
				//setSize
				txtAreaReceive.setColumns(50);
		        txtAreaReceive.setRows(10);
		        solutionText.setViewportView(txtAreaReceive);
				
		        txtAreaReceive.setLocation(20, 60);
				
		this.setSize(600,300);
		solutionText.setSize(500, 300);
		
		this.setVisible(true);
		
	}
	
	public double getAmount()
	{
		double amountDouble;
		amountDouble=Double.parseDouble(quantity.getText());
		
		return amountDouble;
	}
	
	public String getOriginCurrency()
	{
		return originCurrency.getSelectedItem().toString();
	}
	
	public String getDestinationCurrency()
	{
		return destinyCurrency.getSelectedItem().toString();
	}
	
	
	public void setConversionLabel(double solution)
	{
		result.setText(solution +" "+ getDestinationCurrency());
	}
	
	public static void main(String[] args) {
		CurrencyView view= new CurrencyView();
	}
	
	public void addCalculationListener(ActionListener listenForCalcButton)
	{
		
		calculateBtn.addActionListener(listenForCalcButton);
		
	}
	
	public void appendToTextSolution(double amount, String org, String dest, double solution)
	{
		txtAreaReceive.append(amount +"  "+org+" are "+solution+" "+ dest+"\n");
	}
	
	public void setFrameTitle()
	{
		this.setTitle("Exchange update at");
	}
		
}
