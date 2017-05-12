package com.mitchell.erik.apcalc.derivativecalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;

public class Main
{

	private JFrame frmGeneralFunctionDerivative;
	private JTextField numeratorInput;
	private JTextField denominatorInput;
	private JTextField numeratorOutput;
	private JTextField denominatorOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
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
		});
	}

	public Main()
	{
		initialize();
	}

	private void initialize()
	{
		frmGeneralFunctionDerivative = new JFrame();
		frmGeneralFunctionDerivative.setTitle("General Function Derivative Calculator");
		frmGeneralFunctionDerivative.setResizable(false);
		frmGeneralFunctionDerivative.setBounds(100, 100, 640, 455);
		frmGeneralFunctionDerivative.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneralFunctionDerivative.getContentPane().setLayout(null);
		
		JPanel screen = new JPanel();
		screen.setBounds(0, 0, 634, 428);
		frmGeneralFunctionDerivative.getContentPane().add(screen);
		screen.setLayout(null);
		
		numeratorInput = new JTextField();
		numeratorInput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		numeratorInput.setHorizontalAlignment(SwingConstants.CENTER);
		numeratorInput.setBounds(121, 80, 504, 46);
		numeratorInput.setColumns(10);
		screen.add(numeratorInput);
		
		denominatorInput = new JTextField();
		denominatorInput.setFont(new Font("Tahoma", Font.PLAIN, 36));
		denominatorInput.setHorizontalAlignment(SwingConstants.CENTER);
		denominatorInput.setText("1");
		denominatorInput.setBounds(121, 152, 504, 46);
		screen.add(denominatorInput);
		denominatorInput.setColumns(10);
		
		JLabel numeratorInputLbl = new JLabel("Numerator");
		numeratorInputLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		numeratorInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numeratorInputLbl.setBounds(21, 85, 90, 30);
		screen.add(numeratorInputLbl);
		
		JLabel denominatorInputLbl = new JLabel("Denominator");
		denominatorInputLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		denominatorInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		denominatorInputLbl.setBounds(10, 157, 101, 30);
		screen.add(denominatorInputLbl);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(121, 137, 504, 2);
		screen.add(separator);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(121, 377, 128, 30);
		screen.add(btnCalculate);
		
		numeratorOutput = new JTextField();
		numeratorOutput.setHorizontalAlignment(SwingConstants.CENTER);
		numeratorOutput.setEditable(false);
		numeratorOutput.setBounds(121, 250, 504, 46);
		screen.add(numeratorOutput);
		numeratorOutput.setColumns(10);
		
		denominatorOutput = new JTextField();
		denominatorOutput.setHorizontalAlignment(SwingConstants.CENTER);
		denominatorOutput.setEditable(false);
		denominatorOutput.setColumns(10);
		denominatorOutput.setBounds(121, 320, 504, 46);
		screen.add(denominatorOutput);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(121, 307, 504, 2);
		screen.add(separator_1);
		
		JLabel numeratorOutputLbl = new JLabel("Numerator");
		numeratorOutputLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		numeratorOutputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numeratorOutputLbl.setBounds(21, 255, 90, 30);
		screen.add(numeratorOutputLbl);
		
		JLabel denominatorOutputLbl = new JLabel("Denominator");
		denominatorOutputLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		denominatorOutputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		denominatorOutputLbl.setBounds(10, 325, 101, 30);
		screen.add(denominatorOutputLbl);
		
		JLabel outputLbl = new JLabel("Output");
		outputLbl.setHorizontalAlignment(SwingConstants.LEFT);
		outputLbl.setFont(new Font("Tahoma", Font.PLAIN, 42));
		outputLbl.setBounds(121, 197, 169, 51);
		screen.add(outputLbl);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(121, 11, 169, 58);
		screen.add(lblInput);
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblInput.setHorizontalAlignment(SwingConstants.LEFT);
	}
}