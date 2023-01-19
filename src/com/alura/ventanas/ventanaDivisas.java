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
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ventanaDivisas extends JFrame {
	
	private JLabel etiquetaSignoMoneda1,etiquetaMoneda1,etiquetaSignoMoneda2,etiquetaMoneda2,etiquetaPiePrograma;
	private JComboBox<String> comboBoxMoneda1,comboBoxMoneda2;
	private String divisa1="",divisa2="",cantidad="";
	private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	private double dinero,cambio;
	private boolean punto = true;

	private JPanel panelCalculadora;

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
					ventanaDivisas frame = new ventanaDivisas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ventanaDivisas() {
		setSize(400, 486);
		setTitle("Conversor de Divisas");
		setLocationRelativeTo(null);
		
		initComponentes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void initComponentes() {
		colocarPanel();
		colocarMenu();	
		
		colocarEtiquetas();
		colocarComboBox();
		colocarBotonesNumeros();
		colocarPiePrograma();
		
	}
	
	private void obtenerDinero() {
		cantidad = etiquetaMoneda1.getText();
		dinero = Double.parseDouble(cantidad);
		cambioDivisas();
		dinero *= cambio;
		etiquetaMoneda2.setText(String.format("%.3f",dinero));
	}
	
	private void cambioDivisas() {
		//"Peso - Mexicano", "Estados Unidos - Dolar", "Europa - Euro", "Reino Unido - Libras Esterlinas", "Japonés - Yen", "Sur-coreano - Won"
		if(divisa1.equals(divisa2)) {
			cambio = 1;
		}else if(divisa1.equals("Peso - Mexicano") && divisa2.equals("Estados Unidos - Dolar")) {
			cambio = 0.054;
		}else if(divisa1.equals("Peso - Mexicano") && divisa2.equals("Europa - Euro")) {
			cambio = 0.050;
		}else if(divisa1.equals("Peso - Mexicano") && divisa2.equals("Reino Unido - Libras Esterlinas")) {
			cambio = 0.044;
		}else if(divisa1.equals("Peso - Mexicano") && divisa2.equals("Japonés - Yen")) {
			cambio = 7.03;
		}else if(divisa1.equals("Peso - Mexicano") && divisa2.equals("Sur-coreano - Won")) {
			cambio = 66.56;
		}else if(divisa1.equals("Estados Unidos - Dolar") && divisa2.equals("Peso - Mexicano")) {
			cambio = 18.68;
		}else if(divisa1.equals("Europa - Euro") && divisa2.equals("Peso - Mexicano")) {
			cambio = 20.12;
		}else if(divisa1.equals("Reino Unido - Libras Esterlinas") && divisa2.equals("Peso - Mexicano")) {
			cambio = 22.92;
		}else if(divisa1.equals("Japonés - Yen") && divisa2.equals("Peso - Mexicano")) {
			cambio = 0.14;
		}else if(divisa1.equals("Sur-coreano - Won") && divisa2.equals("Peso - Mexicano")) {
			cambio = 0.015;
		}
	}

	private void colocarPiePrograma() {
		etiquetaPiePrograma = new JLabel("Elaborado por Luis Felipe Ramos | Alura Latam | Oracle");
		etiquetaPiePrograma.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaPiePrograma.setForeground(new Color(255, 255, 255));
		etiquetaPiePrograma.setOpaque(true);
		etiquetaPiePrograma.setFont(new Font("Roboto", Font.PLAIN, 15));
		etiquetaPiePrograma.setBackground(new Color(75, 0, 130));
		GridBagConstraints gbc_etiquetaPiePrograma = new GridBagConstraints();
		gbc_etiquetaPiePrograma.fill = GridBagConstraints.BOTH;
		gbc_etiquetaPiePrograma.gridwidth = 4;
		gbc_etiquetaPiePrograma.gridx = 0;
		gbc_etiquetaPiePrograma.gridy = 8;
		panelCalculadora.add(etiquetaPiePrograma, gbc_etiquetaPiePrograma);
		
	}
	private void colocarBotonesNumeros() {
		btn0 = new JButton("0");     //-----------------------------------------[0]
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantidad != "") {
					if (etiquetaMoneda1.getText() == "0") {
						cantidad = "0";
					} else {
						cantidad +="0";
					}					
					etiquetaMoneda1.setText(cantidad);
					obtenerDinero();
				}				
			}
		});
		btn0.setBackground(new Color(128, 128, 128));
		btn0.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 5, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 7;
		panelCalculadora.add(btn0, gbc_btn0);
		
		btn1 = new JButton("1");                //--------------------------------------[|]
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "1";
				} else {
					cantidad +="1";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn1.setBackground(new Color(128, 128, 128));
		btn1.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 6;
		panelCalculadora.add(btn1, gbc_btn1);
		
		btn2 = new JButton("2");             //--------------------------------------[2]
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "2";
				} else {
					cantidad +="2";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn2.setBackground(new Color(128, 128, 128));
		btn2.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 6;
		panelCalculadora.add(btn2, gbc_btn2);
		
		btn3 = new JButton("3");           //--------------------------------------[3]
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "3";
				} else {
					cantidad +="3";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn3.setBackground(new Color(128, 128, 128));
		btn3.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 6;
		panelCalculadora.add(btn3, gbc_btn3);
		
		btn4 = new JButton("4");         //--------------------------------------[4]
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "4";
				} else {
					cantidad +="4";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn4.setBackground(new Color(128, 128, 128));
		btn4.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 5;
		panelCalculadora.add(btn4, gbc_btn4);
		
		btn5 = new JButton("5");       //--------------------------------------[5]
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "5";
				} else {
					cantidad +="5";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn5.setBackground(new Color(128, 128, 128));
		btn5.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 5;
		panelCalculadora.add(btn5, gbc_btn5);
		
		btn6 = new JButton("6");        //--------------------------------------[6]
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "6";
				} else {
					cantidad +="6";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn6.setBackground(new Color(128, 128, 128));
		btn6.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 5;
		panelCalculadora.add(btn6, gbc_btn6);
		
		btn7 = new JButton("7");        //--------------------------------------[7]
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "7";
				} else {
					cantidad +="7";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn7.setBackground(new Color(128, 128, 128));
		btn7.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 4;
		panelCalculadora.add(btn7, gbc_btn7);
		
		btn8 = new JButton("8");        //--------------------------------------[8]
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "8";
				} else {
					cantidad +="8";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn8.setBackground(new Color(128, 128, 128));
		btn8.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 4;
		panelCalculadora.add(btn8, gbc_btn8);
		
		btn9 = new JButton("9");        //--------------------------------------[9]
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (etiquetaMoneda1.getText() == "0") {
					cantidad = "9";
				} else {
					cantidad +="9";
				}
				etiquetaMoneda1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn9.setBackground(new Color(128, 128, 128));
		btn9.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 4;
		panelCalculadora.add(btn9, gbc_btn9);
		
	}
	private void colocarComboBox() {


		comboBoxMoneda1 = new JComboBox<String>();   //---------------------------[ComboBoxMoneda1]
		comboBoxMoneda1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				divisa1 =(String) comboBoxMoneda1.getSelectedItem();
				if(divisa1 == "Peso - Mexicano") {
					etiquetaSignoMoneda1.setText("$");
				}else if(divisa1 == "Estados Unidos - Dolar") {
					etiquetaSignoMoneda1.setText("$");
				}else if(divisa1 == "Europa - Euro") {
					etiquetaSignoMoneda1.setText("€");
				}else if(divisa1 == "Reino Unido - Libras Esterlinas") {
					etiquetaSignoMoneda1.setText("£");
				}else if(divisa1 == "Japonés - Yen") {
					etiquetaSignoMoneda1.setText("¥");
				}else if(divisa1 == "Sur-coreano - Won") {
					etiquetaSignoMoneda1.setText("W");
				}
				obtenerDinero();
			}
		});
		comboBoxMoneda1.setModel(new DefaultComboBoxModel<String>(new String[] {"Peso - Mexicano", "Estados Unidos - Dolar", "Europa - Euro", "Reino Unido - Libras Esterlinas", "Japonés - Yen", "Sur-coreano - Won"}));
		comboBoxMoneda1.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_comboBoxMoneda1 = new GridBagConstraints();
		gbc_comboBoxMoneda1.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxMoneda1.gridwidth = 4;
		gbc_comboBoxMoneda1.insets = new Insets(0, 50, 5, 50);
		gbc_comboBoxMoneda1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMoneda1.gridx = 0;
		gbc_comboBoxMoneda1.gridy = 1;
		panelCalculadora.add(comboBoxMoneda1, gbc_comboBoxMoneda1);
		
		comboBoxMoneda2 = new JComboBox<String>();  //---------------------------[ComboBoxMoneda2]
		comboBoxMoneda2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				divisa2 =(String) comboBoxMoneda2.getSelectedItem();
				if(divisa2 == "Peso - Mexicano") {
					etiquetaSignoMoneda2.setText("$");
				}else if(divisa2 == "Estados Unidos - Dolar") {
					etiquetaSignoMoneda2.setText("$");
				}else if(divisa2 == "Europa - Euro") {
					etiquetaSignoMoneda2.setText("€");
				}else if(divisa2 == "Reino Unido - Libras Esterlinas") {
					etiquetaSignoMoneda2.setText("£");
				}else if(divisa2 == "Japonés - Yen") {
					etiquetaSignoMoneda2.setText("¥");
				}else if(divisa2 == "Sur-coreano - Won") {
					etiquetaSignoMoneda2.setText("W");
				}
				obtenerDinero();
			}
		});
		comboBoxMoneda2.setModel(new DefaultComboBoxModel<String>(new String[] {"Peso - Mexicano", "Estados Unidos - Dolar", "Europa - Euro", "Reino Unido - Libras Esterlinas", "Japonés - Yen", "Sur-coreano - Won"}));
		comboBoxMoneda2.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_comboBoxMoneda2 = new GridBagConstraints();
		gbc_comboBoxMoneda2.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxMoneda2.gridwidth = 4;
		gbc_comboBoxMoneda2.insets = new Insets(0, 50, 5, 50);
		gbc_comboBoxMoneda2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMoneda2.gridx = 0;
		gbc_comboBoxMoneda2.gridy = 3;
		panelCalculadora.add(comboBoxMoneda2, gbc_comboBoxMoneda2);
		
	}
	private void colocarEtiquetas() {
		
		etiquetaSignoMoneda1 = new JLabel("$"); //---------------------------------------[$]
		etiquetaSignoMoneda1.setFont(new Font("Roboto", Font.PLAIN, 20));
		etiquetaSignoMoneda1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_etiquetaSignoMoneda1 = new GridBagConstraints();
		gbc_etiquetaSignoMoneda1.fill = GridBagConstraints.BOTH;
		gbc_etiquetaSignoMoneda1.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSignoMoneda1.gridx = 0;
		gbc_etiquetaSignoMoneda1.gridy = 0;
		panelCalculadora.add(etiquetaSignoMoneda1, gbc_etiquetaSignoMoneda1);
		
		etiquetaMoneda1 = new JLabel("0");    //---------------------------------------[0]
		etiquetaMoneda1.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_etiquetaMoneda1 = new GridBagConstraints();
		gbc_etiquetaMoneda1.fill = GridBagConstraints.BOTH;
		gbc_etiquetaMoneda1.gridwidth = 3;
		gbc_etiquetaMoneda1.insets = new Insets(0, 5, 5, 5);
		gbc_etiquetaMoneda1.gridx = 1;
		gbc_etiquetaMoneda1.gridy = 0;
		panelCalculadora.add(etiquetaMoneda1, gbc_etiquetaMoneda1);
		
		etiquetaSignoMoneda2 = new JLabel("$"); //---------------------------------------[$]
		etiquetaSignoMoneda2.setFont(new Font("Roboto", Font.PLAIN, 20));
		etiquetaSignoMoneda2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_etiquetaSignoMoneda2 = new GridBagConstraints();
		gbc_etiquetaSignoMoneda2.fill = GridBagConstraints.BOTH;
		gbc_etiquetaSignoMoneda2.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSignoMoneda2.gridx = 0;
		gbc_etiquetaSignoMoneda2.gridy = 2;
		panelCalculadora.add(etiquetaSignoMoneda2, gbc_etiquetaSignoMoneda2);
		
		etiquetaMoneda2 = new JLabel("0");     //---------------------------------------[0]
		etiquetaMoneda2.setFont(new Font("Roboto", Font.PLAIN, 20));
		GridBagConstraints gbc_etiquetaMoneda2 = new GridBagConstraints();
		gbc_etiquetaMoneda2.fill = GridBagConstraints.BOTH;
		gbc_etiquetaMoneda2.gridwidth = 3;
		gbc_etiquetaMoneda2.insets = new Insets(0, 5, 5, 5);
		gbc_etiquetaMoneda2.gridx = 1;
		gbc_etiquetaMoneda2.gridy = 2;
		panelCalculadora.add(etiquetaMoneda2, gbc_etiquetaMoneda2);
	}
	private void colocarPanel() {	
		panelCalculadora = new JPanel();
		setContentPane(panelCalculadora);
		
		GridBagLayout gbl_panelCalculadora = new GridBagLayout();
		gbl_panelCalculadora.columnWidths = new int[] {96, 96, 96, 96};
		gbl_panelCalculadora.rowHeights = new int[] {47, 47, 47, 47, 47, 47, 47, 47, 47};
		gbl_panelCalculadora.columnWeights = new double[]{1.0};
		gbl_panelCalculadora.rowWeights = new double[]{Double.MIN_VALUE};
		panelCalculadora.setLayout(gbl_panelCalculadora);		
		
		
		JButton btnC = new JButton("C");  //--------------------------------------[C]
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cantidad = "";
				punto = true;
				etiquetaMoneda1.setText("0");
				etiquetaMoneda2.setText("0");				
			}
		});
		btnC.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets(0, 0, 5, 0);
		gbc_btnC.gridx = 3;
		gbc_btnC.gridy = 4;
		panelCalculadora.add(btnC, gbc_btnC);
		
		
		
		JButton btnPunto = new JButton(".");  //---------------------------------------[.]
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (punto == true) {
					if (cantidad == "") {
						cantidad = "0.";
					}else {
						cantidad += ".";
					}
					etiquetaMoneda1.setText(cantidad);
					punto = false;
				}			
				
			}
		});
		btnPunto.setBackground(new Color(0, 255, 255));
		btnPunto.setFont(new Font("Roboto", Font.BOLD, 20));
		GridBagConstraints gbc_btnPunto = new GridBagConstraints();
		gbc_btnPunto.fill = GridBagConstraints.BOTH;
		gbc_btnPunto.insets = new Insets(0, 0, 5, 0);
		gbc_btnPunto.gridx = 3;
		gbc_btnPunto.gridy = 5;
		panelCalculadora.add(btnPunto, gbc_btnPunto);
		
		
		
		JButton btnDel = new JButton("DEL"); //----------------------------------------[DEL]
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tamaño = cantidad.length();
				if (tamaño > 0) {
					if (tamaño == 1) {
						cantidad = "0";
					}else {
						cantidad = cantidad.substring(0,cantidad.length()-1);
					}
					etiquetaMoneda1.setText(cantidad);
					obtenerDinero();
				}
			}
		});
		btnDel.setFont(new Font("Roboto", Font.BOLD, 20));
		btnDel.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.fill = GridBagConstraints.BOTH;
		gbc_btnDel.insets = new Insets(0, 0, 5, 0);
		gbc_btnDel.gridx = 3;
		gbc_btnDel.gridy = 6;
		panelCalculadora.add(btnDel, gbc_btnDel);		
				
		
	}
	
	private void colocarMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Menu");
		menu1.setForeground(new Color(75, 0, 130));
		menu1.setFont(new Font("Roboto", Font.PLAIN, 14));
		menuBar.add(menu1);
		
		JMenuItem menuDivisas = new JMenuItem("Divisas");
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
