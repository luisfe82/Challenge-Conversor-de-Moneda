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
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ventanaTemperatura extends JFrame {
	
	private String Grados1="",Grados2="",cantidad="";
	private JPanel panelCalculadora;
	private JLabel etiquetaPiePrograma;
	private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	private JComboBox<String> comboBoxGrados2;
	private JLabel etiquetaGrados2;
	private JLabel etiquetaSimbolo2;
	private JLabel etiquetaSimbolo1;
	private JLabel etiquetaGrados1;
	private JComboBox<String> comboBoxGrados1;
	private boolean punto=true;
	private double grados=0,resultado=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {//Establecemos un estilo mejorado para nuetro JFrame
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
					ventanaTemperatura frame = new ventanaTemperatura();
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
	public ventanaTemperatura() {
		setSize(387, 486);
		setTitle("Conversor de Temperatura");
		setLocationRelativeTo(null);
		
		initComponentes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void initComponentes() {
		colocarPanel();
		colocarMenu();
		colocarBotonesNumeros();
		colocarEtiquetasGrados();
		colocarComboBox();
		colocarBotonesOperacion();
		
		colocarPiePrograma();			
	}
	
	private void obtenerGrados() {
		cantidad = etiquetaGrados1.getText();
		grados = Double.parseDouble(cantidad);
		cambioGrados();
		etiquetaGrados2.setText(String.format("%.2f",resultado));
	}

	private void cambioGrados() {
		//"Grado Celsius", "Grado Fahrenheit", "Grado Kelvin"
		if(Grados1.equals(Grados2)) {
			resultado = grados;
		}else if(Grados1.equals("Grado Celsius") && Grados2.equals("Grado Fahrenheit")) {
			resultado = (grados * 9/5) + 32;
		}else if(Grados1.equals("Grado Celsius") && Grados2.equals("Grado Kelvin")) {
			resultado = grados + 273.15;
		}else if(Grados1.equals("Grado Fahrenheit") && Grados2.equals("Grado Celsius")) {
			resultado = (grados - 32) * 5/9;
		}else if(Grados1.equals("Grado Fahrenheit") && Grados2.equals("Grado Kelvin")) {
			resultado = (grados - 32) * 5/9 + 273.15;
		}else if(Grados1.equals("Grado Kelvin") && Grados2.equals("Grado Celsius")) {
			resultado = grados - 273.15;
		}else if(Grados1.equals("Grado Kelvin") && Grados2.equals("Grado Fahrenheit")) {
			resultado = (grados - 273.15) * 9/5 + 32 ;
		}
		
	}

	private void colocarBotonesOperacion() {
		JButton btnC = new JButton("C");      //---------------------------------[C]
		btnC.setBackground(new Color(238, 130, 238));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidad = "";
				punto = true;
				resultado = 0;
				grados = 0;
				etiquetaGrados1.setText("0");
				etiquetaGrados2.setText("0");				
			}
		});
		btnC.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 5, 0);
		gbc_btnC.gridx = 3;
		gbc_btnC.gridy = 5;
		panelCalculadora.add(btnC, gbc_btnC);

		
		JButton btnPunto = new JButton(".");      //---------------------------------[punto]
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (punto == true) {
					if (cantidad == "") {
						cantidad = "0.";
					}else {
						cantidad += ".";
					}
					etiquetaGrados1.setText(cantidad);
					punto = false;
				}			
				
			}
		});
		btnPunto.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btnPunto = new GridBagConstraints();
		gbc_btnPunto.fill = GridBagConstraints.BOTH;
		gbc_btnPunto.insets = new Insets(0, 0, 5, 0);
		gbc_btnPunto.gridx = 3;
		gbc_btnPunto.gridy = 6;
		panelCalculadora.add(btnPunto, gbc_btnPunto);		

		
		JButton btnDelete = new JButton("DEL");      //---------------------------------[Borrar]
		btnDelete.setBackground(new Color(255, 140, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tamaño = cantidad.length();
				if (tamaño > 0) {
					if (tamaño == 1) {
						cantidad = "0";
					}else {
						cantidad = cantidad.substring(0,cantidad.length()-1);
					}
					etiquetaGrados1.setText(cantidad);
					obtenerGrados();
				}
			}
		});
		btnDelete.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 7;
		panelCalculadora.add(btnDelete, gbc_btnDelete);
		
	}

	private void colocarComboBox() {
		comboBoxGrados1 = new JComboBox<String>();           //-----------------------------[combobox1]
		comboBoxGrados1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grados1 =(String) comboBoxGrados1.getSelectedItem();
				if(Grados1 == "Grado Celsius") {
					etiquetaSimbolo1.setText("Grados Cº");
				}else if(Grados1 == "Grado Fahrenheit") {
					etiquetaSimbolo1.setText("Grados Fº");
				}else if(Grados1 == "Grado Kelvin") {
					etiquetaSimbolo1.setText("Grados Kº");
				}
				obtenerGrados();
			}
		});
		comboBoxGrados1.setModel(new DefaultComboBoxModel<String>(new String[] {"Grado Celsius", "Grado Fahrenheit", "Grado Kelvin"}));
		comboBoxGrados1.setFont(new Font("Roboto", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBoxGrados1 = new GridBagConstraints();
		gbc_comboBoxGrados1.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxGrados1.gridwidth = 3;
		gbc_comboBoxGrados1.insets = new Insets(0, 50, 5, 50);
		gbc_comboBoxGrados1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGrados1.gridx = 1;
		gbc_comboBoxGrados1.gridy = 2;
		panelCalculadora.add(comboBoxGrados1, gbc_comboBoxGrados1);
		
		
		comboBoxGrados2 = new JComboBox<String>();           //-----------------------------[combobox2]
		comboBoxGrados2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grados2 =(String) comboBoxGrados2.getSelectedItem();
				if(Grados2 == "Grado Celsius") {
					etiquetaSimbolo2.setText("Grados Cº");
				}else if(Grados2 == "Grado Fahrenheit") {
					etiquetaSimbolo2.setText("Grados Fº");
				}else if(Grados2 == "Grado Kelvin") {
					etiquetaSimbolo2.setText("Grados Kº");
				}
				obtenerGrados();
			}
		});
		comboBoxGrados2.setModel(new DefaultComboBoxModel<String>(new String[] {"Grado Celsius", "Grado Fahrenheit", "Grado Kelvin"}));
		comboBoxGrados2.setFont(new Font("Roboto", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBoxGrados2 = new GridBagConstraints();
		gbc_comboBoxGrados2.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxGrados2.gridwidth = 3;
		gbc_comboBoxGrados2.insets = new Insets(0, 50, 5, 50);
		gbc_comboBoxGrados2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGrados2.gridx = 1;
		gbc_comboBoxGrados2.gridy = 4;
		panelCalculadora.add(comboBoxGrados2, gbc_comboBoxGrados2);
		
	}

	private void colocarEtiquetasGrados() {
		etiquetaSimbolo1 = new JLabel("Grados");            //---------------------------[etiquetaSimbolo1]
		etiquetaSimbolo1.setFont(new Font("Roboto", Font.BOLD, 20));
		etiquetaSimbolo1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_etiquetaSimbolo1 = new GridBagConstraints();
		gbc_etiquetaSimbolo1.gridwidth = 2;
		gbc_etiquetaSimbolo1.fill = GridBagConstraints.BOTH;
		gbc_etiquetaSimbolo1.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSimbolo1.gridx = 0;
		gbc_etiquetaSimbolo1.gridy = 0;
		panelCalculadora.add(etiquetaSimbolo1, gbc_etiquetaSimbolo1);
		
		etiquetaGrados1 = new JLabel("0");                  //----------------------------[etiquetaGrados1]
		etiquetaGrados1.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_etiquetaGrados1 = new GridBagConstraints();
		gbc_etiquetaGrados1.fill = GridBagConstraints.BOTH;
		gbc_etiquetaGrados1.gridwidth = 2;
		gbc_etiquetaGrados1.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaGrados1.gridx = 2;
		gbc_etiquetaGrados1.gridy = 0;
		panelCalculadora.add(etiquetaGrados1, gbc_etiquetaGrados1);
		
		etiquetaSimbolo2 = new JLabel("Grados");         //----------------------------[etiquetaSimbolo12
		etiquetaSimbolo2.setFont(new Font("Roboto", Font.BOLD, 20));
		etiquetaSimbolo2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_etiquetaSimbolo2 = new GridBagConstraints();
		gbc_etiquetaSimbolo2.gridwidth = 2;
		gbc_etiquetaSimbolo2.fill = GridBagConstraints.BOTH;
		gbc_etiquetaSimbolo2.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSimbolo2.gridx = 0;
		gbc_etiquetaSimbolo2.gridy = 3;
		panelCalculadora.add(etiquetaSimbolo2, gbc_etiquetaSimbolo2);
		
		etiquetaGrados2 = new JLabel("0");                  //----------------------------[etiquetaGrados2]
		etiquetaGrados2.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_etiquetaGrados2 = new GridBagConstraints();
		gbc_etiquetaGrados2.fill = GridBagConstraints.BOTH;
		gbc_etiquetaGrados2.gridwidth = 2;
		gbc_etiquetaGrados2.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaGrados2.gridx = 2;
		gbc_etiquetaGrados2.gridy = 3;
		panelCalculadora.add(etiquetaGrados2, gbc_etiquetaGrados2);
		
	}

	private void colocarBotonesNumeros() {
		btn0 = new JButton("0");      //----------------------------------------[0]
		btn0.setBackground(new Color(128, 128, 128));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantidad != "") {
					if (etiquetaGrados1.getText() == "0") {
						cantidad = "0";
					} else {
						cantidad +="0";
					}					
					etiquetaGrados1.setText(cantidad);
					obtenerGrados();
				}				
			}
		});
		btn0.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 5, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 8;
		panelCalculadora.add(btn0, gbc_btn0);
		
		btn1 = new JButton("1");      //----------------------------------------[1]
		btn1.setBackground(new Color(128, 128, 128));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "1";
				} else {
					cantidad +="1";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn1.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 7;
		panelCalculadora.add(btn1, gbc_btn1);
		
		btn2 = new JButton("2");      //----------------------------------------[2]
		btn2.setBackground(new Color(128, 128, 128));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "2";
				} else {
					cantidad +="2";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn2.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 7;
		panelCalculadora.add(btn2, gbc_btn2);
		
		btn3 = new JButton("3");      //----------------------------------------[3]
		btn3.setBackground(new Color(128, 128, 128));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "3";
				} else {
					cantidad +="3";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn3.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 7;
		panelCalculadora.add(btn3, gbc_btn3);
		
		btn4 = new JButton("4");      //----------------------------------------[4]
		btn4.setBackground(new Color(128, 128, 128));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "4";
				} else {
					cantidad +="4";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn4.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 6;
		panelCalculadora.add(btn4, gbc_btn4);
		
		btn5 = new JButton("5");      //----------------------------------------[5]
		btn5.setBackground(new Color(128, 128, 128));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "5";
				} else {
					cantidad +="5";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn5.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 6;
		panelCalculadora.add(btn5, gbc_btn5);
		
		btn6 = new JButton("6");      //----------------------------------------[6]
		btn6.setBackground(new Color(128, 128, 128));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "6";
				} else {
					cantidad +="6";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn6.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 6;
		panelCalculadora.add(btn6, gbc_btn6);
		
		btn7 = new JButton("7");      //----------------------------------------[7]
		btn7.setBackground(new Color(128, 128, 128));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "7";
				} else {
					cantidad +="7";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn7.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 5;
		panelCalculadora.add(btn7, gbc_btn7);
		
		btn8 = new JButton("8");      //----------------------------------------[8]
		btn8.setBackground(new Color(128, 128, 128));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "8";
				} else {
					cantidad +="8";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn8.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 5;
		panelCalculadora.add(btn8, gbc_btn8);
		
		btn9 = new JButton("9");      //----------------------------------------[9]
		btn9.setBackground(new Color(128, 128, 128));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaGrados1.getText() == "0") {
					cantidad = "9";
				} else {
					cantidad +="9";
				}
				etiquetaGrados1.setText(cantidad);
				obtenerGrados();
			}
		});
		btn9.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 5;
		panelCalculadora.add(btn9, gbc_btn9);
		
	}

	private void colocarPiePrograma() {
		etiquetaPiePrograma = new JLabel("Elaborado por Luis Felipe Ramos | Alura Latam | Oracle");
		etiquetaPiePrograma.setForeground(new Color(255, 255, 255));
		etiquetaPiePrograma.setOpaque(true);
		etiquetaPiePrograma.setFont(new Font("Roboto", Font.PLAIN, 14));
		etiquetaPiePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPiePrograma.setBackground(new Color(75, 0, 130));
		GridBagConstraints gbc_etiquetaPiePrograma = new GridBagConstraints();
		gbc_etiquetaPiePrograma.fill = GridBagConstraints.BOTH;
		gbc_etiquetaPiePrograma.gridwidth = 4;
		gbc_etiquetaPiePrograma.gridx = 0;
		gbc_etiquetaPiePrograma.gridy = 9;
		panelCalculadora.add(etiquetaPiePrograma, gbc_etiquetaPiePrograma);
		
	}

	private void colocarPanel() {	
		panelCalculadora = new JPanel();
		setContentPane(panelCalculadora);
		
		GridBagLayout gbl_panelCalculadora = new GridBagLayout();   //--------------------Layout Bad 
		gbl_panelCalculadora.columnWidths = new int[] {96, 96, 96, 96};
		gbl_panelCalculadora.rowHeights = new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47, 47};
		gbl_panelCalculadora.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0};
		gbl_panelCalculadora.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0};
		panelCalculadora.setLayout(gbl_panelCalculadora);	
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
		menuTemperatura.setIcon(new ImageIcon(ventanaCalculadora.class.getResource("/com/alura/imagenes/temperatura.png")));
		menuTemperatura.setForeground(new Color(75, 0, 130));
		menuTemperatura.setFont(new Font("Roboto", Font.PLAIN, 14));
		menu1.add(menuTemperatura);
		
		JMenuItem menuCalculadora = new JMenuItem("Calculadora Estandar");
		menuCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaCalculadora calculadora = new ventanaCalculadora();
				calculadora.setVisible(true);
				dispose();
			}
		});
		menuCalculadora.setIcon(new ImageIcon(ventanaCalculadora.class.getResource("/com/alura/imagenes/calculadora.png")));
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
	
	

}
