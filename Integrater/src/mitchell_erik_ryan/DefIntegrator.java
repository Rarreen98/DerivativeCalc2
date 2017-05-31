package mitchell_erik_ryan;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

public class DefIntegrator
{
	public static JFrame frmDefiniteIntergrator;
	
	public static JTextField function;
	public static JTextField lowerBound;
	public static JTextField upperBound;
	public static JTextField result;
	public static JTextField deltaX;
	public static JTextField runtime;
	
	public static JScrollPane LRAM;
	public static JScrollPane RRAM;
	public static JScrollPane MRAM;
	public static JScrollPane SIMPSONS;
	
	public static JToggleButton btnLeftRiemannSum;
	public static JToggleButton btnRightRiemannSum;
	public static JToggleButton btnSimpsonsRule;
	public static JToggleButton btnMiddleRiemannSum;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					new DefIntegrator();
					frmDefiniteIntergrator.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public DefIntegrator()
	{
		initialize();
	}

	private void initialize()
	{
		//Frames
		frmDefiniteIntergrator = new JFrame();
		frmDefiniteIntergrator.setTitle("Definite Intergrator Approximator");
		frmDefiniteIntergrator.getContentPane().setBackground(Color.WHITE);
		frmDefiniteIntergrator.getContentPane().setLayout(null);
		frmDefiniteIntergrator.setResizable(false);
		frmDefiniteIntergrator.setBounds(100, 100, 580, 770);
		frmDefiniteIntergrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Panels
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 574, 741);
		frmDefiniteIntergrator.getContentPane().add(panel);
		panel.setLayout(null);
		
		//TextFields
		function = new JTextField();
		function.setFont(new Font("Tahoma", Font.PLAIN, 26));
		function.setBackground(Color.WHITE);
		function.setBounds(10, 38, 554, 32);
		panel.add(function);
		function.setColumns(10);
		
		lowerBound = new JTextField();
		lowerBound.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lowerBound.setBounds(180, 81, 40, 32);
		panel.add(lowerBound);
		lowerBound.setColumns(10);
		
		upperBound = new JTextField();
		upperBound.setFont(new Font("Tahoma", Font.PLAIN, 26));
		upperBound.setColumns(10);
		upperBound.setBounds(180, 123, 40, 32);
		panel.add(upperBound);
		
		result = new JTextField();
		result.setFont(new Font("Tahoma", Font.PLAIN, 26));
		result.setEditable(false);
		result.setBounds(106, 211, 458, 32);
		panel.add(result);
		result.setColumns(10);
		
		deltaX = new JTextField();
		deltaX.setFont(new Font("Tahoma", Font.BOLD, 46));
		deltaX.setText(".001");
		deltaX.setBounds(375, 81, 189, 74);
		panel.add(deltaX);
		deltaX.setColumns(10);
		
		//BUttons
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new Listener());
		calculate.setFont(new Font("Tahoma", Font.BOLD, 22));
		calculate.setBounds(10, 166, 554, 32);
		calculate.setFocusPainted(false);
		calculate.setBackground(Color.GRAY);
		calculate.setForeground(Color.GRAY);
		panel.add(calculate);
		
		//Scroll Panes				
		LRAM = new JScrollPane ();
		LRAM.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		LRAM.setSize(262, 117);
		LRAM.setLocation(10, 285);
		LRAM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		LRAM.add(new JTextArea());
		panel.add(LRAM);
		((AbstractButton) LRAM.getComponent(0)).setText("me me");
		
		RRAM = new JScrollPane();
		RRAM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		RRAM.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		RRAM.setBounds(10, 444, 262, 117);
		panel.add(RRAM);
		
		MRAM = new JScrollPane();
		MRAM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		MRAM.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		MRAM.setBounds(302, 285, 262, 117);
		panel.add(MRAM);
		
		SIMPSONS = new JScrollPane();
		SIMPSONS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		SIMPSONS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		SIMPSONS.setBounds(302, 444, 262, 117);
		panel.add(SIMPSONS);
		
		//Labels
		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblResult.setBounds(10, 209, 86, 34);
		panel.add(lblResult);
		
		JLabel lblFunction = new JLabel("Function:");
		lblFunction.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblFunction.setBounds(10, 11, 233, 26);
		panel.add(lblFunction);
		
		JLabel lblLowerBound = new JLabel("Lower Bound:");
		lblLowerBound.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLowerBound.setBounds(10, 81, 160, 32);
		panel.add(lblLowerBound);
			
		JLabel lblUpperBound = new JLabel("Upper Bound:");
		lblUpperBound.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUpperBound.setBounds(10, 123, 160, 32);
		panel.add(lblUpperBound);	
		
		JLabel lblLRAM = new JLabel("Left Riemann Sum");
		lblLRAM.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLRAM.setBounds(10, 254, 262, 26);
		panel.add(lblLRAM);
		
		JLabel lblRRAM = new JLabel("Right Riemann Sum");
		lblRRAM.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRRAM.setBounds(10, 410, 262, 32);
		panel.add(lblRRAM);
			
		JLabel lblMiddleRiemannSum = new JLabel("Middle Riemann Sum");
		lblMiddleRiemannSum.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMiddleRiemannSum.setBounds(302, 254, 262, 26);
		panel.add(lblMiddleRiemannSum);
		
		JLabel lblSimpsonsRule = new JLabel("Simpson's Rule");
		lblSimpsonsRule.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSimpsonsRule.setBounds(302, 413, 262, 26);
		panel.add(lblSimpsonsRule);
		
		JLabel lblDeltaX = new JLabel("\u2206X:");
		lblDeltaX.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblDeltaX.setBounds(302, 81, 63, 74);
		panel.add(lblDeltaX);
		
		JLabel lblMethodSelection = new JLabel("Method Selection");
		lblMethodSelection.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMethodSelection.setBounds(302, 572, 262, 26);
		panel.add(lblMethodSelection);
		
		JLabel lblTimeTaken = new JLabel("Time Taken (in ms):");
		lblTimeTaken.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTimeTaken.setBounds(10, 572, 262, 26);
		panel.add(lblTimeTaken);
		
		//Toggle Buttons
		btnLeftRiemannSum = new JToggleButton("Left Riemann Sum");
		btnLeftRiemannSum.setBounds(302, 603, 262, 25);
		btnLeftRiemannSum.addActionListener(new ToggleListener());
		btnLeftRiemannSum.setFocusPainted(false);
		panel.add(btnLeftRiemannSum);
		
		btnRightRiemannSum = new JToggleButton("Right Riemann Sum");
		btnRightRiemannSum.setBounds(302, 628, 262, 25);
		btnRightRiemannSum.addActionListener(new ToggleListener());
		btnRightRiemannSum.setFocusPainted(false);
		panel.add(btnRightRiemannSum);
		
		btnMiddleRiemannSum = new JToggleButton("Middle Riemann Sum");
		btnMiddleRiemannSum.setSelected(true);
		btnMiddleRiemannSum.setBounds(302, 653, 262, 25);
		btnMiddleRiemannSum.addActionListener(new ToggleListener());
		btnMiddleRiemannSum.setFocusPainted(false);
		panel.add(btnMiddleRiemannSum);
		
		btnSimpsonsRule = new JToggleButton("Simpson's Rule");
		btnSimpsonsRule.setBounds(302, 678, 262, 25);
		btnSimpsonsRule.addActionListener(new ToggleListener());
		btnSimpsonsRule.setFocusPainted(false);
		panel.add(btnSimpsonsRule);
		
		runtime = new JTextField();
		runtime.setBounds(10, 609, 262, 26);
		panel.add(runtime);
		runtime.setColumns(10);
	}
}