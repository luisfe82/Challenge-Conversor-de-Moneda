package com.alura.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ventanaCalculadora extends JFrame {

	private JPanel panelCalculadora;
	private String cadenaNumeros = "", operacion = "nula";
	private double numero1 = 0, resultado = 0;
	private boolean activado = true, punto = true;
	private JLabel etiquetaNumeros, etiquetaMuestra;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

	public static void main(String[] args) {

		try {// Establecemos un estilo mejorado para nuetro JFrame
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
		} catch (InstantiationException ex) {
			// TODO: handle exception
		} catch (IllegalAccessException ex) {
			// TODO: handle exception
		} catch (UnsupportedLookAndFeelException ex) {
			// TODO: handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaCalculadora frame = new ventanaCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanaCalculadora() {
		setSize(387, 486);
		setTitle("Calculadora");
		setLocationRelativeTo(null);
		setResizable(false);

		initComponentes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void initComponentes() {
		colocarPanel();
		colocarMenu();
		colocarBotones();
		colocarBotonesNumeros();
		colocarEtiquetasResultados();
	}

	private void colocarPanel() {
		panelCalculadora = new JPanel();
		setContentPane(panelCalculadora);
	}

	private void colocarMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("Menu");
		menu1.setForeground(new Color(75, 0, 130));
		menu1.setFont(new Font("Roboto", Font.PLAIN, 14));
		menuBar.add(menu1);

		JMenuItem menuDivisas = new JMenuItem("Divisas");
		menuDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaDivisas divisas = new ventanaDivisas();
				divisas.setVisible(true);
				dispose();
			}
		});
		menuDivisas.setIcon(new ImageIcon(ventanaCalculadora.class.getResource("/com/alura/imagenes/divisas.png")));
		menuDivisas.setForeground(new Color(75, 0, 130));
		menuDivisas.setFont(new Font("Roboto", Font.PLAIN, 14));
		menu1.add(menuDivisas);

		JMenuItem menuTemperatura = new JMenuItem("Temperatura");
		menuTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaTemperatura temperatura = new ventanaTemperatura();
				temperatura.setVisible(true);
				dispose();
			}
		});
		menuTemperatura
				.setIcon(new ImageIcon(ventanaCalculadora.class.getResource("/com/alura/imagenes/temperatura.png")));
		menuTemperatura.setForeground(new Color(75, 0, 130));
		menuTemperatura.setFont(new Font("Roboto", Font.PLAIN, 14));
		menu1.add(menuTemperatura);

		JMenuItem menuCalculadora = new JMenuItem("Calculadora Estandar");
		menuCalculadora
				.setIcon(new ImageIcon(ventanaCalculadora.class.getResource("/com/alura/imagenes/calculadora.png")));
		menuCalculadora.setForeground(new Color(75, 0, 130));
		menuCalculadora.setFont(new Font("Roboto", Font.PLAIN, 14));
		menu1.add(menuCalculadora);

		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuSalir.setIcon(new ImageIcon(ventanaCalculadora.class.getResource("/com/alura/imagenes/salir.png")));
		menuSalir.setForeground(new Color(75, 0, 130));
		menuSalir.setFont(new Font("Roboto", Font.PLAIN, 14));
		menu1.add(menuSalir);
	}

	private void colocarEtiquetasResultados() {
		etiquetaNumeros = new JLabel("0");
		etiquetaNumeros.setHorizontalTextPosition(SwingConstants.LEADING);
		etiquetaNumeros.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaNumeros.setFont(new Font("Roboto", Font.PLAIN, 25));
		etiquetaNumeros.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GridBagConstraints gbc_etiquetaNumeros = new GridBagConstraints();
		gbc_etiquetaNumeros.gridwidth = 4;
		gbc_etiquetaNumeros.fill = GridBagConstraints.BOTH;
		gbc_etiquetaNumeros.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaNumeros.gridx = 0;
		gbc_etiquetaNumeros.gridy = 1;
		panelCalculadora.add(etiquetaNumeros, gbc_etiquetaNumeros);

		etiquetaMuestra = new JLabel("");
		etiquetaMuestra.setFont(new Font("Roboto", Font.PLAIN, 20));
		etiquetaMuestra.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		GridBagConstraints gbc_etiquetaMuestra = new GridBagConstraints();
		gbc_etiquetaMuestra.gridwidth = 0;
		gbc_etiquetaMuestra.fill = GridBagConstraints.BOTH;
		gbc_etiquetaMuestra.insets = new Insets(0, 0, 5, 0);
		gbc_etiquetaMuestra.gridx = 0;
		gbc_etiquetaMuestra.gridy = 0;
		panelCalculadora.add(etiquetaMuestra, gbc_etiquetaMuestra);

		JLabel lblNewLabel = new JLabel("Elaborado por Luis Felipe Ramos | Alura Latam | Oracle");
		lblNewLabel.setForeground(new Color(255, 255, 224));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(75, 0, 130));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 7;
		panelCalculadora.add(lblNewLabel, gbc_lblNewLabel);
	}

	private void colocarBotonesNumeros() {

		btn0 = new JButton("0");// ---------------------------------[0]
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "0";
				}else {
					cadenaNumeros += "0";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn0.setBackground(new Color(128, 128, 128));
		btn0.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 5, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 6;
		panelCalculadora.add(btn0, gbc_btn0);

		btn1 = new JButton("1");// ---------------------------------[1]
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "1";
				} else {
					cadenaNumeros += "1";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn1.setBackground(new Color(128, 128, 128));
		btn1.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 5;
		panelCalculadora.add(btn1, gbc_btn1);

		btn2 = new JButton("2");// ---------------------------------[2]
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "2";
				} else {
					cadenaNumeros += "2";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn2.setBackground(new Color(128, 128, 128));
		btn2.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 5;
		panelCalculadora.add(btn2, gbc_btn2);

		btn3 = new JButton("3"); // ---------------------------------[3]
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "3";
				} else {
					cadenaNumeros += "3";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn3.setBackground(new Color(128, 128, 128));
		btn3.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 5;
		panelCalculadora.add(btn3, gbc_btn3);

		btn4 = new JButton("4");// ---------------------------------[4]
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "4";
				} else {
					cadenaNumeros += "4";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn4.setBackground(new Color(128, 128, 128));
		btn4.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 4;
		panelCalculadora.add(btn4, gbc_btn4);

		btn5 = new JButton("5");// ---------------------------------[5]
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "5";
				} else {
					cadenaNumeros += "5";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn5.setBackground(new Color(128, 128, 128));
		btn5.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 4;
		panelCalculadora.add(btn5, gbc_btn5);

		btn6 = new JButton("6");// ---------------------------------[6]
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "6";
				} else {
					cadenaNumeros += "6";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn6.setBackground(new Color(128, 128, 128));
		btn6.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 4;
		panelCalculadora.add(btn6, gbc_btn6);

		btn7 = new JButton("7");// ---------------------------------[7]
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "7";
				} else {
					cadenaNumeros += "7";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn7.setBackground(new Color(128, 128, 128));
		btn7.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 3;
		panelCalculadora.add(btn7, gbc_btn7);

		btn8 = new JButton("8");// ---------------------------------[8]
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "8";
				} else {
					cadenaNumeros += "8";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn8.setBackground(new Color(128, 128, 128));
		btn8.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 3;
		panelCalculadora.add(btn8, gbc_btn8);

		btn9 = new JButton("9");// ---------------------------------[9]
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText()=="0") {
					cadenaNumeros = "9";
				} else {
					cadenaNumeros += "9";
				}
				etiquetaNumeros.setText(cadenaNumeros);
				activado = true;
			}
		});
		btn9.setBackground(new Color(128, 128, 128));
		btn9.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 3;
		panelCalculadora.add(btn9, gbc_btn9);
	}

	private void colocarBotones() {

		GridBagLayout gbl_panelCalculadora = new GridBagLayout();
		gbl_panelCalculadora.rowHeights = new int[] { 57, 57, 57, 57, 57, 57, 57, 57 };
		gbl_panelCalculadora.columnWidths = new int[] { 90, 90, 90, 90 };
		gbl_panelCalculadora.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_panelCalculadora.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelCalculadora.setLayout(gbl_panelCalculadora);

		JButton btnC = new JButton("C");// ---------------------------------[C]
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiquetaMuestra.setText("");
				etiquetaNumeros.setText("0");
				cadenaNumeros = "";
				operacion = "nula";
				activado = true;
				punto = true;
			}
		});
		btnC.setBackground(new Color(255, 215, 0));
		btnC.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 5, 5);
		gbc_btnC.gridx = 0;
		gbc_btnC.gridy = 2;
		panelCalculadora.add(btnC, gbc_btnC);

		JButton btnRaiz = new JButton("√");// ---------------------------------[raiz]
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText() != "0" && etiquetaNumeros.getText() != "0.") {
					numero1 = Double.parseDouble(cadenaNumeros);
					etiquetaMuestra.setText("sqrt[" + cadenaNumeros + "]");
					cadenaNumeros = "";
					resultado = Math.sqrt(numero1);
					etiquetaNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros = String.valueOf(resultado);

					punto = true;
				}

			}
		});
		btnRaiz.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnRaiz = new GridBagConstraints();
		gbc_btnRaiz.fill = GridBagConstraints.BOTH;
		gbc_btnRaiz.insets = new Insets(0, 0, 5, 5);
		gbc_btnRaiz.gridx = 1;
		gbc_btnRaiz.gridy = 2;
		panelCalculadora.add(btnRaiz, gbc_btnRaiz);

		JButton btnDivision = new JButton("÷");// ---------------------------------[division]
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activado == true && etiquetaNumeros.getText() != "0" && etiquetaNumeros.getText() != "0.") {
					numero1 = Double.parseDouble(cadenaNumeros);
					etiquetaMuestra.setText(cadenaNumeros + " / ");
					cadenaNumeros = "";
					operacion = "dividir";

					activado = false;
					punto = true;
				}
			}
		});
		btnDivision.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnDivision = new GridBagConstraints();
		gbc_btnDivision.fill = GridBagConstraints.BOTH;
		gbc_btnDivision.insets = new Insets(0, 0, 5, 5);
		gbc_btnDivision.gridx = 2;
		gbc_btnDivision.gridy = 2;
		panelCalculadora.add(btnDivision, gbc_btnDivision);

		JButton btnDelete = new JButton("DEL");// ---------------------------------[borrar]
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tamaño = cadenaNumeros.length();
				if (tamaño > 0) {
					if (tamaño == 1) {
						cadenaNumeros = "";
						etiquetaNumeros.setText("0");
					} else {
						cadenaNumeros = cadenaNumeros.substring(0, cadenaNumeros.length() - 1);
						etiquetaNumeros.setText(cadenaNumeros);
					}

				}
			}
		});
		btnDelete.setBackground(new Color(255, 140, 0));
		btnDelete.setFont(new Font("Roboto", Font.PLAIN, 15));
		btnDelete.setAlignmentX(0.5f);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 2;
		panelCalculadora.add(btnDelete, gbc_btnDelete);

		JButton btnMultiplicar = new JButton("X");// ---------------------------------[multiplicar]
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activado == true && etiquetaNumeros.getText() != "0" && etiquetaNumeros.getText() != "0.") {
					numero1 = Double.parseDouble(cadenaNumeros);
					etiquetaMuestra.setText(cadenaNumeros + " X ");
					cadenaNumeros = "";
					operacion = "multiplicar";

					activado = false;
					punto = true;
				}
			}
		});
		btnMultiplicar.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnMultiplicar.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnMultiplicar = new GridBagConstraints();
		gbc_btnMultiplicar.insets = new Insets(0, 0, 5, 0);
		gbc_btnMultiplicar.fill = GridBagConstraints.BOTH;
		gbc_btnMultiplicar.gridx = 3;
		gbc_btnMultiplicar.gridy = 3;
		panelCalculadora.add(btnMultiplicar, gbc_btnMultiplicar);

		JButton btnRestar = new JButton("-");// ---------------------------------[restar]
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activado == true && etiquetaNumeros.getText() != "0" && etiquetaNumeros.getText() != "0.") {
					numero1 = Double.parseDouble(cadenaNumeros);
					etiquetaMuestra.setText(cadenaNumeros + " - ");
					cadenaNumeros = "";
					operacion = "restar";

					activado = false;
					punto = true;
				}
			}
		});
		btnRestar.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnRestar = new GridBagConstraints();
		gbc_btnRestar.insets = new Insets(0, 0, 5, 0);
		gbc_btnRestar.fill = GridBagConstraints.BOTH;
		gbc_btnRestar.gridx = 3;
		gbc_btnRestar.gridy = 4;
		panelCalculadora.add(btnRestar, gbc_btnRestar);

		JButton btnSumar = new JButton("+");// ---------------------------------[sumar]
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activado == true && etiquetaNumeros.getText() != "0" && etiquetaNumeros.getText() != "0.") {
					numero1 = Double.parseDouble(cadenaNumeros);
					etiquetaMuestra.setText(cadenaNumeros + " + ");
					cadenaNumeros = "";
					operacion = "sumar";

					activado = false;
					punto = true;
				}
			}
		});
		btnSumar.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnSumar = new GridBagConstraints();
		gbc_btnSumar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSumar.fill = GridBagConstraints.BOTH;
		gbc_btnSumar.gridx = 3;
		gbc_btnSumar.gridy = 5;
		panelCalculadora.add(btnSumar, gbc_btnSumar);

		JButton btnNewButton_3 = new JButton("±");// ---------------------------------[negativo positivo]
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaNumeros.getText() != "0" && etiquetaNumeros.getText() != "0.") {
					if (cadenaNumeros.charAt(0) != '-') {
						cadenaNumeros = "-" + cadenaNumeros;
					} else {
						cadenaNumeros = cadenaNumeros.substring(1, cadenaNumeros.length());
					}
					etiquetaNumeros.setText(cadenaNumeros);
				}

			}
		});
		btnNewButton_3.setAlignmentX(0.5f);
		btnNewButton_3.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 6;
		panelCalculadora.add(btnNewButton_3, gbc_btnNewButton_3);

		JButton btnNewButton_1 = new JButton(".");// ----------------------------------------[Punto]
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (punto == true) {
					if (cadenaNumeros == "") {
						cadenaNumeros = "0.";
					} else {
						cadenaNumeros += ".";
					}
					etiquetaNumeros.setText(cadenaNumeros);
					punto = false;
				}

			}
		});
		btnNewButton_1.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 6;
		panelCalculadora.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton = new JButton("="); // --------------------------------(igual)
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double numero2;
				if (operacion.equals("nula") && etiquetaNumeros.getText() != "0"  && etiquetaNumeros.getText() != "0.") {
					etiquetaNumeros.setText(cadenaNumeros);
				} else if (operacion.equals("sumar")) {
					numero2 = Double.parseDouble(cadenaNumeros);
					resultado = numero1 + numero2;
					etiquetaNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros = String.valueOf(resultado);
					operacion = "nula";
				} else if (operacion.equals("restar")) {
					numero2 = Double.parseDouble(cadenaNumeros);
					resultado = numero1 - numero2;
					etiquetaNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros = String.valueOf(resultado);
					operacion = "nula";
				} else if (operacion.equals("multiplicar")) {
					numero2 = Double.parseDouble(cadenaNumeros);
					resultado = numero1 * numero2;
					etiquetaNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros = String.valueOf(resultado);
					operacion = "nula";
				} else if (operacion.equals("dividir")) {
					numero2 = Double.parseDouble(cadenaNumeros);
					resultado = numero1 / numero2;
					etiquetaNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros = String.valueOf(resultado);
					operacion = "nula";
				}
				etiquetaMuestra.setText("");
				activado = true;
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 6;
		panelCalculadora.add(btnNewButton, gbc_btnNewButton);

	}

}
