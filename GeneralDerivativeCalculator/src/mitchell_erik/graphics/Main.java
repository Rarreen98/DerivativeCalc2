package mitchell_erik.graphics;

import static mitchell_erik.calculus.derivativecalc.Derivative.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Main
{

	private JFrame frmGeneralFunctionDerivative;
	private JTextField input;
	private JTextField output;

	public static void main(String[] args)
	{
		EventQueue.invokeLater
		(
				new Runnable()
				{
					public void run()
					{
						try
						{
							Main window = new Main();
							window.frmGeneralFunctionDerivative.setVisible(true);
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				}
				);
	}

	public Main()
	{
		initialize();
	}

	private void initialize()
	{
		frmGeneralFunctionDerivative = new JFrame();
		frmGeneralFunctionDerivative.setBackground(Color.RED);
		frmGeneralFunctionDerivative.setResizable(false);
		frmGeneralFunctionDerivative.setTitle("General Function Derivative Calculator (NO RATIONALS)");
		frmGeneralFunctionDerivative.setBounds(100, 100, 550, 348);
		frmGeneralFunctionDerivative.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneralFunctionDerivative.getContentPane().setLayout(null);

		JPanel screen = new JPanel();
		screen.setBackground(Color.WHITE);
		screen.setBounds(0, 0, 545, 320);
		frmGeneralFunctionDerivative.getContentPane().add(screen);
		screen.setLayout(null);

		input = new JTextField();
		input.setFont(new Font("Tahoma", Font.PLAIN, 36));
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setBounds(10, 80, 504, 46);
		input.setColumns(10);
		screen.add(input);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(10, 271, 128, 30);
		screen.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<String> result = regexChecker(input.getText(),"(\\\\+|\\-)\\d+\\x\\^");
				//String textOut = "";
				for(String curr : result)
				{
					System.out.println(curr);
				}
				//output.setText(textOut);
			}
		});

		output = new JTextField();
		output.setFont(new Font("Tahoma", Font.PLAIN, 36));
		output.setEditable(false);
		output.setForeground(Color.BLACK);
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setBounds(10, 199, 504, 46);
		screen.add(output);
		output.setColumns(10);

		JLabel outputLbl = new JLabel("Output");
		outputLbl.setHorizontalAlignment(SwingConstants.LEFT);
		outputLbl.setFont(new Font("Tahoma", Font.PLAIN, 42));
		outputLbl.setBounds(10, 137, 134, 51);
		screen.add(outputLbl);

		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(10, 11, 106, 58);
		screen.add(lblInput);
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblInput.setHorizontalAlignment(SwingConstants.LEFT);
	}
}