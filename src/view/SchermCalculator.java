package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.Calculator;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermCalculator {

	private JFrame frame;
	private static String sDisplay;
	private static String sFormula;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String sDisplayInvoer, String sFormulaInvoer) 
	{
		sDisplay=sDisplayInvoer;
		sFormula=sFormulaInvoer;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchermCalculator window = new SchermCalculator();
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
	public SchermCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisplay = new JLabel("New label");
		lblDisplay.setFont(new Font("Stencil", Font.PLAIN, 46));
		lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplay.setBounds(32, 13, 535, 69);
		frame.getContentPane().add(lblDisplay);
		
		lblDisplay.setText(sDisplay);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnC.setBounds(324, 127, 97, 84);
		frame.getContentPane().add(btnC);
		btnC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnC.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btnBackspace = new JButton("<---");
		btnBackspace.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnBackspace.setBounds(32, 127, 243, 84);
		frame.getContentPane().add(btnBackspace);
		btnBackspace.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnBackspace.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn7.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		btn7.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn7.setBounds(32, 224, 97, 84);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn8.setBounds(178, 224, 97, 84);
		frame.getContentPane().add(btn8);
		btn8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn8.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn9.setBounds(324, 224, 97, 84);
		frame.getContentPane().add(btn9);
		btn9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn9.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn4.setBounds(32, 325, 97, 84);
		frame.getContentPane().add(btn4);
		btn4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn4.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn5.setBounds(178, 325, 97, 84);
		frame.getContentPane().add(btn5);
		btn5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn5.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn6.setBounds(324, 325, 97, 84);
		frame.getContentPane().add(btn6);
		btn6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn6.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn1.setBounds(32, 430, 97, 84);
		frame.getContentPane().add(btn1);
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn1.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn2.setBounds(178, 430, 97, 84);
		frame.getContentPane().add(btn2);
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn2.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn3.setBounds(324, 430, 97, 84);
		frame.getContentPane().add(btn3);
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn3.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btnChange = new JButton("+/-");
		btnChange.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnChange.setBounds(32, 535, 97, 84);
		frame.getContentPane().add(btnChange);
		btnChange.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnChange.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Stencil", Font.PLAIN, 46));
		btn0.setBounds(178, 535, 97, 84);
		frame.getContentPane().add(btn0);
		btn0.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btn0.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		JButton btnDecim = new JButton(".");
		btnDecim.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnDecim.setBounds(324, 535, 97, 84);
		frame.getContentPane().add(btnDecim);
		btnDecim.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnDecim.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btnDivide = new JButton("/");
		btnDivide.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnDivide.setBounds(470, 127, 97, 84);
		frame.getContentPane().add(btnDivide);
		btnDivide.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnDivide.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnMultiply.setBounds(470, 224, 97, 84);
		frame.getContentPane().add(btnMultiply);
		btnMultiply.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnMultiply.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnMinus.setBounds(470, 325, 97, 84);
		frame.getContentPane().add(btnMinus);
		btnMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnMinus.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnPlus.setBounds(470, 430, 97, 84);
		frame.getContentPane().add(btnPlus);
		btnPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnPlus.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		JButton btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Stencil", Font.PLAIN, 46));
		btnEquals.setBounds(470, 535, 97, 84);
		frame.getContentPane().add(btnEquals);
		btnEquals.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String sKnop=btnEquals.getText();
				String[] sWaarden=Calculator.InputCalculator(sDisplay, sFormula, sKnop);
				
				sDisplay=sWaarden[0];
				sFormula=sWaarden[1];
				lblDisplay.setText(sDisplay);
			}
		});
		
		
	}
	
	
	

}
