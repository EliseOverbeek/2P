package view;




	import java.io.*;
	import java.net.*;
	import java.util.Observable;
	import java.util.Observer;
	import java.awt.*;
	import java.awt.event.*;
	import java.awt.geom.*;
	import javax.swing.*;
	import java.awt.Color;
	import java.awt.Component;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.geom.Ellipse2D;
	import java.awt.Stroke;
	import java.awt.BasicStroke;
	import java.awt.Dimension;

	import java.awt.EventQueue;

	import javax.swing.JPanel;
	import javax.swing.JFrame;

	

	public class ClientGUI extends JFrame implements ActionListener, KeyListener,
			Observer {

		private JButton bConnect, bEndGame, bHint, bNewGame, bMakeMove;
		private JTextField tfPort, myText, myName, fieldNumber, colorStone,
				stoneSize, AITime;
		JTextField tfAddress;
		private JTextArea taMessages;

		
		JButton[] fields = new JButton[81];


		

		/** Construeert een ClientGUI object. */
		public ClientGUI() {
			super("Client GUI");
			buildGUI();
			setVisible(true);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					e.getWindow().dispose();
				}

				public void windowClosed(WindowEvent e) {
					System.exit(0);
				}
			});
		}

		/** Bouwt de daadwerkelijke GUI. */
		private void buildGUI() {
			setSize(600, 600);
			// -----------------------------------------------------------------------
			// Panel p1 - Listen
			// JPanel Total = new JPanel(new GridLayout(3,2));
			// Total.add(p1);

			JPanel p1 = new JPanel(new FlowLayout());
			JPanel pp = new JPanel(new GridLayout(3, 2));

			JLabel lbAddress = new JLabel("Address: ");
			tfAddress = new JTextField("", 12);
			tfAddress.addKeyListener(this);

			JLabel lbPort = new JLabel("Port:");
			tfPort = new JTextField("2727", 5);
			tfPort.addKeyListener(this);

			JLabel lbName = new JLabel("Name:");
			myName = new JTextField("", 15);
			myName.addKeyListener(this);

			pp.add(lbAddress);
			pp.add(tfAddress);
			pp.add(lbPort);
			pp.add(tfPort);
			pp.add(lbName);
			pp.add(myName);

			bConnect = new JButton("Connect");
			bConnect.addActionListener(this);
			bConnect.setEnabled(false);
			// --------------------------------------------------------------------------
			// knoppen voor het spel
			bEndGame = new JButton("Spel beeindigen");
			bEndGame.addActionListener(this);
			bEndGame.setEnabled(true);

			bNewGame = new JButton("Nieuw spel starten");
			bNewGame.addActionListener(this);
			bNewGame.setEnabled(true);

			bHint = new JButton("Hint");
			bHint.addActionListener(this);
			bHint.setEnabled(true);

			bMakeMove = new JButton("doe zet");
			bMakeMove.addActionListener(this);
			bMakeMove.setEnabled(true);
			// ----------------------------------------------------------------------

			p1.add(pp, BorderLayout.WEST);
			p1.add(bConnect, BorderLayout.EAST);

			// Panel p2 - Messages

			JPanel p2 = new JPanel();
			p2.setLayout(new BorderLayout());

			JLabel lbMessages = new JLabel("Messages:");
			taMessages = new JTextArea("", 15, 50);
			taMessages.setEnabled(false);
			p2.add(lbMessages);
			p2.add(taMessages, BorderLayout.SOUTH);

			// Panel p3 - My Message
			JPanel p3 = new JPanel();
			p3.setLayout(new BorderLayout());

			JLabel lbMyMessage = new JLabel("My message:");
			myText = new JTextField("", 50);
			myText.setEnabled(false);
			myText.addActionListener(this);
			p3.add(lbMyMessage);
			p3.add(myText, BorderLayout.SOUTH);

			JPanel pp2 = new JPanel();
			pp2.add(p1);
			pp2.add(p2);
			pp2.add(p3);

			// -------------------------------------------------------------------
			// Jpanel voor de knoppen en invoer door gebruiker
			JPanel p4 = new JPanel();
			p4.setLayout(new GridLayout(8, 2));

			JLabel lbFieldNumber = new JLabel("veldnummer:");
			fieldNumber = new JTextField("", 15);
			fieldNumber.addKeyListener(this);

			JLabel lbColorStone = new JLabel("kleur van de steen:");
			colorStone = new JTextField("", 15);
			colorStone.addKeyListener(this);

			

			JLabel lbAITime = new JLabel("Tijd voor de AI:");
			AITime = new JTextField("", 15);
			AITime.addKeyListener(this);

			JLabel lbHint = new JLabel("Hint die door de AI gegeven wordt: ");

			JLabel lbEmpty = new JLabel("");
			JLabel lbEmpty2 = new JLabel("");
			JLabel lbEmpty3 = new JLabel("");

			JLabel lbInfo = new JLabel("Je hebt nog x stenen van kleur y");

			p4.add(bNewGame);
			p4.add(bEndGame);
			p4.add(bHint);
			p4.add(lbHint);
			p4.add(lbFieldNumber);
			p4.add(fieldNumber, BorderLayout.SOUTH);
			p4.add(lbColorStone);
			p4.add(colorStone, BorderLayout.SOUTH);
			
			p4.add(lbAITime);
			p4.add(AITime);
			p4.add(lbEmpty2);
			p4.add(lbInfo);
			p4.add(lbEmpty3);
			p4.add(bMakeMove);

			// --------------------------------------------------------
			// het daadwerkelijke spelbord
			JPanel p5 = new JPanel();

			p5.setLayout(new GridLayout(9, 9));

			JFrame j = new JFrame("spelbord");
			for (int i = 0; i < 81; i++) {
				fields[i] = new JButton();
				fields[i].setPreferredSize(new Dimension(100, 100));
				fields[i].setText("" + i);
				Graphics g = null;
				fields[i].getGraphics();
				
				fields[i].setBorder(null);
				
				if (i == 40 ) {
					fields[i].setBackground(Color.cyan);
				}
				else if (i % 9 == 0 || i % 9 == 1 || i % 9 == 2 ){
					if (i > 53){
						fields[i].setBackground(new Color(230,230,230));
					}
					else if (i > 26){
						fields[i].setBackground(Color.white);
					}						
					else {
						fields[i].setBackground(new Color(230,230,230));
					}
				}
				else if (i % 9 == 3 || i % 9 == 4 || i % 9 == 5 ){
					if (i > 53){
						fields[i].setBackground(Color.white);
					}
					else if (i > 26){
						fields[i].setBackground(new Color(230,230,230));
					}						
					else {
						fields[i].setBackground(Color.white);
					}				
				}
				else{
					if (i > 53){
						fields[i].setBackground(new Color(230,230,230));
					}
					else if (i > 26){
						fields[i].setBackground(Color.white);
					}						
					else {
						fields[i].setBackground(new Color(230,230,230));
					}						
				}

				final int FinalIntI = i;

				//add action listener om de ingedrukte knop op te vangen en door te sturen naar de afhandel functie
				fields[i].addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButtonFieldTouched(evt, FinalIntI);
		            }
				});
				
				p5.add(fields[i]);
			}

			

			Container cc = getContentPane();
			cc.setLayout(new GridLayout(2, 2));
			cc.add(pp2, BorderLayout.WEST);
			cc.add(p4, BorderLayout.EAST);
			cc.add(p5, BorderLayout.SOUTH);

		}

		/**
		 * 
		 * @param evt
		 * @param fieldnumber
		 */
	    private void jButtonFieldTouched(java.awt.event.ActionEvent evt, int fieldnumber) {
	    	//de knop fieldnumber is ingedrukt, 
	    	//stuur een bericht naar de controller
	    	setFieldColor(fieldnumber, Color.red);
	    }
		
	    /**
	    
	    
		//deze functie moet aangeroepen worden vanuit het model wanneer de kleur van een veld moet veranderen
		 * 
		 * @param fieldnumber
		 * @param color
		 */
		private void setFieldColor(int fieldnumber, Color color){
			fields[fieldnumber].setBackground(color);
		}
		
	

		public boolean Check() {
			boolean name = false;
			boolean port = false;
			boolean address = false;
			if (tfPort.getText().length() > 0) {
				port = true;
			} else {
				port = false;
			}
			if (tfAddress.getText().length() > 0) {
				address = true;
			} else {
				address = false;
			}
			if (myName.getText().length() > 0) {
				name = true;
			} else {
				name = false;
			}
			return port && address && name;
		}

		/** Afhandeling van een actie van het GUI. */
		public void actionPerformed(ActionEvent ev) {
			if (ev.getSource() == bConnect) {
				connect();
			}
			//if (ev.getSource() == myText) {
			//	client.sendMessage(myText.getText());
			//	myText.setText("");
//
			//}
			if (ev.getSource() == bNewGame) {
				// newGame();
			}
			if (ev.getSource() == bEndGame) {

				// endGame();
			}
			if (ev.getSource() == bHint) {

				// getHint();
			}
			if (ev.getSource() == bMakeMove) {

				// doeZet();

				
			}
		}

		/**
		 * Probeert een socket-verbinding op te zetten met de Server. Als alle
		 * parametervelden geldig zijn, dan wordt getracht een Client-object te
		 * construeren die de daadwerkelijke socketverbinding met de Server maakt.
		 * Als dit gelukt is wordt een aparte thread (van Client) opgestart, die de
		 * berichten van de Server leest. Daarna worden alle parametervelden en de
		 * "Connect" Button niet selecteerbaar gemaakt.
		 */
		public void connect() {
			String name = myName.getText();
			InetAddress host = null;
			try {
				host = InetAddress.getByName(tfAddress.getText());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			int port = Integer.parseInt(tfPort.getText());
		//	try {
			//	client = new Client(name, host, port, null);
			//	client.start();
			//} catch (IOException e) {
		//		e.printStackTrace();
			//}
			myName.setEnabled(false);
			tfAddress.setEnabled(false);
			tfPort.setEnabled(false);
			bConnect.setEnabled(false);
			myText.setEnabled(true);
			addMessage("Connected to server...");

		}

		/** Voegt een bericht toe aan de TextArea op het frame. */
		public void addMessage(String msg) {
			taMessages.append(msg + "\n");
		}

		/** Start een ClientGUI applicatie op. */
		public static void main(String args[]) {
			ClientGUI gui = new ClientGUI();
		}

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {
			if (Check()) {
				bConnect.setEnabled(true);
			} else {
				bConnect.setEnabled(false);

			}

		}

		public void keyReleased(KeyEvent e) {

		}

		public void displayBox() {

		}

		
		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub

		}

	}



	
	
