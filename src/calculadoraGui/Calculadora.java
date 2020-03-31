package calculadoraGui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculadora implements ActionListener {
	
	private static JTextField input;
	private static String valor1;
	private static String valor2;
	private static String operador;
	private static double resultado;
	
	Calculadora() {
		valor1 = valor2 = operador = "";
	}
	
	public static void crearVentana() {
		
		JFrame ventana = new JFrame();
		ventana.setTitle("Calculadora Simple");
		
		crearInterface(ventana);
		ventana.setBounds(500,300,200,200);;
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void crearInterface(JFrame ventana) {
		Calculadora calculadora = new Calculadora();
		JPanel lamina = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		input = new JTextField(10);
		input.setEditable(false);
		
		//Botones Numericos
		JButton boton0 = new JButton("0");
		JButton boton1 = new JButton("1");
		JButton boton2 = new JButton("2");
		JButton boton3 = new JButton("3");
		JButton boton4 = new JButton("4");
		JButton boton5 = new JButton("5");
		JButton boton6 = new JButton("6");
		JButton boton7 = new JButton("7");
		JButton boton8 = new JButton("8");
		JButton boton9 = new JButton("9");
		
		//Botones Operacionales
		JButton botonSuma = new JButton("+");
		JButton botonResta = new JButton("-");
		JButton botonMultiplicacion = new JButton("X");
		JButton botonDivision = new JButton("/");
		JButton botonIgual = new JButton("=");
		JButton botonDecimal = new JButton(".");
		JButton botonLimpiar = new JButton("C");
		
		//Mapeo de botones
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0; gbc.gridy = 0; lamina.add(boton1,gbc);
		gbc.gridx = 1; gbc.gridy = 0; lamina.add(boton2, gbc);
		gbc.gridx = 2; gbc.gridy = 0; lamina.add(boton3, gbc);
	    gbc.gridx = 3; gbc.gridy = 0; lamina.add(botonSuma, gbc);
	    gbc.gridx = 0; gbc.gridy = 1; lamina.add(boton4, gbc);
	    gbc.gridx = 1; gbc.gridy = 1; lamina.add(boton5, gbc);
	    gbc.gridx = 2; gbc.gridy = 1; lamina.add(boton6, gbc);
	    gbc.gridx = 3; gbc.gridy = 1; lamina.add(botonResta, gbc);
	    gbc.gridx = 0; gbc.gridy = 2; lamina.add(boton7, gbc);
	    gbc.gridx = 1; gbc.gridy = 2; lamina.add(boton8, gbc);
	    gbc.gridx = 2; gbc.gridy = 2; lamina.add(boton9, gbc);
	    gbc.gridx = 3; gbc.gridy = 2; lamina.add(botonMultiplicacion, gbc);
	    gbc.gridx = 0; gbc.gridy = 3; lamina.add(botonDecimal, gbc);
	    gbc.gridx = 1; gbc.gridy = 3; lamina.add(boton0, gbc);
	    gbc.gridx = 2; gbc.gridy = 3; lamina.add(botonLimpiar, gbc);
	    gbc.gridx = 3; gbc.gridy = 3; lamina.add(botonDivision, gbc);
	    gbc.gridwidth = 3;

	    gbc.gridx = 0; gbc.gridy = 4; lamina.add(input, gbc);        
	    gbc.gridx = 3; gbc.gridy = 4; lamina.add(botonIgual, gbc);
	    ventana.getContentPane().add(lamina, BorderLayout.CENTER); 
	    
	    //Mapeo de Eventos
	    boton0.addActionListener(calculadora);
	    boton1.addActionListener(calculadora);
	    boton2.addActionListener(calculadora);
	    boton3.addActionListener(calculadora);
	    boton4.addActionListener(calculadora);
	    boton5.addActionListener(calculadora);
	    boton6.addActionListener(calculadora);
	    boton7.addActionListener(calculadora);
	    boton8.addActionListener(calculadora);
	    boton9.addActionListener(calculadora);
	    
	    botonSuma.addActionListener(calculadora);
	    botonResta.addActionListener(calculadora);
	    botonMultiplicacion.addActionListener(calculadora);
	    botonDivision.addActionListener(calculadora);
	    botonDecimal.addActionListener(calculadora);
	    botonLimpiar.addActionListener(calculadora);
	    botonIgual.addActionListener(calculadora);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.charAt(0) == 'C') {
			input.setText("");
			valor1 = valor2 = operador = "";
		} else if (comando.charAt(0) == '=') {
			input.setText(calcular(input.getText()));
		} else {
			input.setText(input.getText() + comando);
		}
	}
	
	public static String calcular(String expresion) {
		char[] array = expresion.toCharArray();
		valor1 = valor2 = operador = "";
		resultado = 0;
		
		for (int i = 0; i<array.length; i++) {
			if ((array[i] >= '0' && array[i] <= '9') || array[i] == '.') {
				if (operador.isEmpty()) {
					valor1 += array[i];
				} else {
					valor2 += array[i];
				}
			} else if (array[i] == '+' || array[i] == '-' || array[i] == 'X' || array[i] == '/') {
				operador += array[i];
			}
		}
		
		switch (operador) {
			case "+":
				resultado = (Double.parseDouble(valor1)) + (Double.parseDouble(valor2));
				break;
			case "-":
				resultado = (Double.parseDouble(valor1)) - (Double.parseDouble(valor2));
				break;
			case "X":
				resultado = (Double.parseDouble(valor1)) * (Double.parseDouble(valor2));
				break;
			case "/":
				resultado = (Double.parseDouble(valor1)) / (Double.parseDouble(valor2));
				break;
		}
		return valor1 + operador + valor2 + "=" + resultado;
	}
	
}